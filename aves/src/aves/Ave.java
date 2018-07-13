package aves;

public abstract class Ave {

	private  char sexo;
	private Integer edad;
	public DatosPersonales nombres;
	
	
	
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		if(sexo!='h'&& sexo!='m' )
			System.out.println("sexo incorrecto");
		else
		this.sexo = sexo;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public static Integer numAvesCreadas=0;
	
	public Ave(Integer edad, char sexo)
	{
		this.sexo=sexo;
		this.edad=edad;
		numAvesCreadas++;
		nombres=new DatosPersonales();
	}
	public void quienSoy()
	{
		System.out.println("mi sexo es " + sexo +" y tengo "+ edad);
	}
public static void mostrarNumAvesCreadas()
{
	System.out.println(numAvesCreadas);
}
public abstract void cantar();
}
