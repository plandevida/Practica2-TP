package sistema.entrada.ordenes;

import sistema.entrada.parseador.lexer.Comandos;

/**
 * Clase que representa una orden a realizar por un elemento
 * único del sistema.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public abstract class Orden implements Comparable<Orden> {
	
	protected Comandos comand;
	
	/**
	 * Obtiene el comando a ejecutar por el objeto.
	 * 
	 * @return Un comando @see {@link Comandos}
	 */
	public Comandos getComando() {
		return comand;
	}
	
	/**
	 * Permite configurar el comando de la orden.
	 * 
	 * @param comando Comando de la orden.
	 */
	public void setComando(Comandos comando) {
		comand = comando;
	}
	
	@Override
	public int compareTo(Orden o) {
		int resultado = 0;
		
		if ( o != null ) {
			if ( this.getComando() != null && o.getComando() != null && this.getComando().equals(o.getComando())) {
				resultado = -1;
			}
		}
		
		return resultado;
	}
}
