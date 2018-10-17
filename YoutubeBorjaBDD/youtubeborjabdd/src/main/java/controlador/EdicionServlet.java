package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.*;
import controlador.*;
import conexion.*;


/**
 * Servlet implementation class EdicionServlet
 */
@WebServlet("/Edicion")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoMySqlDAO dao;

    
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	String opcion=request.getParameter("opcion");
String idVideo=request.getParameter("idvideo");
	String id=request.getParameter("id");
	String nombre=request.getParameter("nombre");

	
	
	
	
	
	
	
	String tipo=request.getParameter("tipo");
	System.out.println(opcion);
	System.out.println(tipo);

	if(opcion!=null&&opcion.equalsIgnoreCase("si")) {
		try {
			dao=VideoMySqlDAO.getInstance();
			
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
			dao=VideoMySqlDAO.getInstance();
			//Perro p=new Perro(id,nombre);
			//dao.update(p);
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
			dao=VideoMySqlDAO.getInstance();
			System.out.println("entra en añadir");
			Video v=new Video(idVideo, nombre);
			dao.insert(v);
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
