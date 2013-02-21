package sistema.entrada.parseador.parser;

import sistema.entrada.parseador.lexer.Comandos;
import sistema.entrada.parseador.ordenes.Orden;
import sistema.entrada.parseador.ordenes.especificas.OrdenCiclista;

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
		
		String[] a = comando.split(",");
		
		Comandos comandoparseado = Comandos.existe(a[0]);
		
		Orden o = comandoparseado.getOrden();
		
		if ( o instanceof OrdenCiclista ) {
			((OrdenCiclista) o).setComando(comandoparseado);
			((OrdenCiclista) o).setIdCilista(Integer.valueOf(a[1]).intValue());
		}
		
		return o;
		
//		return construirOrden(comandoparseado);
	}
	
	/**
	 * Construye un objeto orden para el elemento concreto
	 * a partir del comando.
	 * 
	 * @param comando Comnado a partir del cual se va a construir
	 * la orden
	 * @return orden construida
	 */
	private Orden construirOrden(Comandos comando) {
		Orden orden = null;
		
		orden = comando.getOrden();
		
		orden.setComando(comando);
		
		return orden;
	}
}
