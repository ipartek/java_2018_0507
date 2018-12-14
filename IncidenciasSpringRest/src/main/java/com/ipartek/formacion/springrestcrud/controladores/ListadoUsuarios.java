package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springrestcrud.entidades.Equipo;
import com.ipartek.formacion.springrestcrud.entidades.Usuario;
import com.ipartek.formacion.springrestcrud.repositories.CrudAble;


/**
 * Servlet implementation class AgregarPersonaServlet
 */

@Controller
public class ListadoUsuarios {
	@Autowired
	private final CrudAble<Usuario> repositorio_u = null;
	@Autowired
	private final CrudAble<Equipo> repositorio_e=null;
	
	
	@GetMapping("/AgregarUsuario")
	public String AgregarUsuario(Model modelo) {
		List<Equipo> lista_equipo=repositorio_e.getAll();
		//añadir el listado de equipos modelo.addAttribute("listaincidencia",lista);
		modelo.addAttribute("listaquipos",lista_equipo);
		return "agregarusuario";
	}
	
	
	@GetMapping("/ListadoUsuarios")
	public String listadoIncidencias(Model modelo) {
		List<Usuario> lista = repositorio_u.getAll();
		
		modelo.addAttribute("listausuarios",lista);
			
		return "verusuarios";
	}
	

	@RequestMapping("/addUsuario")
	public String addIncidencia(Usuario usuario,Model modelo) {
		repositorio_u.insert(usuario);
		
		List<Usuario> lista = repositorio_u.getAll();
				
		modelo.addAttribute("listausuarios",lista);
			
		return "verusuarios";
	}
	
	
	
	@RequestMapping("/modifUsuario")
	public String modifIncidencia(Usuario usuario,Model modelo) {
	
		
		//System.out.println("en /modifUsuario");

		//Update
		repositorio_u.update(usuario);
		//EndUpdate
		
		List<Usuario> lista = repositorio_u.getAll();
		
		modelo.addAttribute("listausuarios",lista);
		
		//el nombre del jsp
		return "verusuarios";
	}
}
