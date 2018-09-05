package com.ipartek.formacion.pajaros;

public class Piolin extends Canario{
	public Integer nPeliculas;
	public static String nombrepio;

	public Piolin(char sexo, Integer edad, Integer nPeliculas,int altura) {
		super(sexo, edad,nPeliculas,altura);
		
		this.nPeliculas = nPeliculas;
	}
	
	

	public static void setNombre(String nombrePio) {
		nombrepio = nombrePio;
	}
	public static String getNombre() {
		return nombrepio;
	}
	
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
