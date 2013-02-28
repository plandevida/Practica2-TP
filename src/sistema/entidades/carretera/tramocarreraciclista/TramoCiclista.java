package sistema.entidades.carretera.tramocarreraciclista;

import sistema.entidades.carretera.Carretera;
import sistema.factoresexternos.viento.MiViento;

/**
 * Clase que representa un tramo de la carrera ciclista
 * donde se conoce el viento del tramo y su distancia.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class TramoCiclista extends Carretera {
	
	private MiViento viento;
	private int pendiente;
	
	public TramoCiclista(double kilometros, int pendientetramo, MiViento vientodeltramo) {
		super(kilometros);
		viento = vientodeltramo;
		pendiente = pendientetramo;
	}
	
	public MiViento getViento() {
		return viento;
	}
	
	public int getPendiente() {
		return pendiente;
	}
}
