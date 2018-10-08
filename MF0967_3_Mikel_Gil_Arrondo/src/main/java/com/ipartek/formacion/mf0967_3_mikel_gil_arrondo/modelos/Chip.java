package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos;

public class Chip{
	private String chip; 	// DD-DDDD-AAAA
	private String latitud;
	private String longitud;
	
	private String errorChip = "";
	private String errorLatitud = "";
	private String errorLongitud = "";
	
	public Chip() {
	}

	public Chip(String chip, String latitud, String longitud) {
		super();
		setChip(chip);
		setLatitud(latitud);
		setLongitud(longitud);
	}

	@Override
	public String toString() {
		return "Chip [chip=" + chip + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
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
	
	public String getErrorChip() {
		return errorChip;
	}

	public void setErrorChip(String errorChip) {
		this.errorChip = errorChip;
	}

	public String getErrorLatitud() {
		return errorLatitud;
	}

	public void setErrorLatitud(String errorLatitud) {
		this.errorLatitud = errorLatitud;
	}

	public String getErrorLongitud() {
		return errorLongitud;
	}

	public void setErrorLongitud(String errorLongitud) {
		this.errorLongitud = errorLongitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chip == null) ? 0 : chip.hashCode());
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
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
		Chip other = (Chip) obj;
		if (chip == null) {
			if (other.chip != null)
				return false;
		} else if (!chip.equals(other.chip))
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
		return true;
	}
}
