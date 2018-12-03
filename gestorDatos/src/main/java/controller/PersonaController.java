package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PersonaMySqlDAO;
import modelos.Persona;


@WebServlet("/listaPersonas")
public class PersonaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Persona> p = (ArrayList<Persona>) PersonaMySqlDAO.getInstance().getAll();
			request.setAttribute("personas", p);
		} catch (ClassNotFoundException e) {
			throw new ControladorException("Fallo en el controlador");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String numeroD = request.getParameter("numeroD");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		String puesto = request.getParameter("puesto");
		
		
			if(nombre == null || apellido == null || direccion == null || numeroD == null || 
			email == null || dni == null || puesto == null) {
				throw new RuntimeException("campos vacios");
			}
			Persona persona = new Persona (nombre,apellido,direccion,Long.parseLong(numeroD),
					email,Long.parseLong(dni),puesto);
			try {
				PersonaMySqlDAO.getInstance().insert(persona);
			} catch(Exception e) {
				e.printStackTrace();
			}
			doGet(request,response);				
		}
}
