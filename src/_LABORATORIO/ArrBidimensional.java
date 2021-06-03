package _LABORATORIO;

import java.util.Scanner;

public class ArrBidimensional {

	public static void main(String[] args) {
		interes();
	}

	static void matrizManual() {
		int[][] matriz = { { 2, 5, 3 }, { 1, 1 } };

		// int[][] matriz = new int[2][3];
		//
		// matriz[0][0] = 2;
		// matriz[0][1] = 5;
		// matriz[0][2] = 3;
		//
		// matriz[1][0] = 1;
		// matriz[1][1] = 1;
		// matriz[1][2] = 4;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void matrizForeach() {
		int[][] matriz = { { 2, 3, 6 }, { 3, 5, 7 } };

		for (int[] fila : matriz) {
			for (int z : fila) {
				System.out.print(z + " ");
			}
			System.out.println();
		}

	}

	static void matriz() {
		final int FILAS = 1, COLUMNAS = 3;
		int[][] matriz = new int[FILAS][COLUMNAS];
		Scanner entrada = new Scanner(System.in);

		// for tradicional
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.print("Ingrese el numero para la matriz en la posicion [" + i + "][" + j + "]: ");
				matriz[i][j] = entrada.nextInt();

			}
		}

		System.out.println("\nImprimiendo matriz...");

		for (int i = 0; i < matriz.length; i++) { // Numero de filas
			for (int j = 0; j < matriz[i].length; j++) { // Numero de columnas de cada fila
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		/*
		 * En este ejemplo se han utilizado dos formas distintas para recorrer la
		 * matriz: - Utilizando en el for el n�mero de filas y columnas - Utilizando
		 * en el for el atributo length
		 * 
		 * Para recorrer arrays irregulares como el siguiente: int[][] matriz =
		 * {{6,7,5,0,4}, {3, 8, 4}, {1,0,2,7}, {9,5}};
		 * 
		 * Usaremos siempre length para obtener el numero de columnas que tiene cada
		 * fila:
		 * 
		 * for (i = 0; i < a.length; i++) { // Numero de filas for (j = 0; j <
		 * a[i].length; j++) { // Numero de columnas de cada fila
		 * System.out.print(a[i][j] + " "); } System.out.println(); }
		 */
	}

	static void interes() {

		double acumulado;
		double interes = 0.10;

		double[][] saldo = new double[6][5];

		for (int i = 0; i < saldo.length; i++) {
			saldo[i][0] = 10000;
			acumulado = 10000;
			for (int j = 1; j < saldo[i].length; j++) {
				acumulado += acumulado * interes;
				saldo[i][j] = acumulado;
			}

			interes += 0.01;
		}

		for (int i = 0; i < saldo.length; i++) {
			for (int j = 0; j < saldo[i].length; j++) {
				System.out.printf("%1.2f", saldo[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}
