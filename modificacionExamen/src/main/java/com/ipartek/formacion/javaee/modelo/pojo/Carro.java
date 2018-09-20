package com.ipartek.formacion.javaee.modelo.pojo;

public class Carro {
	private long id;
	private String producto;
	private int precio;
	private int cantidad;
	
	public Carro() {
		super();
	}

	public Carro(long id, String producto, int precio, int cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + precio;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		Carro other = (Carro) obj;
		if (cantidad != other.cantidad)
			return false;
		if (id != other.id)
			return false;
		if (precio != other.precio)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", producto=" + producto + ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
}
