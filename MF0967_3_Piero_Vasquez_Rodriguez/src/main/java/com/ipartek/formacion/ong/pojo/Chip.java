package com.ipartek.formacion.ong.pojo;

public class Chip extends Perro implements Identificable{
	
	private long chip;
	private double latitud;
	private double longitud;
	
	
	
	public Chip (long id, String nombre, int edad, String raza, int peso, String apadrinado,long chip, double latitud, double longitud) {
		
		super(id,nombre,edad,raza,peso,apadrinado);
		this.chip= chip;
		this.latitud =latitud;
		this.longitud=longitud;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (chip ^ (chip >>> 32));
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
		if (chip != other.chip)
			return false;
		if (Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud))
			return false;
		if (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud))
			return false;
		return true;
	}
	public long getChip() {
		return chip;
	}
	public void setChip(long chipIdentificador) {
		this.chip = chipIdentificador;
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