package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.ComentariosMySqlDAO;
import com.ipartek.formacion.youtube.model.VideoArrayListDAO;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;

/**
 * Servlet implementation class Anadir
 */

@WebServlet("/anadir")
public class Anadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String nombre=request.getParameter("nombre");
		//System.out.println("ID de video recibido al crear:"+ id);
		//System.out.println("NOMBRE de video recibido al crear:"+ nombre);
		try {
			id="1";

			VideoArrayListDAO.getInstance().insert(new Video((long) 1,id,nombre));
		
			
			VideoMySqlDAO videomysqldao=new VideoMySqlDAO();
			videomysqldao.getAll();
			request.setAttribute("videos", videomysqldao.getAll());
			ComentariosMySqlDAO comentariomysqldao=new ComentariosMySqlDAO();
			
			request.setAttribute("comentarios", comentariomysqldao.getAll());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			request.getRequestDispatcher("/inicio").forward(request, response);
		}
	
	}

}
