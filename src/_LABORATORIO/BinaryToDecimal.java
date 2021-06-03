package _LABORATORIO;

// Explicacion personal del Byte

/* Un Byte(B) es la unidad de informacion que resulta equivalente a un conjunto 
 * ordenado de bits (generalmente 8 bits de 1s y 0s).
 * La primitiva de Java "byte" esta siempre definida con 8 bits siendo un tipo de datos con signo, 
 * tomando valores entre -128 y 127, ocupando solo 1 byte en memoria. */

// Explicacion extraida de un articulo muy bueno a mi parecer (https://asm86.wordpress.com/2008/12/27/%C2%BFcuantos-bits-tiene-un-byte/)
/* 
 * Lo mas parecido que existe a un BYTE en el mundo de los humanos es una CAJITA. 
 * Una cajita muy pequeña que puede almacenar un numero. Este numero puede ser cualquiera entre 0 y 255, o lo que es lo mismo, 8 bits.
 * 
 * La memoria RAM es un chorizote de varias celdas de memoria con capacidad de un byte. 
 * Para que se den una idea, una maquina con un Gigabyte en RAM tiene algo asi como 2 elevado a la 30 que es mas o 
 * menos 1,073,741,824 cajitas como estas. En el dibujo que acompaña a esta entrada viene una de estas celdas de memoria. 
 * Como se puede ver, una de estas celdas de capacidad de un byte tiene 8 espacios para guardar bits. 
 * Cada una de estas celdas tiene un valor posicional, como en el decimal se manejan unidades, decenas, centenas, etc. 
 * Es una suma de potencias de dos, contando de derecha a izquierda la primera posicion vale 2 elevado a la cero = 1 
 * y la ultima 2 elevado a la 7 = 128. Como puede verse en la ultima celda del dibujo, los numeros mas chiquitos 
 * representan el valor posicional de cada celda y su contenido nos dice si este valor es sumado (uno) o 
 * ignorado (cero) en el resultado final.
 * 
 * En el ejemplo del dibujo, la primer celda tiene todos sus bits en cero, lo que significa que la celda contiene un cero. 
 * El segundo ejemplo tiene una celda de byte llena. Si sumamos 128 + 64 + 32 + 16 + 8 + 4 + 2 + 1 nos da 255 que es 
 * el valor maximo que podemos representar con un solo byte. Para numeros mas grandes se usan varios bytes juntos. 
 * */

public class BinaryToDecimal {

	private static final int LONGITUD_BINARIA = 8;
	private static final int BASE = 2;
	private static int decimal = 0;

	public static void main(String[] args) {

		// generateRandomBinary();
		generateManualBinary();

	}

	// Convierte a decimal un numero binario aleatorio
	private static void generateRandomBinary() {
		byte[] binary = new byte[LONGITUD_BINARIA];
		byte bit = 0;

		for (int i = 0; i < LONGITUD_BINARIA; i++) {
			// Asigna un valor (bit) aleatorio entre 1 y 0 a la variable "bit"
			bit = (byte) (Math.random() * 2);
			// Asigna el bit al byte
			binary[i] = bit;
		}

		System.out.print("Byte: ");
		for (byte b : binary)
			System.out.print(b);

		System.out.println("\nDecimal: " + convertBinaryToDecimalOptimized(binary));

	}

	// Convierte a decimal un numero binario especificado
	private static void generateManualBinary() {
		byte[] binary = { 1, 1, 1, 1, 1, 1, 1, 1 };

		System.out.print("Byte: ");
		for (byte b : binary)
			System.out.print(b);

		System.out.println("\nDecimal: " + convertBinaryToDecimal(binary));
	}

	// Convierte el numero binario a decimal
	private static int convertBinaryToDecimal(byte[] binary) {

		int i = binary.length - 1;

		// Mientras el indice (i) del numero binario sea mayor o igual a 0, entonces...
		while (i >= 0) {

			// Si el bit es 1, entonces...
			if (binary[i] == 1) {

				// Calcula la potencia del bit "i" y lo asigna a la variable "decimal" de tipo int
				/* Explicacion profunda: Al meto estatico "pow" (potencia) de la clase Math, se le pasa como primer argumento la base
				 * (2) y como segundo, se llama al metodo estatico "calcularExponente()". */
				decimal += Math.pow(BASE, calcularExponente(7, i));

				// Le resta 1 al indice del numero binario para trabajar con el indice anterior
				i--;

			}

			// Si el bit es 0, entonces...
			else
				// Le resta 1 al indice del numero binario para trabajar con el indice anterior
				i--;

		}

		// Devuelve el valor del binario en decimal
		return decimal;
	}

	// Convierte el numero binario a decimal *Optimizado (5 lineas menos!)
	private static int convertBinaryToDecimalOptimized(byte[] binary) {

		// Itera cada bit del byte
		for (int i = binary.length - 1; i >= 0; i--) {
			// Si el bit es 1, entonces...
			if (binary[i] == 1)
				// Calcula la potencia del bit "i" y lo asigna a la variable "decimal" de tipo int
				/* Explicacion profunda: Al meto estatico "pow" (potencia) de la clase Math, se le pasa como primer argumento la base
				 * (2) y como segundo, se llama al metodo estatico "calcularExponente()". */
				decimal += Math.pow(BASE, calcularExponente(7, i));
		}

		// Devuelve el valor del binario en decimal
		return decimal;
	}

	// Este metodo es una funcion logica que se encarga de calcular el expontente del bit especificado
	private static int calcularExponente(int indice7, int indice) {
		return indice7 - indice;
	}

}
