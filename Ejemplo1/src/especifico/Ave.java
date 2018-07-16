package especifico;

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
		
		
		String nombreAves = DatosPersonales.getNombreAve();
		
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
		System.out.println( num_aves);
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
	
	public static void cantar(String canto) {
		System.out.println(canto);
		
	}
}
