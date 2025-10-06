package labo1;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println("TIEMPOS DE EJECUCIÓN");
		System.out.println(" ");
		System.out.println("Repositorio Autores:");
		
		//Leer Autores
		double milisInicio = System.currentTimeMillis();
		RepositorioAutores ra = new RepositorioAutores();
		ra.readAutores("Datuak/Datuak/authors-name-all.txt");
		double milisFin = System.currentTimeMillis();
		System.out.println("ReadAutores: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//Load Autores
		milisInicio = System.currentTimeMillis();
		ra.loadAutores("Datuak/Datuak/JUnit loadAutores 2.txt");
		milisFin = System.currentTimeMillis();
		System.out.println("LoadAutores: "+((milisFin-milisInicio)/1000)+" segundos");
		
		System.out.println(" ");
		System.out.println("Repositorio Publicaciones");

		//Leer Citas
		milisInicio = System.currentTimeMillis();
		RepositorioPublicaciones rp = new RepositorioPublicaciones();
		rp.readCitas("Datuak/Datuak/publications-citedPubs-all.txt");
		milisFin = System.currentTimeMillis();
		System.out.println("ReadCitas: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//Leer Autores de Publicaciones
		milisInicio = System.currentTimeMillis();
		rp.readAutores("Datuak/Datuak/publications-authors-all-final.txt");
		milisFin = System.currentTimeMillis();
		System.out.println("ReadAutoresDePublicaciones: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//Leer Publicaciones
		milisInicio = System.currentTimeMillis();
		rp.readPublicaciones("Datuak/Datuak/publications-titles-all.txt");
		milisFin = System.currentTimeMillis();
		System.out.println("ReadPublicaciones: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//Buscar Publi Por ID
		milisInicio = System.currentTimeMillis();
		rp.buscarPubliPorId("Q33205611");
		milisFin = System.currentTimeMillis();
		System.out.println("BuscarPubliPorID: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//ListaPublisCitadas
		milisInicio = System.currentTimeMillis();
		rp.listaPublisCitadas("Q21136163");
		milisFin = System.currentTimeMillis();
		System.out.println("ListaPublisCitadas: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//ListaAutoresPubli
		milisInicio = System.currentTimeMillis();
		rp.listaAutoresPubli(rp.buscarPubliPorId("Q101088249"));
		milisFin = System.currentTimeMillis();
		System.out.println("ListaAutoresPubli: "+((milisFin-milisInicio)/1000)+" segundos");

		//ListaPublicacionesAutor
		milisInicio = System.currentTimeMillis();
		Autor a1 = new Autor("Q47372720", "Andrew J. Stewart");
		rp.listaPublicacionesAutor(a1);
		milisFin = System.currentTimeMillis();
		System.out.println("ListaPublicacionesAutor: "+((milisFin-milisInicio)/1000)+" segundos");

		//OrdenarAlfabeticamente
		milisInicio = System.currentTimeMillis();
		rp.ordenarAlfabeticamente();
		milisFin = System.currentTimeMillis();
		System.out.println("OrdenarAlfabeticamente: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//Load Autores
		milisInicio = System.currentTimeMillis();
		rp.loadAutores("Datuak/Datuak/JUnit loadAutores.txt");
		milisFin = System.currentTimeMillis();
		System.out.println("LoadAutores: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//Load Publicaciones
		milisInicio = System.currentTimeMillis();
		rp.loadPublicaciones("Datuak/Datuak/JUnit loadPublis.txt");
		milisFin = System.currentTimeMillis();
		System.out.println("LoadPublicaciones: "+((milisFin-milisInicio)/1000)+" segundos");
		
		//Load Citas
		milisInicio = System.currentTimeMillis();
		rp.loadCitas("Datuak/Datuak/JUnit loadCitas.txt");
		milisFin = System.currentTimeMillis();
		System.out.println("LoadCitas: "+((milisFin-milisInicio)/1000)+" segundos");
		
	}

}
