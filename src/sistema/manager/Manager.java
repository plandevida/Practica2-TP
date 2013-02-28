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
	private List<Ciclista> ciclistas;
	private Bicicleta bicicleta;
	private Bicicleta bicicleta1;
	private Bicicleta bicicleta2;
	private Bicicleta bicicleta3;
	private Reloj reloj;
	private Dispatcher dispatcher;
	private ParseadorComandos parser;
	private Lector lector;
	
	public void cargarConfiguracion() {
		Lector lectorConfiguracion = new Lector("carrera");
		
		lectorConfiguracion.cargarFichero();
	}
	
	/**
	 * Inicializa el contexto de la aplicación.
	 */
	public void iniciar() {
		
		reloj = new Reloj();
		
		bicicleta = new Bicicleta();
		bicicleta1 = new Bicicleta();
		bicicleta2 = new Bicicleta();
		bicicleta3 = new Bicicleta();
		
		ciclistas = new ArrayList<Ciclista>();
		
		ciclistas.add(new Ciclista("Pamela", 1, 0.5, bicicleta, reloj));
		ciclistas.add(new Ciclista("Pedro", 2, 1.5, bicicleta1, reloj));
		ciclistas.add(new Ciclista("Ana", 3, 1.0, bicicleta2, reloj));
		ciclistas.add(new Ciclista("Juan", 4, 0.75, bicicleta3, reloj));
		
		listaejecutables = new ArrayList<ObjetosQueSeEjecutan>();
		salidadatos = new SalidaDatos();
		
		listaejecutables.add(reloj);
		
		for (Ciclista ciclista : ciclistas) {
			listaejecutables.add(ciclista);
			salidadatos.registrarObjetoConSalidaDatos(ciclista);
		}
		
		salidadatos.registrarObjetoConSalidaDatos(reloj);
		salidadatos.registrarObjetoConSalidaDatos(bicicleta);
		salidadatos.registrarObjetoConSalidaDatos(bicicleta1);
		salidadatos.registrarObjetoConSalidaDatos(bicicleta2);
		salidadatos.registrarObjetoConSalidaDatos(bicicleta3);
		
		dispatcher = new Dispatcher();
		parser = new ParseadorComandos(dispatcher, listaejecutables);
		
		lector = new Lector("prueba");
	}
	
	/**
	 * Ejecuta la aplicación.
	 */
	public void ejecutar() {
		
		while ( reloj.getHoras() < 200000 ) {
			
			parser.parsearComando(lector.leerTeclado());
			parser.parsearComando(lector.leerFichero());
			parser.dispatch();
			
			salidadatos.mostrarDatos();
			for (ObjetosQueSeEjecutan objetoejecutable : listaejecutables) {
				objetoejecutable.ejecutar();
			}
			
			if(reloj.getImpulsos()== 0){
				try {
					Thread.sleep(2000);
				}	
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			salidadatos.mostrarDatos();
		}
	}
	
	/**
	 * Finaliza el contexto de la aplicación.
	 */
	public void finalizar() {
		lector.finalizarLecturas();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		
		manager.cargarConfiguracion();
		manager.iniciar();
		manager.ejecutar();
		manager.finalizar();
	}
}
