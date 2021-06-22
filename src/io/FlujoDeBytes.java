package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlujoDeBytes {

	/* Para los archivos binarios se usan las clases abstractas InputStream y OutputStram para leer/escribir flujos de
	 * bytes. */

	private static final String RUTA = "archivos/imagen.png";

	public static void main(String[] args) {
		leer();
	}

	static void leer() {

		int[] bytes = null;
		int byte_entrada, i = 0;

		try {

			// Clase que lee una imagen byte por byte
			FileInputStream archivo = new FileInputStream(RUTA);

			/* Api de Java: Un InputStreamReader es un puente entre flujos de bytes y flujos de caracteres: lee bytes y los
			 * decodifica en caracteres utilizando un juego de caracteres especifico.
			 * 
			 * StackOverflow: Se usan especificamente para tratar con caracteres (por lo tanto, cadenas), por lo que manejan
			 * codificaciones de juegos de caracteres (utf8, iso-8859-1, etc.) con elegancia.
			 * 
			 * En conclusion, si esta leyendo un archivo que esta codificado en una codificacion de caracteres que no sea la
			 * codificacion char predeterminada del host, entonces debe usar InputStreamReader. La diferencia entre InputStream y
			 * InputStreamReader es que InputStream lee como byte, mientras que InputStreamReader se lee como char. Por ejemplo, si
			 * el texto de un archivo es abc, ambos funcionan bien. Pero si el texto esta a compuesto por un a y dos
			 * caracteres chinos, entonces InputStream no funciona. */
			InputStreamReader charset = new InputStreamReader(archivo);

			bytes = new int[(int) archivo.getChannel().size()];

			// En cada vuelta del while lee un byte o -1 si se ha alcanzado el final de la secuencia
			while ((byte_entrada = charset.read()) != -1) {
				bytes[i] = byte_entrada; // Almacena el byte en la posicion i del arreglo de bytes
				System.out.println(byte_entrada); // (char) para ver los caracteres del byte
				i++;
			}

			System.out.println("Tamaño de la imagen en bytes: " + i + " B\n" + "Tamaño de la imagen en Kilobytes: " + (i / 1024) + " KB");

			archivo.close();

		} catch (IOException e) {
			System.err.println("Error de I/O: " + e.getMessage());
		}

		escribir(bytes);
	}

	static void escribir(int datos[]) {

		try {

			FileOutputStream salida = new FileOutputStream("C:/Users/juand/Downloads/Fondos/Casa2.jpg");

			for (int i = 0; i < datos.length; i++)
				salida.write(datos[i]);

			salida.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
