package sistema.entrada.parseador.parser;

import java.util.List;

import sistema.entidades.personas.ciclistas.Ciclista;
import sistema.entrada.ordenes.Dispatcher;
import sistema.entrada.ordenes.Orden;
import sistema.entrada.ordenes.OrdenParaCiclista;
import sistema.entrada.ordenes.especificas.OrdenAumentarCadencia;
import sistema.entrada.parseador.lexer.Comandos;
import sistema.interfaces.ObjetosQueSeEjecutan;

/**
 * Clase que contruye la orden para el sistema a partir
 * de un comando.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class ParseadorComandos {
	
	/**
	 * Distribuidor de ordenes
	 */
	private Dispatcher distribuidor;
	private List<ObjetosQueSeEjecutan> listadeelementos;
	
	public ParseadorComandos(List<ObjetosQueSeEjecutan> lista) {
		distribuidor = new Dispatcher();
		listadeelementos = lista;
	}
	
	public ParseadorComandos(Dispatcher dispatcher, List<ObjetosQueSeEjecutan> lista) {
		distribuidor = dispatcher;
		listadeelementos = lista;
	}
	
	/**
	 * Genera una orden para un elemento del sistema,
	 * a partir de un comando recibido.
	 * 
	 * @param comando Comando recibido.
	 * @return La orden generada, si el comando no se reconoce
	 * la orden contendrá un comando DESCONOCIDO @see {@link Comandos#DESCONOCIDO}
	 */
	public void parsearComando(String comando) {
		
		String[] argumentos = comando.split(",");
		
		//Borra los carácteres basura añadidos al final de la cadena
		// (residentes en el último token)
		argumentos[argumentos.length - 1] = borraBasura(argumentos[argumentos.length - 1]);
		
		Comandos comandoparseado = Comandos.existe(argumentos[0]);
		
		Orden orden = construirOrden(comandoparseado, argumentos);
		
		// Se registra la orden para ser distribuida
		distribuidor.registrarOrdenes(orden);
	}
	
	/**
	 * Invoca al método {@link Dispatcher#dispatch()} para
	 * distribuir las ordenes.
	 */
	public void dispatch() {
		distribuidor.dispatch();
	}
	
	/**
	 * Devuelve el distribuidor de ordenes del parseador.
	 * 
	 * @return El distribuidor de ordenes.
	 */
	public Dispatcher getDispatcher() {
		return distribuidor;
	}
	
	/**
	 * Borra la basura añadida en la lectura.
	 * 
	 * @param cadena
	 * @return La cadena sin caracterés basura.
	 */
	private String borraBasura(String cadena) {
		String truncada = cadena;
		
		truncada = cadena.split("\n")[0].split("\r")[0];
		
		return truncada;
	}
	
	/**
	 * Construye un objeto orden para el elemento concreto
	 * a partir del comando.
	 * 
	 * @param comando Comnado a partir del cual se va a construir
	 * la orden.
	 * @return Orden construida.
	 */
	private Orden construirOrden(Comandos comando, String[] argumentos) {
		Orden orden = comando.getOrden();
		
		if ( orden instanceof OrdenAumentarCadencia ) {
			OrdenAumentarCadencia ordenAumentarCadencia = (OrdenAumentarCadencia) orden;
			
			determinaCiclista(ordenAumentarCadencia, argumentos);
		}
		
		return orden;
	}
	
	/**
	 * Configura el contexto de una orden.
	 * 
	 * @param orden
	 * @param argumentos
	 */
	private void determinaCiclista(OrdenParaCiclista orden, String[] argumentos) {
		
		int numeromallot = Integer.valueOf(argumentos[1]).intValue();
		
		for (ObjetosQueSeEjecutan objetoejecutable : listadeelementos) {
			
			if (objetoejecutable instanceof Ciclista) {
				
				Ciclista ciclista = (Ciclista) objetoejecutable;
				
				if (numeromallot == ciclista.getNumeromallot()) {
					orden.setCiclista(ciclista);
				}
			}
		}
	}
}
