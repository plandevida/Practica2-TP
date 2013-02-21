package sistema.entrada.parseador.parser;

import sistema.entrada.parseador.lexer.Comandos;
import sistema.entrada.parseador.ordenes.Orden;
import sistema.entrada.parseador.ordenes.especificas.OrdenCiclista;

/**
 * Clase que contruye la orden para el sistema a partir
 * de un comando.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class ParseadorComandos {
	
	/**
	 * Genera una orden para un elemento del sistema,
	 * a partir de un comando recibido.
	 * 
	 * @param comando Comando recibido.
	 * @return La orden generada, si el comando no se reconoce
	 * la orden contendrá un comando DESCONOCIDO @see {@link Comandos#DESCONOCIDO}
	 */
	public Orden parsearComando(String comando) {
		
		String[] argumentos = comando.split(",");
		
		argumentos[argumentos.length - 1] = borraBasura(argumentos[argumentos.length - 1]);
		
		Comandos comandoparseado = Comandos.existe(argumentos[0]);
		
		Orden o = comandoparseado.getOrden();
		
		return construirOrden(o, comandoparseado, argumentos);
	}
	
	/**
	 * Borra la basura añadida en la lectura.
	 * 
	 * @param cadena
	 * @return
	 */
	private String borraBasura(String cadena) {
		String truncada = cadena;
		
		
//		if (cadena.contains("\r")) {
//			truncada = cadena.split("\r")[0];
//		} else {
//			truncada = cadena.split("\n")[0];
//		}
		
		truncada = cadena.split("\n")[0].split("\r")[0];
		
		return truncada;
	}
	
	/**
	 * Construye un objeto orden para el elemento concreto
	 * a partir del comando.
	 * 
	 * @param comando Comnado a partir del cual se va a construir
	 * la orden
	 * @return orden construida
	 */
	private Orden construirOrden(Orden orden, Comandos comando, String[] argumentos) {
		Orden ord = orden;
		
		if ( orden instanceof OrdenCiclista ) {
			((OrdenCiclista) ord).setComando(comando);
			((OrdenCiclista) ord).setIdCilista(Integer.valueOf(argumentos[1]).intValue());
		}
		
		return orden;
	}
}
