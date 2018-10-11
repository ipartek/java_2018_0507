package especifico;
public class Loro extends Ave{
	public char region;
	public String color;
	
	public Loro(char sexo,int edad, char region,String color) {
		
		super(sexo,edad);
		
	}
	public void setRegion(char region) {
		this.region=region;
		
	}
	public char getRegion() { 
		return region;
	};
	public void deDondeEres() {
	
		switch(this.region) {
			case 'N':
				System.out.println("Loro del norte");
				break;
			case 'S':
				System.out.println("Loro del sur");
				break;
			case 'O':
				System.out.println("Loro del oeste");
				break;
			case 'E':
				System.out.println("Loro del este");
				break;
			default:
				System.out.println("Loro Region desconocida");
		}
	}

}
