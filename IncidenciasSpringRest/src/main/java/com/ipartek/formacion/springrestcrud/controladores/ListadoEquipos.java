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
public class ListadoEquipos {
	@Autowired
	private final CrudAble<Equipo> repositorio_e = null;
		
	@GetMapping("/AgregarEquipo")
	public String AgregarUsuario(Model modelo) {
		
		//añadir el listado de equipos modelo.addAttribute("listaincidencia",lista);
		
		return "agregarequipo";
	}
	
	@GetMapping("/ListadoEquipos")
	public String listadoEquipo(Model modelo) {
		List<Equipo> lista_e = repositorio_e.getAll();
		
		modelo.addAttribute("listaequipos",lista_e);
			
		return "verequipos";
	}
	

	@RequestMapping("/addEquipo")
	public String addEquipo(Equipo equipo,Model modelo) {
		repositorio_e.insert(equipo);
		
		List<Equipo> lista = repositorio_e.getAll();	
		modelo.addAttribute("listaequipos",lista);
			
		return "verequipos";
	}
	
	
	
	@RequestMapping("/modifEquip")
	public String modifEquipo(Equipo equipo,Model modelo) {
		//System.out.println("En modif equipo");
		//Update
		repositorio_e.update(equipo);
		//EndUpdate
		
		List<Equipo> lista = repositorio_e.getAll();
		
		modelo.addAttribute("listaequipos",lista);
		
		//el nombre del jsp
		return "verequipos";
	}
}
