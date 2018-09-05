package com.ipartek.formacion.primerProg.personas;

import java.util.Date;

public class Alumno extends Persona{
	public Integer notaMedia;
	
	
	public Alumno(String nombre,String apellidos,Integer altura,Date fechaNacimiento,String numeroCuenta,Integer notaMedia ) {
		super(nombre, apellidos, altura, fechaNacimiento, numeroCuenta);
		this.notaMedia=notaMedia;
	}
	
	
	public Integer darPaga() {
		return 0;
	}
	

}
