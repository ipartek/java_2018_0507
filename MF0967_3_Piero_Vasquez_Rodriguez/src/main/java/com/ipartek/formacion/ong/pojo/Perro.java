package com.ipartek.formacion.ong.pojo;

public class Perro {

	private long id;
	private String nombre;
	private int edad;
	private String raza;
	private int peso;
	private String apadrinado;
	
	public Perro(long id,String nombre, int edad, String raza, int peso, String apadrinado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
	}
	
	public Perro() {
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		this.raza = raza;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(String apadrinado) {
		this.apadrinado = apadrinado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apadrinado == null) ? 0 : apadrinado.hashCode());
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + peso;
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
		Perro other = (Perro) obj;
		if (apadrinado == null) {
			if (other.apadrinado != null)
				return false;
		} else if (!apadrinado.equals(other.apadrinado))
			return false;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (peso != other.peso)
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
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + "]";
	}
	
	
}
