package com.ipartek.formacion.MF0967_3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0967_3.modelo.DogMySQLDAO;
import com.ipartek.formacion.MF0967_3.pojo.Dog;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	/**Describe con tus palabras ( no vale copiar y pegar de internet ) como funciona el patrón Modelo Vista Controlador
	 *Es una forma de trabajo que separa los datos y los procesos del programa en capas,
	 *diferenciando entre la representacion y la gestion de eventos y comunicaciones.
	 * 
	 *Usando modelo (objetos), la vista y el controlador (servlets de control de eventos)
	 *representa la informacion poruna parte y por otra define los objetos con los que trabaja
	 *usando el control para procesarlo. Teoricamente esto se usa para aprovechar codigo y evitar redundancia de codigo
	 *       
	 */
	private static final long serialVersionUID = -8060185148338669345L;
	private static DogMySQLDAO dao;
	static String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
			}

			dao = DogMySQLDAO.getInstance();
			ArrayList<Dog> dogs = (ArrayList<Dog>) dao.getAll();
			request.setAttribute("dogs", dogs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
			}

			dao = DogMySQLDAO.getInstance();
			ArrayList<Dog> dogs = (ArrayList<Dog>) dao.getAll();
			request.setAttribute("dogs", dogs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
