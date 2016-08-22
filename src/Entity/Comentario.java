package Entity;

public class Comentario {
	
	private int comentario_id;

	public int getComentario_id() {
		return comentario_id;
	}

	public void setComentario_id(int comentario_id) {
		this.comentario_id = comentario_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comentario_id;
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
		return true;
	}
	
}