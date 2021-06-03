package _LABORATORIO;

public class Recursividad {

	public static void main(String[] args) {

//		int n = 4;
//		int res = sumaRecursiva(n);
//		System.out.println(res);

		infinite();

	}

	private static void infinite() {
		System.out.println("...");
		infinite();
	}

	private static int sumaRecursiva(int n) {
		int res;

		System.out.println("n = " + n);

		/* Cuando llega al caso base (n == 1) la suma recursiva empieza a sumar los metodos pendientes, entonces vuelve hacia
		 * atras hasta terminar la recursividad pendiente. */

		if (n == 1) return 1;
		else res = n + sumaRecursiva(n - 1);

		return res;
	}

	private static int factorial(int n) {
		int res;

		if (n == 1) return 1; // Cuando llega al 1, ese 1 se lo va a devolver al 2 y ese 2 al 3, etc...
		else res = n * factorial(n - 1); /* El factorial de 5 aunque llama a factorial() se queda esperando en memoria hasta que el 4! termine, como
											 * una baraja de cartas */

		return res;

	}

}
