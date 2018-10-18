package com.ipartek.formacion.youtube;

public class Puntuacion {

	
	private Long id;
	private int numero;
	
	public Puntuacion() {
		super();
		
	}
	
	public Puntuacion(Long id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numero;
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
		Puntuacion other = (Puntuacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Puntuacion [id=" + id + ", numero=" + numero + "]";
	}
	
	
	
	
	
}
