package com.ipartek.formacion.ejercicos.poo;



	public class Piolin extends Canario {
		
		private Integer NumPeliculas;

		
		public void Cantar() {
			System.out.println("Pio Pio sou un Piolin");
		}
		
		
		
		public Piolin(String sexo, Integer edad, Integer tamano, Integer numPeliculas) {
			super(sexo, edad, tamano);
			this.NumPeliculas= numPeliculas;
		}

	



		public Integer getNumPeliculas() {
			return NumPeliculas;
		}

		public void setNumPeliculas(Integer numPeliculas) {
			this.NumPeliculas = numPeliculas;
		}






}
