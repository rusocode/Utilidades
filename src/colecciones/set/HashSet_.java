package colecciones.set;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Este implementacion almacena los elementos en una tabla hash. Es la implementacion con mejor rendimiento de
 * todas pero no garantiza ningun orden a la hora de realizar iteraciones. Es la implementacion mas empleada debido a su
 * rendimiento y a que, generalmente, no nos importa el orden que ocupen los elementos. Esta implementacion proporciona
 * tiempos constantes en las operaciones basicas siempre y cuando la funcion hash disperse de forma correcta los
 * elementos dentro de la tabla hash. Es importante definir el tamaño inicial de la tabla ya que este tamaño marcara el
 * rendimiento de esta implementacion.
 * 
 * Ventajas
 * >Es el Set mas rapido.
 * Desventajas
 * >
 * 
 */

public class HashSet_ {

	public static void main(String[] args) {

		Set hashSet = new HashSet();

		hashSet.add('B');
		hashSet.add('C');
		hashSet.add('A');
		hashSet.add(2);
		hashSet.add(2);

//		final long inicio = System.currentTimeMillis();
//		for (int i = 0; i < 100; i++)
//			hashSet.add(i);
//		final long fin = System.currentTimeMillis();
//
//		System.out.println("Tiempo empleado por HashSet: " + (fin - inicio));

		// FIXME Los ordena wtf
		System.out.println(hashSet.toString());

		Iterator<Character> i = hashSet.iterator();

		/* Los iteradores devueltos por el metodo de iterador de esta clase son rapidos: si el conjunto se modifica en cualquier
		 * momento despues de que se crea el iterador, de cualquier forma, excepto a traves del metodo de eliminacion del
		 * iterador, el iterador arroja una ConcurrentModificationException. */
		// hashSet.add('D');

		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
