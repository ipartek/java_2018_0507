package com.ipartek.formacion.ejemplos.perros.modelos;

import java.math.BigDecimal;

public class Chip {
	private Long id = -1L;
	
	private String identificacion = "00-0000-0000";
	private BigDecimal latitud = new BigDecimal("0.0");
	private BigDecimal longitud = new BigDecimal("0.0");
	private String errorIdentificacion = "";
	private String errorLatitud = "";
	private String errorLongitud = "";
	
	private boolean correcto = true;
	
	public Chip(Long id, String identificacion, BigDecimal latitud, BigDecimal longitud) {
		setId(id);
		setIdentificacion(identificacion);
		setLatitud(latitud);
		setLongitud(longitud);
	}

	public Chip(String identificacion, BigDecimal latitud, BigDecimal longitud) {
		this(-1L, identificacion, latitud, longitud);
	}
	
	public Chip(String identificacion, String latitud, String longitud) {
		setIdentificacion(identificacion);
		
		try {
			setLatitud(new BigDecimal(latitud));
		} catch (Exception e) {
			setErrorLatitud("El dato '" + latitud + "' no es numérico");
		}
		
		try {
			setLongitud(new BigDecimal(longitud));
		} catch (Exception e) {
			setErrorLatitud("El dato '" + longitud + "' no es numérico");
		}
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		if(!identificacion.matches("\\d{2}-\\d{4}-[12]\\d{3}")) {
			setErrorIdentificacion("El formato debe ser dd-dddd-aaaa");
			return;
		}
		
		this.identificacion = identificacion;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public String getErrorIdentificacion() {
		return errorIdentificacion;
	}

	public void setErrorIdentificacion(String errorIdentificacion) {
		correcto = false;
		this.errorIdentificacion = errorIdentificacion;
	}
	
	public String getErrorLatitud() {
		return errorLatitud;
	}

	public void setErrorLatitud(String errorLatitud) {
		correcto = false;
		this.errorLatitud = errorLatitud;
	}

	public String getErrorLongitud() {
		return errorLongitud;
	}

	public void setErrorLongitud(String errorLongitud) {
		correcto = false;
		this.errorLongitud = errorLongitud;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
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

	@Override
	public String toString() {
		return "Chip [id=" + id + ", identificacion=" + identificacion + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
	
	
}
