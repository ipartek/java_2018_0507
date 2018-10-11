package com.ipartek.formacion.ejemplos.listas;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {

	
	public static void main(String args[]) {
		
		//Crear Lista
		List <Persona> person=new ArrayList<Persona>();
		
		//Rellenar lista
		for (int i =0;i<6;i++)
			person.add(new Persona(i,"nombre"+i));
		
		//Mostrar lista
		for (Persona x:person) {
			System.out.println("Recorrer lista->" + x.getNombreP() + " " + x.getNumeroP()	);
			
		}
	}

}
