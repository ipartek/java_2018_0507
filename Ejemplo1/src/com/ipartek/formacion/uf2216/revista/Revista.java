package com.ipartek.formacion.uf2216.revista;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Libro;


public class Revista implements  CrudAble<Revista> {
	
	public String titulo;
	public int ISBN;
	public boolean formato;
	public int n_paginas;

	
	private List<Revista> revista = new ArrayList<>();
	
	
	public Revista(int iSBN, int n_paginas, boolean formato) {
	}

	public Revista() {
		// TODO Auto-generated constructor stub
	}

	public List<Revista> getAll() {
		// TODO Auto-generated method stub
		return revista;
	}

	
		
	public boolean insertar(Revista revista) {
		
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/prueba.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);
            
        }catch(Exception e) {System.out.println("Error");}
        
        
		System.out.println("AKI"+revista.getFormato()+"  "+revista.getISBN()+"  "+revista.getTitulo());
		revista.insert(revista);
		
		return true;
	}
	
	
	
	//Getters y Setters
	public void setTitulo(String titulo) {
		this.titulo =  titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getn_paginas() {
		return n_paginas;
	}
	public void setn_paginas(int n_paginas) {
		this.n_paginas= n_paginas;
	}
	public void setISBN(int iSBN2) {
		this.ISBN=iSBN2;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setFormato(boolean formato) {
		this.formato= formato;
	}
	public boolean getFormato() {
		return formato;
	}

	@Override
	public boolean insert(Revista pojo) {
		
		File fichero = new File ("c:\\temp\\lineadecodigo\\fichero.txt");
		FileWriter fichero1 = null;
        PrintWriter pw = null;
        try{
            
            pw = new PrintWriter(fichero1);

            for (int i = 0; i < 10; i++)
                pw.println("pojo " + pojo.ISBN);
	            pw.println("pojo " + pojo.n_paginas);
	            pw.println("pojo " + pojo.titulo);
	            pw.println("pojo " + pojo.getISBN());
            
        }catch(Exception e){
        	e.printStackTrace();
        }
		return false;
	}


	public Revista getRevistas(long id) {
		System.out.println("En getRevistas para buscar la revista con id="+id);
		//Revista resul = null;
	
		System.out.println("revista.size()"+revista.size());
		while(revista.iterator() != null) {
			System.out.println("revista.get(ISBN).toString();"+revista.get(ISBN).toString());
			String revisbn=revista.get(ISBN).toString();
			
			if(revisbn.equals(id)) {
				System.out.println("ISBN"+revista.get(ISBN).toString());
				System.out.println("ISBN:"+revista.toString());
			}
		}
		return null;
		
		
	}
}
