package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Para los archivos binarios se usan las clases abstractas InputStream y OutputStram que leen y escriben flujos de
 * bytes.
 * 
 * https://mkyong.com/java/java-read-a-file-from-resources-folder/
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeBytes {

	private InputStream input;
	private OutputStream output;

	private static final String TEXT_FILE_PATH = "texts" + File.separator;
	private static final String TEXT_FILE_NAME = "Texto.txt";

	private void read(final String file) {

		int byte_entrada = -1;

		try {

			// Desde el cargador de clases se devuelve el recurso especificado como un flujo de datos
			input = getClass().getClassLoader().getResourceAsStream(TEXT_FILE_PATH + file);

			System.out.println("Nombre del archivo: " + file);
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

	private void write(final String file, String texto) {

		char[] caracteres = texto.toCharArray();

		// https://stackoverflow.com/questions/25546869/how-i-can-write-a-file-using-relative-path-in-java
		Path relativePath = Paths.get(TEXT_FILE_PATH + file);
		Path absolutePath = relativePath.toAbsolutePath();

		System.out.println(absolutePath.getParent());

//		try {
//
//			URL url = getClass().getClassLoader().getResource(TEXT_FILE_PATH + file);
//
//			output = new FileOutputStream(url.getFile());
//
//			System.out.println("Nombre del archivo: " + file);
//
//			for (int i = 0; i < caracteres.length; i++)
//				output.write(caracteres[i]);
//
//		} catch (FileNotFoundException e) {
//			System.err.println("El archivo no existe!");
//		} catch (IOException e) {
//			System.err.println("Error de I/O!");
//		} finally {
//			try {
//				if (output != null) output.close();
//			} catch (IOException e) {
//				System.err.println("No se pudo cerrar el flujo de salida!");
//			}
//		}
	}

	public static void main(String[] args) {
		FlujoDeBytes flujo = new FlujoDeBytes();
		// flujo.read(TEXT_FILE_NAME);
		flujo.write(TEXT_FILE_NAME, "Rulo quemado");
	}

}
