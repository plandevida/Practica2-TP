package sistema.entidades.vehiculos.bicicletas;

import java.util.Map;
import java.util.StringTokenizer;

import sistema.entidades.carretera.tramocarreraciclista.TramoCiclista;
import sistema.entidades.vehiculos.Vehiculo;
import sistema.interfaces.ObjetosConSalidaDeDatos;


/**
 * Esta clase representa una bicicleta, con los elementos y acciones comunes a estas.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class Bicicleta extends Vehiculo implements ObjetosConSalidaDeDatos {

	// El array representa los piñones de la bicicleta con el indice
	// del array y su valor es el número de dientes del piñón
	protected int[] pinhones = new int[] { 15, 20, 25, 30 };

	// El array representa los plato de la bicicleta con el indice
	// del array y su valor es el número de dientes del plato
	protected int[] platos = new int[] { 30, 40, 50 };

	// Continen el indice del piñón que se esta utilizando
	protected int platoactual;

	// Continen el indice del plato que se esta utilizando
	protected int pinhonactual;
	
	protected double radiorueda;
	
	
	protected Map<Integer, TramoCiclista> carreteradecarreraciclsta;
	
	public Bicicleta(Map<Integer, TramoCiclista> carreteradecarreraciclsta) {
		this.carreteradecarreraciclsta = carreteradecarreraciclsta;
		setVelocidad(0);
		setEspacioRecorrido(0);
		setPinhonactual(0);
		setPlatoactual(0);
		radiorueda = 0.2d;
	}

	/**
	 * Relación entre el plato y piñón que se están usando actualmente.
	 * 
	 * @return Un entero que es relación entre ambos valores.
	 */
	private int relacionDeTransmision() {

		int relaciondetrasminsion = platos[platoactual] / pinhones[pinhonactual];

		return relaciondetrasminsion;
	}
	
	/**
	 *  Busca el tramo en el que se encuentra la bici 
	 * @return devuelve el tramo
	 */
	private TramoCiclista tramoActual(){
		TramoCiclista tramo = new TramoCiclista(0, 0, null, 0);
		
		for(Integer reco : carreteradecarreraciclsta.keySet()) {

			if ( carreteradecarreraciclsta.get(reco).getKilometros() <= (int) getEspacioRecorrido() ) {
				tramo = carreteradecarreraciclsta.get(reco);
			}
		}
		return tramo;
	}
	
	/** Metodo que busca el tramo en el que esta y devuelver 
	 * 
	 * @return devuelve la pendiente
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
	 * Devuelve el la longitud de la rueda.
	 * 
	 * @return El valor de la longitud de la rueda.
	 */
	private double recorridoLinealDeLaRueda() {

		double recorridolinealdelarueda = Math.PI * radiorueda;

		return recorridolinealdelarueda;

	}
	
	/**
	 * Calcula el espacio recorrido por cada pedalada que se da.
	 * 
	 * @return El valor del espacio recorrido.
	 */
	private double espacioDePedalada() {

		double espaciodepedalada = recorridoLinealDeLaRueda() * relacionDeTransmision();

		return espaciodepedalada;
	}
	
	/**
	 * Calcula la velocidad de la bicicleta en función de la cadencia del ciclista.
	 * 
	 * @param cadenciaciclista Frecuencia con la que el ciclista da pedaladas.
	 * @return La velocidad de la bicicleta.
	 */
	private double calcularVelocidadCadencia(double cadenciaciclista) {

		double velocidadbici = espacioDePedalada() / cadenciaciclista;

		return velocidadbici;
	}
	
	/**
	 * Método para obtener una salida de datos de un objeto.
	 * 
	 * @return Una cadena de texto separada por tokens.
	 */
	public StringTokenizer mostrarDatos() {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append(getVelocidad());
		
		return new StringTokenizer(mensaje.toString(), ",");
	}
	
	/**
	 * Realiza una pedalada en la bicicleta, aumentando su velocidad.
	 * 
	 * @param cadenciaciclista Frecuencia con la que el ciclista da pedaladas. 
	 */
	public void darPedalada(double cadenciaciclista) {
		double velocidad = calcularVelocidadCadencia(cadenciaciclista) * pendienteTramoActual();
		
		setEspacioRecorrido(espacioDePedalada());
		setVelocidadIncremento(velocidad);
	}
	
	/**
	 * Decrementa la velocidad de la bicicleta.
	 */
	public void frenar() {
		double velocidad = getVelocidad();
		
		setEspacioRecorrido(espacioDePedalada());
		
		double decrementovelocidad = velocidad * 0.2;
		
		setVelocidadIncremento(-decrementovelocidad);
	}
	
	/**
	 * Incrementa el piñón de la bicicleta.
	 */
	public void incrementarPinhon() {
		if (pinhonactual < pinhones.length - 1) {
			pinhonactual++;
		}
	}
	
	/**
	 * Decrementa el piñón de la bicicleta.
	 */
	public void decrementarPinhon() {
		if (pinhonactual > 0) {
			pinhonactual--;
		}
	}
	
	/**
	 * Incrementa el plato de la bicicleta.
	 */
	public void incrementarPlato() {
		if (platoactual < platos.length - 1) {
			platoactual++;
		}
	}
	
	/**
	 * Decrementa el plato de la bicicleta.
	 */
	public void decrementarPlato() {
		if (platoactual > 0) {
			platoactual--;
		}
	}
	
	/**
	 * Obtiene los piñones y sus dientes.
	 * 
	 * @return Una lista de los piñones y sus dientes.
	 */
	public int[] getPinhones() {
		return pinhones;
	}
	
	/**
	 * Obtiene los platos y sus dientes.
	 * 
	 * @return Una lista de los platos y sus dientes.
	 */
	public int[] getPlatos() {
		return platos;
	}
	
	/**
	 * Obtiene el plato engranado actualmente.
	 *  
	 * @return El indice de la lista de platos del plato engranado.
	 */
	public int getPlatoactual() {
		return platoactual;
	}
	
	/**
	 * Ajusta el plato engranado actualmente por otro.
	 * 
	 * @param platoactual El nuevo plato a engranar.
	 */
	public void setPlatoactual(int platoactual) {
		if ( platoactual <= platos.length - 1 || platoactual >= 0) {
			this.platoactual = platoactual;
		}
	}
	
	/**
	 * Obtiene el piñón engranado actualmente.
	 * 
	 * @return El indice de la lista de piñones del piñón engranado
	 */
	public int getPinhonactual() {
		return pinhonactual;
	}
	
	/**
	 * Ajusta el piñón engranado actualmente por otro.
	 * 
	 * @param pinhonactual El nuevo piñón a engranar.
	 */
	public void setPinhonactual(int pinhonactual) {
		if ( pinhonactual <= pinhones.length - 1 || pinhonactual >= 0) {
			this.pinhonactual = pinhonactual;
		}
	}
	
	/**
	 * Obtiene el radio de la rueda.
	 * 
	 * @return Valor del radio de la rueda.
	 */
	public double getRadiorueda() {
		return radiorueda;
	}

//	 private enum Pinhones {
//		 UNO(10), //0
//		 DOS(20), //1
//		 TRES(30), //2
//		 CUATRO(40); //3
//		
//		 private int numerodedientes;
//		
//		 Pinhones(int numerodientes) {
//			 numerodedientes = numerodientes;
//		 }
//		
//		 public int getNumeroDientes() {
//			 return numerodedientes;
//		 }
//		
//		 public Pinhones desdeIndice(int indice) {
//			 return ( indice < Pinhones.values().length) ? Pinhones.values()[indice] : null;
//		 }
//	 }
}