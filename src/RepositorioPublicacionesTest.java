import java.util.ArrayList;

import junit.framework.TestCase;

public class RepositorioPublicacionesTest extends TestCase {
		
	private RepositorioPublicaciones rP;
	private Publicacion p1,p2,p3;
	private ArrayList<Publicacion> lista;
	
	protected void setUp() throws Exception {
		rP = new RepositorioPublicaciones();
		p1 = new Publicacion("P1", "Publi1");
		p2 = new Publicacion("P2", "Publi2");
		p3 = new Publicacion("P3", "Publi3");
		lista = new ArrayList<Publicacion>();
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
		
		rP.getPublicaciones().put("P1", p1);
		rP.getPublicaciones().put("P2", p2);
		rP.getPublicaciones().put("P3", p3);
		
		Publicacion buscar1 = rP.buscarPubliPorId("P1");
		assertEquals("P1", buscar1.getId());
		assertEquals("Publi1", buscar1.getTitulo());
			
		Publicacion buscar2 = rP.buscarPubliPorId("P2");
		assertEquals("P2", buscar2.getId());
		assertEquals("Publi2", buscar2.getTitulo());

	}

	public void testInsertarPubli() {
		rP.getPublicaciones().put("P1", p1);
		assertTrue(rP.getPublicaciones().size()==1);
	}

	public void testAnadirCitaAPubli() {
		rP.readCitas("Datuak/Datuak/publications-citedPubs-all.txt");
		//publicacion con  citas. (tiene ya 41 citas)
		rP.anadirCitaAPubli("Q21136163", "Q21562621");
		assertEquals("Q21562621",rP.getCitas().get("Q21136163").get(41));
		//publicacion sin citas.
		rP.anadirCitaAPubli(p1.getId(),"Q21562621");
		assertTrue(rP.getCitas().containsKey(p1.getId()));
		assertEquals("Q21562621",rP.getCitas().get(p1.getId()).get(0));
	}

	public void testAnadirAutorAPubli() {
		rP.readAutores("Datuak/Datuak/publications-authors-all-final.txt");
		//publicacion con autores.
		rP.anadirAutorAPubli("Q101088249","Q448592");
		assertEquals("Q448592",rP.getAutores().get("Q101088249").get(2));
		//nueva publicacion sin autores.
		rP.anadirAutorAPubli(p1.getId(), "Q448592");
		assertTrue(rP.getAutores().containsKey(p1.getId()));
		assertEquals("Q448592",rP.getAutores().get(p1.getId()).get(0));
	}

	public void testEliminarPubli() {
		rP.getPublicaciones().put("P1", p1);
		rP.getPublicaciones().put("P2", p2);
		assertTrue(rP.getPublicaciones().size()==2);	
		rP.eliminarPubli("P2");
		assertFalse(rP.getPublicaciones().containsKey("P2"));
		assertTrue(rP.getPublicaciones().size()==1);
	}

	public void testListaPublisCitadas() {
		rP.anadirCitaAPubli("P1", "P2");
		rP.anadirCitaAPubli("P1", "P3");
		rP.anadirCitaAPubli("P1", "P3");
		rP.anadirCitaAPubli("P1", "P4");
		rP.anadirCitaAPubli("P1", "P5");
		rP.anadirCitaAPubli("P8", "P5");
		lista = rP.listaPublisCitadas("P1");
		assertTrue(lista.size()==5);
		
		rP.getCitas().get("P1").remove(4);
		lista = rP.listaPublisCitadas("P1");
		assertEquals(4,lista.size());
		
	}
	public void testListaAutoresPubli() {
		
	}

	public void testListaPublicacionesAutor() {
		fail("Not yet implemented");
	}

	public void testOrdenarAlfabeticamente() {
		fail("Not yet implemented");
	}

	public void testLoadCitas() {
		fail("Not yet implemented");
	}

	public void testLoadAutores() {
		fail("Not yet implemented");
	}

	public void testLoadPublicaciones() {
		fail("Not yet implemented");
	}

}
