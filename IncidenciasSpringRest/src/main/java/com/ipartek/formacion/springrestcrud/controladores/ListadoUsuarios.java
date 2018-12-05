package com.ipartek.formacion.springrestcrud.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springrestcrud.entidades.Usuario;
import com.ipartek.formacion.springrestcrud.repositories.CrudAble;


/**
 * Servlet implementation class AgregarPersonaServlet
 */

@Controller
public class ListadoUsuarios {
	@Autowired
	private final CrudAble<Usuario> repositorio_u = null;
		
	@GetMapping("/ListadoUsuarios")
	public String listadoIncidencias() {
		return "index";
	}
	

	@RequestMapping("/addUsuario")
	public String addIncidencia(Usuario usuario) {
		//System.out.println("en AddUsuario");
		//System.out.println("PARAMETRO" + usuario);
		repositorio_u.insert(usuario);
		
		
		return "index";
	}
}
