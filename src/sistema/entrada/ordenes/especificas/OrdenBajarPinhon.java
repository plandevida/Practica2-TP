package sistema.entrada.ordenes.especificas;

import sistema.entrada.ordenes.Orden;
import sistema.entidades.personas.ciclistas.Ciclista;

public class OrdenBajarPinhon extends Orden{
	
	private Ciclista ciclista;

	@Override
	public void ejecutarOrden() {
		ciclista.aumentarPinhon();
	}
}
