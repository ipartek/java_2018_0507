package com.ipartek.txarkur.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.txakur.accesoAdatos.PerroArrayDao;
import com.ipartek.txakur.pojo.Chip;
import com.ipartek.txakur.pojo.Perro;

/**
 * Servlet implementation class EdicionServlet
 */
@WebServlet("/edicion")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre,raza,peso,edad,codigoChip;
		Perro p;
		nombre=request.getParameter("nombre");
		raza=request.getParameter("raza");
		peso=request.getParameter("peso");
		edad=request.getParameter("edad");
		codigoChip=request.getParameter("codigo");
		if (request.getParameter("raza").equals("") || request.getParameter("raza")==null) {
		p=new Perro(-1L, nombre, edad, "mil razas", peso);
		}else {
		p=new Perro(-1L, nombre, edad, raza, peso);
		}
		
		p.setMiChip(new Chip(codigoChip, -1l, -1l));
		if(request.getParameter("apadri")!=null)
			p.setApadrinado(true);
		p.setFoto("imgs/no.jpg");
		PerroArrayDao.getInstance().insert(p);
		request.setAttribute("perros",(ArrayList<Perro> )PerroArrayDao.getInstance().getAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
