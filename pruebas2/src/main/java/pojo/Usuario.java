package pojo;

public class Usuario{

	String nombre;
	String apellido;
	String telefono;
	String contrasena;
	long id;
	
	public Usuario() {
		
		
	}
	public Usuario(String nombre, String apellido, String telefono, String contrasena) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.contrasena = contrasena;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
	
	
}
