package com.formacion.ipartek.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formacion.ipartek.accesoaDatos.LibroElecDao;
import com.formacion.ipartek.accesoaDatos.UsuarioArrayDao;
import com.formacion.ipartek.pojo.HojaLibro;
import com.formacion.ipartek.pojo.Usuario;



/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/index")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pagina=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// TODO Auto-generated method stub
		ServletContext context=getServletConfig().getServletContext();
		HttpSession re=request.getSession();
		for(int i=0;i<10;i++){
			  LibroElecDao.getInstance().insert(new HojaLibro(i,"erase una vez..."+i,"auto"));
		  } 
		UsuarioArrayDao.getInstance().insert(new Usuario(1,"inaki@a","aaa","usuario"));
		UsuarioArrayDao.getInstance().insert(new Usuario(2,"a@a","aaa","admin"));
		re.setAttribute("pagina", pagina);
		 context.setAttribute("libro", LibroElecDao.getInstance().getAll());
		 context.setAttribute("daoUsuarios", UsuarioArrayDao.getInstance().getAll());
		 request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
