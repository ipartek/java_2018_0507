package com.ipartek.formacion.ejercicos.poo;



	public abstract class Piolin extends Canario {
		
		private Integer NumPeliculas;

		private Piolin(String sexo, Integer edad, Integer tamano, Integer numPeliculas) {
			super(sexo, edad, tamano);
			setNumPeliculas(numPeliculas);
		}

		public Integer getNumPeliculas() {
			return NumPeliculas;
		}

		public void setNumPeliculas(Integer numPeliculas) {
			NumPeliculas = numPeliculas;
		}

		public static String setSexo(String string) {
			
			return null;
		}

		public static Integer setEdad(int i) {
			
			return null;
		}

		public static Integer setTamano(int tamano) {
			
			return null;
		}
}
