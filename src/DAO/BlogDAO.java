package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.*;

public class BlogDAO implements IBlogDAO {

	// Métodos de Inserção (SQL)
	private static final String SQL_INSERT_BLOG =
			"INSERT INTO TB_BLOG (DATA_CRIACAO, USUARIO_ID_FK, TITULO, CONTEUDO_ID_FK)"
		  + "VALUES (?, ?, ?, ?)";
	
	private static final String SQL_INSERT_COMENTARIO =
			"INSERT INTO TB_COMENTARIO (CONTEUDO)"
		  + "VALUES (?)";
	
	private static final String SQL_INSERT_CONTEUDO =
			"INSERT INTO TB_CONTEUDO (DATA_INSERCAO, TEXTO, USUARIO_ID_FK)"
		  + "VALUES (?, ?, ?)";
	
	private static final String SQL_INSERT_NOTA =
			"INSERT INTO TB_NOTA (COMENTARIO_FK)"
		  + "VALUES (?)";
	
	private static final String SQL_INSERT_USUARIO =
			"INSERT INTO TB_USUARIO (NOME, EMAIL)"
		  + "VALUES (?, ?)";

	// Métodos de Atualização (SQL)
	private static final String SQL_UPDATE_BLOG =
			"UPDATE TB_BLOG SET DATA_CRIACAO = ?, USUARIO_ID_FK = ?, TITULO = ?, CONTEUDO_ID_FK = ?"
		  + "WHERE BLOG_ID = ?";
	
	private static final String SQL_UPDATE_COMENTARIO =
			"UPDATE TB_COMENTARIO SET CONTEUDO = ?"
		  + "WHERE COMENTARIO_ID = ?";
	
	private static final String SQL_UPDATE_CONTEUDO =
			"UPDATE TB_CONTEUDO SET DATA_INSERCAO = ?, TEXTO = ?, USUARIO_ID_FK = ?"
		  + "WHERE CONTEUDO_ID = ?";
	
	private static final String SQL_UPDATE_NOTA =
			"UPDATE TB_NOTA SET COMENTARIO_FK = ?"
		  + "WHERE NOTA_ID = ?";
	
	private static final String SQL_UPDATE_USUARIO = 
			"UPDATE TB_USUARIO SET NOME = ?, EMAIL = ?"
		  + "WHERE USUARIO_ID = ?";
					
	// Métodos de Deleção (SQL)
	private static final String SQL_REMOVE_BLOG =
    		"DELETE FROM TB_BLOG WHERE BLOG_ID = ?";
					
    private static final String SQL_REMOVE_COMENTARIO =
    		"DELETE FROM TB_COMENTARIO WHERE COMENTARIO_ID = ?";
    
    private static final String SQL_REMOVE_CONTEUDO =
    		"DELETE FROM TB_CONTEUDO WHERE CONTEUDO_ID = ?";
    
    private static final String SQL_REMOVE_NOTA =
    		"DELETE FROM TB_NOTA WHERE NOTA_ID = ?";
    		
    private static final String SQL_REMOVE_USUARIO =
    		"DELETE FROM TB_USUARIO WHERE USUARIO_ID = ?";
    
    // Métodos de Listagem (SQL)
    // A serem decididos de acordo com o decorrer do projeto

	// Implementação utilizando os SQL's acima (Inserção)
	@Override
	public int saveBlog(Blog blog) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_INSERT_BLOG);
		    pstm.setString(1, blog.getData());
		    pstm.setString(2, blog.getDono().getNome());
		    pstm.setString(3, blog.getTitulo());
		    pstm.setInt(4, blog.getConteudo_list().getConteudo_id());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int saveComentario(Comentario comentario) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_INSERT_COMENTARIO);
		    pstm.setString(1, comentario.getConteudo());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int saveConteudo(Conteudo conteudo) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_INSERT_CONTEUDO);
		    pstm.setString(1, conteudo.getData());
		    pstm.setString(2, conteudo.getTexto());
		    pstm.setString(3, conteudo.getAutor().getNome());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int saveNota(Nota nota) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_INSERT_NOTA);
		    pstm.setString(1, nota.getComentario_list().getConteudo());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int saveUsuario(Usuario usuario) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_INSERT_USUARIO);
		    pstm.setString(1, usuario.getNome());
		    pstm.setString(2, usuario.getEmail());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	// Implementação utilizando os SQL's acima (Atualização)
	@Override
	public int updateBlog(Blog blog) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_UPDATE_BLOG);
		    pstm.setString(1, blog.getData());
		    pstm.setString(2, blog.getDono().getNome());
		    pstm.setString(3, blog.getTitulo());
		    pstm.setInt(4, blog.getConteudo_list().getConteudo_id());
		    pstm.setInt(5, blog.getBlog_id());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int updateComentario(Comentario comentario) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_UPDATE_COMENTARIO);
		    pstm.setString(1, comentario.getConteudo());
		    pstm.setInt(2, comentario.getComentario_id());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int updateConteudo(Conteudo conteudo) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_UPDATE_CONTEUDO);
		    pstm.setString(1, conteudo.getData());
		    pstm.setString(2, conteudo.getTexto());
		    pstm.setString(3, conteudo.getAutor().getNome());
		    pstm.setInt(4, conteudo.getConteudo_id());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int updateNota(Nota nota) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_UPDATE_NOTA);
		    pstm.setString(1, nota.getComentario_list().getConteudo());
		    pstm.setInt(2, nota.getNota_id());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int updateUsuario(Usuario usuario) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_UPDATE_USUARIO);
		    pstm.setString(1, usuario.getNome());
		    pstm.setString(2, usuario.getEmail());
		    pstm.setInt(3, usuario.getUsuario_id());
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	// Implementação utilizando os SQL's acima (Deleção)
	@Override
	public int removeBlog(int blog_id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_REMOVE_BLOG);
		    pstm.setInt(1, blog_id);
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int removeComentario(int comentario_id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_REMOVE_COMENTARIO);
		    pstm.setInt(1, comentario_id);
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int removeConteudo(int conteudo_id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_REMOVE_CONTEUDO);
		    pstm.setInt(1, conteudo_id);
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int removeNota(int nota_id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_REMOVE_NOTA);
		    pstm.setInt(1, nota_id);
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	@Override
	public int removeUsuario(int usuario_id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
		    pstm = conn.prepareStatement(SQL_REMOVE_USUARIO);
		    pstm.setInt(1, usuario_id);
		    result = pstm.executeUpdate();
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, null);
		    }
		    e.printStackTrace();
	    }
		return result;
	}

	// Implementação utilizando os SQL's acima (Listagem)
	// Exemplo abaixo em forma de referência para futuro desenvolvimento dos métodos de listagem desse novo projeto
	
	/*
	@Override
	public List<Aluno> findAllAluno() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		List<Aluno> alunos = new ArrayList<Aluno>();
		ResultSet rs = null;
		try {
		    pstm = conn.prepareStatement(SQL_FIND_ALL_ALUNO);
		    rs = pstm.executeQuery();
		    
		    while(rs.next()){
		    	Aluno aluno = new Aluno();
		    	aluno.setMatricula(rs.getLong("MATRICULA"));
		    	aluno.setNome(rs.getString("NOME"));
		    	aluno.setCpf(rs.getString("CPF"));
		    	aluno.setDtNascimento(rs.getDate("DT_NASCIMENTO"));
		    	aluno.setSexo(rs.getString("SEXO"));
		    	
		    	alunos.add(aluno);
		    }
		} catch (SQLException e){
			try {
				if (conn != null){
				    conn.rollback();
				}
		    } catch (SQLException e1){
			   e1.printStackTrace();
		    } finally {
		    	DBConnection.close(conn, pstm, rs);
		    }
		    e.printStackTrace();
	    }
		return alunos;
	}
	*/
	
}