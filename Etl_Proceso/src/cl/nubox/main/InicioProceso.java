package cl.nubox.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cl.nubox.TO.DatosArchivoTO;

public class InicioProceso {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = buscaConexion();
		/* Carga objeto desde archivo de entrada */
		List<DatosArchivoTO> datosArchivo = cl.nubox.DAO.CargaDatosArchivo.leeArchivoEntrada();
		
		/* Carga tabla temporal */
		cl.nubox.bd.GrabaTablaTemporal.grabaTablaTMP(conn, datosArchivo);
		
		/* Carga tabla de JUEGO con datos de tabla temporal */
		cl.nubox.bd.GrabaDatosTablaEsquema.cargaTablaJuego(conn);
		
		/* Carga tabla con notas de usuarios */
		cl.nubox.bd.GrabaDatosTablaEsquema.cargaTablaNotas(conn);

	}
	
	public static Connection buscaConexion() {
		
		Connection conn = null;
		
		try {
			conn = cl.nubox.bd.ConeccionBd.cargaConexion();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return conn;
	}

}
