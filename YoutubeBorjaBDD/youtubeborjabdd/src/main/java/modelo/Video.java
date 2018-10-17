package modelo;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private Long id;
	private String idVideo;
	private String nombre;
	
	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(Long id, String idVideo, String nombre) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
	}
	
	public Video(String idVideo, String nombre ) {
		this(-1L, idVideo, nombre);
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

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		if ( idVideo != null && idVideo.length() == ID_LONGITUD ) {
			this.idVideo = idVideo;
		}else {
			throw new RuntimeException("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}	
		this.idVideo = idVideo;
	}
	
	
	
}
