package pajaros;

public abstract class Ave {
	
	private char sexo;
	private Integer edad; //atributo de instancia
	private static Integer numAves = 0; //atributo de clase
	private DatosPersonales nombres; //atributo de la clase DatosPersonales
	
	public DatosPersonales getNombres() {
		return nombres;
	}

	public void setNombres(DatosPersonales nombres) {
		this.nombres = nombres;
	}

	public Ave(char sexo, Integer edad) {
		this.sexo = sexo;
		this.edad = edad;
		numAves++;
	}
	
	public void mostrarNumAves() {
		System.out.println(numAves);
	}
	
	public void quienSoy() {
		System.out.println("Sexo: " + sexo + ", edad: " + edad);
	}
	
	abstract void cantar();

}
