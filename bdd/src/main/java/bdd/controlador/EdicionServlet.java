package bdd.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bdd.bdd.*;
import bdd.modelo.LibroMySqlDAO;

/**
 * Servlet implementation class EdicionServlet
 */
@WebServlet("/Edicion")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroMySqlDAO dao;

    
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String opcion=request.getParameter("opcion");
	String id=request.getParameter("id");
	String nombre=request.getParameter("nombre");

	String tipo=request.getParameter("tipo");
	System.out.println(opcion);
	System.out.println(tipo);

	if(opcion!=null&&opcion.equalsIgnoreCase("si")) {
		try {
			dao=LibroMySqlDAO.getInstance();
			
			dao.delete(id);
			response.sendRedirect("Principal");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	if(opcion!=null&&opcion.equalsIgnoreCase("no")) {
		response.sendRedirect("Principal");
	}
	
	
	
	if(tipo!=null&&tipo.equalsIgnoreCase("editar")) {
		
		
		try {
			System.out.println("edicion");
			dao=LibroMySqlDAO.getInstance();
			Libro l=new Libro(id,nombre);
			dao.update(l);
			System.out.println(id+" "+nombre);
			response.sendRedirect("Principal");
			//dao.update(pojo)
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(tipo!=null&&tipo.equalsIgnoreCase("anadir")) {
		try {
			dao=LibroMySqlDAO.getInstance();
			System.out.println("entra en añadir");
			Libro li = new Libro(id, nombre);
			dao.insert(li);
			response.sendRedirect("Principal");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
