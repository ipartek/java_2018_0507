package com.ipartek.formacion.ejemplos.librocompartido.logica;

import java.util.TreeMap;

import com.ipartek.formacion.ejemplos.librocompartido.pojos.Pagina;

public class LogicaNegocio {
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

	public static void agregarPagina(Pagina pagina) {
		libro.put(pagina.getNumero(), pagina);		
	}
}
