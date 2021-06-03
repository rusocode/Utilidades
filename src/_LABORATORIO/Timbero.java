package _LABORATORIO;

import java.util.Scanner;

public class Timbero {

	private int mi_oro = 4000;

	private final int APUESTA_MINIMA = 10;
	private final int APUESTA_MAXIMA = 5000;
	private final int PROBABILIDAD = 47; // 47% de probabilidades en ganar oro

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Timbero t = new Timbero();
		int op = 0;

		System.out.println("Oro: " + t.getOro());

		do {
			System.out.print("Apostar 1 (si) - 0 (no): ");
			op = new Scanner(System.in).nextInt();

			if (op == 1) {
				System.out.print("/APOSTAR ");
				t.apostar(new Scanner(System.in).nextInt());
			} else if (op == 0) {
				System.out.println("Hasta luego!");
				break;
			} else
				System.out.println("Opcion incorrecta!");

		} while (op != 0);

	}

	private void apostar(int cant) {
		if (cant < APUESTA_MINIMA) {
			System.out.println("El minimo de apuesta es " + APUESTA_MINIMA + " monedas.");
			return;
		}
		if (cant > APUESTA_MAXIMA) {
			System.out.println("El maximo de apuesta es " + APUESTA_MAXIMA + " monedas.");
			return;
		}
		if (cant > mi_oro) {
			System.out.println("No tienes esa cantidad.");
			return;
		}
		if (azar(1, 100) <= PROBABILIDAD) {
			agregarOro(cant);
			System.out.println("Felicidades! Has ganado " + cant + " monedas de oro!");
		} else {
			quitarOro(cant);
			System.out.println("Lo siento, has perdido " + cant + " monedas de oro.");
		}

		System.out.println("Oro: " + getOro());

	}

	// Devuelve un numero entero aleatorio entre un minimo y un mayor especificado
	// (1 y 100 en este caso)
	private int azar(int min, int max) {
		return (int) ((Math.random() * (max - min + 1)) + min);
	}

	private void agregarOro(int cant) {
		this.mi_oro += cant;
	}

	private void quitarOro(int cant) {
		this.mi_oro -= cant;
	}

	private int getOro() {
		return this.mi_oro;
	}

}
