package Entity;

public class Nota {
	
	private int nota_id;
	private Comentario comentario_list;
	
	public int getNota_id() {
		return nota_id;
	}
	public void setNota_id(int nota_id) {
		this.nota_id = nota_id;
	}
	public Comentario getComentario_list() {
		return comentario_list;
	}
	public void setComentario_list(Comentario comentario_list) {
		this.comentario_list = comentario_list;
	}
	
}