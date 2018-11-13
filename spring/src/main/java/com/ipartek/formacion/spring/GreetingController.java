package com.ipartek.formacion.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@GetMapping("/saludo")
	public String saludar(
			@RequestParam(name="nombre",required=false,defaultValue="Desconocido") String nombre,
			@RequestParam(name="apellido",required=false,defaultValue="Desconocidez")String apellido,
			Model modelo) {
			
		
		//RequestParam es el Request.getParameter
		//Si no lo recibo me pone World
		
		//Añadir la pantalla el atributo Requst.setattributte
		modelo.addAttribute("nombre","Hola :   "+nombre );
		modelo.addAttribute("apellido", "   "+apellido);
	
		return "bienvenida";  //Se llama asi la vista(el html o otra cosa)
	}
}
