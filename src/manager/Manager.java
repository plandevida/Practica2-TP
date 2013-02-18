package manager;

import interfaces.ObjetosQueSeEjecutan;

import java.util.ArrayList;
import java.util.List;

import entidades.bicicletas.Bicicleta;
import entidades.personas.Ciclista;
import entidades.salidadatos.SalidaDatos;
import entidades.tiempo.Reloj;

public class Manager {

	private List<ObjetosQueSeEjecutan> listaejecutables;
	private SalidaDatos salidadatos;
	private Ciclista ciclista;
	private Bicicleta bicicleta;
	private Reloj reloj;
	
	public void iniciar() {
		reloj = new Reloj();
		bicicleta = new Bicicleta();
		ciclista = new Ciclista("Pepe", 0.5, bicicleta, reloj);
		
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
