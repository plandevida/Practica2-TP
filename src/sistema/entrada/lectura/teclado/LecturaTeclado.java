package sistema.entrada.lectura.teclado;

import java.io.IOException;
import java.io.InputStreamReader;

import sistema.entrada.lectura.InterfazLectura;

/**
 * Clase que lee del teclado si espera activa, 
 * es decir, no para el programa esperando a leer.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class LecturaTeclado implements InterfazLectura {

	private InputStreamReader lectura;

	public LecturaTeclado() {
		lectura = new InputStreamReader(System.in);
	}
	
	@Override
	public String leer() {
		
		String salida = "";
		
		try { 

			if (lectura.ready()) {
				
				char[] buffer_de_lectura = new char[100];
				
				lectura.read(buffer_de_lectura);

				salida = new String(buffer_de_lectura);
				
				return salida;
			}
		} catch (IOException e) {
			System.err.println("No está listo la lectura por teclado");
		} finally {
			finalizar();
		}
		
		return salida;
	}
	
	/**
	 * Cierra el flujo de lectura.
	 */
	private void finalizar() {
		if (lectura != null) {
			try {
				lectura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}