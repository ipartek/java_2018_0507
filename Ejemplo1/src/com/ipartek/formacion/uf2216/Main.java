package com.ipartek.formacion.uf2216;


import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		Revista revista;
		Scanner in = new Scanner(System.in);
		File fichero = new File ("C:\\Users\\curso\\Deskto\\fichero.txt");
		int menu=0;
		StringBuilder sb=new StringBuilder("1-introducir revista.\n").append("2-mostrar revistas guardadas.\n").append("3-guardar registro de revistas\n").append("4-salir");
		
		do {
			
		System.out.println(sb.toString());
		String menu1=in.nextLine();
		
		try {
			menu=Integer.parseInt(menu1);
		}catch(Exception e){
			menu=5;
			
		}finally
			{ if(menu>4||menu<1) {
				menu=5;
				System.out.println("opcion incorrecta elija otra");
			}
		}
		
			if(menu>=1&&menu<=4) {
				switch(menu) {
					case 1:
						revista=funciones.pedirDatos();
						System.out.println(revista.toString());
						System.out.println("¿estas seguro de que quieres introducir esta revista?1-si 2-no");
						String guardar=in.nextLine();
						int numero=0;
						boolean repetir=false;
						try{
							numero=Integer.parseInt(guardar);
						}catch(Exception e){
							repetir=true;
						}
						if(numero==1) {
							System.out.println("procedemos a introducir la revista");
							try {
							RevistaArrayDAO.getInstance().insert(revista);
							}catch(Exception e) {
								System.out.println("ha habido un error no se ha introducido");
							}
						}else if(numero==2) {
							System.out.println("no se introduce la revista");
						}else {
							repetir=true;
						}
						break;
					case 2:
						listadoRevistas();
						
						break;
					case 3:					
						crearFichero();
						break;
				}
			}
		}while(menu!=4);
		
}
	public static void crearFichero() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\curso\\Desktop\\archivo.txt");
            PrintWriter pw = new PrintWriter(fw);
            escribirFichero(pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
 
    }
	 public static void escribirFichero(PrintWriter pw) throws Exception {
		 	
	        pw.println(RevistaArrayDAO.getInstance().getAll());
	    }
	private static void listadoRevistas() {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(Revista revista: dao.getAll()) {
			mostrarRevista(revista);
		}
	}
	private static void mostrarCabecera() {
		p("ID    TITULO       isbn      numpaginas        formato");
	}

	private static void mostrarRevista(Revista revista) {
		String formato="";
		if(revista.isFormat()) {
			formato="digital";
		}else {
			formato="papel";
		}
		p(revista.getId() + "\t" +revista.getTitulo()+ "\t" +revista.getIsbn()+ "\t" + revista.getNumPaginas()+ "\t"+ formato );
	}
	public static void p(String s) {
		System.out.println(s);
	}
}
