import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class RepositorioPublicaciones {
	
	private HashMap<String, ArrayList<String>> citas; //ID Publicación # Publi citada
	private HashMap<String, Publicación> publicaciones; //ID Publicación # Objeto Publicación
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
				Publicación publi = new Publicación(datos[0], datos[1]);
				publicaciones.put(datos[0], publi);
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Publicación buscarPubliPorId(String pId) {
		Publicación publi = publicaciones.get(pId);
		return publi;
	}
	
	public void anadirPubli(String pId, String pTítulo) {
		Publicación publi = new Publicación(pId, pTítulo);
		publicaciones.put(pId, publi);
	}
	
	public void anadirCitaAPubli(String pId, String pCita) {
		if (!citas.containsKey(pId)) {
			citas.put(pId, new ArrayList<>());
		}
		citas.get(pId).add(pCita);
	}
	
	public void anadirAutorAPubli(String pIdPubli, String pNom) {
		if (!autores.containsKey(pIdPubli)) {
			autores.put(pIdPubli, new ArrayList<>());
		}
		autores.get(pIdPubli).add(pNom);
	}
	
	public void eliminarPubli(String pIdPubli) {
		publicaciones.remove(pIdPubli);
	}
	
	public ArrayList<Publicación> listaPublisCitadas(String pId) {
		ArrayList<Publicación> lPC = new ArrayList<>();
		ArrayList<String> lista = citas.get(pId);
		for (String i: lista) {
			Publicación publi = publicaciones.get(i);
			lPC.add(publi);
		}
		return lPC;
	}
	
	public ArrayList<String> listaAutores(Publicación p) {
		//TODO hacer este metodo
		ArrayList<String> al = new ArrayList<String>();
		return al;
	}
}
