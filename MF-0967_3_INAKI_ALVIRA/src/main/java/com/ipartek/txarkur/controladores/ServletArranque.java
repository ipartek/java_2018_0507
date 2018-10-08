package com.ipartek.txarkur.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.txakur.accesoAdatos.PerroArrayDao;
import com.ipartek.txakur.accesoAdatos.UsuarioArrayDao;
import com.ipartek.txakur.pojo.Chip;
import com.ipartek.txakur.pojo.Perro;
import com.ipartek.txakur.pojo.Usuario;

/**
 * Servlet implementation class ServletArranque
 */
@WebServlet("/inicio")
public class ServletArranque extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioArrayDao daoUsu;
	private PerroArrayDao daoPerros;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		daoUsu = UsuarioArrayDao.getInstance();
		daoPerros = PerroArrayDao.getInstance();
		if (daoUsu.getAll().size() == 0)
		daoUsu.insert(new Usuario(-1L, "scooby", "galletas"));
		if (daoPerros.getAll().size() == 0)
			for (int i = 0; i < 8; i++) {
				Perro p=new Perro(1L+i, "nombre" + i, "edad" + i, "raza" + i, "peso" + i);
				p.setMiChip(new Chip(-1L+"", 2.85, -8.65));
				p.setFoto("imgs/p"+i+".jpg");
				if(i%2==0)
					p.setApadrinado(true);
				daoPerros.insert(p);
			}
		request.setAttribute("usuarios", (ArrayList<Usuario>) daoUsu.getAll());
		request.setAttribute("perros", (ArrayList<Perro>) daoPerros.getAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
