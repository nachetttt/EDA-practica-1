import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class RepositorioAutores {
	private HashMap<String, Autor> autores;
	
	public RepositorioAutores() {
		autores = new HashMap<>();
	}
	
	public void anadirAutor(String pId, String pNom) {
		Autor a = new Autor(pId,pNom);
		this.autores.put(pId, a);
	}
	
	public void readAutores(String nom) {
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea = null;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				Autor a = new Autor(datos[0],datos[1]);
				autores.put(datos[0],a);
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Autor obtenerAutor(String pId) {
		return autores.get(pId);
	}
	
	public void eliminarAutor(String pId) {
		autores.remove(pId);
		}
	
	public void loadAutores(String nom) {
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (Autor a: autores.values()) { 
				salida.println(a.getId()+" # "+a.getNombre());
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public HashMap<String, Autor> getRepositorioAutores(){
		return autores;
	}
}
