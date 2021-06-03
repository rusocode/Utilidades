package _LABORATORIO;

import java.util.Random;

// http://chuwiki.chuidiang.org/index.php?title=Generar_n%C3%BAmeros_aleatorios_en_Java
// https://es.stackoverflow.com/questions/5390/como-generar-n%C3%BAmeros-aleatorios-dentro-de-un-rango-de-valores
public class Random_ {

	public static void main(String[] args) {

		/* El metodo estatico random() de la clase Math Devuelve un valor doble con un signo positivo, mayor o igual que 0.0 y
		 * menor que 1.0, excluido este ultimo valor, es decir, puede devolver valores como: 0.346442, 0.2344234, 0.98345, etc.
		 * Los valores devueltos se eligen pseudoaleatoriamente con una distribucion (aproximadamente) uniforme de ese rango.
		 * Cuando se llama por primera vez a este metodo, crea un nuevo generador de numeros pseudoaleatorios, exactamente como
		 * si fuera por la expresion new java.util.Random(). */
		// System.out.println(Math.random());

		/* En muchas de nuestras aplicaciones no nos servira este rango de valores. Por ejemplo, si queremos simular una tirada
		 * de dados, vamos a querer numeros entre 1 y 6 sin decimales.
		 * 
		 * En el caso del dado, son 6 valores que van del 1 al 6, ambos incluidos, por lo tanto debemos multiplicar
		 * Math.random() por 6, donde 6 (maximo) es hasta el numero que quieres que llegue, + 1 (minimo) para que nunca tengas
		 * un 0 y cast a int por que Math#random arroja un valor de tipo double */
		// System.out.println((int) (Math.random() * 6 + 1));

		// Devuelve un numero entero aleatorio entre un minimo y un mayor especificado (ambos incluidos)
		int min = 5, max = 10;
		// System.out.println((int) ((Math.random() * (max - min + 1)) + min));

		// Clase Random!
		// La diferencia con la clase Math, es que Random es mas flexible
		Random random = new Random();

		// Muestra un num aleatorio entre 1 y 3, ya que * 4 es de 0 a 3, y se le suma 1 para que nunca de 0
		// System.out.println((int) (random.nextFloat() * 4 + 1));

		// Obtiene un num aleatorio entre -50 y 50
		float f;
		f = random.nextFloat();
		System.out.println("f = " + f);
		f -= 0.5; // Le resta 0.5 a f conviertiendolo en un num negativo
		System.out.println("f - 0.5 =  " + f);
		f *= 100;
		System.out.println("f * 100 =  " + f);
		System.out.println("(int) f = " + (int) f);

	}

}
