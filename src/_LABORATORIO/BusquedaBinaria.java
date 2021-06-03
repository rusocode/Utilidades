package _LABORATORIO;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BusquedaBinaria {

	/* El algoritmo de busqueda binaria es mas eficiente que la busqueda lineal, pero requiere que el arreglo se ordene. La
	 * primera iteracion evalua el elemento medio del arreglo. */

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int clave, posicion;

		PruebaBusquedaBinaria arregloBinario = new PruebaBusquedaBinaria(15);
		System.out.println(arregloBinario);

		System.out.print("Ingrese un valor entero (-1 para terminar): ");
		clave = entrada.nextInt();

		// Mientras la clave sea distinta a -1, entonces...
		while (clave != -1) {
			posicion = arregloBinario.busquedaBinaria(clave);
			if (posicion == -1) System.out.println("El entero " + clave + " no se encontro.");
			else System.out.println("El entero " + clave + " se encontro en la posicion " + posicion);

			System.out.print("Ingrese un valor entero (-1 para terminar): ");
			clave = entrada.nextInt();

		}

	}

}

class PruebaBusquedaBinaria {
	private int[] datos;
	private static Random generador = new Random();

	public PruebaBusquedaBinaria(int n) {
		datos = new int[n];

		for (int i = 0; i < n; i++)
			datos[i] = generador.nextInt(100);

		Arrays.sort(datos);

	}

	public int busquedaBinaria(int clave) {
		int inferior = 0;
		int superior = datos.length - 1;
		int medio = (inferior + superior + 1) / 2;
		int posicion = -1;

		do {

			// Imprime el resto de los elementos del arreglo
			System.out.println(elementosRestantes(inferior, superior));

			// Imprime espacios para alineacion
			for (int i = 0; i < medio; i++)
				System.out.print("	");

			System.out.println(" * "); // Indica el elemento medio actual

			// Si el elemento se encuentra en medio
			if (clave == datos[medio]) posicion = medio; // La ubicacion es el elemento medio actual
			// El elemento medio es demasiado alto
			else if (clave < datos[medio]) superior = medio - 1; // Elimina la mitad superior y el valor medio actual
			// El elemento medio es demasiado bajo
			else inferior = medio + 1; // Elimina la mitad inferior y el valor medio actual

			medio = (inferior + superior + 1) / 2; // Recalcula el elemento medio

		} while ((inferior <= superior) && (posicion == -1));

		return posicion;
	}

	public String elementosRestantes(int inferior, int superior) {
		StringBuilder temp = new StringBuilder();

		// Imprime espacios para alineacion
		for (int i = 0; i < inferior; i++)
			temp.append("	");

		// Imprime los elementos que quedan en el arreglo
		for (int i = inferior; i <= superior; i++)
			temp.append(datos[i] + " ");

		temp.append("/n");

		return temp.toString();
	}

	@Override
	public String toString() {
		return elementosRestantes(0, datos.length - 1);
	}

}
