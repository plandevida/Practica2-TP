package sistema.entrada.lectura;

import sistema.entrada.lectura.fichero.LecturaFichero;
import sistema.entrada.lectura.teclado.LecturaTeclado;

/**
 * Clase que invoca a los sistemas de lectura.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class Lector {
	
	private LecturaTeclado teclado;
	private LecturaFichero fichero;
	
	public Lector(String file) {
		
		teclado = new LecturaTeclado();
		
		// Se instancia como un lector de comandos
		fichero = new LecturaFichero(file, false);
	}
	
	public String leerTeclado() {
		
		return teclado.leer();
	}
	
	public String leerFichero() {
		
		return fichero.leer();
	}
	
	public String cargarFichero() {
		LecturaFichero lecturaFichero = new LecturaFichero(null, true);
		
		return lecturaFichero.cargarFichero();
	}
	
	/**
	 * Cierra todos los flujos de lecturas.
	 * @return
	 */
	public boolean finalizarLecturas() {
		boolean correcto = true;
		
		try {
			teclado.finalizar();
			fichero.finalizar();
		} catch (Exception e) {
			correcto = false;
		}
		
		return correcto;
	}
}
