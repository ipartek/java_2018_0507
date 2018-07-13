package com.ipartek.formacion.ejemplo1;

public class Ave {

	// atributos de instancia
	private char sexo;
	private int edad;

	private DatosPersonales nombres;

	

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

	public DatosPersonales getNombres() {
		return nombres;
	}

	public void setNombres(DatosPersonales nombres) {
		this.nombres = nombres;
	}

	public static Integer getNumAvesCreadas() {
		return numAvesCreadas;
	}

	public static void setNumAvesCreadas(Integer numAvesCreadas) {
		Ave.numAvesCreadas = numAvesCreadas;
	}

	// atributos de clase (static)
	public static Integer numAvesCreadas = 0;

	public Ave() {
		this.sexo = sexo;
		this.edad = edad;
		numAvesCreadas++;

	}

	public Ave(char sexo, int edad) {
		this.sexo = sexo;
		this.edad = edad;

	}

	public void quienSoy() {
		System.out.println("Sexo: " + sexo + "Edad: " + edad);
	}

	public static void mostrarAvesCreadas() {
		System.out.println(numAvesCreadas);
	}

	/**
	 * método abstracto que será cantar. Para un Piolín cantar será sacar el mensaje
	 * “Pio-pio soy un Piolín” y para un Loro cantar será sacar un mensaje diciendo
	 * “Piiio-piiiio loro bonito”
	 * 
	 * @param tipo
	 * @return
	 */
//	public String cantar(String tipo) {
//		String mensaje = "";
//
//		if (tipo.equals(Piolin.class)) {
//			mensaje = "Pio-pio soy un Piolín";
//			System.out.println(mensaje);
//		} else {
//			mensaje = "Piiio-piiiio loro bonito";
//			System.out.println(mensaje);
//		}
//
//		return mensaje;
//	}
	
	public void cantar()  {
	String mensaje = "";

		if (this.getClass().equals(Loro.class)) {
			mensaje = "Piiio-piiiio loro bonito";
			System.out.println(mensaje);
		} else{
			mensaje = "Pio-pio soy un Piolín";
			System.out.println(mensaje);
		}
	

}}
