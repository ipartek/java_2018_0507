package com.ipartek.formacion.youtube;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private Long id;
	private String idurl;
	private String nombre;
	private String descripcion;
	
	
	
	public Video() {
		super();
		
	}
	
	public Video(Long id, String idurl, String nombre, String descripcion) {
		super();
		this.id = id;
		this.idurl = idurl;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Video(String idurl, String nombre, String descripcion) {
		super();
		
		this.idurl = idurl;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdurl() {
		return idurl;
	}

	public void setIdurl(String idurl) {
		this.idurl = idurl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static int getIdLongitud() {
		return ID_LONGITUD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idurl == null) ? 0 : idurl.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Video other = (Video) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idurl == null) {
			if (other.idurl != null)
				return false;
		} else if (!idurl.equals(other.idurl))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", idurl=" + idurl + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
 
	
	

	
	/*public Video() {
		super();
		//this.id = "YlUKcNNmywk";
		//this.nombre = "Red Hot Chili Peppers - Californication";		
	}*/
	
	
	
	

	
	
	
}
