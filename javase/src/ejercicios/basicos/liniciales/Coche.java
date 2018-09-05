package ejercicios.basicos.liniciales;

<<<<<<< HEAD
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
=======

import java.util.ArrayList;
import java.util.Scanner;

public class Coche {
	static ArrayList<Coche> coches = new ArrayList<Coche>();
	
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
		this.modelo = modelo;
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
		Scanner sc = new Scanner(System.in);

		String matricula;
		String marca;
		String modelo;
		int km;
		int N;
		Coche aux;
		
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
	
	public static void mostrarCoches() {
		for(int i = 0; i< coches.size(); i++) {
			System.out.println(coches.get(i)); 
		}
	}
	public static void mostrarPorMarca() {
		String marca;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce marca:");
		marca = sc.nextLine();
		System.out.println("Coches de la marca "+marca+":");
		for(int i = 0; i<coches.size(); i++) {
			if(coches.get(i).getMarca().equalsIgnoreCase(marca)) {
				System.out.println(coches.get(i));
			}
		}
	}
	public static void mostrarPorKm() {
		Scanner sc = new Scanner(System.in);
		int kms;
		System.out.println("Introduce numero de kilometros:");
		kms = sc.nextInt();
		System.out.println("Coches con kilometros inferiores a "+kms);
		for(int i = 0; i<coches.size(); i++){
			if(coches.get(i).getKm()<kms) {
				System.out.println(coches.get(i));
			}
		}
	}
	public static void mostrarMayorKm() {
		Coche mayor = coches.get(0);
		for(int i = 0; i<coches.size(); i++) {
			if(coches.get(i).getKm()>mayor.getKm()) {
				mayor = coches.get(i);
			}
		}
		System.out.println("\nCoche con mas kilometros"+mayor);
	}
	public static void mostrarOrdenadosPorKm(){
        int i, j;
        Coche aux;
        for(i = 0; i< coches.size()-1; i++)
            for(j=0;j<coches.size()-i-1; j++)
                if(coches.get(j+1).getKm() < coches.get(j).getKm()){
                    aux = coches.get(j+1);
                    coches.set(j+1, coches.get(j));
                    coches.set(j, aux);                
                }
        System.out.println("\nCoches ordenador por kilometros ascendentes: ");
        mostrarCoches();
    }
}
>>>>>>> branch 'Aitor84' of https://github.com/ipartek/java_2018_0507.git
