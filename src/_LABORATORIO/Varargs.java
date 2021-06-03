package _LABORATORIO;

import java.text.MessageFormat;
import java.util.Date;

// https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html
// https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html#varargs
// https://stackoverflow.com/questions/3158730/what-do-3-dots-next-to-a-parameter-type-mean-in-java
public class Varargs {

	public static void main(String[] args) {

		/* En versiones anteriores, un metodo que tomaba un numero arbitrario de valores requeria que crearas una matriz y
		 * pusieras los valores en la matriz antes de invocar el metodo. Por ejemplo, asi es como se uso la clase MessageFormat
		 * para formatear un mensaje: */
		Object[] arguments = { new Integer(7), new Date(), "rulo quemado" };

		/* Crea un MessageFormat con el patron dado y lo usa para formatear los argumentos dados.
		 * Los argumentos son cualquier tipo de objeto. */
		String result = MessageFormat.format("Patron", arguments);

		/* Dada la nueva declaracion varargs para MessageFormat.format, la invocacion anterior puede ser reemplazada por la
		 * siguiente invocacion mas corta y dulce: */
		String result2 = MessageFormat.format("Patron", 23);

		// Forma tradicional en donde se pasa un arreglo de numeros
		int[] n = { 2, 5, 4, 1 };
		// System.out.println("La suma del vector n es de: " + sumarTradicional(n));

		System.out.println("La suma del vector n es de: " + sumarVarargs(2, 5, 6));

	}

	/* Aun es cierto que se deben pasar varios argumentos en una matriz, pero la funcion varargs automatiza y oculta el
	 * proceso. Ademas, es compatible con las API preexistentes. Entonces, por ejemplo, el metodo MessageFormat.format ahora
	 * tiene esta declaracion: */
	public static String format(String pattern, Object... arguments) {
		/* Los tres puntos despues del tipo del parametro final indican que el argumento final se puede pasar como una matriz o
		 * como una secuencia de argumentos. Los varargs solo se pueden usar en la posicion final del argumento. */
		return "";
	}

	static int sumarTradicional(int[] n) {
		int suma = 0;
		for (int i : n)
			suma += i;
		return suma;
	}

	// https://www.youtube.com/watch?v=SGTzA0Zk14k
	// Este metodo recibe una cantidad variable numeros
	/* Existen varias reglas para utilizar argumentos variables:
	 * 1. Los elementos que se envian se convierten al final en un arreglo. Por lo tanto los tipos de los parametros que se
	 * estan enviando a este arreglo, deben ser siempre del mismo tipo.
	 * 2. Para indicar que es un argumento variable, se deben usar ... puntos despues del tipo de dato.
	 * 
	 * La ventaja que tiene esto, es que no importa la cantidad de elementos que se envian a este metodo. Esta es la
	 * caracteristica principal de los argumentos variables. */
	static int sumarVarargs(int... n) {
		int suma = 0;
		for (int i = 0; i < n.length; i++)
			suma += n[i];
		return suma;
	}

}
