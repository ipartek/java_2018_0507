package com.ipartek.formacion.javaee.uf2218.pojo;

public class Pagina implements Identificable{
	
	private long id; //Servirá de base para crear las URLs de las imágenes también
	private String nombre;
	private String texto;
	public Pagina(long id, String nombre, String texto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.texto = texto;
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Pagina() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Pagina other = (Pagina) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pagina [id=" + id + ", nombre=" + nombre + ", texto=" + texto + "]";
	}

	
}
