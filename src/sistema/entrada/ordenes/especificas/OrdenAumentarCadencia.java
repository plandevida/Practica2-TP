package sistema.entrada.ordenes.especificas;

import sistema.entrada.ordenes.OrdenParaCiclista;

public class OrdenAumentarCadencia extends OrdenParaCiclista {
	
	private int aumentocadencia;
	
	public OrdenAumentarCadencia() {
		aumentocadencia = 0;
	}
	
	@Override
	public void ejecutarOrden() {
		getCiclista().setCadencia(aumentocadencia);
	}
}
