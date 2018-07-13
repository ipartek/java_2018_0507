package com.ipartek.formacion.ejemplo1;

public class Loro  extends Ave{

	char region;
	String color;
	
	
	 public Loro(char sexo, int edad, char region, String color) {
		
		    super(sexo,edad);
			this.region = region;
			this.color = color;
			
			
		}
	
	
	public void deDondeEres(char region) {
		
		if(region== 'N') {
			System.out.println("Norte");
		}else if(region ==  'S') {
			System.out.println("sur");
		}else if(region== 'E') {
			System.out.println("Este");
		}else if(region ==  'O'){
			System.out.println("Oeste");
		}
		
		
	}
	
	
	public void setRegion(char region) {
		this.region = region;
	}
	
	
	
	
}
