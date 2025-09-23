import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Cita {
	private HashMap<String, ArrayList<String>> citas;
	
	public Cita() {
		citas = new HashMap<>();
	}
	
	public void readFile(String nom) {
		  try {
		    Scanner entrada = new Scanner(new FileReader(nom));
		    String linea;
		    
		    while (entrada.hasNextLine()) {
		      linea = entrada.nextLine();
		      String datos[] = linea.split(" # ");
		      if (!citas.containsKey(datos[0])) {
		    	  citas.put(datos[0], new ArrayList<>()); 
		      }
		      citas.get(datos[0]).add(datos[1]);  
		      
		    }
		    entrada.close();
		  } // try 
		  catch (IOException e) {
		    e.printStackTrace();
		  }                                 
	}
	
	public ArrayList<String> publisCitadas(String pId) {
		ArrayList<String> listaCitas = null;
		if (citas.containsKey(pId)) {
			listaCitas = citas.get(pId);
		}
		return listaCitas;
	}
	
	public void anadirPubliCitada(String pPubli, String pCitada) {
		boolean contiene = citas.get(pPubli).contains(pCitada);
		if (!contiene) {
			citas.get(pPubli).add(pCitada);
		}
	}
	
	
}
