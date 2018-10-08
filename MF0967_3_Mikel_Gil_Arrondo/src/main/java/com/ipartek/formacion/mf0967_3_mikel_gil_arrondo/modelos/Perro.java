package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos;

public class Perro {

	private long id;
	private String nombre = "";
	private int edad = 0;
	private String raza = "";
	private int peso = 0;
	private int apadrinado = 0;  // 1 = si, 0 = no
	private Chip chip;
	
	private String errorNombre = "";
	private String errorEdad = "";
	private String errorRaza = "";
	private String errorPeso = "";
	
	private boolean correcto = true;
	
	public Perro() {
	}
	
	public Perro(long id, String nombre, int edad, String raza, int peso, int apadrinado, Chip chip) {
		this.id = id;
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
		setPeso(peso);
		setApadrinado(apadrinado);
		setChip(chip);
	}
	

	public Perro(String nombre, int edad, String raza, int peso, int apadrinado, Chip chip) {
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
		setPeso(peso);
		setApadrinado(apadrinado);
		setChip(chip);
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

	public int getApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(int apadrinado) {
		this.apadrinado = apadrinado;
	}
	
	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		this.errorNombre = errorNombre;
	}

	public String getErrorEdad() {
		return errorEdad;
	}

	public void setErrorEdad(String errorEdad) {
		this.errorEdad = errorEdad;
	}

	public String getErrorPeso() {
		return errorPeso;
	}

	public void setErrorPeso(String errorPeso) {
		this.errorPeso = errorPeso;
	}
	
	public String getErrorRaza() {
		return errorRaza;
	}

	public void setErrorRaza(String errorRaza) {
		this.errorRaza = errorRaza;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	
	public Chip getChip() {
		return chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}
}
