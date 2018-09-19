package pojo;

public class Video {

	
	public static final int ID_LONGITUD = 11;
	public Video() {
		super();
		this.Idvideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	public Video(String idvideo, String nombre) throws Exception {
		super();
		Idvideo = idvideo;
		this.nombre = nombre;
	}
	public String getIdvideo() {
		return Idvideo;
	}
	public void setIdvideo(String idvideo) {
		Idvideo = idvideo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return Idvideo;
	}
	public void setId(String Idvideo) throws Exception {
		if ( Idvideo != null && Idvideo.length() == ID_LONGITUD ) {
			this.Idvideo = Idvideo;
		}else {
			throw new Exception("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}	
	}
	
	String Idvideo;
	String nombre;
	
	
	
	
}
