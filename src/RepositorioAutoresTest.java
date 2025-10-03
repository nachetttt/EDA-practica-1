import junit.framework.TestCase;

public class RepositorioAutoresTest extends TestCase {

	private RepositorioAutores rA;;
	
	protected void setUp() throws Exception {
		rA = new RepositorioAutores();
		
	}

	protected void tearDown() throws Exception {
		rA=null;
	}

	public void testAnadirAutor() {
		rA.readAutores("Datuak/Datuak/authors-name-all.txt");
		int size = rA.getRepositorioAutores().size();
		rA.anadirAutor("Q29349238", "Pablo");
		assertTrue(rA.getRepositorioAutores().containsKey("Q29349238"));
		assertEquals((size+1), rA.getRepositorioAutores().size());
		//se podría probar a añadir un autor vacío?

	}

	public void testReadAutores() {
		rA.readAutores("Datuak/Datuak/authors-name-all.txt");
		assertNotNull(rA.getRepositorioAutores());
		assertEquals("Kevin Thiele", rA.getRepositorioAutores().get("Q547084").getNombre());
		assertEquals("Eric Waclawik", rA.getRepositorioAutores().get("Q60320741").getNombre());
	}

	public void testObtenerAutor() {
		rA.anadirAutor("Q92389428", "Charles");
		Autor a = rA.obtenerAutor("Q92389428");
		assertEquals("Q92389428", a.getId());
		assertEquals("Charles", a.getNombre());
		assertNotNull(a);
	}

	public void testEliminarAutor() {
		rA.anadirAutor("Q9238523", "Helsey");
		assertTrue(rA.getRepositorioAutores().containsKey("Q9238523"));
		int size = rA.getRepositorioAutores().size();
		rA.eliminarAutor("Q9238523");
		assertFalse(rA.getRepositorioAutores().containsKey("Q9238523"));
		assertTrue(rA.getRepositorioAutores().size()!=size);
	}


}
