package _LABORATORIO;

import java.text.DecimalFormat;

public class Literales {

	/* Para el mundo de los humanos, un literal es la representacion en letras de algo, EJ: "cuatro".
	 * 
	 * Para el mundo de la programacion, un literal es el valor que asignamos a un atributo, EJ: 4, "Cadena", 2.0,
	 * 458L, etc.
	 * http://www.edu4java.com/es/java/literales-operadores-casting-tipos-primitivos.html
	 * 
	 * - TIPOS NUMERICOS -
	 * 
	 * Tipo primitivo -> int | Ejemplo -> 777 | Observacion -> Por defecto, un numero entero es un literal int.
	 * 
	 * Tipo primitivo -> long | Ejemplo -> 777L | Observacion -> Para especificar que un numero entero sea long se utiliza
	 * el sufijo l o L (L por convenio) al final del numero.
	 * 
	 * Tipo primitivo -> double | Ejemplo -> 3.14 | Observacion -> Por defecto, un numero decimal es un literal double. Para
	 * especificar que un decimal sea double se utiliza el sufijo d o D (D por convenio) al final del numero.
	 * 
	 * Tipo primitivo -> float | Ejemplo -> 3.14F | Observacion -> Para especificar que un decimale sea float se utiliza el
	 * sufijo f o F (F por convenio) al final del numero.
	 * 
	 * Literales haxadecimales
	 * Java usa 0x o 0X para representar numeros hexadecimales. Los caracteres ('A' a 'F') en un numero hexadecimal se
	 * pueden escribir en mayusculas o minusculas. Por ejemplo, 0xa8b3d es igual que 0xA8B3D.
	 * 
	 * https://medium.com/coderscorner/hexadecimal-notation-c696eb32328a#:~:text=Java%20and%20C%20uses%200x,0xa8b3d%20is%
	 * 20same%20as%200xA8B3D.
	 * 
	 * https://stackoverflow.com/questions/20984364/dynamically-add-0x-prefix-to-int-in-java/20984444#:~:text=If%20a%
	 * 20number%20starts%20with,digits%20are%20interpreted%20as%20hex. */

	public static void main(String[] args) {

		/* Una caracteristica curiosa, es que si usamos en la mascara el signo de porcentaje %, el numero se multiplicara
		 * automaticamente por 100 al presentarlo en pantalla. */
		DecimalFormat formato = new DecimalFormat("##.##%"); // Especifica la cantidad de decimales a mostrar

		/* Los enteros no necesitan explicacion: los hemos estado usando desde hace mucho tiempo. En el lenguaje Java, ellos son
		 * representados, sin sufijo de ningun tipo, como lo siguiente: */
		int n = 344;

		/* Podemos tambien opcionalmente añadir una D o d a los literales double, pero no es necesario porque es un
		 * comportamiento por defecto: */
		double e = 110599.995011D; // Opcional, no se requiere
		double g = 987.897; // No hay sufijo D, pero esta bien porque el literal es double por defecto

		// EN OTRAS PALABRAS, EL LITERAL ES LA REPRESENTACION DE LA VARIABLE EN VALOR

		// Tipo de sufijo para el literal double: d, D, .D, .0

		// Un literal de double por ejemplo: 3.14D o 3.14 (por defecto un decimal es double)

		// Convierte un entero a decimal
		double doble = 145D;

		/* El sufijo D le indica al compilador que los valores enteros (100 y 1625) son de tipo double, por lo tanto el
		 * resultado de la division va a ser decimal. Si uso numeros enteros para la division, entonces el resultado va a ser
		 * 0.0, ya que la maquina virtual no esta trabajando con decimales. Para que esto no suceda, se le agrega el sufijo D al
		 * final del entero, convirtiendo asi el numero a un decimal. */
		double d = 100 / 1625D;

		System.out.println(d); // 0.06153846153846154
		System.out.println(formato.format(d)); // d x 100 = 6,15
		System.out.println(formato.format(d / 100D)); // 6,15 / 100 = 0.06

		// 0x indica que es un literal hexadecimal
		int hex = 0x101; // 257
		System.out.println("Numero hexadecimal 0x101 a decimal = " + hex);

		// TABLA DE LITERALES: https://es.wikibooks.org/wiki/Programaci%C3%B3n_en_Java/Literales

	}

}
