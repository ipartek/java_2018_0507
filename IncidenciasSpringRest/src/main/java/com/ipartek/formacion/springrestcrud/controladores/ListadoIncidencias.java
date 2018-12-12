package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springrestcrud.entidades.Equipo;
import com.ipartek.formacion.springrestcrud.entidades.Incidencia;
import com.ipartek.formacion.springrestcrud.entidades.Usuario;
import com.ipartek.formacion.springrestcrud.repositories.CrudAble;


@Controller
public class ListadoIncidencias {
	@Autowired
	private final CrudAble<Incidencia> repositorio_i=null;
	@Autowired
	private final CrudAble<Usuario> repositorio_u = null;
	
	@Autowired
	private final CrudAble<Equipo> repositorio_e=null;
		
	
	
	
	@GetMapping("/AgregarIncidencia")
	public String AgregarIncidencia(Model modelo) {
		
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		
		
		return "agregarincidencia";
	}
	
	@GetMapping("/ListadoIncidencias")
	public String listadoIncidencias(Model modelo) {
		
		List<Incidencia> lista = repositorio_i.getAll();
		
		modelo.addAttribute("listaincidencia",lista);
		
		return "verhistorico";
	}
	

	@RequestMapping("/crearIncidencia")
	public String crearIncidencia(Model modelo) {
		List<Usuario> lista = repositorio_u.getAll();
		List<Equipo> lista_equipo=repositorio_e.getAll();
	
		for(Equipo str : lista_equipo)
		{
		    System.out.println(str);
		}
		
		modelo.addAttribute("listausuarios",lista);
		modelo.addAttribute("listaequipos",lista_equipo);
		
		return "agregarincidencia";
	}
		

	@RequestMapping("/addIncidencia")
	public String addIncidencia(Incidencia incidencia,Model modelo) {
		System.out.println("en AddIncidencia");
		repositorio_i.insert(incidencia);
		List<Incidencia> lista = repositorio_i.getAll();
		modelo.addAttribute("listaincidencia",lista);
		return "verhistorico";
	}
	
	@RequestMapping("/modifIncidencia")
	public String modifIncidencia(Incidencia incidencia,Model modelo) {
		System.out.println("en modifIncidencia");
	
		repositorio_i.update(incidencia);
				
		List<Incidencia> lista = repositorio_i.getAll();
		
		modelo.addAttribute("listaincidencia",lista);
		
		return "verhistorico";
	}
}
