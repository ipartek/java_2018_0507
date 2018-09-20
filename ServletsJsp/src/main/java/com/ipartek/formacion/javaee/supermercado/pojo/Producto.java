package com.ipartek.formacion.javaee.supermercado.pojo;

public class Producto {
	private long id = 0;
	private String nombre = "";
	private long precio = 0;
	private String precioUm = "";
	private long descuento = 0;
	private String ruta = "";
	public Producto() {
		super();
	}
	public Producto(long id, String nombre, long precio, String precioUm, long descuento, String ruta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.precioUm = precioUm;
		this.descuento = descuento;
		this.ruta = ruta;
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
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	public String getPrecioUm() {
		return precioUm;
	}
	public void setPrecioUm(String precioUm) {
		this.precioUm = precioUm;
	}
	public long getDescuento() {
		return descuento;
	}
	public void setDescuento(long descuento) {
		this.descuento = descuento;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (descuento ^ (descuento >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + (int) (precio ^ (precio >>> 32));
		result = prime * result + ((precioUm == null) ? 0 : precioUm.hashCode());
		result = prime * result + ((ruta == null) ? 0 : ruta.hashCode());
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
		Producto other = (Producto) obj;
		if (descuento != other.descuento)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio != other.precio)
			return false;
		if (precioUm == null) {
			if (other.precioUm != null)
				return false;
		} else if (!precioUm.equals(other.precioUm))
			return false;
		if (ruta == null) {
			if (other.ruta != null)
				return false;
		} else if (!ruta.equals(other.ruta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", precioUm=" + precioUm
				+ ", descuento=" + descuento + ", ruta=" + ruta + "]";
	}
}
