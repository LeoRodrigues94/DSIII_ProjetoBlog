package DAO;

import Entity.*;

public interface IBlogDAO {
	
	// M�todos para Inser��o
	public int saveBlog(Blog blog);
	public int saveComentario(Comentario comentario);
	public int saveConteudo(Conteudo conteudo);
	public int saveNota(Nota nota);
	public int saveUsuario(Usuario usuario);
		
	// M�todos para Atualiza��o
	public int updateBlog(Blog blog);
	public int updateComentario(Comentario comentario);
	public int updateConteudo(Conteudo conteudo);
	public int updateNota(Nota nota);
	public int updateUsuario(Usuario usuario);
	
	// M�todos para Dele��o
	public int removeBlog(int blog_id);
	public int removeComentario(int comentario_id);
	public int removeConteudo(int conteudo_id);
	public int removeNota(int nota_id);
	public int removeUsuario(int usuario_id);
			
	// M�todos para Busca
	// A serem decididos de acordo com o decorrer do projeto
		
	// M�todos para Listagem
	// A serem decididos de acordo com o decorrer do projeto
	
}