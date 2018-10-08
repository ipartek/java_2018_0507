package com.ipartek.pabloDAO.paginaExamen.modelos;

public class Perro {

	private Long id;
	private String nombre ="";
	private int edad =0;
	private String raza="";
	private int peso=0;
	private boolean apadrinado=false;
	private String chip="";
	
	
	
	
	public Perro(Long id, String nombre, int edad, String raza, int peso, boolean apadrinado, String chip) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
	}
	
	public Perro(String nombre, int edad, String raza, int peso, boolean apadrinado, String chip) {
		this(-1L, nombre, edad, raza, peso, apadrinado, chip);
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

	public boolean isApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(boolean apadrinado) {
		if (apadrinado == true) {
			apadrinado = Boolean.parseBoolean("Si");
		}else {
			apadrinado = Boolean.parseBoolean("No");
		}
		
		this.apadrinado = apadrinado;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso
				+ ", apadrinado=" + apadrinado + ", chip=" + chip + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (apadrinado ? 1231 : 1237);
		result = prime * result + ((chip == null) ? 0 : chip.hashCode());
		result = prime * result + edad;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (apadrinado != other.apadrinado)
			return false;
		if (chip == null) {
			if (other.chip != null)
				return false;
		} else if (!chip.equals(other.chip))
			return false;
		if (edad != other.edad)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
	
}
