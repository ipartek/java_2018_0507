package com.ipartek.formacion.pajaros;

/**
 * Clase ave
 * aveaveaveave
 * 
 * @author Curso
 *
 */

public abstract class Ave{

	private char sexo;			//Atributo de instancia
	private int edad;			//Atributo de instancia
	public static int num_aves=0; //Atributo de clase
	public String nombres;
	
	
	/* La clase Ave tendrá un método abstracto que s7erá cantar. Para un Piolín cantar
	 será sacar el mensaje “Pio-pio soy un Piolín” +y para un Loro cantar será sacar
	 un mensaje diciendo “Piiio-piiiio loro bonito”*/
	/**
	 * constructor ave
	 * aveaveaveave
	 * 
	 * @author Curso
	 * 
	 * @param sexo sexo de la ave
	 *
	 */
	public Ave(char sexo, int edad) {
		
		this.sexo=sexo;
		this.edad=edad;
		num_aves++;
		
		
		String nombreAve = DatosPersonales.getNombreAve();
		
		System.out.println(nombreAve);
		
	}
	
	public Ave() {
		
	}
	
	/**
	 * metodo quiensoy
	 * soy
	 * 
	 * @author Curso
	 *
	 */

	public void quienSoy() {
		System.out.println(this.sexo+"----"+this.edad);
	}
	
	public static void mostrarNAves() {
		System.out.println("NºAves creadas:"+ num_aves);
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexor) {
		sexo=sexor;
	}
	
	public char getEdad() {
		return sexo;
	}
	public void setEdad(char edadr) {
		edad=edadr;
	}
	
	public static void cantar(String quien) {
		
		if(quien.equals("Piolin")) {
			System.out.println("Pio-pio soy un Piolín");
		}else if(quien.equals("Loro")) {
			System.out.println("Piiio-piiiio loro bonito");
		}
	}
	
}
