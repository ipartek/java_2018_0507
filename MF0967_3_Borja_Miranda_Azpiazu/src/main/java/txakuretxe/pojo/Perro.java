package txakuretxe.pojo;

public class Perro {

	private String idPerro;
	private String nombre;
	private String edad;
	private String raza;
	private String kg;
	private boolean Apadrinado;
	private Chip chip;
	
	public Perro() {
		
		
		
	}
	public Perro(String idPerro, String nombre, String edad, String raza, String kg, boolean apadrinado, Chip chip) {
		super();
		this.idPerro = idPerro;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.kg = kg;
		Apadrinado = apadrinado;
		this.chip = chip;
	}
	
	
	
	
	public String getIdPerro() {
		return idPerro;
	}
	public void setIdPerro(String idPerro) {
		this.idPerro = idPerro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getKg() {
		return kg;
	}
	public void setKg(String kg) {
		this.kg = kg;
	}
	public boolean isApadrinado() {
		return Apadrinado;
	}
	public void setApadrinado(boolean apadrinado) {
		Apadrinado = apadrinado;
	}
	public Chip getChip() {
		return chip;
	}
	public void setChip(Chip chip) {
		this.chip = chip;
	}

	
	
}
