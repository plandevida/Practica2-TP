package sistema.factoresexternos;

import java.util.Map;

import sistema.entidades.carretera.tramocarreraciclista.TramoCiclista;
import sistema.entidades.vehiculos.bicicletas.Bicicleta;
import sistema.factoresexternos.viento.MiViento;
import sistema.interfaces.ObjetosQueSeEjecutan;

/**
 * Clase que calcula los datos de los elementos climatológicos
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class FactoresExternos implements ObjetosQueSeEjecutan {
	
	private Bicicleta bici;
	
	//Mapa de la carretera
	private Map<Integer, TramoCiclista> carreteradecarreraciclista;
	
	public FactoresExternos(Bicicleta bici, Map<Integer, TramoCiclista> carreteradecarreraciclista) {
		
		this.bici = bici;
		this.carreteradecarreraciclista = carreteradecarreraciclista;
	}
	
	/**
	 *  Busca el tramo en el que se encuentra la bici 
	 * @return devuelve el tramo
	 */
	private TramoCiclista tramoActual() {
		
		TramoCiclista tramo = new TramoCiclista(0, 0, null, 0);
		
		for(Integer reco : carreteradecarreraciclista.keySet()) {

			if ( carreteradecarreraciclista.get(reco).getKilometros() <= (int) bici.getEspacioRecorrido() ) {
				tramo = carreteradecarreraciclista.get(reco);
			}
		}
		return tramo;
	}
	
	/**
	 * Calcular el factor de la pendiente, gracias al angulo de la pendiente 
	 * 
	 * @return devuelve el factorpendiente
	 */
	private double pendienteTramoActual() {
		
		int angulograd = 0;
		double angulorad = 0d;
		double factorpendiente = 0d;
		
		TramoCiclista tramo = tramoActual();
		
		angulograd = tramo.getPendiente();
		angulorad = (angulograd * Math.PI)/180;
		

		factorpendiente = Math.cos(angulorad);
		
		if (angulograd < 0) {
			factorpendiente = factorpendiente + 1d;

		}

		
		return factorpendiente;
	}
	
	/**
	 * Mira el viento que hay en el tramo actual y devuelve un factor
	 * 
	 * @return devuelve un porcentaje calculado a traves del viento y su direccion
	 */
	private double vientoTramoActual(){
		
		TramoCiclista tramo = tramoActual();
		
		
		int direccionviento = tramo.getViento().getFactor();
		
		double velocidadviento = tramo.getVelocidadViento();
		
		return (double)(direccionviento * velocidadviento)/10;
		
	}

	/**
	 * Modifica la velocidad de la bicicleta dependiendo de los factores externos de la carretera
	 * 
	 */
	private void setVelocidadModificada() {

		double velocidad = bici.getVelocidad() * pendienteTramoActual();
		
		velocidad = velocidad + velocidad * vientoTramoActual();
		
		bici.setVelocidadIncremento(velocidad);
	}


	@Override
	public boolean ejecutar() {
		
		setVelocidadModificada();
		
		return true;
	}
}

