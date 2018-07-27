package ejercicios.basicos.liniciales;

import java.util.ArrayList;
import java.util.Scanner;

public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int km;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		modelo = modelo;
	}
	
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nMatrícula: ");
        sb.append(matricula);
        sb.append("\nMarca: ");
        sb.append(marca);
        sb.append("\nModelo: ");
        sb.append(modelo);
        sb.append("\nKm: ");
        sb.append(km);    
        return sb.toString();
	}
	
	public static void leerCoches() {
	   
		ArrayList<Coche> coches = new ArrayList<Coche>();
		String matricula;
		String marca;
		String modelo;
		int km;
		int N;
		Coche aux;
		
        Scanner sc = new Scanner(System.in);
        do {
        	System.out.println("Numero de coches");
        	N = sc.nextInt();
        	sc.nextLine();
        }while (N<=0);
        for(int i = 1; i<=N; i++) {
        	System.out.println("Coche "+i);
        	System.out.println("Matricula:");
        	matricula = sc.nextLine();
        	System.out.println("Marca:");
        	marca = sc.nextLine();
        	System.out.println("Modelo:");
        	modelo = sc.nextLine();
        	System.out.println("Km:");
        	km = sc.nextInt();
        	sc.nextLine();
        	
        	aux = new Coche();
        	aux.setMatricula(matricula);
        	aux.setMarca(marca);
        	aux.setModelo(modelo);
        	aux.setKm(km); 
        	
        	coches.add(aux);
        }
	}
}
