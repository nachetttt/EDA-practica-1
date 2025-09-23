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
	
	
}
