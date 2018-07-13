package aves;

public class Loro extends Ave{
	private char region;
	private  String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Loro(char sexo,Integer edad, char region,String color)
	{
		super(edad,sexo);
		this.region=region;
		this.color=color;
		
	}
	public char getRegion() {
		return region;
	}
	public void setRegion(char region) {
		if (region!= 'n' && region!= 's' && region!= 'e' && region!= 'o' )
			System.out.println("region incorrecta espabila");
		else
		this.region = region;
	}
	
	public void deDondeEres()
	{
		
		switch (region) {
		case 'n':
			System.out.println("norte");			
			break;
		case 's':
			System.out.println("sur");			
			break;
		case 'e':
			System.out.println("este");			
			break;
		case 'o':
			System.out.println("oeste");			
			break;
			default:
				System.out.println("no es de una region conocida");
			
		}
		/*if(region=='n')		
			System.out.println("norte");
		if(region=='s')		
			System.out.println("sur");
		if(region=='e')		
			System.out.println("este");
		if(region=='o')		
			System.out.println("oeste");*/
		
	}
	@Override
	public void cantar() {
		// TODO Auto-generated method stub
		System.out.println("soy loro");
	}

}
