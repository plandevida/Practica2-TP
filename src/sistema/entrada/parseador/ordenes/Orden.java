package sistema.entrada.parseador.ordenes;

import sistema.entrada.parseador.lexer.Comandos;

/**
 * Clase que representa una orden a realizar por un elemento
 * único del sistema.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public abstract class Orden {
	
	protected Comandos comand;
	
	/**
	 * Obtiene el comando a ejecutar por el objeto.
	 * 
	 * @return Un comando @see {@link Comandos}
	 */
	protected abstract Comandos getComando();
	
	/**
	 * Permite configurar el comando de la orden.
	 * 
	 * @param comando Comando de la orden.
	 */
	public void setComando(Comandos comando) {
		comand = comando;
	}
}
