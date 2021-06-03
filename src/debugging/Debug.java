package debugging;

import javax.swing.JOptionPane;

public class Debug {

	/**
	 * En java existen dos tipos de errores, los errores de sintaxis (;) y errores
	 * en tiempo de ejecucion. Los de ejecucion se dividen en IOException
	 * (controladas) y RuntimeException (no controladas).
	 * 
	 * El ID de una variable es el espacio que se le da en la memoria interna.
	 * 
	 * En el panel "Breakpoints" se pueden hacer puntos de interrupciones
	 * condicionados.
	 */

	public static void main(String[] args) {

		int elementos = Integer.parseInt(JOptionPane.showInputDialog("Elementos de matriz"));

		int[] matriz = new int[elementos];

		for (int i = 0; i < matriz.length; i++)
			matriz[i] = (int) (Math.random() * 100 + 1);

		// Ejemplo para la opcion "Step Into" de la vista debugging
		mensaje();

		for (int i : matriz)
			System.out.print(i + " ");

	}

	static void mensaje() {
		System.out.println("Esto es un mensaje...");
	}

}
