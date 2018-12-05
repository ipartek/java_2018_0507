package com.ipartek.formacion.pildoras;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;


public @Log @Data @AllArgsConstructor class Persona {
	//private final static Logger log = Logger.getLogger(Persona.class.getName());
	
	private Long id;
	private String nombre, apellidos;
	private Date fechaDeNacimiento;
	private String email;
	
	public void setEmail(String email) {
		if(email.indexOf('@') == -1) {
			log.info("Me han pasado un email sin arroba");
			
			throw new RuntimeException("No tiene arroba el email");
		}
		
		this.email = email;
	}
}
 