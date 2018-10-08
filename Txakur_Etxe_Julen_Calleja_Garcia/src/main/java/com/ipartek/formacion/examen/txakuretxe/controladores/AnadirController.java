package com.ipartek.formacion.examen.txakuretxe.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.txakuretxe.accesodatos.PerroTreeMapDAO;
import com.ipartek.formacion.examen.txakuretxe.modelo.Chip;




@WebServlet("/anadir")
public class AnadirController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Editar.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identificador = request.getParameter("identificador");
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		String peso = request.getParameter("peso");
		String apadrinado = request.getParameter("apadrinado");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		
		
		Chip perro;
		
		perro = new Chip(-1,nombre,raza,Double.parseDouble(peso),Boolean.parseBoolean(apadrinado),Long.parseLong(identificador),Double.parseDouble(latitud),Double.parseDouble(longitud));
		
		PerroTreeMapDAO.getInstance().insert(perro);
		
		request.getRequestDispatcher("principal").forward(request, response);

	}

	
	
}
