package _LABORATORIO;

import java.util.Date;

/**
 * Es mucho mas rapida que la clase String, la diferencia que tiene es que es una clase mutable, es decir que se puede
 * modificar sin crear nuevos objetos. Al igual que String, es Thread-safe (sincronizada).
 * En caso de que la app no sea multihilo, es recomendable usar StringBuilder.
 * 
 * ¿Cuando usarla?
 * Si la cadena va a ser modificada desde varios hilos.
 * 
 * - Clase del paquete java.lang, no hace falta importarla!
 */
public class StringBuffer_ {

	public static void main(String[] args) {
		delete();
	}

	static void prueba() {
		// Crea un buffer de cadena sin caracteres con una capacidad inicial de 1000 caracteres
		StringBuffer sb = new StringBuffer(1000); // Por defecto se crean con una capacidad inicial de 16 caracteres

		// Agrega cadenas sin crear nuevos objetos (mutable)
		sb.append("rulo");
		sb.append("drogadicto");
		sb.append("estas");
		sb.append("re");
		sb.append("quemado");

		System.out.println(sb.hashCode());

		// Aacepta objetos y tipos primitivos
		sb.append('R');
		sb.append(234 + "\n");
		sb.append(new Date());
		sb.append(false);

		System.out.println(sb.hashCode()); // El hashCode sigue siendo el mismo!

		// Mas rapida
		long inicio = new Date().getTime();
		for (int i = 0; i < 10000; i++)
			sb.append("rulo tostado\n");
		long fin = new Date().getTime();
		System.out.println("Tiempo que tardo en agregar todas las cadenas = " + (fin - inicio) + " milisegundos");

		// Muestra la cadena completa
		// System.out.println(sb.toString());
	}

	static void delete() {
		StringBuffer sb = new StringBuffer();

		sb.append("rulo");
		sb.append("quemado");

		/* Elimina los caracteres de una subcadena de esta secuencia. La subcadena comienza en el inicio especificado y se
		 * extiende hasta el caracter al final del indice - 1 o al final de la secuencia si no existe tal caracter. Si el inicio
		 * es igual al final, no se realizan cambios.
		 * 
		 * start - El indice inicial, incluido.
		 * end - El indice final, exclusivo. */
		sb.delete(4, sb.length());

		System.out.println(sb.toString());
	}

}
