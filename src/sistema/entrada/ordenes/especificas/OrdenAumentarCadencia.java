package sistema.entrada.ordenes.especificas;

import sistema.entrada.ordenes.Orden;
import sistema.entidades.personas.ciclistas.Ciclista;

public class OrdenAumentarCadencia extends Orden {
	
	private Ciclista ciclista;
	private int aumentocadencia;
	
	public OrdenAumentarCadencia() {
		aumentocadencia = 0;
	}
	
	@Override
	public void ejecutarOrden() {
		ciclista.setCadencia(aumentocadencia);
	}
}
