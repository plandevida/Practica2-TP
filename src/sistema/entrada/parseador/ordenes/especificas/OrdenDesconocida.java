package sistema.entrada.parseador.ordenes.especificas;

import sistema.entrada.parseador.lexer.Comandos;
import sistema.entrada.parseador.ordenes.Orden;

public class OrdenDesconocida extends Orden {

	@Override
	public Comandos getComando() {
		return comand;
	}

}
