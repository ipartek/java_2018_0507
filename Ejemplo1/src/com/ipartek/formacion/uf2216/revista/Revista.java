package com.ipartek.formacion.uf2216.revista;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Revista implements  CrudAble<Revista> {
	
	private String titulo;
	private int ISBN;
	private boolean formato;
	private int n_paginas;

	
	private List<Revista> revistas = new ArrayList<>();
	
	
	public Revista(int iSBN, int n_paginas, boolean formato) {
	}

	public Revista() {
		// TODO Auto-generated constructor stub
	}

	public List<Revista> getAll() {
		// TODO Auto-generated method stub
		return revistas;
	}

	
		
	public boolean insertar(Revista revista) {
		
		this.revistas.add(revista);
		
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
		
		this.revistas.add(pojo);
		
		File fichero = new File ("fichero.txt");
		
        PrintWriter pw = null;
        FileWriter fichero1 = null;
        try{
        	fichero1 = new FileWriter(fichero,true);
            pw = new PrintWriter(fichero1,true);

            //for (int i = 0; i < 10; i++) {
                pw.print(pojo.getISBN());
                pw.print(";");
	            pw.print(pojo.getn_paginas());
	            pw.print(";");
	            pw.print(pojo.getTitulo());
            //}
        }catch(Exception e){
        	e.printStackTrace();
        } finally {
        	pw.close();
        	try {
				fichero1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return false;
	}


	public Revista getRevistas(long id) {
		System.out.println("En getRevistas para buscar la revista con id="+id);
		//Revista resul = null;
	
		System.out.println("revista.size()"+revistas.size());
		while(revistas.iterator() != null) {
			System.out.println("revista.get(ISBN).toString();"+revistas.get(ISBN).toString());
			String revisbn=revistas.get(ISBN).toString();
			
			if(revisbn.equals(id)) {
				System.out.println("ISBN"+revistas.get(ISBN).toString());
				System.out.println("ISBN:"+revistas.toString());
			}
		}
		return null;
		
		
	}

	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", ISBN=" + ISBN + ", formato=" + formato + ", n_paginas=" + n_paginas
				+ ", revista=" + revistas + "]";
	}
}
