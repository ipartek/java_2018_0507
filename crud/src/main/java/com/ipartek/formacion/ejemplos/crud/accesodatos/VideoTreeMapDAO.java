package com.ipartek.formacion.ejemplos.crud.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.ejemplos.crud.modelos.Video;

public class VideoTreeMapDAO implements CrudAble<Video> {

	//PRINCIPIO SINGLETON
	private static final VideoTreeMapDAO dao = new VideoTreeMapDAO();
	
	private VideoTreeMapDAO() {}
	
	public static VideoTreeMapDAO getInstance() { return dao; }
	//FIN SINGLETON
	
	//CONSTRUCTOR ESTÃ?TICO
	static {
		//CREAR UN CONJUNTO DE USUARIOS DE PRUEBA QUE SERÃ?N
		//1, email1@email.com, contra1
		//2, email2@email.com, contra2
		//...
		//10, email10@email.com, contra10
		for(long i = 1; i <= 10; i++) {
			try {
				dao.insert(new Video(i, "nombre" + i , "id" + i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//FIN
	
	private TreeMap<Long, Video> video = new TreeMap<>();
	
	private Long idUltimo = 0L;
	
	@Override
	public List<Video> getAll() {
		return new ArrayList<Video>(video.values());
	}

	@Override
	public Video getById(long id) {
		return video.get(id);
	}

	@Override
	public void insert(Video video) {
		//insert a bd
		
			String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
			String usuario = "root";
			String password = "admin";

			//String id = "2";
			String email = "admin@email.com";
			
			try(Connection con = DriverManager.getConnection(url, usuario, password)) {
				long id = 2;
				String contra = "nuevapassword";
				
				String sql = "INSERT INTO VIDEOS VALUES(?,?,?,?) ";
				
				try(PreparedStatement pst = con.prepareStatement(sql)) {
					pst.setString(1, video.getId());
					pst.setString(2, video.getIdVideo());
					pst.setString(3, video.getNombre());
					pst.setString(4,"usuarioprovisional");
					
					
					int numFilas = pst.executeUpdate();
					
					if(numFilas != 1) {
						System.out.println("El número de filas modificado ha sido " + numFilas);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
	}

	@Override
	public void update(Video video) {
		//uodate a bd
	}

	@Override
	public void delete(long id) {
		//delete a bd
	}

}
