package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ipartek.formacion.springrestcrud.entidades.Estado;

import com.ipartek.formacion.springrestcrud.repositories.CrudAble;


/**
 * Servlet implementation class AgregarPersonaServlet
 */

@Controller
public class ListadoEstados {
	@Autowired
	private final CrudAble<Estado> repositorio_est = null;
		
	@GetMapping("/AgregarEstado")
	public String AgregarEstado(Model modelo) {
		
		//añadir el listado de equipos modelo.addAttribute("listaincidencia",lista);
		
		return "agregarestado";
	}
	
	@GetMapping("/ListadoEstados")
	public String listadoEstados(Model modelo) {
		List<Estado> lista_est = repositorio_est.getAll();
		
		modelo.addAttribute("listaestados",lista_est);
			
		return "verestados";
	}
	

	@RequestMapping("/addEstado")
	public String addEstado(Estado estado,Model modelo) {
		repositorio_est.insert(estado);
		
		List<Estado> lista = repositorio_est.getAll();	
		modelo.addAttribute("listaestados",lista);
			
		return "verestados";
	}
	
	
	
	@RequestMapping("/modifEstado")
	public String modifEstado(Estado estado,Model modelo) {
		//System.out.println("En modif estado");
		//Update
		//System.out.println(estado);
		repositorio_est.update(estado);
		//EndUpdate
		
		List<Estado> lista = repositorio_est.getAll();
		
		modelo.addAttribute("listaestados",lista);
		
		//el nombre del jsp
		return "verestados";
	}
}
