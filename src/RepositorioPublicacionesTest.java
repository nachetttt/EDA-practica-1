import java.util.ArrayList;

import junit.framework.TestCase;

public class RepositorioPublicacionesTest extends TestCase {
		
	private RepositorioPublicaciones rP;
	private Publicacion p1,p2,p3;
	private ArrayList<Publicacion> lista;
	private ArrayList<String> lista2;
	private Autor a1;
	
	protected void setUp() throws Exception {
		rP = new RepositorioPublicaciones();
		p1 = new Publicacion("P1", "Publi1");
		p2 = new Publicacion("P2", "Publi2");
		p3 = new Publicacion("P3", "Publi3");
		lista = new ArrayList<Publicacion>();
		lista2 = new ArrayList<String>();
		a1 = new Autor("Q47372720", "Andrew J. Stewart");
	}

	protected void tearDown() throws Exception {
		rP = null;
	}

	public void testReadCitas() {
		rP.readCitas("Datuak/Datuak/publications-citedPubs-all.txt");
		assertTrue(rP.getCitas().size()!=0);
		//Comprobar que la primera publicacion del archivo existe,
		//con su respectiva cita.
		assertTrue(rP.getCitas().containsKey("Q21136163"));
		assertEquals("Q24600704",rP.getCitas().get("Q21136163").get(0));
	}

	public void testReadAutores() {
		rP.readAutores("Datuak/Datuak/publications-authors-all-final.txt");
		assertTrue(rP.getAutores().size()!=0);
		//Comprobar que la primera publicacion del archivo existe,
		//con su respectivo autor.
		assertTrue(rP.getAutores().containsKey("Q101088249"));
		assertEquals("Q333959",rP.getAutores().get("Q101088249").get(0));
	}

	public void testReadPublicaciones() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		assertTrue(rP.getPublicaciones().size()!=0);
		//Comprobar que la primera publicacion del archivo existe,
		//con su respectivo titulo.
		assertTrue(rP.getPublicaciones().containsKey("Q33205611"));
		assertEquals("Towards two-dimensional electrophoresis mapping of the cerebrospinal fluid proteome from a single individual", rP.getPublicaciones().get("Q33205611").getTitulo());
	}

	public void testBuscarPubliPorId() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		//buscar primera publicacion
		assertEquals(rP.getPublicaciones().get("Q33205611"),rP.buscarPubliPorId("Q33205611"));
		//buscar ultima publicacion
		assertEquals(rP.getPublicaciones().get("Q28390663"),rP.buscarPubliPorId("Q28390663"));
	}

	public void AnadirPubli() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		int size = rP.getPublicaciones().size();
		rP.anadirPubli("P1", "TITULO");
		assertTrue(rP.getPublicaciones().size()==size+1);
	}

	public void testAnadirCitaAPubli() {
		rP.readCitas("Datuak/Datuak/publications-citedPubs-all.txt");
		//publicacion con  citas. (tiene ya 41 citas)
		int size = rP.getCitas().get("Q21136163").size();
		rP.anadirCitaAPubli("Q21136163", "Q21562621");
		assertEquals("Q21562621",rP.getCitas().get("Q21136163").get(size));
		//publicacion sin citas.
		rP.anadirCitaAPubli(p1.getId(),"Q21562621");
		assertTrue(rP.getCitas().containsKey(p1.getId()));
		assertEquals("Q21562621",rP.getCitas().get(p1.getId()).get(0));
	}

	public void testAnadirAutorAPubli() {
		rP.readAutores("Datuak/Datuak/publications-authors-all-final.txt");
		//publicacion con autores.
		int size = rP.getAutores().size();
		rP.anadirAutorAPubli("Q101088249","Q448592");
		assertEquals("Q448592",rP.getAutores().get("Q101088249").get(2));
		//nueva publicacion sin autores.
		rP.anadirAutorAPubli(p1.getId(), "Q448592");
		assertTrue(rP.getAutores().containsKey(p1.getId()));
		assertEquals("Q448592",rP.getAutores().get(p1.getId()).get(0));
	}

	public void testEliminarPubli() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		int size = rP.getPublicaciones().size();
		rP.eliminarPubli("Q33205611");
		assertFalse(rP.getPublicaciones().containsKey("Q33205611"));
		assertEquals((size-1),rP.getPublicaciones().size());
	}

	public void testListaPublisCitadas() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		rP.readCitas("Datuak/Datuak/publications-citedPubs-all.txt");
		lista = rP.listaPublisCitadas("Q21136163");
		//comprobar que las dos tengan el mismo numero de citas
		assertTrue(lista.size()==rP.getCitas().get("Q21136163").size());
		//comprobar que una misma cita la contienen las dos listas
		assertTrue(lista.contains(rP.buscarPubliPorId(rP.getCitas().get("Q21136163").get(0)))); 
	}
	
	public void testListaAutoresPubli() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		rP.readAutores("Datuak/Datuak/publications-authors-all-final.txt");
		lista2 = rP.listaAutoresPubli(rP.buscarPubliPorId("Q101088249"));
		//comprobar que las dos tengan el mismo numero de citas
		assertTrue(lista2.size()==rP.getAutores().get("Q101088249").size());
		//comprobar que una misma cita la contienen las dos listas
		assertTrue(lista2.contains(rP.getAutores().get("Q101088249").get(0)));
	}

	public void testListaPublicacionesAutor() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		rP.readAutores("Datuak/Datuak/publications-authors-all-final.txt");
		lista = rP.listaPublicacionesAutor(a1);
		Publicacion p = rP.buscarPubliPorId("Q38395106");
		assertTrue(lista.contains(p));	
	}

	public void testOrdenarAlfabeticamente() {
		rP.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		ArrayList<Publicacion> lista = rP.ordenarAlfabeticamente();
		assertTrue(lista.get(0).getId().compareTo(lista.get(1).getId())<0);
	}
}
