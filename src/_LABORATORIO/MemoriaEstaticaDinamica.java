package _LABORATORIO;

public class MemoriaEstaticaDinamica {

	public static void main(String[] args) {

		// Memoria dinamica (diferentes espacios logicos de memoria)
		Dinamico d = new Dinamico(5);
		d.var_dinamica += 25;
		System.out.println("var_dinamica de p: " + d.var_dinamica);

		Dinamico d2 = new Dinamico();
		// System.out.println (â€œsysoutâ€� and Ctrl + Space)
		System.out.println("var_dinamica de p2: " + ++d2.var_dinamica + " (usando el operador de preincremento)");
		System.out.println("var_dinamica de p2: " + d2.var_dinamica++ + " (usando el operador de posincremento)");
		System.out.println("var_dinamica de p2 despues de postincrementar su valor en 1: " + d2.var_dinamica);

		System.out.println("var_dinamica de p: " + d.var_dinamica + " *Su valor no cambia despues de modificarlo desde otro objeto.");

		// Memoria estatica (valor fijo con la misma direccion de memoria *rapido acceso)
		Estatico e = new Estatico();
		Estatico e2 = new Estatico();
		Estatico e3 = new Estatico();

		/* Para los atributos estaticos no hace falta instaciar al objeto de la clase estatica, por eso me lo subraya como
		 * innecesario. */
		e.var_estatica = 4;
		System.out.println("var_estatica de e: " + e.var_estatica); // 4

		e2.var_estatica++;
		System.out.println("var_estatica de e2: " + e2.var_estatica); // 5
		System.out.println("var_estatica de e: " + e.var_estatica); // 5
		System.out.println("var_estatica despues de preincrementar su valor en 1: " + ++Estatico.var_estatica);
		System.out.println("var_estatica de e2: " + e2.var_estatica); // 6

		e3.var_estatica = 500;

		System.out.println("var_estatica de e: " + e.var_estatica); // 500

	}

}

class Dinamico {

	int var_dinamica = 5;

	// Constructor sin parametros
	public Dinamico() {
	}

	// Constructor con un parametro
	public Dinamico(int var_dinamica) {
		this.var_dinamica = var_dinamica;
	}

}

class Estatico {

	/* La variable var_estatica es estatica, por lo tanto comparte la misma ubicacion de memoria para todos los objetos que
	 * instancian de la clase Estatico. */

	static int var_estatica;

	public Estatico() {
	}

}
