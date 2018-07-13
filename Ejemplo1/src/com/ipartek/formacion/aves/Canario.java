package com.ipartek.formacion.aves;

public class Canario extends Ave{
 public Integer tamano;
 
 public Canario(Integer edad,char sexo)
 {
	 super(edad,sexo);
 }
 public Canario(Integer edad,char sexo,Integer tamano)
 {
	 super(edad,sexo);
	 this.tamano=tamano;
 }

 public Integer getAltura()
 {
	 return tamano;
 }
 public void altura()
 {
	 if(tamano!=null)
	 {
		 if (tamano>30)
		 System.out.println("alto");
		 if(tamano<30 && tamano>15)
			System.out.println("mediano");
		 if (tamano<15)
			 System.out.println("pequeño");
	 }
	 else
		 System.out.println("no hay altura");
	 
	 System.out.println(" " + tamano);
		 
 }
@Override
public void cantar() {
	// TODO Auto-generated method stub
	
}
}
