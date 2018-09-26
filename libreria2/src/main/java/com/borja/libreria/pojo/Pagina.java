package com.borja.libreria.pojo;


import com.borja.libreria.pojo.Identificable;
import com.borja.libreria.pojo.Pagina;

public class Pagina implements Identificable{
	private long id; //Servirá de base para crear las URLs de las imágenes también
	private String texto;
	private String nick;
	public Pagina(long id, String texto, String nick) {
		super();
		this.id = id;
		this.texto =texto;
		this.nick = nick;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getnick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
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
		Pagina other = (Pagina) obj;
		if (id != other.id)
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pagina [id=" + id + ", texto=" + texto + ", nick=" + nick + "]";
	}
	
}
