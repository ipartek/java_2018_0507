package com.ipartek.formacion.ejercicos.poo;


	public class Loro extends Aves{
		
		private Character region;
		private String color;
		
		public void Cantar() {
			System.out.println("Pio Pio soy un Loro");
		}
		

		public Loro (String sexo, Integer edad, Character region, String color) {
			super (sexo,edad);
			this.setRegion(region);
			this.setColor(color);
		}
		



		public void DondeEres(Character region) {
			
			switch (region)
			{
			case 'N':
				System.out.println("Es de Norte");
				break;
			case 'S':
				System.out.println("Es del Sur");
				break;
			case 'E':
				System.out.println("Es del Este");
				break;
			case 'O':
				System.out.println("Es del Oeste");
				break;
			default:
				System.out.println("No es de una region conocida");
				
			}
			
		}

		public Character getRegion() {
			return region;
		}

		public void setRegion(Character region) {
			this.region = region;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
}
