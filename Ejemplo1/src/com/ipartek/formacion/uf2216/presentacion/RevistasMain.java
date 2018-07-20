package com.ipartek.formacion.uf2216.presentacion;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.omg.CORBA.portable.IndirectionException;

import com.ipartek.formacion.uf2216.accesodatos.RevistasArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;
import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class RevistasMain {
	private static final String RUTA_FICHERO = "C:\\trabajos\\fichero.txt";
	private static final boolean AUTO_FLUSH = true;
	private static final boolean SOBREESCRIBIR = false;
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p("Bienvenido a nuestro sistema de gestion de revistas");
		empezar();

	}

	private static void empezar() {
		// TODO Auto-generated method stub
		/**
		 * inicio del programa
		 */
		mostrarmenu();
	}

	private static void mostrarmenu() {
		// TODO Auto-generated method stub
/**
 * funcion que le presenta un menu a el usuario y va directamente al metodo eleccion(), que recogera su decision
 */
		p("¿Que desea?\n");
		p("1.Dar de alta una revista");
		p("2.Ver el catalogo de revistas");
		p("3.Crear fichero con todas las revistas");

		eleccion();
	}

	private static void eleccion() {
		// TODO Auto-generated method stub
/**
 * funcion que recoge la decision decision del cliente para mandarle al metodo correspondiente
 */
		
		
		Scanner o = new Scanner(System.in);

		String opcion = o.next();
		if (isNumeric(opcion)) {

			int opcionint = Integer.parseInt(opcion);

			// int opcionint=Integer.parseInt(opcion);

			if (opcionint > 0 && opcionint < 4) {
				// if(opcionint.matches("[0-9]*")) {

				switch (opcionint) {
				case 1:
					try {
						insertarRevista();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 2:
					listaRevistas();
					break;
				case 3:
					try {
						crearFichero();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				// }
				}
			} else {
				System.err.println("el numero debe ser una de las opciones\n");
				mostrarmenu();
			}
		} else {
			System.out.println("\n");
			System.err.println("debes introducir un numero\n");
			mostrarmenu();
		}
		// }
		// else {
		// System.out.println("debes elegir una de las 3 opciones\n");
		// mostrarmenu();
		// }

	}

	private static boolean isNumeric(String opcion) {
		// TODO Auto-generated method stub
/**
 * funcion que mira si un string es numerico y retorna true si lo es o false
 */
		return (opcion.matches("[+-]?\\d*(\\.\\d+)?") && opcion.equals("") == false);

	}

	private static void crearFichero() throws IOException {
		// TODO Auto-generated method stub


FileWriter fw = new FileWriter(RUTA_FICHERO, SOBREESCRIBIR);
PrintWriter pw = new PrintWriter(fw,AUTO_FLUSH);



RevistasArrayDAO dao = RevistasArrayDAO.getInstance();

pw.println("ID\tTITULO\tISBN\tNUMPAGS\tFORMATO");

for(Revista revista: dao.getAll()) {
	pw.println(revista.getId()+"\t"+revista.getTitulo()+"\t"+revista.getISBN()+"\t"+revista.getNumPag()+"\t"+revista.isFormato()+"\n");
	System.out.println("\n");
	//System.out.println("\n");
}
System.out.println("todo correcto");
pw.close();
fw.close();
	}
//FileReader fr = new FileReader(RUTA_FICHERO);
//BufferedReader br = new BufferedReader(fr);
//
//String linea;
//
//while( (linea = br.readLine()) != null ) {
//	System.out.println(linea);
//}
//
//br.close();
//fr.close();
//	}

	private static void listaRevistas() {
		// TODO Auto-generated method stub
		
		/**
		 * funcion que coge todas las revistas y las muestra en pantalla
		 */
RevistasArrayDAO dao = RevistasArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(Revista revista: dao.getAll()) {
			mostrarRevista(revista);
			//System.out.println("\n");
		}
		empezar();

	}
	private static void mostrarRevista(Revista revista) {
		/**
		 * funcion que recoge los parametros de la revista
		 */
		p(revista.getId() + "\t" +revista.getTitulo()+"\t"+ revista.getISBN() + "\t" + revista.getNumPag()+"\t"+revista.isFormato());
	}

	private static void mostrarCabecera() {
		/**
		 * funcion que muestra la cabecera como si se tratase de un excel
		 */
		p("ID\tTITULO\tISBN\tNUMPAGS\tFORMATO");
	}
	
	private static void insertarRevista() {
		
		/**
		 * funcion que hace el procedimiento de insercion despues de su correspondiente validacion
		 */
		// TODO Auto-generated method stub
		System.out.println("mete id, codigo y nombre ");
		RevistasArrayDAO dao = RevistasArrayDAO.getInstance();

		Scanner o = new Scanner(System.in);
		System.out.println("inserta el ID del libro");

		String id = o.next();
		if (isNumeric(id)) {
			long ids = Integer.parseInt(id);

			if (dao.getById(ids) == null && ids >= 1) {

				System.out.println("mete el titulo");

				String titulo = o.next();
				if (titulo != null) {

					System.out.println("Mete el ISBN(debe de ser numerico");

					String ISBN = o.next();
					if (isNumeric(ISBN)) {
						int ISBNi = Integer.parseInt(ISBN);
						if (ISBNi > 0) {
							System.out.println("mete numero de paginas");

							String numPag = o.next();
							int numPagi = Integer.parseInt(numPag);
							if (isNumeric(numPag)) {
								if (numPagi > 1) {

									System.out.println("Identifica el formato:\nD para Digital o P para papel");
									String format = o.next();
									boolean formato = false;
									

									if (format.equalsIgnoreCase("d")) {

										System.out.println("vas a insertar lo siguiente\n");
										System.out.println("id =" + ids + " titulo = " + titulo + " ISBN = " + ISBNi
												+ " numPags = " + numPagi + " formato = " + formato+"\n\n");

										System.out.println("te parece correcto?\n");
										System.out.println("S aceptar\n  cualquier otra letra para volver al inicio");
										String decision = o.next();
										if (decision.equalsIgnoreCase("s")) {
											dao.insert(new Revista(ids, titulo, ISBNi, numPagi, formato));
											System.out.println("insertado");
											empezar();
										} else {
											mostrarmenu();
										}
									}

									else if (format.equalsIgnoreCase("p")) {
										System.out.println("vas a insertar lo siguiente\n");
										System.out.println("id =" + ids + " titulo = " + titulo + " ISBN = " + ISBNi
												+ " numPags = " + numPagi + " formato = " + formato);
										System.out.println("te parece correcto?\n");
										System.out.println("S aceptar\n  cualquier otra letra para volver al inicio");
										String decision = o.next();
										if (decision.equalsIgnoreCase("s")) {
											dao.insert(new Revista(ids, titulo, ISBNi, numPagi, formato));
											System.out.println("insertado");
											empezar();
										} 
	/**
	* posibles errores al poner parametros incorrectos
	 */
										else {
											mostrarmenu();
										}

									}
									else {
										System.err.println("debes de elegir una de las 2 opciones");
										insertarRevista();
									}

								} else {
									System.err.println("debes meter un formato valido");
									insertarRevista();
								}
							} else {
								System.err.println("debe de ser numerico");
								insertarRevista();

							}
						} else {
							System.out.println("debe de ser mayor a 0");
							insertarRevista();

						}
					} else {
						System.err.println("debe de ser numerico");
						insertarRevista();

					}
				} else {
					System.err.println("debes de meter un titulo");
					insertarRevista();

				}
			} else {
				System.err.println("debe de ser mayor a 0 o ya existe");
				insertarRevista();

			}
		} else {
			System.err.println("debes de meter un numerico");
			insertarRevista();

		}

		// if(dao.getById(id)==null) {
		// dao.insert(new Revista(id,titulo,ISBN,numPag,formato));
		// }
		// else {
		// System.out.println("ya existe");
		// }
		// empezar();
		//
		//
		//

	}

	public static long comprobarid(String id) {
		if(isNumeric(id)) {
		long id2=Integer.parseInt(id);
		return id2;
		}
		return 0;
		
	}

private static void insertarRevista2() throws Exception {
		
		/**
intento de mejora de codigo con do while pero no me a dado tiempo
		 */
		// TODO Auto-generated method stub
		System.out.println("mete id, codigo y nombre ");
		RevistasArrayDAO dao = RevistasArrayDAO.getInstance();

		Scanner o = new Scanner(System.in);
		System.out.println("inserta el ID del libro");

		String id ;
		String titulo = null;
		String ISBN;
		String numpag;
		String formato = null;
		do {
			System.out.println("inserta el ID del libro");
			
			 id = o.next();
				

			
		} while (comprobarid(id)==0);
		
		
		do {
			System.out.println("mete un titulo");
			try {
				titulo=o.next();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while (titulo==null);
		
		do {
			System.out.println("mete el isbn");
			ISBN=o.next();
		} while (comprobarid(ISBN)==0);
		
		
		do {
			System.out.println("mete el numero de paginas");
			numpag=o.next();
			} while (comprobarid(numpag)==0||comprobarid(numpag)>0);
		
		do {
			System.out.println("mete el formato de libro.\n D para digital y P para papel");
			formato=o.next();
			
		} while (formato!="d"&&formato!="p");
		System.out.println("vas a insertar lo siguiente\n");
		System.out.println("id =" + id + " titulo = " + titulo + " ISBN = " + ISBN
				+ " numPags = " + numpag+ " formato = " + formato);
		System.out.println("te parece correcto?\n");
		System.out.println("S aceptar\n  cualquier otra letra para volver al inicio");
		String decision = o.next();
		
		
//		do {
//			
//		} while (asserte||formato!="p");
	}


	
	public static void p(String p) {
		/**
		 * funcion que facilita la escritura de strings, evitando tener que poner system.out.print todo el rato
		 */
		System.out.println(p);

	}

	private void KeyReleased(KeyEvent e) {
		/**
		 * funcion que queria implementar para que cuando el cliente pulse la tecla ENTER el programa se sigiese ejecutando.
		 * pero no e sido capaz de implementarla finalmente :(
		 */
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			mostrarmenu();
		}
	}
	
	private void formatolibro(boolean f) {
		String formato;
		if(f=true) {
			formato="digital";
			
		}
		else {
			formato="papel";
		}
		System.out.print(formato);
	}
	
}
