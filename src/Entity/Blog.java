package Entity;

public class Blog {
	
	private int blog_id;
	private String data;
	private Usuario dono;
	private String titulo;
	private Conteudo conteudo_list;
	
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Usuario getDono() {
		return dono;
	}
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Conteudo getConteudo_list() {
		return conteudo_list;
	}
	public void setConteudo_list(Conteudo conteudo_list) {
		this.conteudo_list = conteudo_list;
	}

}