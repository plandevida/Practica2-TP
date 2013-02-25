/** NO SE ESTA UTILIZANDO **/

package sistema.entrada.ordenes.especificas;

import sistema.entidades.personas.ciclistas.Ciclista;
import sistema.entrada.ordenes.Orden;

/**
 * Orden específica para el ciclista
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class OrdenCiclista extends Orden {

	/**
	 * Identificador único del ciclista.
	 */
	protected int numeromallotciclista;
	
	/**
	 * Obtiene el número del mallot del ciclista,
	 * el cual es único.
	 * 
	 * @return Número del mallot @see {@link Ciclista#numero_mallot}
	 */
	public int getIdCiclista() {
		return numeromallotciclista;
	}
	
	public void setIdCilista(int numeromallot) {
		numeromallotciclista = numeromallot;
	}
}
