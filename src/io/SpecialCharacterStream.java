package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Un InputStreamReader es un puente entre flujos de bytes y flujos de caracteres. Lee bytes y los decodifica en
 * caracteres utilizando un formato especifico.
 * Se usan especificamente para tratar con caracteres (por lo tanto, cadenas), por lo que manejan
 * codificaciones de juegos de caracteres (utf8, iso-8859-1, etc.) con elegancia.
 * 
 * En conclusion, si esta leyendo un archivo que esta codificado en una codificacion de caracteres que no sea la
 * codificacion char predeterminada del host, entonces debe usar InputStreamReader. La diferencia entre InputStream y
 * InputStreamReader es que InputStream lee como byte, mientras que InputStreamReader se lee como char. Por ejemplo, si
 * el texto de un archivo es abc, ambos funcionan bien. Pero si el texto esta a compuesto por un a y dos caracteres
 * chinos, entonces InputStream no funciona.
 * 
 * Por defecto, el charset (juego de caracteres) esta especificado en la plataforma, pero en este caso
 * se lo indico explicitamente al constructor de InputStreamReader que use UTF-8.
 * 
 * TODO Agrege un caracter chino (特 = 3 bytes) al archivo de texto para probar la decodificacion de caracteres epeciales
 * (no predeterminado por el host) con InputStreamReader.
 * FIXME La plataforma se refiere a la JVM, Eclipse o al SO?
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class SpecialCharacterStream implements Constants {

	private File file;
	private FileInputStream input;
	private InputStreamReader charset;

	/** Crea un flujo para el archivo usando un objeto File. */
	public SpecialCharacterStream(File file) {
		this.file = file;
	}

	/**
	 * Crea un flujo de entrada para el archivo de texto, lee los bytes del array y los decodifica en caracteres utilizando
	 * el formato UTF-8.
	 */
	private void read() {

		char[] buf = new char[8192];

		try {

			input = new FileInputStream(file);
			charset = new InputStreamReader(input, StandardCharsets.UTF_8);

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.available() + " bytes");
			System.out.println("-Texto-");

			// Lee los caracteres del array o -1 si llego al final del archivo
			while (charset.read(buf) != -1) {
				System.out.println(buf);
				System.out.println("Bytes restantes que se pueden leer: " + input.available());
			}

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.err.println("Codificacion de caracteres no soportada!\nMas informacion...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informacion...");
			e.printStackTrace();
		} finally {
			try {
				if (input != null || charset != null) {
					input.close();
					charset.close();
				}
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de entrada!\nMas informacion...");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SpecialCharacterStream file = new SpecialCharacterStream(
				new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + TEXT_FILENAME));
		file.read();

	}

}
