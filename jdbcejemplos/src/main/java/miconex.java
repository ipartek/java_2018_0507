

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class miconex {
	static String url;
	static String username;
	static String password;
	public static String[] dir = new String[10];
	public static String[] resultado = null;
		
		
	public static void main (String[] args){
		
		//String query = "SELECT * FROM direccion";
		String query = "SELECT * FROM videos";
		
		//String query2="Insert into direccion values(51,'assaSAsa','gfdsgdfgdf')";
		Statement st=conectarMySql();
		
		ResultSet rsES;
		
		System.out.println("executeSelect");
		//executeInsert(query);
		
		rsES=executeSelect(st,query);
		mostrarDatos(rsES);
		
		/*System.out.println("executeInsert");
		executeInsert(query2);
		rsES=executeSelect(st,query);
		mostrarDatos(rsES);
		
		System.out.println("ejecutarUpdate");
		ejecutarUpdate();
		rsES=executeSelect(st,query);
		mostrarDatos(rsES);
		
		System.out.println("executeDelete");
		executeDelete();
		rsES=executeSelect(st,query);
		mostrarDatos(rsES);
		*/
		
	}
	
	public static Statement conectarMySql(){
		url="jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
			
		username="root";
		password="admin";	
		
		System.out.println("URL_BBDD: "+url);
		System.out.println("Username: "+username);
		System.out.println("PAssword: "+password);
		
		System.out.println("Connecting database...");
		
	
		try{
			System.out.println("com.mysql.jdbc.Driver");
			//Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection co= DriverManager.getConnection(url, username,password);
			
		    System.out.println("Database connected!");
			System.out.println("Loading driver...");					
			System.out.println("Driver loaded!");

			Statement st = co.createStatement();
			
			return st;

		} catch (SQLException | ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);}
		//}catch (ClassNotFoundException e1) {
			//e1.printStackTrace();//return null;
	}
	
	public static  ResultSet executeSelect(Statement st, String query){
		try {
			ResultSet rs = st.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}						
		return null;
	}
	
	public static  ResultSet executeSelectW(Statement st,String query){
		try {
			ResultSet rs = st.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}						
		return null;
	}
	
	
 
	public static void executeInsert(String insertSql){
		Statement st2=conectarMySql();
		try {
			st2.execute(insertSql);
			
			//INSERT
			ResultSet rseI=executeSelect(st2,"select * from videos");
			mostrarDatos(rseI);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ejecutarUpdate(){
		Statement st2=conectarMySql();
		try {
			st2.executeUpdate("update direccion set id='9' where nombre='2'");
			
			System.out.println("Update echo");
		} catch (SQLException e) {
			System.out.println("Error en el Update");
			e.printStackTrace();
		}	
	}
	
	public static void executeDelete(){
		Statement st2=conectarMySql();
		try {
			st2.executeUpdate("delete from direccion where iddirecion='50'");
			
			System.out.println("Delete echo");
		} catch (SQLException e) {
			System.out.println("Error en el Delete");
			e.printStackTrace();
		}
	}
	
	public static void mostrarDatos(ResultSet rs){

		int id=0;
		String calle="";
		String poblacion="";
		
		System.out.format("id ,calle ,poblacion\n");

		try {
			while (rs.next()){
				id = rs.getInt("id");
				calle = rs.getString("nombre");
				//poblacion = rs.getString("poblacion");
				   
				System.out.println(id +"	"+calle+"	"+ poblacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	