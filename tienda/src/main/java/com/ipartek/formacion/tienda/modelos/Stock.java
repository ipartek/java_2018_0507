package com.ipartek.formacion.tienda.modelos;

public class Stock {

	private Long id;
	private Almacen almacen;
	private Producto producto;
	private Long stock;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	public Stock(Long id, Almacen almacen, Producto producto, Long stock) {
		super();
		this.id = id;
		this.almacen = almacen;
		this.producto = producto;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((almacen == null) ? 0 : almacen.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		Stock other = (Stock) obj;
		if (almacen == null) {
			if (other.almacen != null)
				return false;
		} else if (!almacen.equals(other.almacen))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stock [id=").append(id).append(", almacen=").append(almacen).append(", producto=")
				.append(producto).append(", stock=").append(stock).append("]");
		return builder.toString();
	}
}
