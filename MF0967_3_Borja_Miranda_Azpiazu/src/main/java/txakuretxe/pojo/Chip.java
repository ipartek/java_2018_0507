package txakuretxe.pojo;

public class Chip {

private	String nidentificacion;
private String latitud;
private String longitud;


public Chip() {
	
	
	
}




public Chip(String nidentificacion, String latitud, String longitud) {
	super();
	this.nidentificacion = nidentificacion;
	this.latitud = latitud;
	this.longitud = longitud;
}



public String getNidentificacion() {
	return nidentificacion;
}
public void setNidentificacion(String nidentificacion) {
	this.nidentificacion = nidentificacion;
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
