package sistema.entrada.lectura.fichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sistema.entrada.lectura.InterfazLectura;

public class LecturaFichero implements InterfazLectura {

	private FileReader fileinput;
	
	public LecturaFichero(String file) {
		try {
			fileinput = new FileReader(new File(file));
		} catch (FileNotFoundException f) {
//			System.err.println("El fichero no existe");
		}
	}

	@Override
	public String leer() {
		
		String cadena = "";
		
		try {
			if (fileinput.ready()) {
				char[] buffer = new char[512];
				
				fileinput.read(buffer);
				
				cadena = buffer.toString();
			}
			
			return cadena;
		} catch (IOException e) {
//			System.err.println("No está lista la lectura por fichero");
		} finally {
			if (fileinput != null) {
				try {
					fileinput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return cadena;
	}
}
