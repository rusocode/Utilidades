package _LABORATORIO;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BusquedaLineal {

	/* Algoritmo facil de programar pero con poca eficiencia. El algoritmo de busqueda lineal busca por cada elemento de un
	 * arreglo en forma secuencial. Si la clave de busqueda no coincide evalua el siguiente y asi hasta el final del
	 * arreglo. */
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int clave, posicion;

		// Crea el arreglo y lo muestra
		ArregloLineal arregloLineal = new ArregloLineal(10);
		System.out.println(arregloLineal);

		System.out.print("Ingrese un valor entero (-1 para terminar): ");
		clave = entrada.nextInt();

		// Mientras la clave sea distinta a -1, entonces...
		while (clave != -1) {
			posicion = arregloLineal.busquedaLineal(clave);
			if (posicion == -1) System.out.println("El entero " + clave + " no se encontro.");
			else System.out.println("El entero " + clave + " se encontro en la posicion " + posicion);

			System.out.print("Ingrese un valor entero (-1 para terminar): ");
			clave = entrada.nextInt();

		}

	}

}

class ArregloLineal {

	private int[] datos;
	private static Random generador = new Random();

	public ArregloLineal(int n) {
		datos = new int[n];

		for (int i = 0; i < datos.length; i++)
			datos[i] = generador.nextInt(100);

	}

	public int busquedaLineal(int clave) {
		// Itera a traves del arreglo de forma secuencial
		for (int i = 0; i < datos.length; i++)
			if (datos[i] == clave) return i; // Devuelve el indice del entero

		return -1; // No se encontro el entero
	}

	@Override
	public String toString() {
		return "datos=" + Arrays.toString(datos);
	}

}
