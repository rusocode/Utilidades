package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArchivoEspecial {

	public static void main(String[] args) {

		final String filename = "texto.txt";
		int byte_entrada = -1;
		FileInputStream input = null;

		try {

			input = new FileInputStream(
					"C:" + File.separator + "Users" + File.separator + "juand" + File.separator + "Desktop" + File.separator + filename);

			System.out.println("Nombre del archivo: " + filename);

			// Devuelve el tamaño actual del archivo de este canal
			System.out.println("Tamaño: " + (int) input.getChannel().size() + " bytes"); // Cada caracter pesa 1 byte

			System.out.print("Texto: ");
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

}
