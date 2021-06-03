package genericos;

import java.io.File;
import java.util.ArrayList;

public class UsoArrayList2 {

	public static void main(String[] args) {

		ArrayList2 o = new ArrayList2(4);

		o.add("Juan");

		o.add("Jose");

		o.add("Jjik");

		o.add(new File("texto.txt"));

		String nombre = (String) o.get(0); // Ineficiencia-> Uso continuo del casting

		// No marca el error en tiempo de compilacion
		// String nombreArchivo = (String) o.get(3); // Errores en tiempo de ejecucion-> Dificil encontrar errores

		// ---

		/* Para que esto no suceda, java implementa en su API la PROGRAMACION GENERICA. La clase ArrayList<E> es un ejemplo de
		 * la programacion generica y "en esta ocasion", va a manejar datos de tipo String, con lo cual nos marcaria un error en
		 * tiempo de compilacion si pretendemos manejar otro tipo de datos. */

		ArrayList<String> nombres = new ArrayList<String>();

		// nombres.add(new File("texto.txt")); // Error en tiempo de compilacion = VENTAJA

	}

}
