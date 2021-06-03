package colecciones.set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Esta implementacion almacena los elementos en funcion del orden de insercion. Es, simplemente, un poco mas costosa
 * que HashSet.
 */

public class LinkedHashSet_ {

	public static void main(String[] args) {

		final Set linkedHashSet = new LinkedHashSet(1_000_000);

		final long inicio = System.currentTimeMillis();
		for (int i = 0; i < 1_000_000; i++)
			linkedHashSet.add(i);
		final long fin = System.currentTimeMillis();

		System.out.println("Tiempo empleado por LinkedHashSet: " + (fin - inicio));

		/* En conclusion, las mas rapidas en orden descendente:
		 * HashSet
		 * LinkedHashSet
		 * TreeSet */

	}

}
