import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RepositorioPublicaciones {
	
	private HashMap<String, ArrayList<String>> citas; //ID Publicación # Publi citada
	private HashMap<String, Publicacion> publicaciones; //ID Publicación # Objeto Publicación
	private HashMap<String, ArrayList<String>> autores; //ID publicación # Autores que la han realizado 
	
	private RepositorioPublicaciones() {
		citas = new HashMap<>();
		publicaciones = new HashMap<>();
		autores = new HashMap<>();
	}
	
	public void readCitas(String nom) {
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				if (!citas.containsKey(datos[0])) {
					citas.put(datos[0], new ArrayList<>());
				}
				citas.get(datos[0]).add(datos[1]);
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readAutores(String nom) {
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				if (!autores.containsKey(datos[0])) {
					autores.put(datos[0], new ArrayList<>());
				}
				autores.get(datos[0]).add(datos[1]);
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readPublicaciones(String nom) {
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				Publicacion publi = new Publicacion(datos[0], datos[1]);
				publicaciones.put(datos[0], publi);
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Publicacion buscarPubliPorId(String pId) {
		Publicacion publi = publicaciones.get(pId);
		return publi;
	}
	
	public void anadirPubli(String pId, String pTítulo) {
		Publicacion publi = new Publicacion(pId, pTítulo);
		publicaciones.put(pId, publi);
	}
	
	public void anadirCitaAPubli(String pId, String pCita) {
		if (!citas.containsKey(pId)) {
			citas.put(pId, new ArrayList<>());
		}
		citas.get(pId).add(pCita);
	}
	
	public void anadirAutorAPubli(String pIdPubli, String pIdAutor) {
		if (!autores.containsKey(pIdPubli)) {
			autores.put(pIdPubli, new ArrayList<>());
		}
		autores.get(pIdPubli).add(pIdAutor);
	}
	
	public void eliminarPubli(String pIdPubli) {
		publicaciones.remove(pIdPubli);
	}
	
	public ArrayList<Publicacion> listaPublisCitadas(String pId) {
		ArrayList<Publicacion> lPC = new ArrayList<>();
		ArrayList<String> lista = citas.get(pId);
		for (String i: lista) {
			Publicacion publi = publicaciones.get(i);
			lPC.add(publi);
		}
		return lPC;
	}
	
	public ArrayList<String> listaAutoresPubli(Publicacion p) {
		ArrayList<String> lA = autores.get(p.getId());
		return lA;
	}
	
	public ArrayList<Publicacion> listaPublicacionesAutor(Autor a){
		ArrayList<Publicacion> lista = new ArrayList<>();
		for(String pIdPubli: autores.keySet()) {
			ArrayList<String> lA = autores.get(pIdPubli);
			if(lA.contains(a.getId())){
				lista.add(publicaciones.get(pIdPubli));
			}
		}
		return lista;
	}
	
	
	public ArrayList<String> ordenarAlfabeticamente(){
		ArrayList<String> lista = new ArrayList<>();
		//TODO Hacer este método en el que se ordena alfabeticamente con algoritmo de ordenación.
		return lista;
	}
	
	public void loadCitas(String nom) {
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (String pId: citas.keySet()) {
				for (String pCita: citas.get(pId)) {
					salida.println(pId+" # "+pCita);
				}
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadAutores(String nom) {
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (String pId: autores.keySet()) {
				for (String pAutor: autores.get(pId)) {
					salida.println(pId+" # "+pAutor);
				}
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadPublicaciones(String nom) {
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (String pId: publicaciones.keySet()) {
				salida.println(pId+" # "+publicaciones.get(pId).getTitulo());
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
