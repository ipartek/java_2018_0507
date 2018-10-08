package com.ipartek.formacion.examen.txakuretxe.modelo;

public class Chip extends Perro {
	
		private long chipIdentificador;
		private double latitud;
		private double longitud;
		
		
		
		public Chip (long id, String raza, long chip, String nombre, double peso, boolean apadrinado, double latitud, double longitud) {
			
			super(id,nombre,raza,peso,apadrinado);
			this.chipIdentificador= chip;
			this.latitud =latitud;
			this.longitud=longitud;
		}
		
	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (int) (chipIdentificador ^ (chipIdentificador >>> 32));
			long temp;
			temp = Double.doubleToLongBits(latitud);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(longitud);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Chip other = (Chip) obj;
			if (chipIdentificador != other.chipIdentificador)
				return false;
			if (Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud))
				return false;
			if (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud))
				return false;
			return true;
		}
		public long getChipIdentificador() {
			return chipIdentificador;
		}
		public void setChipIdentificador(long chipIdentificador) {
			this.chipIdentificador = chipIdentificador;
		}
		public double getLatitud() {
			return latitud;
		}
		public void setLatitud(double latitud) {
			this.latitud = latitud;
		}
		public double getLongitud() {
			return longitud;
		}
		public void setLongitud(double longitud) {
			this.longitud = longitud;
		}
		
		
}
