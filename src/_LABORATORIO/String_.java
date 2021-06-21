package _LABORATORIO;

import java.util.Date;

/**
 * La clasde String es inmutable, cualquier operacion de modificacion produce una nueva instancia. Esto resulta
 * ineficiente, pero buena para compartir entre hilos de ejecucion diferentes.
 * Java almacena los objetos en el heap. Los literales String son un caso especial, y los almacena en el Java String
 * Pool.
 * Se trata de un conjunto de String reutilizables: si intentamos crear una cadena que es igual a una existente, no crea
 * una nueva, sino que nos devuelve una referencia a la existente.
 * 
 * Hay dos formas de crear objetos de cadena. Si usamos comillas dobles para crear un objeto de cadena, se almacena en
 * el grupo de cadenas (Heap > Java String Pool). Si usamos el operador new para crear una cadena, se crea en la memoria
 * del monton (Heap).
 * 
 * ¿Cuando usarla?
 * Si la cadena no va a ser modificada.
 * 
 * - Clase del paquete java.lang, no hace falta importarla!
 */

// https://www.youtube.com/watch?v=YoV2W8NHFoc 
public class String_ {

	public static void main(String[] args) {

		String a = "cadena1";

		System.out.println(a.hashCode());

		a = "cadena1 modificada";

		/* El hashCode cambia despues de modificar el valor de la cadena de la instancia "a", es decir, se crea un nuevo objeto
		 * (inmutable = ineficiencia). */
		System.out.println(a.hashCode());

		/* JAVA STRINGS POOL (https://www.arquitecturajava.com/java-string-pool-un-concepto-importante/)
		 * Imagen demostrativa -> https://www.javastring.net/java/string/pool
		 * 
		 * Antes que nada: '==' compara primitivos, 'equals()' compara objetos.
		 * 
		 * En Java solo los tipos primitivos (Descritos en el JLS (�4.2), por ejemplo int o char) se comparan con ==, los
		 * Strings (y los demas objetos) en Java se comparan entre ellos con el metodo equals.
		 * 
		 * Si bien puede utilizarse == para comparar referencias de tipo String, una prueba de igualdad determina si los dos
		 * operandos refieren al mismo objeto String. El resultado es false si los operandos son distintos objetos String,
		 * incluso si contienen la misma secuencia de caracteres.
		 * 
		 * https://es.stackoverflow.com/questions/225/c%C3%B3mo-comparar-correctamente-strings-y-objetos-en-java/258 */

		// Los literales de String se almacena en el Pool String Java
		String b = "cadena2";
		String c = "cadena2";
		String d = new String("cadena2"); // Se almacena en la heap de la JVM
		String e = "cadena3";

		System.out.println(b == c); // Es true ya que ambas instancias hacen referencia al mismo objeto, SIEMPRE Y CUANDO LAS CADENAS SEAN IGUALES!
		System.out.println(b == d); // Es false ya que d es un nuevo objeto aunque las cadenas coincidan!
		System.out.println(b.equals(d)); // Es true por que compara las cadenas y no los objetos
		System.out.println(b == e); // Es false ya que e es una referencia a nueva cadena (objeto) en el pool

		// Ineficiencia, crea nuevas cadenas cada vez que se concatenan
		String cadena = null;
		long inicio = new Date().getTime();
		for (int i = 0; i < 10000; i++)
			cadena += "rulo tostado\n";
		long fin = new Date().getTime();
		System.out.println("Tiempo que tardo en agregar todas las cadenas = " + (fin - inicio) + " milisegundos");

	}

}
