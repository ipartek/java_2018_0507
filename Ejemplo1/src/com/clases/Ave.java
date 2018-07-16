package com.clases;

public abstract class Ave {
	char sexo;
	int edad;
	DatosPersonales nombres;
	
	public DatosPersonales getNombres() {
		return nombres;
	}

	public void setNombres(DatosPersonales nombres) {
		this.nombres = nombres;
	}
	private  static int numeroAves;
	
	public static int getNumeroAves(){
		return numeroAves;
	}
	abstract public void cantar();

	//mostrar datos
	public void quienSoy() {
		System.out.println("El sexo del ave es:"+sexo);
		System.out.println("La edad del pajaro es:"+edad);
	}
	//contructor;
	public Ave(char sexo, int edad) {
		super();
		this.sexo = sexo;
		this.edad = edad;
		numeroAves++;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

}
