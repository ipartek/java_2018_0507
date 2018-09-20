package supermercado.accesodatos;

import java.util.List;

public class Carrito {
	private static String id;
	public Carrito(String nombre, String precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}


	public static String getId() {
		return id;
	}


	public static void setId(String id) {
		Carrito.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Carrito [nombre=" + nombre + ", precio=" + precio + "]";
	}


	private String nombre;
	private String precio;


	public Carrito(String id, String nombre, String precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}


	public Carrito(String idprod) {
		this.id=idprod;
	}


	public void set(int i, List<Carrito> carrito) {
		// TODO Auto-generated method stub
		
	}
}
