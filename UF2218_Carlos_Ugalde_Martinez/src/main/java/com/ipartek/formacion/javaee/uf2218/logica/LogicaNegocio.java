package com.ipartek.formacion.javaee.uf2218.logica;


import java.util.List;

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
		
		paginas.insert(new Pagina(1, "b", "ERASE UNA VEZ"));
		
	/*	for(int i = 1; i <= 10; i++) {
			paginas.insert(new Pagina(i, "gato","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente laudantium, at natus ullam inventore sunt accusantium reprehenderit, quisquam delectus laborum nisi quia ratione voluptatum, accusamus mollitia autem deserunt quibusdam repudiandae."));
		}*/
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
	
	public static void agregarPagina(Pagina pagina) {
		if(!paginas.insert(pagina)) {
			throw new LogicaNegocioException("No se ha podido insertar la pagina");
		}
	}
}
