package com.ipartek.txakur.pojo;

public class Perro {
	long id, latitud, longitud;
	String nombre, edad, raza, peso;
	private Chip miChip;
	private String foto;
	private boolean apadrinado = false;

	public boolean isApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
	
			this.foto = foto;

	}

	public Chip getMiChip() {
		return miChip;
	}

	public void setMiChip(Chip miChip) {
		this.miChip = miChip;
	}

	public Perro() {

	}

	public Perro(long id, String nombre, String edad, String raza, String peso) {
		super();
		setId(id);
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
		this.peso = peso;
		miChip = new Chip(id + "", latitud, longitud);
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null)
			nombre = "desc";
		else
			this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		if(edad==null) {
			edad="desc";
		}else
		this.edad = edad;
	}

	public String getRaza() {
		
		return raza;
	}

	public void setRaza(String raza) {
		if (raza.equalsIgnoreCase("") || raza == null)
			raza = "milRazas";
		else
			this.raza = raza;
	}
}
