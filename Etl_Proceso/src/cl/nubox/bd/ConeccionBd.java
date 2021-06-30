package cl.nubox.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConeccionBd {
	
	public void cargaClase(){
		 
		try {
		 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		} catch (ClassNotFoundException ex) {
		 
		ex.printStackTrace();
		 
		}
		 
		}
	
	public static Connection cargaConexion(){
		
		Connection conexion = null;
		try{
		 
			String urll;
			 
			urll = "jdbc:oracle:thin:@localhost:1521:xe";
			 
			conexion=DriverManager.getConnection(urll,"SVR_TOA","of1c14l.25");
		 
		} catch(SQLException s){
		 
			s.printStackTrace();
		 
		}
		
		return conexion;
		
	}

}
