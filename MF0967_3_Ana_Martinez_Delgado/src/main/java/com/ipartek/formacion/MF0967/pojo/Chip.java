package com.ipartek.formacion.MF0967.pojo;

public class Chip {
	 /*chip con numero de identificación 
	 * con el siguiente formato DD-DDDD-AAAA ( D: numero del 0 al 9, AAAA año del chip ), en el chip también 
	 * se guarda la ultima localización del perro ( latitud y longitud */
	
	String latitud="";
	String longitud="";
	String chipid="";
	
	public Chip(String chipid, String latitud, String longitud) {
		super();
		this.chipid = chipid;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Chip [chipid=" + chipid + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chipid == null) ? 0 : chipid.hashCode());
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
		if (chipid == null) {
			if (other.chipid != null)
				return false;
		} else if (!chipid.equals(other.chipid))
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
	public String getChipid() {
		return chipid;
	}
	public void setChipid(String chipid) {
		this.chipid = chipid;
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

}
