package com.ipartek.formacion.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaludoController {

	@GetMapping("/saludo")
	public String saludar(
			@RequestParam(name="nombre", required=false, defaultValue="Desconocido") String nombre, 
			@RequestParam(name="apellidos", required=false, defaultValue="Desconocidez") String apellido, 
			Model modelo) {
		
		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("apellido", apellido);
		
		return "bienvenida";
	}
}
