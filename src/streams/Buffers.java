package streams;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Buffers {

	/* FileOuputStream, FileInputStream, FileWriter y FileReader se utilizan para escribir o leer datos en memoria.
	 * 
	 * BufferedOutputStream, BufferedInputStream, BufferedWriter y BufferedReader, añaden un buffer intermedio encargado
	 * de controlar el acceso a la memoria.
	 * 
	 * -Si vamos escribiendo, se guardaran los datos hasta que tenga basantes como para hacer la escritura eficiente.
	 * 
	 * -Si queremos leer, la clase leera muchos datos de golpe, aunque solo nos de los que hayamos pedido. En las siguientes
	 * lecturas nos dara lo que tiene almacenado, hasta que necesite leer otra vez.
	 * 
	 * Esta forma de trabajar hace que el acceso al disco sea mas eficiente y el programa corra mas rapido. La diferencia se
	 * notara mas cuanto mayor sea el fichero que queramos leer o escribir.
	 * 
	 * La clave en las clases que comienzan con Buffered es que usan un buffer. Digamos que es una memoria interna que
	 * normalmente hace que esas clases sean mas eficientes, es decir, es esperable que un BufferedInputStream sea mas
	 * rapido que el flujo ordinario. El flujo normal tiene que estar llamando y accediendo a la memoria por cada byte
	 * que quiera devolver, resultando ineficiente y consumiendo muchos recursos. En cambio el buffer accede a la memoria
	 * una vez y recolecta un array de bytes.
	 * Cuando se le llama al metodo read() ya no tiene que acceder a la memoria, sino que devuelve la informacion
	 * del buffer interno. En algun momento el buffer interno se agota, pero mientras esto ocurre se han ahorrado un monton
	 * de procesos. */

	private static final String RUTA_IMAGEN = "archivos/imagen.png";
	private static final String RUTA_TEXTO = "archivos/texto.txt";

	public static void main(String[] args) {
		leerImagen();
		// leerTexto();
		// escribirTexto();
	}

	static void leerImagen() {

		int[] bytes = null;
		int byte_entrada, c = 0;

		try {

			// El BufferedInputStream se usa para leer bytes y el BufferedReader para caracteres

			FileInputStream archivo = new FileInputStream(RUTA_IMAGEN);
			BufferedInputStream buffer = new BufferedInputStream(archivo); // Almacena en un buffer (memoria intermedia) el archivo

			bytes = new int[(int) archivo.getChannel().size()];

			while ((byte_entrada = buffer.read()) != -1) {
				bytes[c] = byte_entrada;
				System.out.println(byte_entrada);
				c++;
			}

			System.out.println("Tamaño de la imagen en bytes: " + c + " B\n" + "Tamaño de la imagen en Kilobytes: " + (c / 1024) + " KB");

			buffer.close();

		} catch (IOException e) {
			System.err.println("Error de I/O: " + e.getMessage());
		}
	}

	private static void leerTexto() {

		String linea;

		try {

			// FileReader archivo = new FileReader(RUTA_TEXTO);
			FileInputStream archivo = new FileInputStream(RUTA_TEXTO);
			InputStreamReader charset = new InputStreamReader(archivo);
			BufferedReader buffer = new BufferedReader(charset);

			// Megasimplificacion
			// BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(RUTA_TEXTO)));

			/* El metodo readLine() lee una linea de texto. Una linea se considera terminada por cualquiera de un avance de linea
			 * ('\n'), un retorno de carro ('\r') o un retorno de carro seguido inmediatamente por un salto de linea. */
			while ((linea = buffer.readLine()) != null)
				System.out.println(linea);

			buffer.close();

		} catch (IOException e) {
			System.err.println("Error de I/O: " + e.getMessage());
		}
	}

	static void escribirTexto() {

		try {

			FileWriter salida = new FileWriter("c:/users/juand/Desktop/texto.txt", true);
			BufferedWriter buffer = new BufferedWriter(salida);

			buffer.write("Ola k ase!");

			buffer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
