package modelo;
import java.util.ArrayList;

public class ListaPerros {
	static ArrayList<Perro> listaPerros = new ArrayList<Perro>();

	public static ArrayList<Perro> getListaPerros() {
		return listaPerros;
	}

	public static void setListaPerros(ArrayList<Perro> listaPerros) {
		ListaPerros.listaPerros = listaPerros;
	}

}
