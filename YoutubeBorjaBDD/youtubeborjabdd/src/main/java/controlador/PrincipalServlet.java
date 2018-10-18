package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import controlador.*;
import modelo.*;
import conexion.*;
/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/Principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoMySqlDAO dao;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entra");
		System.out.println("claro que si");
		try {
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
			}

			dao = VideoMySqlDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			
			System.out.println("VIDEOS: " + videos);
			
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
