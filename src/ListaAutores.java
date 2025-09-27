import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaAutores {
	private ArrayList<Autor> lista;
	
	public ListaAutores() {
		lista = new ArrayList<>();
	}
	
	public void anadirAutor(String pId, String pNom) {
		Autor a = new Autor(pId,pNom);
		this.lista.add(a);
	}
	
	public void readAutores(String nom) {
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea = null;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				Autor a = new Autor(datos[0],datos[1]);
				lista.add(a);
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Iterator<Autor> getIterador() {
		return lista.iterator();
	}
	
	public int obtenerInd(String pId) {
		int ind = 0;
		boolean enc = false;
		Autor a = null;
		Iterator<Autor> itr = getIterador();
		
		while (!enc && itr.hasNext()) {
			a = itr.next();
			if (a.getId().equals(pId)) {
				enc = true;
			}else {
				ind++;
			}
		}
		
		if (enc) {
			return ind;
		}else {
			return -1;
		}
	}
	
	public void eliminarAutor(String pId) {
		int ind = obtenerInd(pId);
		if (ind!=-1) {
			lista.remove(ind);
		}
	}
	
	public void loadAutores(String nom) {
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (Autor a: lista) { 
				salida.println(a.getId()+" # "+a.getNombre());
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
