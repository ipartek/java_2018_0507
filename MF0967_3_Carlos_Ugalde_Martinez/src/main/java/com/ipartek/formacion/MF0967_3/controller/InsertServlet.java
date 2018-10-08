package com.ipartek.formacion.MF0967_3.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0967_3.modelo.DogMySQLDAO;
import com.ipartek.formacion.MF0967_3.pojo.Dog;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = -4098241051217846470L;
	private static DogMySQLDAO dao;
	static String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	Connection conn;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			dao = DogMySQLDAO.getInstance();
			//Entro
			// recoger parametros
			//Esta parte es dependiente del insert, no deberia llegar aqui
			int edad = Integer.parseInt(request.getParameter("edad"));
			int apadrinado = Integer.parseInt(request.getParameter("apadrinado"));
			String nombre = request.getParameter("nombre");
			String raza = request.getParameter("raza");
			if(raza.equals("")||raza==null) {
				raza="milrazas";
			}
			String chip = request.getParameter("chip");	
			Double latitud = Double.parseDouble(request.getParameter("latitud"));
			Double longitud = Double.parseDouble(request.getParameter("longitud"));
			Double peso = Double.parseDouble(request.getParameter("peso"));
			Dog d = new Dog(nombre, edad, raza, chip,latitud, longitud, peso, apadrinado);
			dao.insert(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("data.jsp").forward(request, response);
		}
	}

}
