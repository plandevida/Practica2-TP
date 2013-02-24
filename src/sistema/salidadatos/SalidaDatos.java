package sistema.salidadatos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import sistema.interfaces.ObjetosConSalidaDeDatos;

/**
 * Clase que muestra la información formateada de cada
 * elemento registrado en esta.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 */
public class SalidaDatos {

	/**
	 *  Lista de objetos que se van a mostrar
	 */
	private List<ObjetosConSalidaDeDatos> registroobjetossalidadatos;

	/**
	 * Contruye la calase con un registro vacío de elementos.
	 */
	public SalidaDatos() {
		registroobjetossalidadatos = new ArrayList<ObjetosConSalidaDeDatos>();
	}
	
	/**
	 * Registra un objeto para ser mostrada su salida.
	 * 
	 * @param objetoconsalidadatos Objeto a reistrar.
	 */
	public void registrarObjetoConSalidaDatos(ObjetosConSalidaDeDatos objetoconsalidadatos) {

		registroobjetossalidadatos.add(objetoconsalidadatos);
	}
	
	/**
	 * Registra todos los elementos de una colección.
	 * 
	 * @param listadeobjetosconsalidadatos
	 */
	public void registrarObjetoConSalidaDatos(Collection<ObjetosConSalidaDeDatos> listadeobjetosconsalidadatos) {
		
		for (ObjetosConSalidaDeDatos objetoaregistrar : listadeobjetosconsalidadatos) {
			registroobjetossalidadatos.add(objetoaregistrar);
		}
	}

	/**
	 * Muestra la salida de datos personalizada para cada tipo de elemento.
	 */
	public void mostrarDatos() {

		if (registroobjetossalidadatos != null) {

			for (ObjetosConSalidaDeDatos objetoamostrar : registroobjetossalidadatos) {

				int numerodetokens = objetoamostrar.mostrarDatos().countTokens();
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
					
					break;
				}

			}
		}
	}
}
