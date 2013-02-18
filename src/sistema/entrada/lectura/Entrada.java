package sistema.entrada.lectura;


import java.io.*;

import sistema.interfaces.ObjetosQueSeEjecutan;

public class Entrada implements ObjetosQueSeEjecutan {

	InputStreamReader lectura;

	public Entrada(InputStreamReader nuevo_origen_de_lectura) {
		lectura = nuevo_origen_de_lectura;
	}

	@Override
	public boolean ejecutar() {
		try {

			if (lectura.ready()) {
				char[] buffer_de_lectura = new char[100];
				lectura.read(buffer_de_lectura);

				String Salida = new String(buffer_de_lectura);
				System.out.println(Salida);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			finalizar();
		}
		
		return false;
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