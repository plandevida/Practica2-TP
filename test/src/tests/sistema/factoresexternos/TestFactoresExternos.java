package src.tests.sistema.factoresexternos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import sistema.entidades.carretera.tramocarreraciclista.TramoCiclista;
import sistema.entidades.vehiculos.bicicletas.Bicicleta;
import sistema.entrada.lectura.Lector;
import sistema.entrada.parseador.parser.ParseadorCarrera;
import sistema.manager.Manager;

@RunWith(JUnit4.class)
public class TestFactoresExternos {
	
	private Bicicleta bicicleta;
	private Map<Integer, TramoCiclista> mapa;
	
	@Before
	public void run() {
		
		Lector lectorConfiguracion = new Lector(Manager.DEFAULT_CONFIG_PATH, true);
		
		String configuracioncarreraciclista = lectorConfiguracion.cargarFicheroCompelto();
		
		mapa = new HashMap<Integer, TramoCiclista>();
		
		ParseadorCarrera parseadorcarrera = new ParseadorCarrera(mapa);
		
		parseadorcarrera.parse(configuracioncarreraciclista);
		
		bicicleta = new Bicicleta();
		
	}
	
	@Test
	public void testNoNulos() {
		
		// Comprobamos que las propiedades no sean nulas
		assertNotNull("Error: La bici es nula", bicicleta);
		assertNotNull("Error: El mapa es nulo", mapa);
		
	}
	
	@Test
	public void testResultadosEsperados() {

	}
}