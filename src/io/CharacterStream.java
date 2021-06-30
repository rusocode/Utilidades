package io;

import java.io.*;

/**
 * Clase para leer y escribir archivos de caracteres usando la codificacion predeterminada.
 * Para especificar la codificacion utilize un InputStreamReader o OutputStreamWriter dependiendo del caso.
 * 
 * Ubicar el directorio del proyecto actual en cualquier plataforma
 * https://stackoverflow.com/questions/13011892/how-to-locate-the-path-of-the-current-project-directory-in-java-ide/22011009
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class CharacterStream implements Constants {

	private String path;
	private FileReader input;

	/**
	 * Crea un flujo para el archivo usando un objeto String.
	 * No hay ninguna ventaja en particular al usar un String o un File para especificar la ruta del archivo, la unica
	 * diferencia es que usando un objeto File, este puede ser mas manipulable a travez de sus metodos.
	 */
	public CharacterStream(String path) {
		this.path = path;
	}

	/**
	 * Crea un flujo de entrada para el archivo de texto y lee los caracteres del buffer decodificadolos en el formato
	 * predetermiando.
	 *
	 * Para leer flujos de bytes sin procesar, considere usar un FileInputStream (ver {@link ByteStream#readText}).
	 */
	private void read() {

		char[] buffer = new char[BUFFER_SIZE];

		try {

			input = new FileReader(path);
			// Lee todos los caracteres del array o -1 si llego al final del archivo
			while (input.read(buffer) != -1) // Caracter leido, como un numero entero en el rango de 0 a 65535 (0x00-0xffff)
				System.out.print(buffer);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informacion...");
			e.printStackTrace();
		} finally {
			try {
				if (input != null) input.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de entrada!\nMas informacion...");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Crea un flujo de salida hacia el archivo de texto y escribe una cadena utilizando la codificacion en el formato
	 * predeterminado.
	 * 
	 * Para escribir flujos de bytes sin procesar, considere usar un FileOutputStream (ver {@link ByteStream#writeText}).
	 * 
	 * @param text   - El texto que se va a escribir.
	 * @param append - Si es verdadero, los datos se escribiran al final del archivo en lugar de sobreescribirlos.
	 */
	private void write(String text, boolean append) {

		// Creando el objeto desde el try se logra cerrar el flujo automaticamente
		try (FileWriter output = new FileWriter(path, append)) {

			output.write(text);

		} catch (IOException e) {
			System.err.println(
					"El archivo mencionado existe pero es un directorio en lugar de un archivo normal, no existe pero no se puede crear o no se puede abrir por cualquier otro motivo.\nMas informacion...");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CharacterStream flujo = new CharacterStream(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + TEXT_FILENAME);
		flujo.read();
		// flujo.write("Rulo quemado", false);
	}

}
