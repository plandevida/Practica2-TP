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
		fichero = new LecturaFichero(file);
	}
	
	public String leerTeclado() {
		
		return teclado.leer();
	}
	
	public String leerFichero() {
		
		return fichero.leer();
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
