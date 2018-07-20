package com.ipartek.formacion.uf2216.pojo;

import java.util.regex.Pattern;
import java.util.regex.Matcher;



/**
 * @class Revista
 * 
 * contiene los validadores
 * @author AnaMAMM
 *
 */
public class Revista {

    private String titulo;
    private String isbn;
    private int paginas;
    private boolean formato;
    private int id;

    public Revista() {
    }

    public Revista(String titulo, String isbn, int paginas, boolean digital, int id) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = paginas;
        this.formato = digital;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public boolean isDigital() {
        return formato;
    }

    public void setDigital(boolean digital) {
        this.formato = digital;
    }
    
    
    public boolean validarTitulo(String titulo){
    	
    	boolean res;
    	Pattern p = Pattern.compile("[a-zA-Z]{3,150}");
    	Matcher m = p.matcher(titulo);
    	
    	if (m.find() == true) {
            System.out.println("El titulo ingresado es válido .");
            res = true;
        } else {
            System.out.println("El titulo ingresado es inválido debe tener minimo 3 letras y máximo 150.");
            res = false;
        }
    	return res;
    	
    }
    
    public boolean validarIsbn(String isbn){
    	
    	boolean res;
    	Pattern p = Pattern.compile("\\w{10}");
    	Matcher m = p.matcher(isbn);
    	
    	if (m.find() == true) {
            System.out.println("El isbn ingresado es válido.");
            res = true;
        } else {
            System.out.println("El isbn ingresado es inválido. Debe tener 10 digitos de longitud");
            res = false;
        }
    	return res;
    	
    }
    
    
  
    
    public boolean validarNumPaginas(int numPaginas){
    	
    	boolean res;
    
    	
    	if (numPaginas > 1) {
            System.out.println("El numero de páginas ingresado es válido.");
            res= true;
        } else {
            System.out.println("El número de páginas ingresado es inválido. Debe tener minimo 1 numero");
            res = false;
        }
    	return res;
    	
    }
    
    
    public boolean validarFormato(){
    	
    	boolean res;
    	
    	if (formato == true) {
            System.out.println("Digital");
            res = true;
        } else {
            System.out.println("Papel");
            res= false;
        }
    	
    	
    	return res;
    	
    }
    
    
    
}