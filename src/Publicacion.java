public class Publicacion {

	private String id;
	private String titulo;
	
	public Publicacion(String pId, String pNombre) {
		this.id = pId;
		this.titulo = pNombre;
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}