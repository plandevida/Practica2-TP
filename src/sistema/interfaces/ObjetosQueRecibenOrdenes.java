package sistema.interfaces;

import sistema.entrada.ordenes.Orden;

public interface ObjetosQueRecibenOrdenes {
	
	/**
	 * Método que ejecutará el comando concreto del objeto correspondiente 
	 */
	public void ejecutaComando(Orden orden);
}
