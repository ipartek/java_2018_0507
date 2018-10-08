package com.ipartek.formacion.MF0967_3.pojo;

public class Dog {

	private int id;
	private String nombre;
	private int edad;
	private String raza;
	private double peso;
	private String chip;
	private int apadrinado;
	private double latitud;
	private double longitud;
	private String errorChip;
	private boolean correcto = true;
	
	public Dog(int id, String nombre, int edad, String raza, double peso, String chip, int apadrinado, double latitud,
			double longitud) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.chip = chip;
		this.apadrinado = apadrinado;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public Dog(String nombre, int edad, String raza, double peso, String chip, int apadrinado, double latitud,
			double longitud) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.chip = chip;
		this.apadrinado = apadrinado;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public Dog(String nombre, int edad, String raza, String chip,double latitud, double longitud, double peso, int apadrinado) { 
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.chip = chip;
		this.latitud = latitud;
		this.longitud = longitud;
		this.peso = peso;
		this.apadrinado = apadrinado;
	}
	
	
	public Dog() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		if(raza.equals("")||raza.equals(null)) {
			raza = "milrazas";
		}
		this.raza = raza;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {

		if(chip == null || chip.trim().length() == 0) {
			setErrorChip("No Hay chip");
		} else if(!chip.matches("^[A-Z]{2}/[-]/[A-Z]{4}/[-][0-9]{4}$")) {
			setErrorChip("El chip introducido no tiene el formato adecuado");
		}
		//("^\\w+@\\w+\\.\\w+$"))
		this.chip = chip;
	}
	public int getApadrinado() {
		return apadrinado;
	}
	public void setApadrinado(int apadrinado) {
		this.apadrinado = apadrinado;
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
	public String getErrorChip() {
		return errorChip;
	}
	public void setErrorChip(String errorChip) {
		correcto = false;
		this.errorChip = errorChip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apadrinado;
		result = prime * result + ((chip == null) ? 0 : chip.hashCode());
		result = prime * result + edad;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((raza == null) ? 0 : raza.hashCode());
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
		Dog other = (Dog) obj;
		if (apadrinado != other.apadrinado)
			return false;
		if (chip == null) {
			if (other.chip != null)
				return false;
		} else if (!chip.equals(other.chip))
			return false;
		if (edad != other.edad)
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud))
			return false;
		if (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (raza == null) {
			if (other.raza != null)
				return false;
		} else if (!raza.equals(other.raza))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso
				+ ", chip=" + chip + ", apadrinado=" + apadrinado + ", latitud=" + latitud + ", longitud=" + longitud
				+ "]";
	}
	
	
	
	
}
