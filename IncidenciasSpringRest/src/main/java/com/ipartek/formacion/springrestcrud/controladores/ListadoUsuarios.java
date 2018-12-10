package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springrestcrud.entidades.Incidencia;
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
	public String listadoIncidencias(Model modelo) {
		List<Usuario> lista = repositorio_u.getAll();
		
		modelo.addAttribute("listausuarios",lista);
			
		return "verusuarios";
	}
	

	@RequestMapping("/addUsuario")
	public String addIncidencia(Usuario usuario) {
		repositorio_u.insert(usuario);
		
		
		return "index";
	}
}
