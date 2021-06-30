package ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ubicar el directorio del proyecto actual en cualquier plataforma
 * https://stackoverflow.com/questions/13011892/how-to-locate-the-path-of-the-current-project-directory-in-java-ide/22011009
 */

public class Crear {

	public static void main(String[] args) throws IOException {

		// Ruta + recurso (texto.txt) ?
		String directorio = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "texto.txt";

		File file = new File(directorio);

		/* Crea un directorio a la vez, si es padre ese solo, de lo contrario, puede crear el subdirectorio (si solo existe la
		 * ruta especificada) y no crear ningun directorio entre dos directorios. */
		// file.mkdir();

		// Crea multiples directorios (entre dos directorios tambien) a la vez
		// file.mkdirs();

		try {
			// Crea un archivo solo si la ruta especificada existe
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* Una vez creado el archivo vamos a escribir sobre el. */

		BufferedWriter buffer; // Buffer intermedio para hacer escritura eficiente

		// Si el archivo existe, entonces...
		if (file.exists()) {

			// Almacena lo que se va escribiendo en el buffer
			buffer = new BufferedWriter(new FileWriter(file));
			buffer.write("Hola crack!");

			// Cierra el flujo de datos para evitar el consumo innecesario de recursos
			buffer.close();

		} else System.out.println("El archivo no existe!");

		/* Elimina el archivo o directorio indicado por este nombre de ruta abstracto. Si este nombre de ruta denota un
		 * directorio, entonces el directorio debe estar vac�o para ser eliminado. */
		// file.delete();

	}

}
