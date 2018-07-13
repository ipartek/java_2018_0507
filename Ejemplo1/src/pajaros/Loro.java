package pajaros;

public class Loro extends Ave {
	
	public char region;
	public String color;

	public Loro(char sexo, Integer edad, char region, String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}
	
	public void deDondeEres() {
		switch(this.region) {
		case 'N':
			System.out.println("Norte");
			break;
		
		case 'S':
			System.out.println("Sur");
			break;
		
		case 'E':
			System.out.println("Este");
			break;
	
		case 'O':
			System.out.println("Oeste");
			break;
			
		default:
			System.out.println("No es una region conocida");
		}
	}

	void cantar() {
		System.out.println("Piiio-piiiio loro bonito");
	}
	

}