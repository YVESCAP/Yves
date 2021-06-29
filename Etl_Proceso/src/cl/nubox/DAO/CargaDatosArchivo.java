package cl.nubox.DAO;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import cl.nubox.TO.DatosArchivoTO;

public class CargaDatosArchivo {
	
	public static List<DatosArchivoTO> leeArchivoEntrada() {
		String archivoEntrada = "C:\\data\\result.csv";
		CSVReader csvReader = null;
		List<DatosArchivoTO> datosArchivo = new ArrayList<DatosArchivoTO>();
		
		try {
			csvReader = new CSVReader(new FileReader(archivoEntrada));
			String[] fila = null;
			
			while ((fila = csvReader.readNext()) != null) {

				DatosArchivoTO data = new DatosArchivoTO();
				data.setMetaScore(fila[0]);
				data.setNombreJuego(fila[1]);
				data.setNombreConsola(fila[2]);
				data.setNotaUsuario(fila[3]);
				data.setFechaNota(fila[4]);
				datosArchivo.add(data);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datosArchivo;
		
	}


}
