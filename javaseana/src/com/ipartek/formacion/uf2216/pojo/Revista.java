package com.ipartek.formacion.uf2216.pojo;

/**
 * @class Revista
 * @author AnaMAMM
 *
 */
public class Revista {

    private String titulo;
    private String isbn;
    private int paginas;
    private boolean digital;
    private int id;

    public Revista() {
    }

    public Revista(String titulo, String isbn, int paginas, boolean digital, int id) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = paginas;
        this.digital = digital;
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
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }
}