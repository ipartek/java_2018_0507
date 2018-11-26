package com.ipartek.formacion.prestamolibrosspring.controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.prestamolibrosspring.model.Prestamo;
import com.ipartek.formacion.prestamolibrosspring.repositories.CrudAble;
import com.ipartek.formacion.prestamolibrosspring.repositories.LibroMapRepository;

@Controller
public class PrestamosController {
	@Autowired
	private final CrudAble<Prestamo> repositoriop = null;
	@Autowired
	private LibroMapRepository repositorilibros=null;
	
	@GetMapping("/prestamos")
	public String getAll(Model modelo) {
		modelo.addAttribute("prestamos", repositoriop.getAll());
		return "prestamos";
	}
	
	@GetMapping("/prestamos/{accion}/{id}") 
	public String mostrarPantalla(
			@PathVariable("id") Long id, @PathVariable("accion") String accion, Model modelo) {
		
		modelo.addAttribute("id", id);
		modelo.addAttribute("accion", accion);
		
		Prestamo prestamo;
		
		if(id != null && id != 0L) {
			prestamo = repositoriop.getById(id);
		} else {
			prestamo = new Prestamo(0,"titulo","usuario",null,null);
			
		}
		
			List<Prestamo> prestamos=repositoriop.getAll();
			
			for (Prestamo string : prestamos) {
		        System.out.println(string);
		    }
			
			
			
			Date fechaactual=new Date();
			//System.out.println("LocalDateTime.now()" +
			
				//	LocalDateTime.now().getYear()
					
				//	+LocalDateTime.now().getMonthValue()
				//	+LocalDateTime.now().getDayOfMonth());
			prestamo.setFechdevol(
					new Date(LocalDateTime.now().getYear()-1900,
							LocalDateTime.now().getMonthValue()-1,
							LocalDateTime.now().getDayOfMonth()));
			
			//System.out.println("FECHAdevol:"+accion+ prestamo.getFechdevol());
			//System.out.println("FECHAmostrar:"+accion+ prestamo.getFechaprestamo());

		
		modelo.addAttribute("prestamo", prestamo);
		System.out.println(repositorilibros.getAll());
		modelo.addAttribute("libros",repositorilibros.getAll());
		
		
		
		
		return "prestamo";
	}
	
	@PostMapping("/prestamos/{accion}")
	public String procesarPantalla(
			@PathVariable(value="accion") String accion, 
			@Valid Prestamo prestamo, BindingResult bindingResult) {
		
		
		
		
		System.out.println("ACCION" + accion);
		
	
//		
//		if (!accion.equals("borrar") && bindingResult.hasErrors()) {
//            return "prestamo";
//        }
//		
//		

		System.out.println("FECHA:"+ prestamo.getFechaprestamo()+prestamo.getFechaprestamo()+ prestamo.getFechaprestamo());



		switch(accion) {
		case "crear": 
			System.out.println("CREAR: " + prestamo.getTitulo() + "  " + prestamo.getFechaprestamo());
			repositoriop.insert(prestamo);
			break;
		//case "editar":
		//repositoriop.update(prestamo);
		case "devolver":
			//Devolver el libro es y ponerle la fecha de hoy
			
					
					System.out.println("devolver");
					
					
					
			
			break;
		case "borrar":
			repositoriop.delete((long) prestamo.getId());
			break;
		}
		
        return "redirect:/prestamos";
	}
}
