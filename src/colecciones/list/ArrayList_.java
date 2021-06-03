package colecciones.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Esta es la implementacion tipica. Los ArrayList solo almacenan objetos en la memoria HEAP, nunca pueden almacenar
 * datos de tipo primitivo. Son colecciones dinamicas, es decir que su tamaño aumenta automaticamente cuando se agrega
 * un elemento y se reduce cuando se elimina uno (redimensionables). Es la que mejor rendimiento tiene sobre la mayoria
 * de situaciones.
 */

public class ArrayList_ {

	public static void main(String[] args) {

		Integer[] n = { 5, 44, 0, -2 };

		convertArrayToArrayList(n);

		System.out.println();

		// ---

		ArrayList<Integer> numeros = new ArrayList<Integer>();

		numeros.add(5);
		numeros.add(6);
		numeros.add(444);
		numeros.add(985);

		// Si no se agregan mas elementos entonces recorta el espacio sobrante de la memoria vacia en el ArrayList
		// numeros.trimToSize();

		// Con un for-each castea el objeto Integer a tipo int y alamcena todos sus elementos en la variable i
		for (int i : numeros)
			System.out.print(i + " ");

		System.out.println();

		for (int i = 0; i < numeros.size(); i++)
			System.out.print(numeros.get(i) + " ");

		// Convierte el ArrayList a un Array convencional
		Integer[] e = new Integer[numeros.size()];

		numeros.toArray(e);

		for (int i = 0; i < e.length; i++)
			System.out.print(e[i] + " ");

	}

	private static void convertArrayToArrayList(Integer[] n) throws UnsupportedOperationException {

		List<Integer> lista_convertida, lista_nueva; // final: Se asegura de que nadie reasigne su lista una vez que haya recibido su valor

		/* La lista devuelta desde asList tiene un tamaño fijo, por lo tanto si desea agregar o eliminar elementos de la lista
		 * devuelta en su codigo, debera envolverlo en un nuevo ArrayList. De lo contrario, obtendra una
		 * UnsupportedOperationException. */
		lista_convertida = Arrays.asList(n); // Transforma el array de enteros a una lista

		for (int i = 0; i < lista_convertida.size(); i++)
			System.out.print(lista_convertida.get(i) + " ");

		System.out.println();

		try {
			lista_convertida.add(786);
		} catch (UnsupportedOperationException e) {
			System.err.print("\nLa lista devuelta desde asList tiene un tamaño fijo, por lo tanto no se pueden agregar mas elementos.");
		}

		// Envuelve la lista convertida con la nueva lista para evitar errores de insercion
		lista_nueva = new ArrayList<>(lista_convertida);

		lista_nueva.add(577);

		for (int i = 0; i < lista_nueva.size(); i++)
			System.out.print(lista_nueva.get(i) + " ");

	}

}
