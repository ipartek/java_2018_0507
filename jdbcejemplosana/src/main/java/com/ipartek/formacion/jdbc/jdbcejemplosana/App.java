package com.ipartek.formacion.jdbc.jdbcejemplosana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	
   
        String url="jdbc:mysql://localhost:3307/ipartek";
        String usuario= "root";
        String password= "admin";
        
        
        //conseguir conexion
        Connection conn = DriverManager.getConnection(url, usuario, password);
        Statement stmt = conn.createStatement();
        
        //consulta
        String sql="SELECT * FROM usuarios";
        
        ResultSet rs= stmt.executeQuery(sql);
        
        rs.next();
        
        System.out.println(rs.getString(2));
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
