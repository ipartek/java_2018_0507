package com.ipartek.formacion.ejemplos.librocompartido.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.ipartek.formacion.ejemplos.librocompartido.pojos.ConnectLibrosBD;
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
	
	public static String obtenerPaginaBD(int numeroPagina) {
		System.out.println("Pagina obtenerPaginaBD(int numeroPagina) " +numeroPagina);
		String contenidopag=ConnectLibrosBD.getContenidoPagina(numeroPagina);
		
		System.out.println("obtenerPaginaBD"+contenidopag);
		
		
		
		
		
		return contenidopag;
		
	}
	
	

	public static int obtenerNumeroPaginas() {
		
		int numPaginaMayorenBD = numPaginaMayorenBD();
		Pagina pag=new Pagina();
		pag.setNumero(numPaginaMayorenBD);
		return libro.size();
	}

	public static int numPaginaMayorenBD() {
		return ConnectLibrosBD.getNumPaginasBD();
	}

	public static boolean agregarPagina(Pagina pagina) throws ClassNotFoundException {
		if(new StringTokenizer(pagina.getContenido()).countTokens() >= 25) {
			libro.put(pagina.getNumero(), pagina);
			ConnectLibrosBD.anadirPaginaaBD(pagina.getAutor(),pagina.getNumero(),pagina.getContenido());
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
