package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Administrar
 */
public class Administrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Administrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String correo=request.getParameter("correo");
		String pas=request.getParameter("pass");
		if(correo.equals("scobby") && pas.equals("galletas")){
            //si coincide usuario y password y además no hay sesión iniciada
            sesion.setAttribute("usuario", correo);
            response.sendRedirect("administrar.jsp");		
	}else {
		response.sendRedirect("Admin.jsp");	
	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
