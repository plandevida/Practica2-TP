package sistema.entrada.parseador.ordenes.especificas;

import sistema.entidades.personas.Ciclista;
import sistema.entrada.parseador.lexer.Comandos;
import sistema.entrada.parseador.ordenes.Orden;

/**
 * Orden específica para el ciclista
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class OrdenCiclista extends Orden {

	/**
	 * Comando que realizará el ciclista.
	 */
	private Comandos comando;
	
	/**
	 * Identificador único del ciclista.
	 */
	private int numeromallotciclista;
	
	@Override
	public Comandos getComando() {
		return comando;
	}
	
	/**
	 * Obtiene el número del mallot del ciclista,
	 * el cual es único.
	 * 
	 * @return Número del mallot @see {@link Ciclista#numero_mallot}
	 */
	public int getIdCiclista() {
		return numeromallotciclista;
	}
}
