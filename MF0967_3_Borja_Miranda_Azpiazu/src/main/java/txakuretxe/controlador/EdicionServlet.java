package txakuretxe.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import txakuretxe.controlador.*;
import txakuretxe.modelo.*;
import txakuretxe.pojo.*;

/**
 * Servlet implementation class EdicionServlet
 */
@WebServlet("/Edicion")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerroMySqlDAO dao;

    
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		boolean apadrinadop=false;
		
	String opcion=request.getParameter("opcion");
	String id=request.getParameter("id");
	String nombre=request.getParameter("nombre");
	String edad=request.getParameter("edad");
	String raza=request.getParameter("raza");
	String kg=request.getParameter("kg");
	String apadrinado=request.getParameter("apadrinado");
	String nidentificacion=request.getParameter("nidentificacion");
	String latitud=request.getParameter("latitud");
	String longitud=request.getParameter("longitud");

	
	
	
	
	
	String tipo=request.getParameter("tipo");
	System.out.println(opcion);
	System.out.println(tipo);

	if(opcion!=null&&opcion.equalsIgnoreCase("si")) {
		try {
			dao=PerroMySqlDAO.getInstance();
			
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
			dao=PerroMySqlDAO.getInstance();
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
		
		if(apadrinado.equalsIgnoreCase("true")) {
			apadrinadop=true;
			
		}
		try {
			dao=PerroMySqlDAO.getInstance();
			System.out.println("entra en añadir");
			Perro pe = new Perro(id, nombre,edad,raza,kg,apadrinadop,new Chip(nidentificacion,latitud,longitud));
			dao.insert(pe);
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
