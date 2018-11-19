package clases;

public class Usuario {
	String nombre;
	String Contraseina;
	public Usuario(String nombre, String contraseina) {
		super();
		this.nombre = nombre;
		Contraseina = contraseina;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseina() {
		return Contraseina;
	}
	public void setContraseina(String contraseina) {
		Contraseina = contraseina;
	}

}
