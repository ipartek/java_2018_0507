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
@WebServlet("/ListadoPersonaServlet")
public class ListadoPersonasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoPersonasServlet() {
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
		
		
		String accion=request.getParameter("accion");
		System.out.println("ACCION" + accion);
		request.setCharacterEncoding("UTF-8");
		
		if (accion!=null) {
			if(accion.equals("guardar")) {
			/*	System.out.println("fdfds" + request.getParameter("id"));
				System.out.println("fdfds" + request.getParameter("nombre"));
				System.out.println("fdfds" + request.getParameter("apellido1"));
				System.out.println("fdfds" + request.getParameter("calle"));
				System.out.println("fdfds" + request.getParameter("numero"));
				System.out.println("fdfds" + request.getParameter("email"));
				System.out.println("fdfds" + request.getParameter("dni"));
				System.out.println("fdfds" + request.getParameter("status"));*/
				
				try {
					ConnectPersonasBD.anadirRegistro(request.getParameter("nombre"), request.getParameter("apellido1"), request.getParameter("calle"),
							request.getParameter("numero"), request.getParameter("email"), request.getParameter("dni"), request.getParameter("status"));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}	
		}
		List<Persona> personaslist = null;
		
		try {
			personaslist = ConnectPersonasBD.getAll();			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
		/*for (Persona string : personaslist) {
	        System.out.println(string);
	    }*/
	
			
			request.setAttribute("personaslist", personaslist);
			request.getRequestDispatcher("listado.jsp").forward(request, response);
		

	}

}
