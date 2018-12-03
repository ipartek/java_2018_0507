package com.ipartek.formacion.Main.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0966_3.pojos.ConnectPersonasBD;

/**
 * Servlet implementation class AgregarPersonaServlet
 */

//Mostrar un listado con las últimos 50 personas de la base datos  ( 1 punto  - UF2214 )
@WebServlet("/AgregarPersonaServlet")
public class AgregarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarPersonaServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String nombre=request.getParameter("nombre");
		String apellido1=request.getParameter("apellido1");
		String calle=request.getParameter("calle");
		String numero=request.getParameter("numero");
		String email=request.getParameter("email");
		String dni=request.getParameter("dni");
		String status=request.getParameter("status");
		
		try {
			ConnectPersonasBD.anadirRegistro(nombre, apellido1, calle, numero,email, dni,  status);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
			
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
