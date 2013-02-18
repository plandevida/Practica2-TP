package sistema.interfaces;

import sistema.entrada.parseador.ordenes.Orden;

public interface ObjetosQueRecibenComandos {
	
	/**
	 * Método que ejecutará el comando concreto del objeto correspondiente 
	 */
	public void ejecutaComando(Orden orden);
}
