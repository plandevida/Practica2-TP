package entidades.salidadatos;

import interfaces.ObjetosConSalidaDeDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SalidaDatos {

	private List<ObjetosConSalidaDeDatos> registroobjetossalidadatos;

	public void registrarObjetoConSalidaDatos(
			ObjetosConSalidaDeDatos objetoconsalidadatos) {

		if (registroobjetossalidadatos == null) {
			registroobjetossalidadatos = new ArrayList<ObjetosConSalidaDeDatos>();
		}

		registroobjetossalidadatos.add(objetoconsalidadatos);
	}

	public void mostrarDatos() {

		if (registroobjetossalidadatos != null) {

			for (ObjetosConSalidaDeDatos objetoamostrar : registroobjetossalidadatos) {

				int numerodetokens = objetoamostrar.mostrarDatos()
						.countTokens();
				System.out.println(numerodetokens);
				StringTokenizer mensaje = objetoamostrar.mostrarDatos();

				switch (numerodetokens) {

				// Caso para el formato de la bicicleta
				case 1:
					System.out.println("-- Bicicleta --");
					System.out.println("velocidad: " + mensaje.nextElement());
					break;

				// Caso para el formato del ciclista
				case 3:
					System.out.println("-- Ciclista --");
					System.out.println("nombre: " + mensaje.nextElement());
					System.out.println("peso: " + mensaje.nextElement());
					System.out.println("cansancio: " + mensaje.nextElement());
					break;

				// Caso para el formato reloj
				case 4:
					System.out.println("-- Reloj --");

					StringBuilder formato = new StringBuilder(
							(String) mensaje.nextElement()).append("h ")
							.append((String) mensaje.nextElement())
							.append("m ")
							.append((String) mensaje.nextElement())
							.append("s ")
							.append((String) mensaje.nextElement())
							.append(" impulsos");

					System.out.println(formato.toString());
					break;

				default:
					while (mensaje.hasMoreElements())
						System.out.println(mensaje.nextElement());
					;
					break;
				}

			}
		}
	}
}
