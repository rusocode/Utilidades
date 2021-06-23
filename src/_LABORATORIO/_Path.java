package _LABORATORIO;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * https://stackoverflow.com/questions/25546869/how-i-can-write-a-file-using-relative-path-in-java
 */

public class _Path {

	private static final String TEXT_FILE_PATH = "texts" + File.separator;
	private static final String TEXT_FILE_NAME = "Texto.txt";

	public static void main(String[] args) {

		// Convierte el URI dado en un objeto de ruta
		Path relativePath = Paths.get(TEXT_FILE_PATH + TEXT_FILE_NAME);
		// Devuelve un objeto Path que representa la ruta absoluta de esta ruta
		Path absolutePath = relativePath.toAbsolutePath();

		// Devuelve el componente raiz
		System.out.println("Componente raiz = " + absolutePath.getRoot());
		// Devuelve la ruta principal
		System.out.println("Ruta principal = " + absolutePath.getParent());
		// Devuelve el nombre del archivo o null si la ruta tiene 0 elementos
		System.out.println("Nombre del archivo = " + absolutePath.getFileName());

	}

}
