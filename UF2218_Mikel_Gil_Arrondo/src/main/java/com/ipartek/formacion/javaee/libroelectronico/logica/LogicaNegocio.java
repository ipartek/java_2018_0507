package com.ipartek.formacion.javaee.libroelectronico.logica;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.ipartek.formacion.javaee.libroelectronico.accesodatos.UsuarioMapDAO;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Pagina;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Usuario;

public class LogicaNegocio {
	private static UsuarioMapDAO usuarios = new UsuarioMapDAO();
	private static TreeMap<Integer, Pagina> libro = new TreeMap<>();

	// Datos de inicio
	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "Cervantes", "Saavedra"));
		usuarios.insert(new Usuario(3, "Pablo", "Neruda"));
		usuarios.insert(new Usuario(4, "Paulo", "Cohelo"));
		
		libro.put(new Integer(1), new Pagina(1, 
				"Erase una vez... Lorem ipsum dolor sit amet, "
				+ "consectetur adipiscing elit. Fusce interdum neque a purus pulvinar, "
				+ "vel dapibus lorem cursus. Fusce purus turpis, pretium ac arcu eu, "
				+ "laoreet pretium lectus. Pellentesque ut massa nec orci viverra vulputate. "
				+ "Pellentesque ut nibh augue. Maecenas ultrices fermentum convallis.",
				"Pablo"));
	}

	// Funcion para validar el usuario contra la lista de usuarios
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
	
	// Función para obtener el numero total de páginas en el libro
	public static int obtenerPaginas() {
		return libro.size();
	}
	
	// Función para obtener la página pasandole un id
	public static Pagina obtenerPaginaPorId(int id) {
		if(id < 1) {
			id = 1;
		}
		if(id > libro.size()) {
			id = libro.size();
		}
		return libro.get(id);
	}
	
	// Función para escribir una nueva página.
	// Se usa StringTokenizer para contar las palabras. En este caso tienen que ser más de 25.
	public static boolean validarPagina(Pagina pagina) {
		if(new StringTokenizer(pagina.getTexto()).countTokens() >= 25) {
			libro.put((int) pagina.getId(), pagina);
			return true;
		} else {
			return false;
		}
	}
	
	// Función para buscar un texto en las páginas.
	public static List<Integer> buscarTexto(String texto) {
		ArrayList<Integer> numerosPagina = new ArrayList<>();
		
		for(Pagina pagina: libro.values()) {
			if(pagina.getTexto().contains(texto)) {
				numerosPagina.add((int) pagina.getId());
			}
		}
		return numerosPagina;
	}
}
