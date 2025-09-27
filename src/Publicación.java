
public class Publicación {
	
	private String id;
	private String título;
	private Autor autor;
	
	public Publicación(String pId, String pNombre) {
	
		this.id = pId;
		this.título = pNombre;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTítulo() {
		return título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}