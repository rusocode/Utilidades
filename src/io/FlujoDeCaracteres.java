package io;

import java.io.*;

/**
 * Clase de conveniencia para leer y escribir archivos de caracteres. El constructor de esta clase asumen que la
 * codificacion de caracteres predeterminada y el tamaño de buffer de bytes predeterminado son aceptables. Para
 * especificar estos valores usted mismo, construya un InputStreamReader en un FileInputStream para la lectura o un
 * OutputStreamWriter en un FileOutputStream para la escritura.
 * 
 * Ubicar el directorio del proyecto actual en cualquier plataforma
 * https://stackoverflow.com/questions/13011892/how-to-locate-the-path-of-the-current-project-directory-in-java-ide/22011009
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeCaracteres {

	private String path;

	private FileReader input;

	private static final String S = File.separator;
	private static final String ASSETS = "assets";
	private static final String TEXTS_PATH = "texts";
	private static final String FILENAME = "text.txt";

	public FlujoDeCaracteres(String path) {
		this.path = path;
	}

	/**
	 * Lee un solo caracter.
	 * Para leer flujos de bytes sin procesar, considere usar un FileInputStream (ver {@link FlujoDeBytes#readText}).
	 */
	private void read() {

		int character;

		try {

			input = new FileReader(path);

			/* Obtiene el caracter leido, o -1 si se ha alcanzado el final de la secuencia.
			 * Cada caracter del alfabeto ASCII ocupa 1 byte! */
			while ((character = input.read()) != -1)
				System.out.print((char) character);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...\n" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de I/O: " + e.getMessage());
		} finally {
			try {
				if (input != null) input.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de entrada!");
			}
		}
	}

	/**
	 * Escribe una cadena.
	 * Para escribir flujos de bytes sin procesar, considere usar un FileOutputStream (ver {@link FlujoDeBytes#writeText}).
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
					"El archivo mencionado existe pero es un directorio en lugar de un archivo normal, no existe pero no se puede crear o no se puede abrir por cualquier otro motivo.");
		}

	}

	public static void main(String[] args) {
		FlujoDeCaracteres flujo = new FlujoDeCaracteres(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + FILENAME);
		// flujo.read();
		flujo.write("Rulo quemado", false);
	}

}
