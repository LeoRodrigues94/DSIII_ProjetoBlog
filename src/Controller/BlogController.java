package Controller;

import Entity.*;
import Facade.BlogFacade;

public class BlogController {
	
	private BlogFacade facade;
	
	public BlogController(){
		this.facade = new BlogFacade();	
	}
	
	// Implementação do Controlador para os métodos de Inserção
	public int salvarBlog(Blog blog){
		return facade.saveBlog(blog);
	}
	
	public int salvarComentario(Comentario comentario){
		return facade.saveComentario(comentario);
	}
	
	public int salvarConteudo(Conteudo conteudo){
		return facade.saveConteudo(conteudo);
	}
	
	public int salvarNota(Nota nota){
		return facade.saveNota(nota);
	}
	
	public int salvarUsuario(Usuario usuario){
		return facade.saveUsuario(usuario);
	}
	
	// Implementação do Controlador para os métodos de Atualização
	public int atualizarBlog(Blog blog){
		return facade.updateBlog(blog);
	}
	
	public int atualizarComentario(Comentario comentario){
		return facade.updateComentario(comentario);
	}
	
	public int atualizarConteudo(Conteudo conteudo){
		return facade.updateConteudo(conteudo);
	}
	
	public int atualizarNota(Nota nota){
		return facade.updateNota(nota);
	}
	
	public int atualizarUsuario(Usuario usuario){
		return facade.updateUsuario(usuario);
	}
	
	// Implementação do Controlador para os métodos de Deleção
	public int removerBlog(int blog_id){
		return facade.removeBlog(blog_id);
	}
	
	public int removerComentario(int comentario_id){
		return facade.removeComentario(comentario_id);
	}
	
	public int removerConteudo(int conteudo_id){
		return facade.removeConteudo(conteudo_id);
	}
	
	public int removerNota(int nota_id){
		return facade.removeNota(nota_id);
	}
	
	public int removerUsuario(int usuario_id){
		return facade.removeUsuario(usuario_id);
	}
	
	// Implementação da Fachada para os métodos de Listagem
	// A serem decididos de acordo com o decorrer do projeto

}
