package pajaros;

public class Piolin extends Canario{
	
	public Integer numPeliculas;

	public Piolin(char sexo, Integer edad, Float tamano, Integer numPeliculas) {
		super(sexo, edad, tamano);
		this.numPeliculas = numPeliculas;
		
	}
	
	public void altura() {
		if(tamano>30) {
			System.out.println("Alto");
		}
		else if(tamano<15) {
			System.out.println("Mediano");
		} 
		else {
			System.out.println("Bajo");
		}	
	}
	
	void cantar() {
		System.out.println("Pio-pio soy un Piolín");
	}

}
