package com.ipartek.ebook.pojo;

public class Usuario {
    private int ID;
    private String nombre;
    private String pass;
    


    public Usuario(int ID, String nombre, String pass) {
        this.ID = ID;
        this.nombre = nombre;
        this.pass = pass;
    }

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
