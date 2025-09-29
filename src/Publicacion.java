public class Publicacion {
	
	private String id;
	private String titulo;
	private Autor autor;
	
	public Publicacion(String pId, String pNombre) {
	
		this.id = pId;
		this.titulo = pNombre;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
