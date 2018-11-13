package com.ipartek.spring.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Prueba {
	
	@NotNull
	@Max(200)
	 private Long id;
	 
	 
	@NotNull
	@Size(min=5,max=10)
	private String contenido;

	

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getContenido() {
	        return contenido;
	    }

	    public void setContenido(String content) {
	        this.contenido = content;
	    }
	    
	    @Override
		public String toString() {
			return "Prueba [id=" + id + ", contenido=" + contenido + "]";
		}
	
}
