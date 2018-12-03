package com.ipartek.formacion.Main.Controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0966_3.pojos.ConnectPersonasBD;
import com.ipartek.formacion.MF0966_3.pojos.Persona;

/**
 * Servlet implementation class AgregarPersonaServlet
 */

//Mostrar un listado con las últimos 50 personas de la base datos  ( 1 punto  - UF2214 )
@WebServlet("/BuscarxDNIServlet")
public class BuscarxDniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarxDniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String dni=request.getParameter("dni");
		System.out.println(dni);
		ConnectPersonasBD.buscarxDNI(dni);
			
		
		List<Persona> personasdni = null;
		
		personasdni = ConnectPersonasBD.buscarxDNI(dni);
		
		
		for (Persona string : personasdni) {
	        System.out.println(string);
	    }
		if (personasdni!=null) {
			request.setAttribute("personasdni", personasdni);
		
			request.getRequestDispatcher("verpersona.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("buscarxdni.jsp").forward(request, response);
		}
	}

}
