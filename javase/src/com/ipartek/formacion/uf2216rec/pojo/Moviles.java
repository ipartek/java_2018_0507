package com.ipartek.formacion.uf2216rec.pojo;

public class Moviles {
	
	private boolean android;
	private String marca;
	private double ram;
	private double pulgadas;
	private int memoria;
	
	
	public Moviles(boolean android, String marca, double ram, double pulgadas, int memoria) {
		super();
		this.android = android;
		this.marca = marca;
		this.ram = ram;
		this.pulgadas = pulgadas;
		this.memoria = memoria;
	}
	
	public Moviles() {
		this(false, "", 0.0, 0.0, 0);
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
		if (marca.length()>3 && marca.length()<15) {
			this.marca = marca;
		}else {
			throw new RuntimeException();
		}
	}
	

	public double getRam() {
		return ram;
	}


	public void setRam(double ram) {
		if(ram > 0.5) {
			this.ram = ram;
		}else {
			throw new RuntimeException();
		}
		
	}


	public double getPulgadas() {
		return pulgadas;
	}


	public void setPulgadas(double pulgadas) {
		if(pulgadas<7.0 && pulgadas>0.0) {
			this.pulgadas = pulgadas;
		}else {
			throw new RuntimeException();
		}
	}


	public int getMemoria() {
		return memoria;
	}


	public void setMemoria(int memoria) {
		if (memoria%4 == 0) {
			this.memoria = memoria;	
		}else {
			throw new RuntimeException();	
		}
	}


	@Override
	public String toString() {
		return "Moviles [android=" + android + ", marca=" + marca + ", ram=" + ram + ", pulgadas=" + pulgadas
				+ ", memoria=" + memoria + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (android ? 1231 : 1237);
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
		Moviles other = (Moviles) obj;
		if (android != other.android)
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
