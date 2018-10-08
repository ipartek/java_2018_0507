package logica;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
import pojo.Hoja;
import pojo.Usuario;

public class LogicaNegocio {
	private static TreeMap<Integer, Hoja> libro = new TreeMap<>();
	static ArrayList<Usuario> usuarios = new ArrayList<>();

	static {
		usuarios.add(new Usuario(1,"william", "shakespeare"));
		libro.put(new Integer(1), new Hoja(1,"YO","Erase una vez..."));
		libro.put(new Integer(1), new Hoja(2,"YO","Lorem ipsum"));
		libro.put(new Integer(1), new Hoja(3,"YO","Y comieron perdices"));
		libro.put(new Integer(1), new Hoja(4,"YO","Ultima pagina"));
	}
	
	//Comprobar si el numero de hoja es la primera
	public static Hoja obtenerHoja(int numeroHoja) {
		if(numeroHoja < 1) {
			numeroHoja = 1;
		}
		
		if(numeroHoja > libro.size()) {
			numeroHoja = libro.size();
		}
		
		return libro.get(numeroHoja);
	}
	
	public static int obtenerNumeroHojas() {
		return libro.size();
	}
	
	public static boolean insertarNuevaHoja(Hoja hoja) {
		if(new StringTokenizer(hoja.getTexto()).countTokens() >=25) {
			libro.put(hoja.getId(), hoja);
			return true;
		}else {
			return false;
		}
	}
	
	public static List<Integer> buscarTexto(String texto){
		ArrayList<Integer> numeroHoja = new ArrayList<>();
		
		for(Hoja hoja: libro.values()) {
		if(hoja.getTexto().contains(texto)) {
			numeroHoja.add(hoja.getId());
		}
		}
		return numeroHoja;
	}
}