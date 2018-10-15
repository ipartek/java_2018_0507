package modelo;

public class Chip {
	String id="-1";
	int latitud=-1;
	int longitud=-1;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLatitud() {
		return latitud;
	}
	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public Chip() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Chip [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
	
	
}
