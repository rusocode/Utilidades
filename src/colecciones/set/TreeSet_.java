package colecciones.set;

import java.util.TreeSet;
import java.util.Set;

/**
 * Esta implementacion almacena los elementos ordenandolos en funcion de sus valores. Es bastante mas lento que HashSet.
 * Los elementos almacenados deben implementar la interfaz Comparable. Esta implementacion garantiza, siempre, un
 * rendimiento de log(N) en las operaciones basicas, debido a la estructura de arbol empleada para almacenar los
 * elementos.
 */

public class TreeSet_ {

	public static void main(String[] args) {

		Set treeSet = new TreeSet();

//		final long inicio = System.currentTimeMillis();
//		for (int i = 0; i < 1_000_000; i++)
//			treeSet.add(i);
//		final long fin = System.currentTimeMillis();
//		
//		System.out.println("Tiempo empleado por TreeSet: " + (fin - inicio));

		treeSet.add('B');
		treeSet.add('C');
		treeSet.add('A');
		treeSet.add(2);
		

		System.out.println(treeSet.toString());

	}

}
