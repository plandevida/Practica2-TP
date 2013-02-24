package src.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import sistema.entidades.bicicletas.Bicicleta;
import sistema.entidades.personas.ciclistas.Ciclista;
import sistema.entidades.tiempo.Reloj;
import src.tests.utils.TestUtilidadesBicicleta;

@RunWith(JUnit4.class)
public class TestCiclista {
	
	private Ciclista ciclista;
	
	private String nombreciclista = "Juan";
	private int numeromallot = 1;
	private double cadenciaciclista = 1.0d;
	private Bicicleta bicicletaciclista;
	private Reloj relojciclista;
	
	private TestUtilidadesBicicleta utilidadesBicicleta;
	
	@Before
	public void run() {
		
		utilidadesBicicleta = new TestUtilidadesBicicleta();
		
		relojciclista = new Reloj();
		
		bicicletaciclista = new Bicicleta();
		
		ciclista = new Ciclista(nombreciclista, numeromallot, cadenciaciclista, bicicletaciclista, relojciclista);
	}
	
	@Test
	public void testNoNulos() {
		
		// Comprobamos que las propiedades no sean nulas
		assertNotNull("Error: El ciclista es nulo", ciclista);
		assertNotNull("Error: El nombre es nulo", ciclista.getNombre());
		assertNotNull("Error: La cadencia es nula", ciclista.getCadencia());
		assertNotNull("Error: La bicicleta es nula", ciclista.getBicicletamontada());
		assertNotNull("Error: El ciclista no tiene reloj", ciclista.getReloj());
	}
	
	@Test
	public void testResultadosEsperados() {
		
		// Comprobamos que los resultados son los esperados
		
		// Incremento de la velocidad de la bicicleta al pedalear
		
		Bicicleta bicicleta = ciclista.getBicicletamontada();
		
		ciclista.ejecutar();
		
		double velocidadesperada = utilidadesBicicleta.velocidadDeBici(ciclista.getCadencia(), 
																	bicicleta.getRadiorueda(), 
																	bicicleta.getPlatos()[bicicleta.getPlatoactual()], 
																	bicicleta.getPinhones()[bicicleta.getPinhonactual()]);
		
		assertEquals("Error: La velocidad de la bicicleta no es la correcta", velocidadesperada, bicicleta.getVelocidad(), 0);
	}
}
