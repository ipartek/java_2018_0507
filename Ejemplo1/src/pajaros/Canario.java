package pajaros;

public abstract class Canario extends Ave {

	public Float tamano;

	public Canario(char sexo, Integer edad) {
		super(sexo, edad);
	}
	
	public Canario(char sexo, Integer edad, Float tamano) {
		super(sexo, edad);
		this.sexo = sexo;
		this.edad = edad;
		this.tamano = tamano;
	}
	
	public void altura() {
		if(tamano!=null) {
				
			if(tamano>30) {
				System.out.println("Alto");
			}
			else if(tamano<15) {
				System.out.println("Mediano");
			} 
			else {
				System.out.println("Bajo");
			}	
		}else {
			System.out.println("El canario no tiene tamaño.");
		}
	}

}
