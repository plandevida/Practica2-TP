package sistema.entrada.parseador.parser;

import sistema.entrada.parseador.lexer.Comandos;
import sistema.entrada.parseador.ordenes.Orden;

/**
 * Clase que contruye la orden para el sistema a partir
 * de un comando.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class ParseadorComandos {
	
	/**
	 * Genera una orden para un elemento del sistema,
	 * a partir de un comando recibido.
	 * 
	 * @param comando Comando recibido.
	 * @return La orden generada, si el comando no se reconoce
	 * la orden contendrá un comando DESCONOCIDO @see {@link Comandos#DESCONOCIDO}
	 */
	public Orden parsearComando(String comando) {
		Orden orden = null;
		
		Comandos comandoparseado = Comandos.existe(comando);
		
		orden = comandoparseado.getOrden();
		
		orden.setComando(comandoparseado);
		
		return orden;
	}
	
	private Orden construirOrden(Comandos comando) {
		
		
		return null;
	}
}
