package com.ipartek.formacion.pildoras;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;


//Al poner las anotaciones te crea los contructores y los geters y setters por la dependencia del lombok
//Se ve lo que te genera el lombok en el outline
public @Log @Data @AllArgsConstructor class Persona {
	
	//private final static Logger log=Logger.getLogger(Persona.class.getName());
	
	
	private Long id;
	private String nombre,apellidos;
	private Date fechadeNacimiento;
	private String email;
	
	public void setEmail(String email) {
		
		if(email.indexOf('@') == -1){
			
			//Al poner @Log en la clase te crea el looger como la primera linea
			log.info("No hay arroba");
			throw new RuntimeException("No tiene arroba");
		}
		this.email=email;
	}
}
