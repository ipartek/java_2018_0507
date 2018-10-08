package com.ipartek.formacion.ong.modelos;

public class Perro {
	private Long id = -1L;
	private String nombre, raza;
	private int edad;
	private float peso;
	private String numIdent, latitud, longitud;
	private String errorId = "";
	private boolean correcto = true;
	
	public String apadrinado="false";
	
	public Perro(Long id, String nombre, String raza, int edad, float peso, String apadrinado, String numIdent, String latitud, String longitud) {
		super();
		this.setId(id);
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.numIdent = numIdent;
		this.latitud= latitud;
		this.longitud = longitud;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getNumIdent() {
		return numIdent;
	}

	public void setNumIdent(String numIdent) {
		
		if(numIdent == null) {
			setErrorId("Numero de identificacion nulo");
			setCorrecto(false);
			return;
		}
		
		if(!numIdent.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]+)$")) {
			setErrorId("No coincide con el formato del numero de dentificacion");
			setCorrecto(false);
			return;
		}
		
		
		this.numIdent = numIdent;
	}

	public String getLatitud() {
		return latitud;
	}
	

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}



	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}


	public String getApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(String apadrinado) {
		this.apadrinado = "true";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apadrinado == null) ? 0 : apadrinado.hashCode());
		result = prime * result + (correcto ? 1231 : 1237);
		result = prime * result + edad;
		result = prime * result + ((errorId == null) ? 0 : errorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numIdent == null) ? 0 : numIdent.hashCode());
		result = prime * result + Float.floatToIntBits(peso);
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
		if (correcto != other.correcto)
			return false;
		if (edad != other.edad)
			return false;
		if (errorId == null) {
			if (other.errorId != null)
				return false;
		} else if (!errorId.equals(other.errorId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numIdent == null) {
			if (other.numIdent != null)
				return false;
		} else if (!numIdent.equals(other.numIdent))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
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
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", peso=" + peso + ", numIdent="
				+ numIdent + ", latitud=" + latitud + ", longitud=" + longitud + ", errorId=" + errorId + ", correcto="
				+ correcto + ", apadrinado=" + apadrinado + "]";
	}
	
}
