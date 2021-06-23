package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Para los archivos de texto se usan las clases abstractas Reader y Writer para leer/escribir flujos de caracteres.
 * 
 * Nota: La clase FileReader usa la codificacion de caracteres predeterminada.
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeCaracteres {

	private static final String S = File.separator;
	private static final String ASSETS = "assets";
	private static final String TEXT_FILE_PATH = "texts";

	private void read(final String filename) {

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

	private void write(final String filename, String texto) {

		// Declarando el objeto desde el try se logra cerrar el flujo automaticamente
		// Si es verdadero, entonces los datos se escribiran al final del archivo en lugar de al principio
		try (FileWriter output = new FileWriter(System.getProperty("user.dir") + S + ASSETS + S + TEXT_FILE_PATH + S + filename, true)) {

			output.write(texto);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...\n" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de I/O!");
		}

	}

	public static void main(String[] args) {
		FlujoDeCaracteres flujo = new FlujoDeCaracteres();
		flujo.read("texto.txt");
		// flujo.write();
	}

}
