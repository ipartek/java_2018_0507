package com.ipartek.formacion.ejemplos.perros.modelos;

public class Perro {
	private static final String RAZA_POR_DEFECTO = "milrazas";

	private Long id = -1L;
	
	private String nombre = "Desconocido";
	private Integer edad = 0;
	private String raza = RAZA_POR_DEFECTO;
	private Double peso = 0.0;
	private boolean apadrinado = false;
	
	private String errorEdad = "";
	private String errorPeso = "";
	
	private boolean correcto = true;
	
	private Chip chip = null;

	public Perro(Long id, String nombre, Integer edad, String raza, Double peso, Chip chip, boolean apadrinado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.chip = chip;
		this.apadrinado = apadrinado;
	}

	public Perro(String nombre, Integer edad, String raza, Double peso, Chip chip, boolean apadrinado) {
		this(-1L, nombre, edad, raza, peso, chip, apadrinado);	
	}
	
	public Perro(String nombre, String edad, String raza, String peso, Chip chip, String apadrinado) {
		setNombre(nombre);
		setRaza(raza);
		
		if(!chip.isCorrecto()) {
			correcto = false;
		}
		setChip(chip);
		
		try {
			setEdad(Integer.parseInt(edad));
		} catch(Exception e) {
			setErrorEdad("La edad no es un número");
		}
		
		try {
			setPeso(Double.parseDouble(peso));
		} catch(Exception e) {
			setErrorEdad("El peso no es un número");
		}
		
		setApadrinado(apadrinado != null);
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
		this.nombre = nombre.trim();
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		if(raza == null || raza.trim().length() == 0) {
			raza = RAZA_POR_DEFECTO;
		}
		
		this.raza = raza.trim();
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Chip getChip() {
		return chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}

	public String getErrorEdad() {
		return errorEdad;
	}

	public void setErrorEdad(String errorEdad) {
		correcto = false;
		this.errorEdad = errorEdad;
	}

	public String getErrorPeso() {
		return errorPeso;
	}

	public void setErrorPeso(String errorPeso) {
		correcto = false;
		this.errorPeso = errorPeso;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chip == null) ? 0 : chip.hashCode());
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
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
		if (chip == null) {
			if (other.chip != null)
				return false;
		} else if (!chip.equals(other.chip))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
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
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
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
		return "Perro [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso
				+ ", chip=" + chip + "]";
	}

	public boolean isApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
	
	
}
