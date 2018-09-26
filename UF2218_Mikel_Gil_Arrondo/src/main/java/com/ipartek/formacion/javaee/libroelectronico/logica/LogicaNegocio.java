package com.ipartek.formacion.javaee.libroelectronico.logica;


import java.util.List;

import com.ipartek.formacion.javaee.libroelectronico.accesodatos.MapDAO;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Libro;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Libro> paginas = new MapDAO<Libro>();

	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(3, "pablo", "neruda"));
		usuarios.insert(new Usuario(4, "paulo", "cohelo"));
		
		paginas.insert(new Libro(1, 
				"Erase una vez... Lorem ipsum dolor sit amet, "
				+ "consectetur adipiscing elit. Fusce interdum neque a purus pulvinar, "
				+ "vel dapibus lorem cursus. Fusce purus turpis, pretium ac arcu eu, "
				+ "laoreet pretium lectus. Pellentesque ut massa nec orci viverra vulputate. "
				+ "Pellentesque ut nibh augue. Maecenas ultrices fermentum convallis.",
				"Pablo"));
	}
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
	
	public static boolean validarPagina(Libro libro) {
		String textoAValidar = libro.getTexto();
		
		int numPalabras = 0;

	    boolean esPalabra = false;
	    
	    int retornoCarro = textoAValidar.length() - 1;

	    for (int i = 0; i < textoAValidar.length(); i++) {
	        // Si el char es una letra = palabra
	        if (Character.isLetter(textoAValidar.charAt(i)) && i != retornoCarro) {
	        	esPalabra = true;
	        } else if (!Character.isLetter(textoAValidar.charAt(i)) && esPalabra) {
	        	numPalabras++;
	        	esPalabra = false;
	        } else if (Character.isLetter(textoAValidar.charAt(i)) && i == retornoCarro) {
	        	numPalabras++;
	        }
	    }
	    
	    if (numPalabras > 25) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	public static Libro obtenerPaginaPorId(long id) {
		return paginas.getById(id);
	}
	
	public static List<Libro> obtenerPaginas() {
		return paginas.getAll();
	}
}
