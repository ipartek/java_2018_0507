package com.ipartek.formacion.MF0967.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Perro {
/*Un perro debe contener las siguientes características:  nombre, edad, raza (en caso de no saber 
 * 'milrazas'), peso (kg), si esta apdrinado o no. Ademas todos tiene un chip con numero de identificación 
 * con el siguiente formato DD-DDDD-AAAA ( D: numero del 0 al 9, AAAA año del chip ), en el chip también 
 * se guarda la ultima localización del perro ( latitud y longitud */
	
	private static final Perro dao = new Perro();
	static {
		for(int i = 1; i <= 10; i++) {
			dao.insert(new Perro("nombre"+i,i, "raza" + i,(double)i, "false","chip"+i));
		}
	}
	
	public int edadperro=0;
	@Override
	public String toString() {
		return "Perro [edadperro=" + edadperro + ", razaperro=" + razaperro + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", nombreperro=" + nombreperro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (apadrinado != null ? 1231 : 1237);
		result = prime * result + edadperro;
		result = prime * result + ((nombreperro == null) ? 0 : nombreperro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((razaperro == null) ? 0 : razaperro.hashCode());
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
		Perro other = (Perro) obj;
		if (apadrinado != other.apadrinado)
			return false;
		if (edadperro != other.edadperro)
			return false;
		if (nombreperro == null) {
			if (other.nombreperro != null)
				return false;
		} else if (!nombreperro.equals(other.nombreperro))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (razaperro == null) {
			if (other.razaperro != null)
				return false;
		} else if (!razaperro.equals(other.razaperro))
			return false;
		return true;
	}
	public int getEdadperro() {
		return edadperro;
	}
	public void setEdadperro(int edadperro) {
		this.edadperro = edadperro;
	}
	public String getRazaperro() {
		return razaperro;
	}
	public void setRazaperro(String razaperro) {
		this.razaperro = razaperro;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String isApadrinado() {
		return apadrinado;
	}
	public void setApadrinado(String apadrinado) {
		this.apadrinado = "true";
	}
	public String getNombreperro() {
		return nombreperro;
	}
	public void setNombreperro(String nombreperro) {
		this.nombreperro = nombreperro;
	}
	public static Perro getDao() {
		return dao;
	}
	public String razaperro="";
	public double peso=0;
	public String apadrinado="false";
	
	public String nombreperro="";
	public String chip="";
	
	public Perro(String nombreperro, int i, String razaperro, double peso, String apadrinado,String chip) {
		super();
		this.nombreperro = nombreperro;
		this.edadperro = i;
		this.razaperro = razaperro;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
		Long l=1L;
		
		
	}
	private void insert(Perro perro) {
		
		
	}
	public Perro() {
		// TODO Auto-generated constructor stub
	}
	private TreeMap<Long, Perro> perro = new TreeMap<>();
	
	public List<Perro> getAll() {
		return new ArrayList<Perro>(perro.values());
	}
	public String getChip() {
		// TODO Auto-generated method stub
		return chip;
	}
	public void setChip(String chip) {
		this.chip=chip;
	}
	
}
