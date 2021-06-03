package _LABORATORIO;

/**
 * Factor: Es cada uno de los numeros que se multiplican para formar un producto.
 * Factorizar: Es un proceso que permite descomponer en factores una expresion matematica.
 * 
 * El resultado de factorizar SIEMPRE SERA UNA MULTIPLICACION.
 * 
 * Factorial: No es mas que el producto de todos los numeros enteros positivos desde el 1 hasta el numero
 * en cuestion, incluido. Es una operacion matematica que se denota por la notacion n! (factorial de n). Asi, el
 * factorial de, por ejemplo, 6, es el resultado de multiplicar todos los numeros enteros entre 1 y 6, ambos inclusives.
 * https://professor-falken.com/programacion-en-ejemplos/ejemplos-java/calculo-del-factorial-de-un-numero-en-java/
 */

public class Factores {

	/* Tomando como ejemplo el algoritmo RSA de llaves publicas/privadas, podemos suponer que nuestra LLAVE PUBLICA es 33.
	 * El 33 es el producto de dos numeros primos, entonces para cualquiera seria facil saber que 3 y 11 son los dos numeros
	 * primos que multiplicados dan 33, osea la llave publica. Sabiendo esto, podemos decir que 3 y 11 son la LLAVE PRIVADA.
	 * El proceso de averiguar la llave privada se hace factorizando la llave publica, eso es sencillo usando un programa
	 * como estos. Pero la magia del cifrado RSA, esta en usar numeros primos muy grandes para generar la llave publica,
	 * entonces asi, resultaria demasiado dificil factorizarla. Ni con los ordenadores mas potentes del muedo se pueden
	 * factorizar numeros grandes.
	 * 
	 * Tiene mucho sentido los numeros primos, porque uno siempre puede dividir entre numeros populares para adivinar la
	 * contraseña, pero los numeros primos son tan poco comunes que seria dificil probar dividiendo entre mumeros primos
	 * hasta dar con un entero.
	 * Ejemplificando, 24 podria ser una llave, pero se ve que es un numero compuesto, las contraseñas podrian ser dos de
	 * sus multiplos 1, 2, 3, 4, 6 y 12, y si el numero es muy grande, basta con probar dividiento, porque es un numero con
	 * multiplos y al dividir exitosamente me acerco cada vez mas a la respuesta. Pero si trato con un numero generado por
	 * multiplicacion de primos elegidos como 4739573277, no hay forma de empezar a dividir, en principio porque los primos
	 * son indivisibles. Ya a partir de ahi tendria que ir de 1 en 1 hasta cualquier numero para ver si la division da
	 * entero, y ya tendria la clave.
	 * 
	 * NOTA: Es importante recordar que una vez encriptado el mensaje con la llave publica del emisor, no se puede
	 * desencriptar con la misma la llave publica. Solo el receptor puede desencriptar el mensaje con la llave privada, para
	 * ser mas especificos, con sus dos numeros primos. */

	public static void main(String[] args) {

		/* 24 es un numero compuesto porque tiene multiplos y se puede dividir, por lo tanto es mas facil descifrarlo. */
		int compuesto = 1477015848; // 24 1477015848

		/* 33 es el producto de dos numeros primos, y por lo tanto es mucho mas dificil descifrarlos por que los primos
		 * son indivisibles.
		 * 
		 * 1_477_015_847 es el producto de dos numeros primos grande. Si se factoriza, se puede ver como tarda un poco mas
		 * que un numero compuesto. */
		int primo = 1_477_015_847; // 33 Llave publica

		factorizar(2753);
		// calcularFactorial(n);

	}

	static void factorizar(int n) {
		System.out.print("Los factores de " + n + " son: ");
		for (int i = 1; i <= n; i++)
			if (n % i == 0) System.out.print(i + " ");
	}

	// !n = n1 x n2 x ... (n-1) x n
	static void calcularFactorial(int n) {
		int factorial = 1;

		for (int factor = 1; factor <= n; factor++)
			factorial *= factor;

		System.out.println("El factorial del numero " + n + " es " + factorial);

	}

}
