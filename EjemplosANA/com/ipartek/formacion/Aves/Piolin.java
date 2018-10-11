package com.ipartek.formacion.Aves;

public class Piolin extends Canario{
	public Integer nPeliculas;

	public Piolin(char sexo, Integer edad, Integer nPeliculas,int altura) {
		super(sexo, edad,nPeliculas,altura);
		
		this.nPeliculas = nPeliculas;
	}
	
	

/*
	• Llamar al método altura con la instancia del Piolín

	• Modificar el tamaño del Piolín y volver a invocar al método altura
	
	• Mostrar el número de Aves creadas. 
	
	*/
	
public static void altura(Piolin pio) {
		
		if (tamanio != null) {
			if (tamanio > 30) {
				System.out.println("Piolin Alto");
			}else if(tamanio<15) {
				System.out.println("Piolin Bajo");
				
			}else {
				System.out.println("Piolin Mediano");
			}
		}else {
			System.out.println("El canario no tiene tamanio");
		}
	}
}
