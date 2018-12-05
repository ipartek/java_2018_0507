package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String listadoIncidencias() {
		
		List<Incidencia> lista = repositorio_i.getAll();
		
		for (Incidencia presente:lista) {
			System.out.println("id:" +presente.getId()  + " - equipo: " + presente.getEquipo() +" - desc: " + presente.getDescripcion());


		
		}
		return "index";
	}
	

	@RequestMapping("/addIncidencia")
	public String addIncidencia(Incidencia incidencia) {
		System.out.println("en AddIncidencia");
		repositorio_i.insert(incidencia);
		return "index";
	}
}
