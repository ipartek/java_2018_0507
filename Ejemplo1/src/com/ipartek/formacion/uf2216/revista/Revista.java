package com.ipartek.formacion.uf2216.revista;

import java.util.ArrayList;
import java.util.List;


public class Revista implements  CrudAble<Revista> {
	
	public String titulo;
	public int ISBN;
	public boolean formato;
	public int n_paginas;

	
	private List<Revista> revistas = new ArrayList<>();
		public Revista(int iSBN2, int n_paginas, boolean formato) {
			
	
		// TODO Auto-generated constructor stub
		}

		public List<Revista> getAll() {
			// TODO Auto-generated method stub
			return revistas;
		}


		public Revista getRevistas(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		
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

	
		public boolean insert(Revista pojo) {
			// TODO Auto-generated method stub
			return false;
		}


	}
