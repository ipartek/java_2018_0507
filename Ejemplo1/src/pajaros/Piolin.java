package pajaros;

public class Piolin extends Canario{
	
	private Integer numPeliculas;

	public Piolin(char sexo, Integer edad, Float tamano, Integer numPeliculas) {
		super(sexo, edad, tamano);
		this.setNumPeliculas(numPeliculas);
		
	}
	
	public void altura() {
		if(getTamano()>30) {
			System.out.println("Alto");
		}
		else if(getTamano()<15) {
			System.out.println("Mediano");
		} 
		else {
			System.out.println("Bajo");
		}	
	}
	
	void cantar() {
		System.out.println("Pio-pio soy un Piolín");
	}

	public Integer getNumPeliculas() {
		return numPeliculas;
	}

	public void setNumPeliculas(Integer numPeliculas) {
		this.numPeliculas = numPeliculas;
	}

}
