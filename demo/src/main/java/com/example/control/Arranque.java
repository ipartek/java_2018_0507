package com.example.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class Arranque {
	@GetMapping("/")
	public String inicio() {
		return"prueba";
	}
		
	
	

}
