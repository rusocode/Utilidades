package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Para los archivos binarios se usan las clases abstractas InputStream y OutputStram que leen y escriben flujos de
 * bytes.
 * 
 * https://mkyong.com/java/java-read-a-file-from-resources-folder/
 * 
 * Para ubiar el directorio del proyecto en cualquier entorno
 * https://stackoverflow.com/questions/13011892/how-to-locate-the-path-of-the-current-project-directory-in-java-ide/22011009
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeBytes {

	private InputStream input;
	private FileOutputStream output;

	private static final String S = File.separator;
	private static final String TEXT_FILE_PATH = S + "assets" + S + "texts" + S;

	public static final String TEXT_FILE_NAME = "texto.txt";

	private void read(final String filename) {

		int byte_entrada = -1;

		try {

			// Desde el cargador de clases se devuelve el recurso especificado como un flujo de datos
			input = getClass().getClassLoader().getResourceAsStream(TEXT_FILE_PATH + filename);

			System.out.println("Nombre del archivo: " + filename);
			System.out.println("Tamaño: " + input.available() + " bytes");
			System.out.print("Texto: ");
			// En cada vuelta del while lee un byte o -1 si se ha alcanzado el final de la secuencia
			while ((byte_entrada = input.read()) != -1) // Cada caracter del alfabeto ASCII pesa 1 byte
				System.out.print((char) byte_entrada);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!");
		} catch (IOException e) {
			System.err.println("Error de I/O!");
		} finally {
			try {
				if (input != null) input.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de entrada!");
			}
		}

	}

	private void write(final String filename, String texto) {

		char[] caracteres = texto.toCharArray();

		try {

			File file = new File(System.getProperty("user.dir") + TEXT_FILE_PATH + filename);

			output = new FileOutputStream(file);

			for (int i = 0; i < caracteres.length; i++)
				output.write(caracteres[i]);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...\n" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de I/O!");
		} finally {
			try {
				if (output != null) output.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de salida!");
			}
		}

	}

	public static void main(String[] args) {
		FlujoDeBytes flujo = new FlujoDeBytes();
		// flujo.read(TEXT_FILE_NAME);
		flujo.write(TEXT_FILE_NAME, "Rulo quemado");
	}

}
