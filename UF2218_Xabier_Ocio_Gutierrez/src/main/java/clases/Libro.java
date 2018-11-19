package clases;
import java.util.ArrayList;

public class Libro {

	static ArrayList<Pagina>libro=new ArrayList<Pagina>();

	public static ArrayList<Pagina> getLibro() {
		return libro;
	}

	public static void setLibro(ArrayList<Pagina> libro) {
		Libro.libro = libro;
	}

}
