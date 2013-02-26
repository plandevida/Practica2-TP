package sistema.entrada.ordenes.especificas;

import sistema.entrada.ordenes.OrdenParaCiclista;

public class OrdenBajarPlato extends OrdenParaCiclista {
	
	public OrdenBajarPlato() {
		
	}

	@Override
	public void ejecutarOrden() {
		getCiclista().disminuirPlato();
	}
}
