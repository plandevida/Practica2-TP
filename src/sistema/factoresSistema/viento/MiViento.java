package sistema.factoresSistema.viento;

/**
 * Enumerado que representa las direcciones del viento
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public enum MiViento {
	AFAVOR(1),
	ENCONTRA(-1),
	LATERAL(0),
	NULO(0),
	DESCONOCIDO(0);
	
	// factor que se usa para determinar la dirección de la velocidad del viento
	int factor;
	
	MiViento(int factorViento) {
		factor = factorViento;
	}
	
	public int getFactor() {
		return factor;
	}
}
