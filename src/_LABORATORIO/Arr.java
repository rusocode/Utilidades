package _LABORATORIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arr {

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		int l = 0;

		try {
			System.out.print("Size: ");
			l = entrada.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Error, la entrada recuperada no coincide con el patron para el tipo esperado.");
		}

		/*
		 * Crea un Array de enteros aleatorios entre 1 y 100, con una capacidad de l
		 * elementos para alamacenarlos en la memoria STACK. Si l es menor o igual a 0 o
		 * mayor a 50 entonces por defecto se inicializa en 4.
		 */
		int[] arr = initArr(l <= 0 || l > 50 ? 4 : l);

		System.out.println(toString(arr, 0));

		sortAsc(arr);
//		sortDesc(arr);
//		mayor(arr);
		menor(arr);
//		promedio(arr);
//		pares(arr);
//		impares(arr);
//		desordenar(arr);
//		contador(arr);
	}

	private static int[] initArr(int l) {

		int arr[] = new int[l];

		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) (Math.random() * 100 + 1);

		return arr;
	}

	private static void sortAsc(int[] arr) {
		System.out.println("ordenando de manera ascendente...");
		int aux = 0;
		/*
		 * El primer for controla las pasadas y el segundo el intercambio. Si arr es el
		 * array a ordenar, se realizan arr.length-1 pasadas. Si la variable i es la que
		 * cuenta el numero de pasadas, en cada pasada i se comprueban los elementos
		 * adyacentes desde el primero hasta arr.length-i-1 ya que el resto hasta el
		 * final del array estan ordenados. Si los elementos adyacentes estan
		 * desordenados se intercambian. El tiempo de ejecucion del algoritmo de la
		 * burbuja es del orden O(n2). Es uno de los peores algoritmos de ordenacion en
		 * cuanto a tiempo de ejecucion, solamente es recomendable su uso para ordenar
		 * listas con un numero pequeño de elementos.
		 */
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					aux = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = aux;
				}

			}
		}

		// Otro forma de ordenar el vector
		// Arrays.sort(n);

		System.out.println(toString(arr, 0));

	}

	private static void sortDesc(int[] arr) {
		System.out.println("ordenando de manera descendente...");
		int aux = 0;
		for (int i = 0; i < arr.length - 1; i++) { // Se itera hasta arr.length - 1 para evitar que el array se salga de
													// los limites
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] < arr[j + 1]) {
					aux = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = aux;
				}
			}
		}

		System.out.println(toString(arr, 0));

	}

	private static void mayor(int[] arr) {
		int mayor = 0;

		for (int i = 0; i < arr.length; i++)
			if (mayor < arr[i])
				mayor = arr[i];

		System.out.println("El mayor es: " + mayor);
	}

	private static void menor(int[] arr) {
		int menor = arr[0];

		for (int i = 0; i < arr.length; i++)
			if (menor > arr[i])
				menor = arr[i];

		System.out.println("El menor es: " + menor);

	}

	private static void promedio(int[] arr) {
		int suma = 0;
		for (int i = 0; i < arr.length; i++)
			suma += arr[i];

		System.out.println("Promedio: " + (suma / arr.length));
	}

	private static void pares(int[] arr) {
		System.out.print("Pares:");
		for (int i = 0; i < arr.length; i++)
			if (arr[i] % 2 == 0)
				System.out.print(" " + arr[i]);

		System.out.println();

	}

	private static void impares(int[] arr) {
		System.out.print("Impares:");
		for (int i = 0; i < arr.length; i++)
			if (arr[i] % 2 == 1)
				System.out.print(" " + arr[i]);

	}

	private static void desordenar(int[] arr) {
		System.out.println("\ndesordenando...");

		int posicionAleatoria = 0, posicionActual = 0;

		for (int i = 0; i < arr.length; i++) {
			// Asigna el indice aleatorio
			posicionAleatoria = (int) (Math.random() * arr.length); /* posicionAleatoria = r.nextInt(n.length); */
			// Asigna el indice actual (variable temporal)
			posicionActual = arr[i];

			// SWAPPING
			// Intercambia el valor de la posicion actual por el valor de la posicion
			// aleatoria
			arr[i] = arr[posicionAleatoria];
			// Intercambia el valor de la posicion aleatoria por el valor de la posicion
			// actual
			arr[posicionAleatoria] = posicionActual;

		}

		System.out.println(toString(arr, 0));

	}

	private static void contador(int[] arr) {
		int c = 0, numero = 0;
		do {
			System.out.print("\nNumero que desea contar (-1 salir): ");
			numero = entrada.nextInt();
			if (numero != -1) {
				for (int i = 0; i < arr.length; i++)
					if (arr[i] == numero)
						c++;
				System.out.println("El " + numero + " se repite " + c + " veces.");
				c = 0;
			}

		} while (numero != -1);

	}

	private static String toString(int arr[], int i) {
		return i < arr.length
				? (i == 0 ? "Array: [" : "") + arr[i] + (i == arr.length - 1 ? "]" : ",") + toString(arr, i + 1)
				: "";
	}

}
