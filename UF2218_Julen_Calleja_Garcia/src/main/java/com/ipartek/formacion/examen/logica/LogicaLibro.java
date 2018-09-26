package com.ipartek.formacion.examen.logica;

import java.math.BigDecimal;

import com.ipartek.formacion.examen.accesodatos.MapDAO;
import com.ipartek.formacion.examen.pojo.Libro;
import com.ipartek.formacion.examen.pojo.Usuario;



public class LogicaLibro {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Libro> paginas = new MapDAO<Libro>();
	
	static { 
		usuarios.insert(new Usuario(1, "javier@email.com", "contra"));
		usuarios.insert(new Usuario(2, "admin@email.com", "contra"));
		
		for(int i = 1; i <= 10; i++) { //genero unos productos tambien por defecto
			productos.insert(new Producto(i, "Producto" + i, new BigDecimal(i*10 + "." + i)));
		}
	}
	
}
