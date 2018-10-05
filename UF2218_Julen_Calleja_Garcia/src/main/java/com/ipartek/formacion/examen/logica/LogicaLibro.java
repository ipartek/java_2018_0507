package com.ipartek.formacion.examen.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.ipartek.formacion.examen.pojo.Pagina;
import com.ipartek.formacion.examen.pojo.Usuario;

public class LogicaLibro {
	private static TreeMap<Integer, Pagina> libro = new TreeMap<>();
	private static TreeMap<Integer, Usuario> usuarios = new TreeMap<>();

	static {

		usuarios.put(new Integer(1), new Usuario("William", "Shakespeare"));
		usuarios.put(new Integer(2), new Usuario("cervantes", "saavedra"));
		usuarios.put(new Integer(3), new Usuario("pablo", "neruda"));
		usuarios.put(new Integer(4), new Usuario("paulo", "cohelo"));

		libro.put(new Integer(1), new Pagina(1, "YO", "Erase una vez..."));
	}

	public static Pagina obtenerPagina(int numeroPagina) {
		if (numeroPagina < 1) {
			numeroPagina = 1;
		}

		if (numeroPagina > libro.size()) {
			numeroPagina = libro.size();
		}

		return libro.get(numeroPagina);
	}

	public static int obtenerNumeroPaginas() {
		return libro.size();
	}

	public static boolean agregarPagina(Pagina pagina) {
		if (new StringTokenizer(pagina.getContenido()).countTokens() >= 25) {
			libro.put(pagina.getNumero(), pagina);
			return true;
		} else {
			return false;
		}
	}

	public static List<Integer> buscarTexto(String texto) {
		ArrayList<Integer> numerosPagina = new ArrayList<>();

		for (Pagina pagina : libro.values()) {
			if (pagina.getContenido().contains(texto)) {
				numerosPagina.add(pagina.getNumero());
			}
		}

		return numerosPagina;
	}

	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u: usuarios.values()) {
			if (u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
}
