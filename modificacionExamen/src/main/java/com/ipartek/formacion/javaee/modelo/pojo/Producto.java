package com.ipartek.formacion.javaee.modelo.pojo;

public class Producto {
		private long id;
		private String producto;
		private double precio;
		private double precioUnidadMetrica;
		private int descuento;
		private String rutaImagen;
		
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
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public double getPrecioUnidadMetrica() {
			return precioUnidadMetrica;
		}
		public void setPrecioUnidadMetrica(double precioUnidadMetrica) {
			this.precioUnidadMetrica = precioUnidadMetrica;
		}
		public int getDescuento() {
			return descuento;
		}
		public void setDescuento(int descuento) {
			this.descuento = descuento;
		}
		public String getRutaImagen() {
			return rutaImagen;
		}
		public void setRutaImagen(String rutaImagen) {
			this.rutaImagen = rutaImagen;
		}
		public Producto() {
			super();
		}
		public Producto(long id, String producto, double precio, double precioUnidadMetrica, int descuento,
				String rutaImagen) {
			super();
			this.id = id;
			this.producto = producto;
			this.precio = precio;
			this.precioUnidadMetrica = precioUnidadMetrica;
			this.descuento = descuento;
			this.rutaImagen = rutaImagen;
		}
		@Override
		public String toString() {
			return "Producto [id=" + id + ", producto=" + producto + ", precio=" + precio + ", precioUnidadMetrica="
					+ precioUnidadMetrica + ", descuento=" + descuento + ", rutaImagen=" + rutaImagen + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + descuento;
			result = prime * result + (int) (id ^ (id >>> 32));
			long temp;
			temp = Double.doubleToLongBits(precio);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(precioUnidadMetrica);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((producto == null) ? 0 : producto.hashCode());
			result = prime * result + ((rutaImagen == null) ? 0 : rutaImagen.hashCode());
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
			if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
				return false;
			if (Double.doubleToLongBits(precioUnidadMetrica) != Double.doubleToLongBits(other.precioUnidadMetrica))
				return false;
			if (producto == null) {
				if (other.producto != null)
					return false;
			} else if (!producto.equals(other.producto))
				return false;
			if (rutaImagen == null) {
				if (other.rutaImagen != null)
					return false;
			} else if (!rutaImagen.equals(other.rutaImagen))
				return false;
			return true;
		}

		
		
}
