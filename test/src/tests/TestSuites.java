package src.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import src.tests.sistema.entidades.personas.ciclistas.TestCiclista;

@RunWith(Suite.class)
@SuiteClasses({ TestCiclista.class })
public class TestSuites {

}
