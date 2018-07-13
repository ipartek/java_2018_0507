package com.ipartek.formacion.ejercicio1.poo;

/*La clase Ave
• Tiene como atributos de instancia el sexo (M/H), la edad (entero) y como
atributo de clase el número de aves creadas, que se incrementa cada vez que
se crea un nuevo Ave
• Tiene como método el constructor que inicializa, con los parámetros que recibe,
los dos atributos de la clase.
• Además existe un método de clase que indica el número de Aves creadas
• Además tiene un método quienSoy que saca los valores de los dos atributos
por pantalla */

public class Ave {
	
	private char sexo;
	private Integer edad;
	private static int avesCreadas = 0;
	
	public Ave (char sexo, Integer edad) {
		setSexo(sexo);
		setEdad(edad);
		avesCreadas += 1;
	}

	public static void getAvesCreadas() {
		System.out.println(avesCreadas);
	}
	
	public void quienSoy() {
		System.out.println("Sexo: " + sexo + ", edad: " + edad +"\n");
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		if (Character.compare(sexo, 'M') != 0 || Character.compare(sexo, 'H') != 0) {
			this.sexo = 'M';
		}else {
			this.sexo = sexo;
		}
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	
}
