package pajaros;

public abstract class Canario extends Ave {

	private Float tamano;

	public Canario(char sexo, Integer edad) {
		super(sexo, edad);
	}
	
	public Canario(char sexo, Integer edad, Float tamano) {
		super(sexo, edad);
		this.setSexo(sexo);
		this.setEdad(edad);
		this.setTamano(tamano);
	}
	
	public void altura() {
		if(getTamano()!=null) {
				
			if(getTamano()>30) {
				System.out.println("Alto");
			}
			else if(getTamano()<15) {
				System.out.println("Mediano");
			} 
			else {
				System.out.println("Bajo");
			}	
		}else {
			System.out.println("El canario no tiene tamaño.");
		}
	}

	public Float getTamano() {
		return tamano;
	}

	public void setTamano(Float tamano) {
		this.tamano = tamano;
	}

}
