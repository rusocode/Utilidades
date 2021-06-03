package _LABORATORIO;

import java.util.ArrayList;

/**
 * Los numeros primos son aquellos numeros naturales que solamente se pueden dividir por si mismos y por 1, es decir,
 * que si intentamos dividirlos por cualquier otro numero, el resultado no es entero.
 * El numero 1 solo tiene un divisor, por eso no lo consideramos primo.
 */

public class Primo {

	private int n;

	public Primo() {
	}

	public Primo(int n) {
		this.n = n;
	}

	int getNumero() {
		return n;
	}

	boolean isPrime() {
		int divisor = 0;
		for (int j = 1; j <= n; j++)
			if ((n % j) == 0) divisor++;
		return divisor == 2 ? true : false;
	}

	/**
	 * Busca un numero primo en un rango especificado de numeros.
	 * 
	 * @param min - Numero minimo en el rango.
	 * @param max - Numero maximo en el rango.
	 * 
	 */
	void buscarPrimosEnRango(int min, int max) {

		// FIXME Lo reemplazo por un array de ints?
		ArrayList<Integer> primos = new ArrayList<Integer>();

		int divisor = 0;
		int auxMin = min;

		// Mientras no llegue al rango maximo, entonces...
		while (min <= max) {

			// Calcula cuantos divisores tiene el numero
			for (int j = 1; j <= min; j++)
				if ((min % j) == 0) divisor++;

			// Si el numero solo tiene dos divisores, entonces es un primo!
			if (divisor == 2) primos.add(min);

			divisor = 0;

			// Pasa al otro numero
			min++;

		}

		System.out.print("Los numeros primos que van del " + auxMin + " al " + max + " son: " + primos.toString());

	}

	public static void main(String[] args) {

		Primo p = new Primo(17);

		// p.buscarPrimosEnRango(2, 19);

		if (p.isPrime()) System.out.println("El numero " + p.getNumero() + " es primo!");
		else System.out.println("El numero " + p.getNumero() + " no es primo!");

	}

}
