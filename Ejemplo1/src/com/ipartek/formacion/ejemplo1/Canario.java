package com.ipartek.formacion.ejemplo1;

public class Canario extends Ave {

	 Integer tamano;
	
	 public Canario(char sexo, int edad) {
			
			
			super(sexo,edad);
		
		}
	 
	 public Canario(char sexo, int edad, Integer tamano) {
		
		
		super(sexo,edad);
		this.tamano = tamano;
	}
	
	 
	 
	 public void altura() {
		 
		 
		 
		if(tamano != null) {
		 
		 
		 if( tamano > 30) {
			
			 System.out.println("Alto");
			 
		 }else if(tamano<15) {
			 System.out.println("Bajo");
			
			 }else  {
				 System.out.println("Mediano");
			 }
		 
		 
		 
	 }
	 }
	 
	 
	 public void setTamano(Integer tamano) {
			this.tamano = tamano;
		}
	
	 
	 
}
