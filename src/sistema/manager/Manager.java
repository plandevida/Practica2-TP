package sistema.manager;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import sistema.entidades.bicicletas.Bicicleta;
import sistema.entidades.personas.Ciclista;
import sistema.entidades.tiempo.Reloj;
import sistema.entrada.lectura.teclado.LecturaTeclado;
import sistema.entrada.parseador.parser.ParseadorComandos;
import sistema.interfaces.ObjetosQueSeEjecutan;
import sistema.salidadatos.SalidaDatos;

public class Manager {

	private List<ObjetosQueSeEjecutan> listaejecutables;
	private SalidaDatos salidadatos;
	private Ciclista ciclista;
	private Bicicleta bicicleta;
	private Reloj reloj;
	private ParseadorComandos parser;
	
	public void iniciar() {
		parser = new ParseadorComandos();
		
		reloj = new Reloj();
		bicicleta = new Bicicleta();
		ciclista = new Ciclista("Pepe", 1, 0.5, bicicleta, reloj);
		
		listaejecutables = new ArrayList<ObjetosQueSeEjecutan>();
		
		listaejecutables.add(reloj);
		listaejecutables.add(bicicleta);
		listaejecutables.add(ciclista);
		
		salidadatos = new SalidaDatos();
		
		salidadatos.registrarObjetoConSalidaDatos(reloj);
		salidadatos.registrarObjetoConSalidaDatos(bicicleta);
		salidadatos.registrarObjetoConSalidaDatos(ciclista);
	}
	
	public void ejecutar() {
		
		while ( reloj.getMinutos() < 2 ) {
			parser.parsearComando(new LecturaTeclado(new InputStreamReader(System.in)).leer());
			
			for (ObjetosQueSeEjecutan objetoejecutable : listaejecutables) {
				objetoejecutable.ejecutar();
			}
			salidadatos.mostrarDatos();
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
