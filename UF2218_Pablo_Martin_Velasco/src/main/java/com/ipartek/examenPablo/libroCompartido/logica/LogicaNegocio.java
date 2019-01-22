package com.ipartek.examenPablo.libroCompartido.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.ipartek.examenPablo.libroCompartido.acessodatos.MapDAO;
import com.ipartek.examenPablo.libroCompartido.pojo.Pagina;
import com.ipartek.examenPablo.libroCompartido.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();

	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(3, "pablo", "neruda"));
		usuarios.insert(new Usuario(4, "paulo", "cohelo"));		
	}
	

	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.getAll()) {
			if (u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}

		return false;
	}
	

		private static TreeMap<Integer, Pagina> libro = new TreeMap<>();
		
		static {
			libro.put(new Integer(1), new Pagina(1, "YO", "Erase una vez..."));
		}

		public static Pagina obtenerPagina(int numeroPagina) {
			if(numeroPagina < 1) {
				numeroPagina = 1;
			}
			
			if(numeroPagina > libro.size()) {
				numeroPagina  = libro.size();
			}
			
			return libro.get(numeroPagina);
		}

		public static int obtenerNumeroPaginas() {
			return libro.size();
		}

		public static boolean agregarPagina(Pagina pagina) {
			if(new StringTokenizer(pagina.getContenido()).countTokens() >= 25) {
				libro.put(pagina.getNumero(), pagina);
				return true;
			} else {
				return false;
			}
		}
		
		public static List<Integer> buscarTexto(String texto) {
			ArrayList<Integer> numerosPagina = new ArrayList<>();
			
			for(Pagina pagina: libro.values()) {
				if(pagina.getContenido().contains(texto)) {
					numerosPagina.add(pagina.getNumero());
				}
			}
			
			return numerosPagina;
		}
		
		
}
