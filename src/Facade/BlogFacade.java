package Facade;

import DAO.BlogDAO;
import DAO.IBlogDAO;
import Entity.*;

public class BlogFacade {
	
	private IBlogDAO dao;
	
	public BlogFacade(){
		this.dao = new BlogDAO();
	}
	
	// Implementa��o da Fachada para os m�todos de Inser��o
	public int saveBlog(Blog blog){
		return dao.saveBlog(blog);
	}
	
	public int saveComentario(Comentario comentario){
		return dao.saveComentario(comentario);
	}
	
	public int saveConteudo(Conteudo conteudo){
		return dao.saveConteudo(conteudo);
	}
	
	public int saveNota(Nota nota){
		return dao.saveNota(nota);
	}
	
	public int saveUsuario(Usuario usuario){
		return dao.saveUsuario(usuario);
	}
	
	// Implementa��o da Fachada para os m�todos de Atualiza��o
	public int updateBlog(Blog blog){
		return dao.updateBlog(blog);
	}
	
	public int updateComentario(Comentario comentario){
		return dao.updateComentario(comentario);
	}
	
	public int updateConteudo(Conteudo conteudo){
		return dao.updateConteudo(conteudo);
	}
	
	public int updateNota(Nota nota){
		return dao.updateNota(nota);
	}
	
	public int updateUsuario(Usuario usuario){
		return dao.updateUsuario(usuario);
	}
	
	// Implementa��o da Fachada para os m�todos de Dele��o
	public int removeBlog(int blog_id){
		return dao.removeBlog(blog_id);
	}
	
	public int removeComentario(int comentario_id){
		return dao.removeComentario(comentario_id);
	}
	
	public int removeConteudo(int conteudo_id){
		return dao.removeConteudo(conteudo_id);
	}
	
	public int removeNota(int nota_id){
		return dao.removeNota(nota_id);
	}
	
	public int removeUsuario(int usuario_id){
		return dao.removeUsuario(usuario_id);
	}
	
	// Implementa��o da Fachada para os m�todos de Listagem
	// A serem decididos de acordo com o decorrer do projeto
	
}