package com.javierlete.testjsp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	@GetMapping("/indice")
	public String principal(Model modelo) {
		System.out.println("PRINCIPAL");
		
		modelo.addAttribute("informacion", "Ejemplo de vistas JSP y JSTL en Spring Boot");
		
		return "principal";
	}
}
