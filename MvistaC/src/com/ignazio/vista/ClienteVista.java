package com.ignazio.vista;
 
public class ClienteVista {
	public void imprimirDatosCliente(int id,String nombre, String apellido) {
		System.out.println("**** DATOS CLIENTE ****");
		System.out.println("Id: "+id);
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
	}
}