package sistema.entidades.personas.ciclistas;

import java.util.StringTokenizer;

import sistema.entidades.personas.Persona;
import sistema.entidades.tiempo.Reloj;
import sistema.entidades.veiculos.bicicletas.Bicicleta;
import sistema.entrada.ordenes.Orden;
import sistema.entrada.ordenes.especificas.OrdenCiclista;
import sistema.entrada.parseador.lexer.Comandos;
import sistema.interfaces.ObjetosConSalidaDeDatos;
import sistema.interfaces.ObjetosQueRecibenOrdenes;

/**
 * Clase que representa un ciclista.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class Ciclista extends Persona implements ObjetosConSalidaDeDatos, ObjetosQueRecibenOrdenes {
	/**
	 * La bicicleta que va a montar.
	 */
	private Bicicleta bicicletamontada;
	
	/**
	 * El reloj del ciclista.
	 */
	private Reloj reloj;
	
	/**
	 * La candencia de la pedalada del ciclista.
	 */
	private double cadencia;
	
	/**
	 * Variable que dice si el ciclista esta frenando.
	 */
	private boolean frenando = false;
	
	/**
	 * Identificador único del cilista en la carrera.
	 */
	private int numero_mallot;

	public Ciclista(String nombre, int numeromallot, double cadenciaCiclista, Bicicleta bicicletaamontar, Reloj relojCiclista) {
		/**
		 * Demomento el peso no es relevante, ni el cansancio
		 * 
		 * Esta clase hereda de persona @link Persona
		 */
		super(nombre, 50, 100);
		numero_mallot = numeromallot;
		cadencia = cadenciaCiclista;
		bicicletamontada = bicicletaamontar;
		reloj = relojCiclista;
	}
	
	/**
	 * Metodo que evalua la velociadad de la bicicleta, en fucion de ella
	 * decide si frenar o serguir pedaleando.
	 * 
	 * @return Una cadena de texto separada por tokens.
	 */
	@Override
	public boolean ejecutar() {
		if ( !frenando ) {
			if (bicicletamontada.getVelocidad() < 30)
				pedalear();
			else
				frenando = true;
		}
		else {
			if (bicicletamontada.getVelocidad() < 15)
				frenando = false;
				
			bicicletamontada.frenar();
		}
		
		return true;
	}
	
	/**
	 * Metodo para obtener una salida de datos de un objeto.
	 * 
	 * @return Una cadena de texto separada por tokens.
	 */
	public StringTokenizer mostrarDatos() {
		StringBuilder mensaje = new StringBuilder(getNombre());
		mensaje.append(",");
		mensaje.append(getPeso());
		mensaje.append(",");
		mensaje.append(getCadencia());

		StringTokenizer stringTokenizer = new StringTokenizer(mensaje.toString(), ",");

		return stringTokenizer;
	}
	
	/**
	 * Metodo que da pedaladas a la bicicleta
	 *  
	 */
	private void pedalear() {
		bicicletamontada.darPedalada(cadencia);
	}
	
	/**
	 * Obtiene la bicicleta que se esta montando.
	 *  
	 * @return la bicicleta que se esta montando
	 */
	public Bicicleta getBicicletamontada() {
		return bicicletamontada;
	}
	
	/**
	 * Cambia la bicicleta que se esta montando.
	 * 
	 * @param bicicletamontada Bicicleta que se esta montando.
	 */
	public void setBicicletamontada(Bicicleta bicicletamontada) {
		this.bicicletamontada = bicicletamontada;
	}
	
	/**
	 * Obtiene el reloj.
	 *  
	 * @return el reloj
	 */
	public Reloj getReloj() {
		return reloj;
	}
	
	/**
	 * Cambia el reloj.
	 * 
	 * @param reloj Reloj del ciclista.
	 */
	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}
	
	/**
	 * Obtiene la cadencia del ciclista
	 *  
	 * @return La cadencia
	 */
	public double getCadencia() {
		return cadencia;
	}
	
	/**
	 * Cambia la candencia del ciclista.
	 * 
	 * @param cadencia Cadencia nueva.
	 */
	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}
	
	/**
	 * Obtiene el número del mallot del ciclista.
	 * @return Número único que identifica al ciclista.
	 */
	public int getNumeroMallot() {
		return numero_mallot;
	}

	@Override
	public void ejecutaComando(Orden orden) {
		OrdenCiclista oc = (OrdenCiclista) orden;
		
		Comandos c = oc.getComando();
		
		System.out.println("EL CICLISTA " + getNumeroMallot() + " HA RECIBIDO LA ORDEN " + c.name());
	}
}
