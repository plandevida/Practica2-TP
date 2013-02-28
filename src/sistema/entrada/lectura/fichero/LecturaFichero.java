package sistema.entrada.lectura.fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sistema.entrada.lectura.InterfazLectura;

public class LecturaFichero implements InterfazLectura {

	private BufferedReader fileinput;
	
	public LecturaFichero(String file) {
		try {
			fileinput = new BufferedReader(new FileReader(new File(file)));
		} catch (FileNotFoundException f) {
			System.err.println("El fichero no existe");
		}
	}

	@Override
	public String leer() {
		
		String cadena = "";
		
		try {
			if (fileinput != null && fileinput.ready()) {
				char[] buffer = new char[512];
				
				fileinput.read(buffer);
				
				cadena = buffer.toString();
			}
			
			return cadena;
		} catch (IOException e) {
//			System.err.println("Error al leer el fichero o no está lista la lectura por fichero");
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
