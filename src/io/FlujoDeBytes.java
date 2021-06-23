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
	private FileOutputStream output;

	private static final String S = File.separator;
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

		// System.out.println(absolutePath.getParent().toString());

		// URL url = getClass().getClassLoader().getResource("texts/Texto.txt"); FUNCIONA POR LA BARRA DE MIERDA!!
		URL url = getClass().getResource("/texts/Texto.txt");

		// System.out.println(url.getPath());

		// File f = new File("texts/Texto.txt");
		// System.out.println(f.exists());

		try {

			// "C:"+S+"Users"+S+"juand"+S+"Documents"+S+"Eclipse - Proyectos"+S+"utilidades"+S+"assets"+S+"texts"+S+"Texto.txt"
			// "C:\\Users\\juand\\Documents\\Eclipse - Proyectos\\utilidades\\assets\\texts\\Texto.txt"
			// "C:/Users/juand/Documents/Eclipse - Proyectos/utilidades/assets/texts/Texto.txt"

			// https://stackoverflow.com/questions/17287478/get-file-from-project-folder-java/36445369
			ClassLoader cl = getClass().getClassLoader(); // Parece que cargando el recurso desde el loader no encuentra el archivo...
			File f1 = new File(cl.getResource(".").getFile());

			File f2 = new File(System.getProperty("user.home") + S + "Documents" + S + "Eclipse - Proyectos" + S + "utilidades" + S + "bin" + S
					+ "texts" + S + "texto.txt");

			if (f1 != null) {
				System.out.println("Ruta absoluta = " + f1.getAbsolutePath());
				System.out.println("Nombre del archivo = " + f1.getName());
				System.out.println(f1.list());

				// https://stackoverflow.com/questions/11553042/the-system-cannot-find-the-file-specified-in-java
//				for (String files : f2.list())
//					System.out.println(files);
			}

			output = new FileOutputStream(f1);

			for (int i = 0; i < caracteres.length; i++)
				output.write(caracteres[i]);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\n" + e.getMessage());
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
		flujo.write(TEXT_FILE_NAME, "Rulo quemadouuaaa");
	}

}
