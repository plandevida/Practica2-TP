package sistema.entrada.ordenes.especificas;

import sistema.entrada.ordenes.Orden;
import sistema.entidades.personas.ciclistas.Ciclista;

public class OrdenBajarPlato extends Orden{
	
	private Ciclista ciclista;
	
	public OrdenBajarPlato() {
		
	}

	@Override
	public void ejecutarOrden() {
		ciclista.disminuirPlato();
	}
}
