package txakuretxe.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import txakuretxe.controlador.*;
import txakuretxe.modelo.*;
import txakuretxe.pojo.*;
/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/Principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerroMySqlDAO dao;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entra");
		try {
			dao=PerroMySqlDAO.getInstance();
			
		ArrayList<Perro> perros = (ArrayList<Perro>) dao.getAll();
		System.out.println(perros.get(0).getNombre());	
		
			request.setAttribute("perros", perros);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
