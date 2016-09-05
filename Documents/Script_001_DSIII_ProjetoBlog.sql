------------------------------------------------------
------------ SCRIPT_001_DSIII_PROJETOBLOG ------------
------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
-- Banco........: DSIII - MySQL
-- Versão.......: Padrão
-- Autor........: Leonardo Jefferson Vasconcelos Rodrigues
-- Data.........: 27/08/2016
-- Disciplina...: Desenvolvimento de Software III
-- Professor....: Mauricio Manoel
-- Finalidade...: Inicialização do Banco de Dados "DSIII" e preparação do mesmo para o recebimento das tabelas do projeto "DSIII_ProjetoBlog".
-- Tabelas......: 
-- Sistemas.....: DSIII_ProjetoBlog 
------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------
------------- Criando/Inicializando o BD -------------
------------------------------------------------------

CREATE DATABASE DSIII

USE DSIII

------------------------------------------------------
------- Criando/Inicializando as Tabelas do BD -------
------------------------------------------------------
				
CREATE TABLE IF NOT EXISTS TB_USUARIO(
			USUARIO_ID INT UNSIGNED AUTO_INCREMENT Primary key,
        	NOME VARCHAR(140) NOT NULL,
        	EMAIL VARCHAR(140) NOT NULL
			)
				
CREATE TABLE IF NOT EXISTS TB_COMENTARIO(
        	COMENTARIO_ID INT UNSIGNED AUTO_INCREMENT Primary key,
        	CONTEUDO VARCHAR(140) NOT NULL
			)
				
CREATE TABLE IF NOT EXISTS TB_NOTA(
        	NOTA_ID INT UNSIGNED AUTO_INCREMENT Primary key,
        	COMENTARIO_FK INT NOT NULL, -- Representará uma Lista de Comentários.
			FOREIGN KEY (COMENTARIO_FK) REFERENCES TB_COMENTARIO(COMENTARIO_ID)
			)
				
CREATE TABLE IF NOT EXISTS TB_CONTEUDO(
        	CONTEUDO_ID INT UNSIGNED AUTO_INCREMENT Primary key,
        	DATA_INSERCAO DATE NOT NULL,
			TEXTO VARCHAR(140) NOT NULL,
			USUARIO_ID_FK INT NOT NULL, -- Representará o campo AUTOR, trazendo o Nome/Email do mesmo quando chamado via sistema.
			FOREIGN KEY (USUARIO_ID_FK) REFERENCES TB_USUARIO(USUARIO_ID)
			)
				
CREATE TABLE IF NOT EXISTS TB_BLOG(
        	BLOG_ID INT UNSIGNED AUTO_INCREMENT Primary key,
        	DATA_CRIACAO DATE NOT NULL,
			USUARIO_ID_FK INT NOT NULL, -- Representará o campo DONO, trazendo o Nome/Email do mesmo quando chamado via sistema.
			TITULO VARCHAR(140) NOT NULL,
			CONTEUDO_ID_FK INT NOT NULL, -- Representará uma Lista de Conteúdos.
			FOREIGN KEY (USUARIO_ID_FK) REFERENCES TB_USUARIO(USUARIO_ID),
			FOREIGN KEY (CONTEUDO_ID_FK) REFERENCES TB_CONTEUDO(CONTEUDO_ID)
			)
			
------------------------------------------------------
---- Comandos SQL para Inserção/Alteração/Deleção ----
------------------------------------------------------

INSERT INTO TB_BLOG (DATA_CRIACAO, USUARIO_ID_FK, TITULO, CONTEUDO_ID_FK) VALUES (?, ?, ?, ?);
	
INSERT INTO TB_COMENTARIO (CONTEUDO) VALUES (?);
	
INSERT INTO TB_CONTEUDO (DATA_INSERCAO, TEXTO, USUARIO_ID_FK) VALUES (?, ?, ?);
	
INSERT INTO TB_NOTA (COMENTARIO_FK) VALUES (?);
	
INSERT INTO TB_USUARIO (NOME, EMAIL) VALUES (?, ?);

UPDATE TB_BLOG SET DATA_CRIACAO = ?, USUARIO_ID_FK = ?, TITULO = ?, CONTEUDO_ID_FK = ?
	WHERE BLOG_ID = ?;
	
UPDATE TB_COMENTARIO SET CONTEUDO = ?
	WHERE COMENTARIO_ID = ?;
	
UPDATE TB_CONTEUDO SET DATA_INSERCAO = ?, TEXTO = ?, USUARIO_ID_FK = ?
	WHERE CONTEUDO_ID = ?;
	
UPDATE TB_NOTA SET COMENTARIO_FK = ?
	WHERE NOTA_ID = ?;
	
UPDATE TB_USUARIO SET NOME = ?, EMAIL = ?
	WHERE USUARIO_ID = ?;
					
DELETE FROM TB_BLOG WHERE BLOG_ID = ?;
					
DELETE FROM TB_COMENTARIO WHERE COMENTARIO_ID = ?;
    
DELETE FROM TB_CONTEUDO WHERE CONTEUDO_ID = ?;
    
DELETE FROM TB_NOTA WHERE NOTA_ID = ?;
    		
DELETE FROM TB_USUARIO WHERE USUARIO_ID = ?;