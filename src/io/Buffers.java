package io;

import java.io.*;

import static util.Constants.*;

/**
 * FileOuputStream, FileInputStream, FileWriter y FileReader se utilizan para escribir o leer datos en memoria.
 * BufferedOutputStream, BufferedInputStream, BufferedWriter y BufferedReader, añaden un buffer intermedio encargado
 * de controlar el acceso a la memoria.
 * Caracteristicas de los buffers en java:
 * -Si vamos escribiendo, se guardaran los datos hasta que tenga basantes como para hacer la escritura eficiente.
 * -Si queremos leer, la clase leera muchos datos de golpe, aunque solo nos de los que hayamos pedido. En las siguientes
 * lecturas nos dara lo que tiene almacenado, hasta que necesite leer otra vez.
 * 
 * Esta forma de trabajar hace que el acceso al disco sea mas eficiente y el programa corra mas rapido. La diferencia se
 * notara mas cuanto mayor sea el fichero que queramos leer o escribir.
 * 
 * La clave en las clases que comienzan con Buffered es que usan un buffer. Digamos que es una memoria interna que
 * normalmente hace que esas clases sean mas eficientes, es decir, es esperable que un BufferedInputStream sea mas
 * rapido que el flujo ordinario. El flujo normal tiene que estar llamando y accediendo a la memoria por cada byte
 * que quiera devolver, resultando ineficiente y consumiendo muchos recursos, siempre y cuando no se haya agregado un
 * buffer casero. En cambio el buffer accede a la memoria una vez y recolecta un array de bytes.
 * Cuando se le llama al metodo read() ya no tiene que acceder a la memoria, sino que devuelve la informacion del buffer
 * interno. En algun momento el buffer interno se agota, pero mientras esto ocurre se han ahorrado un monton de
 * procesos.
 * 
 * Puede agregar lectura y almacenamiento en buffers transparentes y automaticos de un array de bytes desde un
 * FileInputStream utilizando un BufferedInputStream. BufferedInputStream lee un fragmento de bytes en un array
 * de bytes del FileInputStream subyacente. Luego puede leer los bytes uno por uno desde BufferedInputStream y aun asi
 * obtener gran parte de la aceleracion que proviene de leer un array de bytes en lugar de un byte a la vez.
 * 
 * El BufferedInputStream se usa para leer bytes y el BufferedReader para caracteres
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class Buffers {

	private File file;

	private FileInputStream input;
	private FileOutputStream output;

	private InputStreamReader charset;

	private BufferedInputStream streamBuffer;
	private BufferedReader characterBuffer;

	public Buffers(File file) {
		this.file = file;
	}

	/**
	 * Crea un flujo de entrada para el archivo de imagen y le agrega un buffer de 8192 bytes.
	 */
	private void readTexture() {

		int UInt8, i = 0;

		try {

			input = new FileInputStream(file);
			streamBuffer = new BufferedInputStream(input);

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.available() + " bytes / " + ((double) input.available() / 1024) + " Kb");

			System.out.println("Decodificando...");

			/* Lee el siguiente byte de datos de este flujo de entrada. El byte de valor se devuelve como un int en el rango de 0 a
			 * 255. */
			while ((UInt8 = streamBuffer.read()) != -1)
				System.out.println("bloque " + (i++) + " > UInt8 = " + UInt8);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informaion...");
			e.printStackTrace();
		} finally {
			try {
				if (input != null) input.close(); // FIXME Que cierro aca?
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de entrada!\nMas informacion...");
				e.printStackTrace();
			}
		}
	}

	private void readText() {

		String linea;
		int b;

		try {

			// input = new FileInputStream(file);
			// charset = new InputStreamReader(input);
			// characterBuffer = new BufferedReader(charset);

			// Megasimplificacion
			characterBuffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			/* El metodo readLine() lee una linea de texto. Una linea se considera terminada por cualquiera de un avance de linea
			 * ('\n'), un retorno de carro ('\r') o un retorno de carro seguido inmediatamente por un salto de linea. */
			while ((linea = characterBuffer.readLine()) != null)
				System.out.println(linea);

			// TODO Calcular el tiempo
//			while ((b = input.read()) != -1)
//				System.out.print((char) b);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informaion...");
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

	private void writeText() {

		try {

			FileWriter salida = new FileWriter("c:/users/juand/Desktop/texto.txt", true);
			BufferedWriter buffer = new BufferedWriter(salida);

			buffer.write("Ola k ase!");

			buffer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Buffers texture = new Buffers(new File(BOLA_AMARILLA2));
		// texture.readTexture();

		Buffers text = new Buffers(new File(TEXT_GRANDE));
		text.readText();
	}

}
