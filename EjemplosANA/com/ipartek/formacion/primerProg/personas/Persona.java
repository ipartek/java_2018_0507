package com.ipartek.formacion.primerProg.personas;

import java.util.Date;

public class Persona {
	//Atributos-VARIABLES
	public String apellidos;
	public String nombre;
	public Integer altura;
	public Date fechaNacimiento;
	private String numeroCuenta;
	
	//Constructores

	public Persona(String nombre,String apellidos,Integer altura,Date fechaNacimiento,String numeroCuenta ) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.altura=altura;
		this.fechaNacimiento=fechaNacimiento;
		//this.numeroCuenta=numeroCuenta;
		numeroCuenta="12345678901234567890";
		this.setNumeroCuenta(numeroCuenta);
	}
	
	
	//Comportamientos-Metodos
	public void saludar() {
		System.out.println("Hola");
	}
	
	public void andar(Integer pasos) {
		System.out.println("He andado "+pasos+" pasos");
	}
	
	public Integer darPaga() {
		return 25;
	}
	public Integer darPaga(int i) {
		return 20+i;
	}
	
	public String getNumeroCuenta(){
		return numeroCuenta.substring(numeroCuenta.length()-4);
		
	}
	
	public void setNumeroCuenta(String nCuenta) {
		if(nCuenta.length()!=20) {
			System.out.println("el numero de cuenta tiene que tener 20 digitos");
		}else {
			numeroCuenta=nCuenta;
		}
	}
	
}
