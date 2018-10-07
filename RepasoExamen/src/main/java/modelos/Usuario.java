package modelos;

public class Usuario {
	private Long id = -1L;
	private String email = "", password = "";
	private String errorEmail = "", errorPassword = "";
	private boolean correcto = true;
	
	public Usuario(long id, String email, String password) {
		super();
		this.id = id;
		setEmail(email);
		setPassword(password);
	}
	public Usuario(String email, String password) {
		this(-1L, email, password);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email == null) {
			setErrorEmail("Email nulo");
			setCorrecto(false);
			return;
		}
		
		if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]+)$")) {
			setErrorEmail("No coincide con el formato de email");
			setCorrecto(false);
			return;
		}
		
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password == null) {
			setErrorPassword("No se admite un password nulo");
			setCorrecto(false);
			return;
		}
		
		this.password = password;
	}
	
	public String getErrorEmail() {
		return errorEmail;
	}
	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}
	public String getErrorPassword() {
		return errorPassword;
	}
	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	public boolean isCorrecto() {
		return correcto;
	}
	private void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
	
	
}
