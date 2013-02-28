package sistema.entrada.lectura.fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sistema.entrada.lectura.InterfazLectura;

public class LecturaFichero implements InterfazLectura {

	private BufferedReader fileinput;
	private static final String COMANDOS_PATH = "resources/instrucciones/";
	private static final String CONFIG_PATH = "resources/configuracion/";
	
	public LecturaFichero(String filepath, boolean configuracion) {
		
		try {
			
			File file;
			
			if(configuracion) {
				file = new File(CONFIG_PATH + filepath);
			} else {
				file = new File(COMANDOS_PATH + filepath);
			}
			
			fileinput = new BufferedReader(new FileReader(file));
			
		} catch (FileNotFoundException f) {
			System.err.println("El fichero no existe");
		}
	}
	
	public String cargarFichero() {
		String cadena = "";
		
		try {
			while(cadena.equals("EOF")) {
				
				cadena = fileinput.readLine();
			}
		} catch (IOException io) {
			System.err.println("Error al leer el fichero de configuración de la aplicación");
		}
		
		return cadena;
	}

	@Override
	public String leer() {
		
		String cadena = "";
		
		try {
			if (fileinput != null && fileinput.ready()) {
				
				cadena = fileinput.readLine();
				
			}	
		} catch (IOException e) {
			System.err.println("Error al leer el fichero o no está lista la lectura por fichero");
		}
		
		return cadena;
	}
	
	/**
	 * Cierra el flujo de lectura.
	 * @throws IOException 
	 */
	public void finalizar() throws IOException {
		if (fileinput != null) {
			fileinput.close();
		}
	}
}
