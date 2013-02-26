package sistema.entrada.ordenes;

import sistema.entidades.personas.ciclistas.Ciclista;

/**
 * Orden solo para los ciclistas.
 * 
 * @author Daniel Serrano Torres
 * @author Arlvaro Quesada Pimentel
 */
public class OrdenParaCiclista extends Orden {

	private Ciclista ciclista;
	
	@Override
	public void ejecutarOrden() {
		
	}
	
	/**
	 * Configura el ciclista.
	 * 
	 * @param ciclista
	 */
	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}
	
	/**
	 * Obtiene el ciclista de la orden
	 * 
	 * @return El ciclista para el que está
	 * dirigida la orden.
	 */
	public Ciclista getCiclista() {
		return ciclista;
	}
}
