package com.ipartek.txakur.pojo;

public class Chip {
String id;
double latitud,longitud;


public Chip(String id, double latitud, double longitud) {
	super();
	this.id = id;
	this.latitud = latitud;
	this.longitud = longitud;
}

public String getId() {
	return id;
}

@Override
public String toString() {
	return "Chip [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + "]";
}

public void setId(String id) {
	this.id = id;
}

public double getLatitud() {
	return latitud;
}

public void setLatitud(long latitud) {
	this.latitud = latitud;
}

public double getLongitud() {
	return longitud;
}

public void setLongitud(long longitud) {
	this.longitud = longitud;
}

}
