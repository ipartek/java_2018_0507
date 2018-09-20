package supermercado.pojo;

public class Articulo {
	
	public String categoria;
	public String precio;
	public String descuento;
	public String nombre;
	public String id;

	public Articulo(String nombre, String categoria, String precio, String descuento) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;//Bebida o comida
		this.precio = precio;
		this.descuento = descuento;
	}
	public Articulo() {
		
	}
	public Articulo(String id) {
		this.id=id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	public String getId() {
		return id;
	}
	public void setId() {
		this.id=id;
	}
	
	
}
