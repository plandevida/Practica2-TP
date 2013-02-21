package sistema.entrada.lectura.teclado;


import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaTeclado {

	InputStreamReader lectura;

	public LecturaTeclado(InputStreamReader nuevo_origen_de_lectura) {
		lectura = nuevo_origen_de_lectura;
	}
	
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
			e.printStackTrace();
		} finally {
			finalizar();
		}
		
		return salida;
	}
	
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