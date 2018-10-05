package bdd.bdd;

public class Usuario {
	private long id;
	private String nombre;
	private String password;
	private String email;	
	public Usuario() {
		
		
	}
	
	
	
	
	public Usuario(long id, String nombre, String password, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
	}




	public Usuario(String nombre, String password,String email) {
		// TODO Auto-generated constructor stub
		this(-1L,nombre,password,email);
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
