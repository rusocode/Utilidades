package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ArchivoEspecial {

	private InputStreamReader charset;

	private FileInputStream input;
	private FileOutputStream output;

	private final String s = File.separator;
	private final String FILEPATH = "C:" + s + "Users" + s + "juand" + s + "Desktop" + s;
	private final String FILENAME = "Texto.txt";

	public static void main(String[] args) {
		ArchivoEspecial file = new ArchivoEspecial();
		file.read();
		// file.write("tostado");
	}

	private void read() {

		int byte_entrada = -1;

		try {

			input = new FileInputStream(FILEPATH + FILENAME);

			/**
			 * Api de Java: Un InputStreamReader es un puente entre flujos de bytes y flujos de caracteres: lee bytes y los
			 * decodifica en caracteres utilizando un juego de caracteres especifico.
			 * 
			 * StackOverflow: Se usan especificamente para tratar con caracteres (por lo tanto, cadenas), por lo que manejan
			 * codificaciones de juegos de caracteres (utf8, iso-8859-1, etc.) con elegancia.
			 * 
			 * En conclusion, si esta leyendo un archivo que esta codificado en una codificacion de caracteres que no sea la
			 * codificacion char predeterminada del host, entonces debe usar InputStreamReader. La diferencia entre InputStream y
			 * InputStreamReader es que InputStream lee como byte, mientras que InputStreamReader se lee como char. Por ejemplo, si
			 * el texto de un archivo es abc, ambos funcionan bien. Pero si el texto esta a compuesto por un a y dos
			 * caracteres chinos, entonces InputStream no funciona.
			 * 
			 * 
			 * Le agrege un caracter chino (特) al archivo para probar la decodificacion de caracteres epeciales (no predeterminado
			 * por el host) por el InputStreamReader.
			 * 
			 * Por defecto, el charset (juego de caracteres) esta especificado en la plataforma, pero en este caso
			 * se lo indico explicitamente al constructor de InputStreamReader que use UTF-8.
			 * 
			 * La plataforma se refiere a la JVM, Eclipse o al SO?
			 */
			charset = new InputStreamReader(input, "UTF-8");

			System.out.println("Nombre del archivo: " + FILENAME);

			// Devuelve el tamaño actual del archivo de este canal
			System.out.println("Tamaño: " + (int) input.getChannel().size() + " bytes"); // Cada caracter pesa 1 byte

			System.out.print("Texto: ");
			while ((byte_entrada = charset.read()) != -1)
				System.out.print((char) byte_entrada);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Codificacion de caracteres no soportada!");
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
