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
		this.setSexo(sexo);
		this.setEdad(edad);
		numAves++;
	}
	
	public void mostrarNumAves() {
		System.out.println(numAves);
	}
	
	public void quienSoy() {
		System.out.println("Sexo: " + getSexo() + ", edad: " + getEdad());
	}
	
	abstract void cantar();

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
