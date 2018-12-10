package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ipartek.formacion.springrestcrud.entidades.Incidencia;
import com.ipartek.formacion.springrestcrud.repositories.CrudAble;


/**
 * Servlet implementation class AgregarPersonaServlet
 */

@Controller
public class ListadoIncidencias {
	@Autowired
	private final CrudAble<Incidencia> repositorio_i=null;
		
	@GetMapping("/ListadoIncidencias")
	public String listadoIncidencias(Model modelo) {
		
		List<Incidencia> lista = repositorio_i.getAll();
		
		modelo.addAttribute("listaincidencia",lista);
		
		return "verhistorico";
	}
	

	@RequestMapping("/addIncidencia")
	public String addIncidencia(Incidencia incidencia) {
		System.out.println("en AddIncidencia");
		repositorio_i.insert(incidencia);
		return "index";
	}
	
	@RequestMapping("/modifIncidencia")
	public String modifIncidencia(Incidencia incidencia,Model modelo) {
		System.out.println("en modifIncidencia");

//		System.out.println(incidencia.getUsuario_creador() +" \n"+incidencia.getTitulo()+" \n"+ incidencia.getDescripcion() 
//		+" \n"+ incidencia.getEquipo() +" \n"+incidencia.getUsuario_asignado());
//	
		
//		//Update
	
		repositorio_i.update(incidencia);
		
		//EndUpdate
		
		List<Incidencia> lista = repositorio_i.getAll();
		
		modelo.addAttribute("listaincidencia",lista);
		
		return "verhistorico";
	}
}
