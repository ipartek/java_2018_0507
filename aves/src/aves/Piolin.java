package aves;

public class Piolin extends Canario{
	public Integer numPelis;
 public Piolin(char sexo, Integer edad,Integer tamano,Integer numPelis) {
		super(edad,sexo,tamano);
		this.numPelis=numPelis;
		
		// TODO Auto-generated constructor stub
	}
 public void cantar() {
     System.out.println("pio pio soy un piolon!");
 }


}
