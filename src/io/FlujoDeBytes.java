package io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Para los archivos binarios se usan las clases abstractas InputStream y OutputStram encargadas de leer y escribir
 * flujos de bytes.
 * 
 * https://mkyong.com/java/java-read-a-file-from-resources-folder/
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeBytes {

	private InputStream input;
	private FileInputStream in;
	private FileOutputStream output;

	private static final String S = File.separator;
	private static final String ASSETS = "assets";
	private static final String TEXTS_PATH = "texts";

	private void read(final String filename) {

		int byte_entrada;

		try {

			in = new FileInputStream();

			// Desde el cargador de clases se devuelve el recurso especificado como un flujo de datos
			input = getClass().getClassLoader().getResourceAsStream(TEXTS_PATH + S + filename);

			System.out.println("Nombre del archivo: " + filename);
			System.out.println("Tamaño: " + input.available() + " bytes");
			System.out.print("Texto: ");

			while ((byte_entrada = input.read()) != -1)
				System.out.print((char) byte_entrada);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...\n" + e.getMessage());
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

	/**
	 * Un flujo de salida de archivo es un flujo de salida para escribir datos en un archivo o en un descriptor de archivo.
	 * Si un archivo está disponible o puede crearse depende de la plataforma subyacente. Algunas plataformas, en
	 * particular, permiten que un archivo se abra para escritura por solo un FileOutputStream (u otro objeto de escritura
	 * de archivos) a la vez. En tales situaciones, los constructores de esta clase fallaran si el archivo involucrado ya
	 * esta abierto.
	 * <p>
	 * FileOutputStream esta diseñado para escribir flujos de bytes sin procesar, como datos de imagen. Para escribir
	 * secuencias de caracteres, considere usar FileWriter (ver {@link FlujoDeCaracteres#write}).
	 * </p>
	 * 
	 * @param filename - El nombre del archivo de texto.
	 * @param texto    - El texto que se va a escribir.
	 * @param append   - Si es verdadero, los datos se escribiran al final del archivo en lugar de al principio.
	 */
	private void write(final String filename, String texto, boolean append) {

		// Convierte la cadena en un array de caracteres para poder escribirlos como un flujo de bytes
		char[] caracteres = texto.toCharArray();

		try {

			// TODO Lo agrego a un constructor?
			File file = new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + filename);

			output = new FileOutputStream(file, append);

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

	// TODO Agregar un metodo para lectura de imagenes, aprovechando la ocasion del flujo de bytes

	public static void main(String[] args) {
		FlujoDeBytes flujo = new FlujoDeBytes();
		flujo.read("texto.txt");
		// flujo.write("texto.txt", "Rulo tostado");
	}

}
