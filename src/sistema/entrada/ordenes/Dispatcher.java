package sistema.entrada.ordenes;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import sistema.entidades.personas.ciclistas.Ciclista;
import sistema.entrada.ordenes.especificas.OrdenCiclista;
import sistema.interfaces.ObjetosQueRecibenOrdenes;

/**
 * Clase que distruye ls ordenes del sistema a los elementos del sistema.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class Dispatcher {
	
	List<ObjetosQueRecibenOrdenes> objetosquerecibenordenes;
	PriorityQueue<Orden> listadeordenes;
	
	/**
	 * Crea una instancia del distribuidor con la lista de elementos
	 * y la cola de ordenes vacía.
	 */
	public Dispatcher() {
		objetosquerecibenordenes = new ArrayList<ObjetosQueRecibenOrdenes>();
		listadeordenes = new PriorityQueue<Orden>();
	}
	
	public void registrarOrdenes(Orden orden) {
		
		listadeordenes.add(orden);
	}
	
	/**
	 * Distribuye las ordenes a los elementos del sistema.
	 */
	public void dispatch() {
		
		if (listadeordenes.peek() != null) {
			
			for (Orden orden : listadeordenes) {
				
				if (orden instanceof OrdenCiclista) {
					
					dispatchCiclista( (OrdenCiclista) orden);
				}
			}	
		}
	}
	
	/**
	 * Distribye las ordenes a los ciclistas.
	 * 
	 * @param orden Orden del tipo {@link OrdenCiclista}
	 */
	private void dispatchCiclista(OrdenCiclista orden) {
		
		for (ObjetosQueRecibenOrdenes objeto : objetosquerecibenordenes) {
			
			if (objeto instanceof Ciclista) {
				
				Ciclista ciclista = (Ciclista) objeto;
				
				if ( orden.getIdCiclista() == ciclista.getNumeroMallot()) {
					
					ciclista.ejecutaComando(orden);
				}
			}
		}
	}
}
