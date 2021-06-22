package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Para los archivos binarios se usan las clases abstractas InputStream y OutputStram que leen/escriben flujos de
 * bytes.
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeBytes {

	private FileInputStream input;
	private FileOutputStream output;

	private final String s = File.separator;
	private final String FILEPATH = "archivos" + s;
	private final String FILENAME = "Texto.txt";

	public static void main(String[] args) {
		FlujoDeBytes flujo = new FlujoDeBytes();
		flujo.read();

	}

	private void read() {

		int byte_entrada = -1;

		try {

			input = new FileInputStream("/utilidades/src/io/archivos/Texto.txt"); // FILEPATH + FILENAME

			System.out.println("Nombre del archivo: " + FILENAME);

			// Devuelve el tamaño actual del archivo de este canal
			System.out.println("Tamaño: " + (int) input.getChannel().size() + " bytes"); // Cada caracter pesa 1 byte

			System.out.print("Texto: ");
			// En cada vuelta del while lee un byte o -1 si se ha alcanzado el final de la secuencia
			while ((byte_entrada = input.read()) != -1)
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

	private void write(String texto) {

		// int datos[] ?
		char[] caracteres = texto.toCharArray();

		try {

			output = new FileOutputStream("C:" + s + "Users" + s + "juand" + s + "Desktop" + s + FILENAME);

			System.out.println("Nombre del archivo: " + FILENAME);

			System.out.println("Se escribio: " + texto);

			for (int i = 0; i < caracteres.length; i++)
				output.write(caracteres[i]);

			// Devuelve el tamaño actual del archivo de este canal
			System.out.println("Tamaño: " + (int) output.getChannel().size() + " bytes"); // Cada caracter pesa 1 byte

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

}
