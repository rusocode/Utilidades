package ficheros;

import java.io.File;

/**
 * La rutas se dividen en absolutas y relativas. Las absolutas representan la ruta completa del recurso. Dicho de otra
 * forma, parten desde el directorio raiz hasta llegar al recurso, ej: "C:\Users\juand\Desktop\texto.txt".
 * En cambio, las relativas representan solo una parte de la ruta. Esto es posible porque en las rutas
 * relativas se tiene en cuenta el directorio actual de trabajo, ej: "assets\texto.txt" (sin separador al inicio de la
 * ruta).
 * 
 * Mas informacion...
 * https://www.vozidea.com/diferencias-ruta-relativa-y-absoluta#:~:text=Rutas%20relativas%20y%20absolutas%2C%20diferencias%20caracter%C3%ADsticas.&text=Dicho%20de%20otra%20forma%2C%20se,el%20directorio%20actual%20de%20trabajo
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class Rutas {

	/* Como java es un lenguaje de programacion multiplataforma, nos brinda la posibilidad de implementar el caracter
	 * separador de carpetas para un SO en especifico. */
	private static String s = File.separator;

	private static void fileFor(File file) {

		// Devuelve el nombre de la ruta absoluta que indica el mismo archivo o directorio
		System.out.println(file.getAbsolutePath());

		/* Devuelve verdadero si y solo si el archivo o directorio indicado por este nombre de ruta abstracto existe; falso de
		 * lo contrario. */
		System.out.println(file.exists());

		// Devuelve una matriz de cadenas que nombran los archivos y directorios
		String[] archivos = file.list();

		// Itera e imprime cada archivo de la ruta especificada
		for (int i = 0; i < archivos.length; i++) {

			System.out.println(archivos[i]);

			// Crea una nueva ruta para comprobar si hay alguna carpeta dentro de la ruta padre
			File f = new File(file.getAbsolutePath(), archivos[i]);

			// Si es un directorio, entonces...
			if (f.isDirectory()) {
				String[] archivos_sub = f.list();

				for (int j = 0; j < archivos_sub.length; j++)
					System.out.println(archivos_sub[j]);

			}

		}
	}

	private static void fileRecursivo(File file) {
		if (!file.isDirectory()) System.out.println(file.getName());
		else {

			System.out.println("Cantidad de archivos en la carpeta \"" + file.getName() + "\": " + file.list().length);

			// Almacena los archivos de la ruta en un array de cadenas
			String[] dirs = file.list();

			// Itera cada archivo y si hay una carpeta detro de la subcarpeta hace una llamada recursiva
			for (String dir : dirs) {

				File f = new File(file.getAbsolutePath(), dir);

				System.out.println(f.getName());

				if (f.isDirectory()) fileRecursivo(f);
			}
		}
	}

	public static void main(String[] args) {
		/* Si no se especifica una ruta especifica (ej: ".project" archivo que pertenece al proyecto), entonces toma por defecto
		 * la ruta del proyecto actual. */
		fileRecursivo(new File(System.getProperty("user.home") + s + "Documents" + s + "Silentsoft" + s + "CalculadoraAO"));

	}

}
