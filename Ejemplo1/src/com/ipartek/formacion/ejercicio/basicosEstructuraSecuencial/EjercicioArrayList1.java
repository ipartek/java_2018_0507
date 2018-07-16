//Calcular la altura media de los alumnos de una clase.
package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioArrayList1 extends LeerTeclado{

	public int alumnos;
	ArrayList <Double> altura = new ArrayList();
	//Double es mas preciso que Float.
	public double media;
	public double alturaAlumno;
	public double suma = 0;
	
	public EjercicioArrayList1(Scanner sc) {
		super(sc);
	}

	public void numeroAlumnos() {
		
		System.out.println("¿Cuantos alumnos hay en clase?");
		alumnos= leerInt(alumnos);
		System.out.println("Tenemos " + alumnos + " alumnos.");
		System.out.println("Introduzca la altura de los alumnos.");
		añadirAlumnos(alumnos);

	}
	public void añadirAlumnos(int alumnos) {
		for (int i = 0; i < alumnos; i++) {
			System.out.print((i+1) + " ");
			alturaAlumno = leerDoble(alturaAlumno);
			altura.add(alturaAlumno);
		}
		System.out.println("Ya ha introducido las " + alumnos + " alturas.");
		System.out.println("Se procede a calcular la media");
		media(altura);
	}
	public void media(ArrayList<Double> altura) {
		for(int i= 0;i < altura.size();i++) {
			suma = suma+ altura.get(i);
		}
		media = suma/alumnos; 
		System.out.println(media);
	}
}
