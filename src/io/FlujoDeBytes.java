package io;

import java.io.*;

/**
 * Las clases FileInputStream y FileOutputStream, hacen posible leer y escribir un archivo como un flujo de bytes.
 * 
 * https://mkyong.com/java/java-read-a-file-from-resources-folder/
 * http://tutorials.jenkov.com/java-io/index.html
 * 
 * TODO Agregar un metodo para lectura de imagenes, aprovechando la ocasion del flujo de bytes
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class FlujoDeBytes {

	private File file;

	private FileInputStream input;
	private FileOutputStream output;

	private static final String S = File.separator;
	private static final String ASSETS = "assets";
	private static final String TEXTS_PATH = "texts";
	private static final String TEXTURE_PATH = "textures";
	private static final String TEXT_FILENAME = "text.txt";
	private static final String TEXTURE_FILENAME = "dragon.png";

	public FlujoDeBytes(File file) {
		this.file = file;
	}

	/**
	 * Lee una matriz de bytes del flujo de entrada. Este metodo se bloquea si aun no hay ninguna entrada disponible.
	 * <p>
	 * FileInputStream esta diseñado para leer flujos de bytes sin procesar, como datos de imagen. Para leer
	 * secuencias de caracteres, considere usar FileReader (ver {@link FlujoDeCaracteres#read}).
	 * </p>
	 */
	private void read() {

		// Crea una matriz de bytes con la capacidad de 1 Kb
		byte[] bytes = new byte[1024];

		int byteRead;

		try {

			/* Teniendo en cuanta que InputStream es una clase abstracta, entonces se utiliza el cargador de clases para obtener
			 * el recurso especificado (un archivo de texto en este caso) como un flujo de bytes. */
			// InputStream input = getClass().getClassLoader().getResourceAsStream(TEXTS_PATH + S + FILENAME);

			/* Puede agregar lectura y almacenamiento en buffer transparentes y automaticos de una matriz de bytes desde un
			 * FileInputStream utilizando un BufferedInputStream. BufferedInputStream lee un fragmento de bytes en una matriz
			 * de bytes del FileInputStream subyacente. Luego puede leer los bytes uno por uno desde BufferedInputStream y aun asi
			 * obtener gran parte de la aceleracion que proviene de leer una matriz de bytes en lugar de un byte a la vez. */
			input = new FileInputStream(file);

			/* El metodo read() devuelve el numero total de bytes leidos en el buffer, o -1 si no hay mas datos porque se ha
			 * alcanzado el final del archivo.
			 * 
			 * En caso de que haya menos bytes para leer de los que hay en el espacio de la matriz, o menos de lo que se especifico
			 * en el parametro de longitud, se leeran menos bytes en la matriz de bytes. Si se han leido todos los bytes del
			 * FileInputStream, devolvera -1. Por lo tanto, es necesario inspeccionar el valor devuelto por estas llamadas al metodo
			 * read().
			 *
			 * -Rendimiento de lectura
			 * Leer una matriz de bytes a la vez es mas rapido que leer un solo byte a la vez desde un FileInputStream. La
			 * diferencia puede ser facilmente un factor 10 o mas en el aumento del rendimiento, al leer una matriz de bytes en
			 * lugar de leer un solo byte a la vez.
			 * 
			 * La aceleracion exacta obtenida depende del tamaño de la matriz de bytes que lee y del sistema operativo, hardware,
			 * etc. de la computadora en la que esta ejecutando el codigo. Debe estudiar los tamaños de buffer del disco duro, etc.
			 * del sistema de destino antes de tomar una decision. Sin embargo, los tamaños de buffer de 8 Kb y superiores
			 * proporcionaran una buena aceleracion. Sin embargo, una vez que su matriz de bytes exceda la capacidad del sistema
			 * operativo y el hardware subyacentes, no obtendra una mayor aceleracion de una matriz de bytes mas grande.
			 * 
			 * Probablemente tendra que experimentar con diferentes tamaños de matriz de bytes y medir el rendimiento de lectura
			 * para encontrar el tamaño de matriz de bytes optimo. */

			while ((byteRead = input.read(bytes)) != -1)
				System.out.print(byteRead);
			System.out.println(" bytes leidos de " + TEXT_FILENAME);

			// TODO No estara al pedo el ciclo while?
			// System.out.println(input.read(bytes));

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
	 * Escribe una matriz de bytes en el flujo de salida.
	 * <p>
	 * FileOutputStream esta diseñado para escribir flujos de bytes sin procesar, como datos de imagen. Para escribir
	 * secuencias de caracteres, considere usar FileWriter (ver {@link FlujoDeCaracteres#write}).
	 * </p>
	 * 
	 * @param texto  - El texto que se va a escribir.
	 * @param append - Si es verdadero, los datos se escribiran al final del archivo en lugar de sobreescribirlos.
	 */
	private void write(String texto, boolean append) {

		/* Codifica esta cadena en una secuencia de bytes usando el juego de caracteres predeterminado de la plataforma,
		 * almacenando el resultado en una nueva matriz de bytes. */
		byte[] bytes = texto.getBytes();

		try {

			output = new FileOutputStream(file, append);

			/* -Rendimiento de escritura
			 * Es mas rapido escribir una matriz de bytes en un FileOutputStream que escribir un byte a la vez. La
			 * aceleracion puede ser bastante significativa, hasta 10 veces mayor o mas. Por lo tanto, se recomienda utilizar los
			 * metodos de escritura (byte[]) siempre que sea posible.
			 * 
			 * La aceleracion exacta que obtiene depende del sistema operativo subyacente y el hardware de la computadora en la que
			 * ejecuta el codigo Java. La aceleracion depende de cuestiones como la velocidad de la memoria, la velocidad del disco
			 * duro y el tamaño del buffer. */
			output.write(bytes);

			// Escribe un byte a la vez en el flujo de salida (ineficiencia)
			/* for (int i = 0; i < 10; i++)
			 * output.write(i); */

			/* Cuando escribe datos en un FileOutputStream, los datos pueden almacenarse en cache internamente en la memoria
			 * de la computadora y escribirse en el disco en un momento posterior. Por ejemplo, cada vez que hay X cantidad de datos
			 * para escribir, o cuando se cierra FileOutputStream.
			 * 
			 * Si desea asegurarse de que todos los datos escritos se escriban en el disco sin tener que cerrar FileOutputStream,
			 * puede llamar al metodo flush(). Llamar a flush() se asegurara de que todos los datos que se han escrito en
			 * FileOutputStream hasta ahora, tambien se escriban por completo en el disco. */

			// output.flush();

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

	private void readTexture() {

		// Crea una matriz de bytes con la capacidad de 2 Kb
		byte[] bytes = new byte[1024 * 2];
		int byte_, i = 0;

		try {

			input = new FileInputStream(file);

			while ((byte_ = input.read()) != -1)
				bytes[i++] = (byte) byte_;

			System.out.println(i);

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

	public static void main(String[] args) {

		/* No hay ninguna ventaja en particular al usar un String o un File para especificar la ruta del archivo, la unica
		 * diferencia es que usando un objeto File, este puede ser mas manipulable a travez de sus metodos. */
		FlujoDeBytes texto = new FlujoDeBytes(new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + TEXT_FILENAME));
		// texto.read();
		// texto.write("Tostado", false);

		FlujoDeBytes imagen = new FlujoDeBytes(new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTURE_PATH + S + TEXTURE_FILENAME));
		imagen.readTexture();
	}

}
