
public class Publicacion {
	
	private String id;
	private String título;
	
	public Publicacion(String pId, String pNombre) {
		this.id = pId;
		this.título = pNombre;
	}

	public String getId() {
		return id;
	}

	public String getTítulo() {
		return título;
	}
	
}