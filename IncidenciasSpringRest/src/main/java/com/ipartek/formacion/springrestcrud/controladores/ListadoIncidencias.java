package com.ipartek.formacion.springrestcrud.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Servlet implementation class AgregarPersonaServlet
 */

@Controller
public class ListadoIncidencias {
	
	@GetMapping("/ListadoIncidencias")
	public String hola() {
		System.out.println("jhkhjkhjk");
		return "index";
	}
	
}
