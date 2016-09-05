package Entity;

public class Comentario {
	
	private int comentario_id;
	private String conteudo;
	
	public int getComentario_id() {
		return comentario_id;
	}
	public void setComentario_id(int comentario_id) {
		this.comentario_id = comentario_id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comentario_id;
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (comentario_id != other.comentario_id)
			return false;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		return true;
	}
	
}