package io;

import java.io.*;

/**
 * Para los archivos de texto se usan las clases abstractas Reader y Writer encargadas de leer y escribir flujos de
 * caracteres.
 * 
 * Para ubiar el directorio del proyecto en cualquier entorno
 * https://stackoverflow.com/questions/13011892/how-to-locate-the-path-of-the-current-project-directory-in-java-ide/22011009
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeCaracteres {

	private static final String S = File.separator;
	private static final String ASSETS = "assets";
	private static final String TEXTS_PATH = "texts";

	/**
	 * Clase de conveniencia para leer archivos de caracteres. Los constructores de esta clase asumen que la codificacion de
	 * caracteres predeterminada y el tamaño de buffer de bytes predeterminado son aceptables. Para especificar estos
	 * valores usted mismo, construya un InputStreamReader en un FileInputStream.
	 * <p>
	 * FileReader esta diseñado para leer secuencias de caracteres. Para leer flujos de bytes sin procesar, considere usar
	 * un FileInputStream (ver {@link FlujoDeBytes#read}).
	 * </p>
	 * 
	 * @param filename - El nombre del archivo de texto.
	 */
	private void read(final String filename) {

		FileReader input = null;
		int byte_entrada;

		try {

			input = new FileReader(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + filename);

			// En cada vuelta del while lee el codigo del caracter o -1 si se ha alcanzado el final de la secuencia
			while ((byte_entrada = input.read()) != -1) // Cada caracter del alfabeto ASCII pesa 1 byte
				System.out.println( byte_entrada);

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
	 * Clase de conveniencia para escribir archivos de caracteres. Los constructores de esta clase asumen que la
	 * codificacion de caracteres predeterminada y el tamaño de buffer de bytes predeterminado son aceptables. Para
	 * especificar estos valores usted mismo, construya un OutputStreamWriter en un FileOutputStream.
	 * <p>
	 * FileWriter esta diseñado para escribir secuencias de caracteres. Para escribir flujos de bytes sin procesar,
	 * considere usar un FileOutputStream (ver {@link FlujoDeBytes#write}).
	 * </p>
	 * 
	 * @param filename - El nombre del archivo de texto.
	 * @param texto    - El texto que se va a escribir.
	 * @param append   - Si es verdadero, los datos se escribiran al final del archivo en lugar de al principio.
	 */
	private void write(final String filename, String texto, boolean append) {

		// Declarando el objeto desde el try se logra cerrar el flujo automaticamente
		try (FileWriter output = new FileWriter(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + filename, append)) {

			output.write(texto);

		} catch (IOException e) {
			System.err.println(
					"El archivo mencionado existe pero es un directorio en lugar de un archivo normal, no existe pero no se puede crear o no se puede abrir por cualquier otro motivo.");
		}

	}

	public static void main(String[] args) {
		FlujoDeCaracteres flujo = new FlujoDeCaracteres();
		flujo.read("Texto.txt");
		// flujo.write("texto.txt", "Rulo quemado", false);
	}

}
