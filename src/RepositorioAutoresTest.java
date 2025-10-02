import java.util.HashMap;

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
		rA.anadirAutor("A1", "Pablo");
		assertTrue(rA.getRepositorioAutores().containsKey("A1"));
		
	}

	public void testReadAutores() {
		fail("Not yet implemented");
		//TODO Hacer este test
	}

	public void testObtenerAutor() {
		rA.anadirAutor("A1", "Pablo");
		Autor a = rA.obtenerAutor("A1");
		assertEquals("A1", a.getId());
		assertEquals("Pablo", a.getNombre());
		assertNotNull(a);
	}

	public void testEliminarAutor() {
		rA.anadirAutor("A1", "Pablo");
		assertTrue(rA.getRepositorioAutores().containsKey("A1"));
		rA.eliminarAutor("A1");
		assertFalse(rA.getRepositorioAutores().containsKey("A1"));
	}

	public void testLoadAutores() {
		//TODO Hacer este test
		fail("Not yet implemented");
	}

}
