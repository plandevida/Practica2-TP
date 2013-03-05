package src.tests.utils;

import java.util.Map;

import sistema.entidades.carretera.tramocarreraciclista.TramoCiclista;


public class TestUtilidadesBicicleta {

	/**
	 * Calcula la velocidad de la bicicleta en función de la cadencia del ciclista.
	 * 
	 * @param cadenciaciclista Frecuencia con la que el ciclista da pedaladas.
	 * @return La velocidad de la bicicleta.
	 */
	public double velocidadDeBici(double cadenciaciclista, double radiorueda, int dientesPlato, int dientesPinhon, Map<Integer, TramoCiclista> carreteradecarreraciclista, double espaciorecorrido) {

		double velocidadbici = espacioDePedalada(radiorueda, dientesPlato, dientesPinhon) / cadenciaciclista * pendienteTramoActual(carreteradecarreraciclista, espaciorecorrido);

		return velocidadbici;
	}
	
	/**
	 * Calcula el espacio recorrido por cada pedalada que se da.
	 * 
	 * @return El valor del espacio recorrido.
	 */
	public double espacioDePedalada(double radiorueda, int dientesPlato, int dientesPinhon) {

		double espaciodepedalada = recorridoLinealDeLaRueda(radiorueda) * relacionDeTransmision(dientesPlato, dientesPinhon);

		return espaciodepedalada;
	}

	/**
	 * Relación entre el plato y piñón que se están usando actualmente.
	 * 
	 * @return Un entero que es relación entre ambos valores.
	 */
	public int relacionDeTransmision(int dientesPlato, int dientesPinhon) {

		int relaciondetrasminsion = dientesPlato / dientesPinhon;

		return relaciondetrasminsion;
	}
	
	/**
	 * Devuelve el la longitud de la rueda.
	 * 
	 * @return El valor de la longitud de la rueda.
	 */
	public double recorridoLinealDeLaRueda(double radiorueda) {

		double recorridolinealdelarueda = Math.PI * radiorueda;

		return recorridolinealdelarueda;

	}
	
	/** Metodo que busca el tramo en el que esta y devuelver 
	 * 
	 * @return devuelve la pendiente
	 */
	public double pendienteTramoActual(Map<Integer, TramoCiclista> carreteradecarreraciclista, double espaciorecorrido) {
		
		int pendiente = 0;
		
		for(Integer km : carreteradecarreraciclista.keySet()) {
			
			if ( km.intValue() <= (int) espaciorecorrido ) {
				pendiente = carreteradecarreraciclista.get(km).getPendiente();
			}
		}
		
		double factorpendiente = 0d;
		
		if (pendiente < 0) {
			factorpendiente = 1 + Math.cos(pendiente);
		} else {
			factorpendiente = Math.cos(pendiente);
		}
		
		return factorpendiente;
	}
	

}
