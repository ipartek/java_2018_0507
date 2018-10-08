package com.ipartek.formacion.examen.txakuretxe.modelo;

public class Perro {
	
	private long id;
	private String nombre;
	private String raza;
	private double peso;
	private boolean apadrinado;

	
	private String Erroridentificador = "";
	private boolean correcto = true;
	
	
	public Perro(long id, String nombre, String raza, double peso, boolean apadrinado) {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		
		if (nombre == null || nombre == "") {
			this.nombre = "milrazas";
		}
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public boolean isApadrinado() {
		return apadrinado;
	}
	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}

	
	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", Erroridentificador=" + Erroridentificador + ", correcto=" + correcto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Erroridentificador == null) ? 0 : Erroridentificador.hashCode());
		result = prime * result + (apadrinado ? 1231 : 1237);
		result = prime * result + (correcto ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
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
		Perro other = (Perro) obj;
		if (Erroridentificador == null) {
			if (other.Erroridentificador != null)
				return false;
		} else if (!Erroridentificador.equals(other.Erroridentificador))
			return false;
		if (apadrinado != other.apadrinado)
			return false;
		if (correcto != other.correcto)
			return false;
		if (id != other.id)
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
	public String getErroridentificador() {
		return Erroridentificador;
	}
	public void setErroridentificador(String erroridentificador) {
		Erroridentificador = erroridentificador;
	}
	public boolean isCorrecto() {
		return correcto;
	}
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
	
	
	
	
	
	
}
