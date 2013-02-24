package sistema.manager;

import java.util.ArrayList;
import java.util.List;

import sistema.entidades.personas.ciclistas.Ciclista;
import sistema.entidades.tiempo.Reloj;
import sistema.entidades.veiculos.bicicletas.Bicicleta;
import sistema.entrada.lectura.Lector;
import sistema.entrada.ordenes.Dispatcher;
import sistema.entrada.parseador.parser.ParseadorComandos;
import sistema.interfaces.ObjetosQueSeEjecutan;
import sistema.salidadatos.SalidaDatos;

/**
 * Clase principal que inicia la aplicación.
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class Manager {

	private List<ObjetosQueSeEjecutan> listaejecutables;
	private SalidaDatos salidadatos;
	private Ciclista ciclista;
	private Bicicleta bicicleta;
	private Reloj reloj;
	private Dispatcher dispatcher;
	private ParseadorComandos parser;
	private Lector lector;
	
	/**
	 * Inicializa el contexto de la aplicación.
	 */
	public void iniciar() {
		
		dispatcher = new Dispatcher();
		parser = new ParseadorComandos(dispatcher);
		
		lector = new Lector("prueba");
		
		reloj = new Reloj();
		bicicleta = new Bicicleta();
		ciclista = new Ciclista("Pamela", 1, 0.5, bicicleta, reloj);
		
		listaejecutables = new ArrayList<ObjetosQueSeEjecutan>();
		
		listaejecutables.add(reloj);
		listaejecutables.add(bicicleta);
		listaejecutables.add(ciclista);
		
		salidadatos = new SalidaDatos();
		
		salidadatos.registrarObjetoConSalidaDatos(reloj);
		salidadatos.registrarObjetoConSalidaDatos(bicicleta);
		salidadatos.registrarObjetoConSalidaDatos(ciclista);
	}
	
	/**
	 * Ejecuta la aplicación.
	 */
	public void ejecutar() {
		
		while ( reloj.getHoras() < 200000 ) {
			
			parser.parsearComando(lector.leerTeclado());
			parser.dispatch();
			
			for (ObjetosQueSeEjecutan objetoejecutable : listaejecutables) {
				objetoejecutable.ejecutar();
			}
//			salidadatos.mostrarDatos();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		
		manager.iniciar();
		manager.ejecutar();
	}
}
