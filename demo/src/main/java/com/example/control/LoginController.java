package com.example.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	//@ModelAttribute("sesion")

	@GetMapping("/login")
	public String comprobarGet(@RequestParam("email") String uCorreo, @RequestParam("pass") String uPass) {
return "redirect:/";		/*
		String correo = "admin@admin.com";
		String pass = "admin";
		
		return "prueba";
		/*
		if (correo.equals(uCorreo)) {
			model.addAttribute("email", uCorreo);
			if (pass.equals(uPass)) {
				model.addAttribute("pass", uPass);
				 return "prueba";
			} else {
				 return "prueba";
			}
		} else {
			 return "prueba";
		}*/
	}
	

}
