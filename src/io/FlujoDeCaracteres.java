package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlujoDeCaracteres {

	/* Para los archivos de texto se usan las clases abstractas Reader y Writer para leer/escribir flujos de caracteres.
	 * 
	 * Nota: La clase FileReader usa la codificacion de caracteres predeterminada. */

	private final static String RUTA = "archivos/texto.txt";

	public static void main(String[] args) {
		leer();
		// escribir();
	}

	static void leer() {

		int codigo;

		try {

			// Clase que lee el archivo caracter por caracter
			FileReader archivo = new FileReader(RUTA);

			// En cada vuelta del while lee el codigo del caracter o -1 si se ha alcanzado el final de la secuencia
			while ((codigo = archivo.read()) != -1)
				System.out.print((char) codigo); // Traduce el codigo a caracter

			archivo.close(); // Cerrar siempre el flujo de datos para evitar el consumo de recursos

		} catch (IOException e) {
			System.err.println("Error de I/O: " + e.getMessage());
		}
	}

	static void escribir() {

		// Declarando el objeto desde el try se logra cerrar el flujo automaticamente

		// Si es verdadero, entonces los datos se escribiran al final del archivo en lugar de al principio
		try (FileWriter salida = new FileWriter("c:/users/juand/Desktop/texto.txt", true)) {

			String frase = "De rutaaa";

			salida.write("Tambien se puede agregar texto de esta forma!");

			// Escribe un caracter en la ruta especificada
			for (int i = 0; i < frase.length(); i++)
				salida.write(frase.charAt(i));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
