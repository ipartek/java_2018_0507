package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Video;

public class ComentariosMySqlDAO{
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static ComentariosMySqlDAO INSTANCE = null;

	public static synchronized ComentariosMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new ComentariosMySqlDAO();
		}

		return INSTANCE;
	}


	public boolean insert(Comentario pojo)  {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO videos_comentarios (usuario,comentario) VALUES (?,?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				
				pst.setString(1,pojo.getUsuario());
				pst.setString(2, pojo.getComentario());
			

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					return false;
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

public static void main (String args[]) {
	//List lista<Comentario>= getAll();
	ComentariosMySqlDAO com=new ComentariosMySqlDAO();
	com.getAll();
}

	public List<Comentario> getAll() {
		
		//System.out.println("En dao comentario getALL");
		List<Comentario> comentarios = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT id, usuario, comentario FROM videos_comentarios";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						comentarios.add(new Comentario(rs.getString("usuario"), rs.getString("comentario")));
					}
				} catch (Exception e) {
					throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}

		
		/*for(Comentario str : comentarios)
		{
		   
		    System.out.println( "REcojido de bd" + str.getUsuario() +" " +str.getComentario());
		}*/
		return comentarios;

	}


}
