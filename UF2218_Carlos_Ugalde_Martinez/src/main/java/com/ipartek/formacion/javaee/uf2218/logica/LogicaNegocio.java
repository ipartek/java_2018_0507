package com.ipartek.formacion.javaee.uf2218.logica;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.ipartek.formacion.javaee.uf2218.accesodatos.MapDAO;
import com.ipartek.formacion.javaee.uf2218.pojo.Pagina;
import com.ipartek.formacion.javaee.uf2218.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Pagina> paginas = new MapDAO<Pagina>();
	
	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(3, "pablo", "neruda"));
		usuarios.insert(new Usuario(4, "paulo", "cohelo"));
		usuarios.insert(new Usuario(5, "a", "a"));
		
		paginas.insert(new Pagina(1, "bota", "ERASE UNA VEZ"));
		paginas.insert(new Pagina(2, "gato","Lorem ipsum dolor sit"));
		paginas.insert(new Pagina(2, "bo", "ERASE DOS VECES"));
		paginas.insert(new Pagina(3, "bot", "ERASE TRES VECES"));
		paginas.insert(new Pagina(4, "bota", "ERASE CUATRO VECES"));
		paginas.insert(new Pagina(5, "b", "ERASE 5 VECES"));
		paginas.insert(new Pagina(6, "bo", "ERASE SEIS VECES"));
		paginas.insert(new Pagina(7, "bot", "ERASE 7 VECES"));
		/*
		for(int i = 2; i <= 10; i++) {
			paginas.insert(new Pagina(i, "gato","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente laudantium, at natus ullam "
					+ "inventore sunt accusantium reprehenderit, quisquam delectus laborum nisi quia ratione voluptatum, accusamus mollitia autem "));
		}*/
		
	}
	public static Pagina obtenerPagina(int numeroPagina) {
		
		if(numeroPagina < 1) {
			numeroPagina = 1;
		}
		
		if(numeroPagina > paginas.getAll().size()) {
			numeroPagina  = paginas.getAll().size();
		}
		
		return paginas.getById(numeroPagina);
	}
	
	public static int obtenerNumeroPaginas() {
		return paginas.getAll().size();
	}
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;	
	}
	
	public static List<Pagina> obtenerPaginas() {
		return paginas.getAll();
	}
	
	public static Pagina obtenerPaginasPorId(long id) {
		return paginas.getById(id);
	}
	
	public static boolean agregarPagina(Pagina pagina) {
		if(new StringTokenizer(pagina.getTexto()).countTokens() >= 25) {
			paginas.insert(pagina);
			return true;
		} else {
			return false;
		}
	}
	public static List<Long> buscarTexto(String texto) {
		ArrayList<Long> numerosPagina = new ArrayList<>();
		
		for(Pagina pagina: paginas.getAll()) {
			if(pagina.getTexto().contains(texto)) {
				numerosPagina.add(pagina.getId());
			}
		}
		
		return numerosPagina;
	}
}
