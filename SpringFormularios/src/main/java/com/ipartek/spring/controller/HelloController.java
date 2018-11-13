package com.ipartek.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller 
public class HelloController implements WebMvcConfigurer {

	   @GetMapping("/prueba")
	    public String PruebaForm(Model model) {
	        model.addAttribute("prueba", new Prueba());
	        return "Prueba";
	    }

	    @PostMapping("/prueba")
	    public String PruebaForm(@Valid Prueba ValidarPrueba,@ModelAttribute Prueba prueba,BindingResult bindingResult) {
	    	
	    	
	    	  if (bindingResult.hasErrors()) {
	              return "Prueba";
	          }
	        return "Resultado";
	    }
	    
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/prueba").setViewName("Prueba");
	    }
}
