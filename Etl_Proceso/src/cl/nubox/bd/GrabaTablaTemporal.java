package cl.nubox.bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cl.nubox.TO.DatosArchivoTO;

import java.sql.CallableStatement;

public class GrabaTablaTemporal {
	
	public static void grabaTablaTMP(Connection conn, List data) {
		CallableStatement stmt = null;
		
		/* Se trunca tabla temporal */
		try {
			stmt = conn.prepareCall("truncate table tmp_videogame");
			stmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			stmt = conn.prepareCall("insert into tmp_videogame values(?,?,?,?,?)");
			
			for(int indice = 0;indice<data.size();indice++)
			{
			    DatosArchivoTO registro = (DatosArchivoTO) data.get(indice);
			    			    
			    stmt.setString(1, registro.getMetaScore());
			    stmt.setString(2, registro.getNombreJuego());
			    stmt.setString(3, registro.getNombreConsola());
			    stmt.setString(4, registro.getNotaUsuario());
			    stmt.setString(5, registro.getFechaNota());
			    
			    stmt.execute();
			    
			}
		}
		catch (Exception e)
        {
          e.printStackTrace();
		  System.out.println("*** No se pudo insertar en tabla Temporal ***");
        } 
        finally 
        {
          try { stmt.close(); } catch ( Exception ee) {}
        }
		
	}

}
