package sistema.entrada.ordenes.especificas;

import sistema.entidades.personas.ciclistas.Ciclista;
import sistema.entrada.ordenes.Orden;

public class OrdenFrenar extends Orden{
	
	private Ciclista ciclista;
	
	public OrdenFrenar(){
	
	}

	@Override
	public void ejecutarOrden() {
		ciclista.frenar();
	}

}
