
public class Publicación {
	
	private String id;
	private String título;
	private Autor autor;
	
	public Publicación(String pId, String pNombre) {
	
		this.id = pId;
		this.título = pNombre;

	}
	
	public boolean tieneMismoId(String pId) {
		//se puede hacer directamente contans(pId)?
		boolean tiene = false;
		if (this.id==pId) {
			tiene = true;
		}
		return tiene;
	}
}