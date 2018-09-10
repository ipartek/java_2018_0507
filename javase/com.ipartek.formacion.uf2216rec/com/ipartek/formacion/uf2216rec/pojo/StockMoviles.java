package com.ipartek.formacion.uf2216rec.pojo;

public class StockMoviles {

	private long id;
	private boolean android;
	private String marca;
	private double ram;
	private double pulgadas;
	private int memoria;
	
	public StockMoviles(long id, boolean android, String marca, double ram, double pulgadas, int memoria) {
		this.id = id;
		this.android = android;
		this.marca = marca;
		this.ram = ram;
		this.pulgadas = pulgadas;
		this.memoria = memoria;
	}
	
	public StockMoviles() {
		this(-1, false, "", 0, 0, 0 );
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isAndroid() {
		return android;
	}
	public void setAndroid(boolean android) {
		this.android = android;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getRam() {
		return ram;
	}
	public void setRam(double ram) {
		this.ram = ram;
	}
	public double getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}
	public int getMemoria() {
		return memoria;
	}
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	@Override
	public String toString() {
		return "stockMoviles [id=" + id + ", android=" + android + ", marca=" + marca + ", ram=" + ram + ", pulgadas="
				+ pulgadas + ", memoria=" + memoria + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (android ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + memoria;
		long temp;
		temp = Double.doubleToLongBits(pulgadas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ram);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockMoviles other = (StockMoviles) obj;
		if (android != other.android)
			return false;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (memoria != other.memoria)
			return false;
		if (Double.doubleToLongBits(pulgadas) != Double.doubleToLongBits(other.pulgadas))
			return false;
		if (Double.doubleToLongBits(ram) != Double.doubleToLongBits(other.ram))
			return false;
		return true;
	}
	
	
}
