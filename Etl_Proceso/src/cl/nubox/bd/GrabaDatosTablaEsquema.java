package cl.nubox.bd;

import java.sql.CallableStatement;
import java.sql.Connection;

public class GrabaDatosTablaEsquema {
	
	public static void cargaTablaJuego(Connection conn) {
		
		CallableStatement stmt = null;
		try {
			stmt = conn.prepareCall("begin PKG_VIDEOJUEGO.carga_juego(); end;");
			stmt.execute();
		}
		catch (Exception e)
        {
          e.printStackTrace();
		  System.out.println("*** No se pudo insertar en tabla JUEGO ***");
        } 
        finally 
        {
          try { stmt.close(); } catch ( Exception ee) {}
        }
	}
	
public static void cargaTablaNotas(Connection conn) {
		
		CallableStatement stmt = null;
		try {
			stmt = conn.prepareCall("begin PKG_VIDEOJUEGO.carga_notas_juego(); end;");
			stmt.execute();
		}
		catch (Exception e)
        {
          e.printStackTrace();
		  System.out.println("*** No se pudo insertar en tabla JUEGO ***");
        } 
        finally 
        {
          try { stmt.close(); } catch ( Exception ee) {}
        }
	}

}
