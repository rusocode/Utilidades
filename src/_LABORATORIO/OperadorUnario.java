package _LABORATORIO;

// https://parasitovirtual.wordpress.com/2010/09/29/operadores-de-asignacion-aritmeticos-y-unarios-en-java/

public class OperadorUnario {

	/* Los operadores unarios solo requieren un operando y realizan varias tareas, entre ellas incrementar/disminuir un
	 * valor en uno, negar una expresion o invertir el valor de un booleano.
	 * 
	 * El operador + indica un valor positivo, el operador – indica un valor negativo, el operador ++ incrementa en uno, el
	 * operador — decrementa en uno y el operador ! invierte el valor de un booleano, es decir si el valor es true lo
	 * convierte a false, y al contrario.
	 * 
	 * El operador de decremento/incremento se puede utilizar como sufijo o prefijo, pero hay que tener en cuenta como se
	 * evaluan. Si se utiliza el operador como prefijo primero se incrementa/decrementa y luego se utiliza el valor, si se
	 * utiliza como sufijo primero se utiliza su valor y después se decrementa. */

	public static void main(String[] args) {

		int x = 0;

		// Operador unario de incremento (prefijo y sufijo)
		System.out.println("x = " + x);
		System.out.println("x = " + x++); // Imprime la variable x y postincrementa su valor en 1
		System.out.println("x = " + x); // 1
		System.out.println("x = " + ++x); // Preincrementa el valor de x en 1 y lo imprime

		boolean bandera = false;

		System.out.println(!bandera); // Invierte su valor a true

	}

}
