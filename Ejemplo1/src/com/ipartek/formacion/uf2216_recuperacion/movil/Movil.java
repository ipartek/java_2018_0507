package com.ipartek.formacion.uf2216_recuperacion.movil;

import java.util.ArrayList;
import java.util.List;

public class Movil implements  CrudAble<Movil> {
	

	
	/*
	1.      Android                                         verdadero o falso
	2.      Marca                                            de 3 a 15 caracteres
	3.      RAM                                              en GB, m�nimo 0,5
	4.      Pulgadas                                      m�ximo 7,0
	5.      Memoria                                       m�ltiplo de 4 (en GB)

	*/
	
	private boolean android;
	private String marca;
	private float ram;
	private float pulgadas;
	private int memoria;
	List<Movil> lista = null;
	
	public Movil(boolean android, String marca, float ram, float pulgadas,int memoria) {
		this.setAndroid(android);
		this.setMarca(marca);
		this.setRam(ram);
		this.setPulgadas(pulgadas);
		this.setMemoria(memoria);
		
		movil.add(this);
	}
	
	public Movil() {
		// TODO Auto-generated constructor stub
	}

	private List<Movil> movil = new ArrayList<>();
	
	public boolean isAndroid() {
		return android;
	}


	public void setAndroid(boolean android) {
		this.android = android;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public float getRam() {
		return ram;
	}


	public void setRam(float ram) {
		this.ram = ram;
	}


	public float getPulgadas() {
		return pulgadas;
	}


	public void setPulgadas(float pulgadas) {
		this.pulgadas = pulgadas;
	}


	public int getMemoria() {
		return memoria;
	}


	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}


	public void setMovil(List<Movil> movil) {
		this.movil = movil;
	}


	@Override
	public List<Movil> getAll() {
		// TODO Auto-generated method stub
		return movil;
	}


	

	@Override
	public List<Movil> insert(Movil movil) {		
		
		//DAO
		
		movil.setAndroid(android);
		movil.setMarca(marca);
		movil.setMemoria(memoria);
		movil.setPulgadas(pulgadas);
		movil.setRam(ram);
		
		//lista.add(movil);
		
		ManejoFichero.escribirFich("Android: "+movil.android +" Marca: "+movil.marca + "  Memoria: "
									+movil.memoria+"  Pulgadas: "+movil.pulgadas +"  RAM: "+movil.ram+"\n");
		return lista;
	}


	@Override
	public Movil getMovil() {
		// TODO Auto-generated method stub
		return null;
	}



}