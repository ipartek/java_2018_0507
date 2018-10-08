package com.ipartek.formacion.examen.txakuretxe.modelo;

public class Chip extends Perro {

		private long numeroIdentificacion;
		private double latitud;
		private double longitud;
		
		
		
		public long getNumeroIdentificacion() {
			return numeroIdentificacion;
		}
		public void setNumeroIdentificacion(long numeroIdentificacion) {
			this.numeroIdentificacion = numeroIdentificacion;
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			long temp;
			temp = Double.doubleToLongBits(latitud);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(longitud);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + (int) (numeroIdentificacion ^ (numeroIdentificacion >>> 32));
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
			if (Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud))
				return false;
			if (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud))
				return false;
			if (numeroIdentificacion != other.numeroIdentificacion)
				return false;
			return true;
		}
		
		
}
