package _LABORATORIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraBasica {
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		calcular();
	}

	private static void calcular() throws InputMismatchException {

		final char suma = '+', resta = '-', division = '/', producto = '*';
		char signo;
		double n1 = 0, n2 = 0, total = 0;

		try {
			do {

				System.out.print("\nIngrese el primer numero o -1 para salir: ");
				n1 = entrada.nextDouble();
				if (n1 == -1) break;
				System.out.print("Ingrese el segundo numero o -1 para salir: ");
				n2 = entrada.nextDouble();
				if (n2 == -1) break;

				do {

					System.out.print("\nSuma + | Resta - | Division / | Producto * | Salir S\nIngrese un signo: ");
					signo = entrada.next().charAt(0);

					switch (signo) {
					case suma:
						total = n1 + n2;
						break;
					case resta:
						total = n1 - n2;
						break;
					case division:
						total = n1 / n2;
						break;
					case producto:
						total = n1 * n2;
						break;
					case 'S':
						System.out.println("Salio.");
						break;
					case 's':
						System.out.println("Salio.");
						break;
					default:
						System.out.println("Signo incorrecto.");
						break;
					}

					if (signo == '+' || signo == '-' || signo == '/' || signo == '*') System.out.println("Total: " + total);

				} while (signo != 'S' && signo != 's');

			} while (n1 != -1 && n2 != -1);

			System.out.println("Salio.");

		} catch (InputMismatchException e) {
			System.out.println("El numero no coincide con el patron para el tipo esperado, o el numero esta fuera del rango para el tipo esperado.");
		}

	}

}
