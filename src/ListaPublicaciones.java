import java.util.ArrayList;
import java.util.Iterator;

public class ListaPublicaciones {
	
	private ArrayList<Publicación> lista;
	private static ListaPublicaciones miListaPublicaciones = null;
	
	private ListaPublicaciones() {
		lista = new ArrayList<Publicación>();
	}
	
	public static ListaPublicaciones getListaPublicaciones() {
		if (miListaPublicaciones == null) {
			miListaPublicaciones = new ListaPublicaciones();
		}
		return miListaPublicaciones;
	}
	
	private Iterator<Publicación> getIterador() {
		return lista.iterator();
	}
	
	public Publicación buscarPubliPorId(String pId) {
		boolean enc = false;
		Iterator<Publicación> itr = getIterador();
		Publicación p =null;
		while (!enc && itr.hasNext()) {
			p = itr.next();
			if (p.tieneMismoId(pId)) {
				enc = true;
			}
		}
		return p;
	}
	
	public void anadirPublicación(String pId, String pTítulo) {
		Publicación p = new Publicación(pId, pTítulo);
		this.lista.add(p);
	}
	
}
