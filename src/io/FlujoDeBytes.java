package io;

import java.io.*;

/**
 * Las clases FileInputStream y FileOutputStream, hacen posible leer y escribir un archivo como un flujo de bytes.
 * 
 * https://mkyong.com/java/java-read-a-file-from-resources-folder/
 * http://tutorials.jenkov.com/java-io/index.html
 * 
 * Teniendo en cuanta que InputStream es una clase abstracta, entonces se utiliza el cargador de clases para obtener
 * el recurso especificado (un archivo de texto en este caso) como un flujo de bytes.
 * InputStream input = getClass().getClassLoader().getResourceAsStream(TEXTS_PATH + S + FILENAME);
 * 
 * -Rendimiento de lectura
 * Leer un array de bytes a la vez es mas rapido que leer un solo byte a la vez desde un FileInputStream. La
 * diferencia puede ser facilmente un factor 10 o mas en el aumento del rendimiento, al leer un array de bytes en
 * lugar de leer un solo byte a la vez.
 * 
 * La aceleracion exacta obtenida depende del tamaño de el array de bytes que lee y del sistema operativo, hardware,
 * etc. de la computadora en la que esta ejecutando el codigo. Debe estudiar los tamaños de buffer del disco duro, etc.
 * del sistema de destino antes de tomar una decision. Sin embargo, los tamaños de buffer de 8 Kb y superiores
 * proporcionaran una buena aceleracion. Sin embargo, una vez que su array de bytes exceda la capacidad del sistema
 * operativo y el hardware subyacentes, no obtendra una mayor aceleracion de un array de bytes mas grande.
 * 
 * Probablemente tendra que experimentar con diferentes tamaños de array de bytes y medir el rendimiento de lectura
 * para encontrar el tamaño de array de bytes optimo.
 * 
 * -Rendimiento de escritura
 * Es mas rapido escribir un array de bytes en un FileOutputStream que escribir un byte a la vez. La
 * aceleracion puede ser bastante significativa, hasta 10 veces mayor o mas. Por lo tanto, se recomienda utilizar los
 * metodos de escritura a travez de un array siempre que sea posible.
 * 
 * La aceleracion exacta que obtiene depende del sistema operativo subyacente y el hardware de la computadora en la que
 * ejecuta el codigo Java. La aceleracion depende de cuestiones como la velocidad de la memoria, la velocidad del disco
 * duro y el tamaño del buffer.
 * 
 * Ejemplo de ineficiencia escribiendo un byte a la vez:
 * 
 * <code>
 * 	for (int i = 0; i < 10; i++)
 * 		output.write(i);
 * </code>
 * 
 * - Flush
 * Cuando escribe datos en un FileOutputStream, los datos pueden almacenarse en cache internamente en la memoria
 * de la computadora y escribirse en el disco en un momento posterior. Por ejemplo, cada vez que hay X cantidad de datos
 * para escribir, o cuando se cierra FileOutputStream.
 * 
 * Si desea asegurarse de que todos los datos escritos se escriban en el disco sin tener que cerrar FileOutputStream,
 * puede llamar al metodo flush(). Llamar a flush() se asegurara de que todos los datos que se han escrito en
 * FileOutputStream hasta ahora, tambien se escriban por completo en el disco.
 * 
 * <code>output.flush();</code>
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
	private static final String TEXTURE_FILENAME = "bola_amarilla2.png";

	public FlujoDeBytes(File file) {
		this.file = file;
	}

	/**
	 * Crea un flujo de entrada para el archivo de imagen, lee los bytes y los alamcena en un array.
	 * 
	 * @return Devuelve el array de bytes con los datos de la imagen o null si no se pudo leer.
	 */
	private byte[] readTexture() {

		// https://stackoverflow.com/questions/3621067/why-is-the-range-of-bytes-128-to-127-in-java#:~:text=8%20Answers&text=The%20answer%20is%20two's%20complement,a%207-bit%20unsigned%20integer.
		byte[] bytes = null; // Array para alamcenar bytes con signo (-128 a 127)
		int[] Ubytes = null; // Array para almacenar bytes sin singo/sin firmar (0 a 255)

		int byte_, i = 0;

		try {

			input = new FileInputStream(file);

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.getChannel().size() + " bytes");

			/* Inicializa el array tomando el tamaño total de la imagen. Esto resulta eficiente en terminos de rendimiento ya que no
			 * se estarian creando espacios sobrantes como en el caso de un array convencional (new byte[1024]). */
			bytes = new byte[(int) input.getChannel().size()];
			Ubytes = new int[(int) input.getChannel().size()];

			/* Lee un byte de los datos del flujo de entrada. Si devuelve -1, no hay mas datos para leer y se puede cerrar. Es
			 * decir, -1 como int, no como byte. ¡Hay una diferencia aqui! Por lo tanto, es necesario inspeccionar el valor devuelto
			 * por estas llamadas al metodo read() por medio de un bucle while. */
			while ((byte_ = input.read()) != -1) {
				bytes[i] = (byte) byte_; // Convierte el byte sin firma a un byte con signo y lo almacena
				Ubytes[i] = byte_; // Almacena el byte sin firma
				i++;
			}

			for (i = 0; i < bytes.length; i++)
				System.out.println("byte en el bloque " + i + " > byte = " + bytes[i] + ", Ubyte = " + Ubytes[i]);

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

		return bytes;

	}

	/**
	 * Crea un flujo de salida hacia un nuevo archivo de imagen y escribe los bytes de la imagen recibidos en la nueva.
	 * 
	 * @param bytes[] - Los bytes leidos de la imagen.
	 */
	private void writeTexture(byte[] bytes) {
		try {

			// Crea un archivo llamado "dragon_copia.png"
			output = new FileOutputStream(new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTURE_PATH + S + "dragon_copia.png"));

			output.write(bytes);

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

	/**
	 * Crea un flujo de entrada para el archivo de texto, lee los caracteres como bytes y los almacena en un array. Este
	 * metodo se bloquea si aun no hay ninguna entrada disponible.
	 * <p>
	 * FileInputStream esta diseñado para leer flujos de bytes sin procesar, como datos de imagen. Para leer
	 * secuencias de caracteres, considere usar FileReader (ver {@link FlujoDeCaracteres#read}).
	 */
	private void readText() {

		/* El tamaño del array tiene que ser mayor al tamaño del archivo, por eso es importante saber de antemano ese tamaño.
		 * Si el tamaño del archivo es menor al espacio del array, entonces se asignaran 0 a los espacios sobrantes. */
		final int size = 100;

		byte[] bytes = new byte[size];

		try {

			input = new FileInputStream(file);

			/* Devuelve el numero total de bytes leidos en el buffer, o -1 si no hay mas datos porque se ha alcanzado el final del
			 * archivo. */
			input.read(bytes);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...\n" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informacion...\n");
			e.printStackTrace();
		} finally {
			try {
				if (input != null) input.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de entrada!");
			}
		}

	}

	/**
	 * Crea un flujo de salida hacia el archivo de texto y escribe los bytes del mensaje.
	 * <p>
	 * FileOutputStream esta diseñado para escribir flujos de bytes sin procesar, como datos de imagen. Para escribir
	 * secuencias de caracteres, considere usar FileWriter (ver {@link FlujoDeCaracteres#write}).
	 * 
	 * @param mensaje - El mensaje que se va a escribir.
	 * @param append  - Si es verdadero, los datos se escribiran al final del archivo en lugar de sobreescribirlos.
	 */
	private void writeText(String mensaje, boolean append) {

		/* Codifica el mensaje en una secuencia de bytes usando el juego de caracteres predeterminado de la plataforma,
		 * almacenando el resultado en un nuevo array de bytes. */
		byte[] bytes = mensaje.getBytes(); // TODO "utf-8"?

		try {

			output = new FileOutputStream(file, append);

			output.write(bytes);

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

		FlujoDeBytes texture = new FlujoDeBytes(new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTURE_PATH + S + TEXTURE_FILENAME));
		texture.readTexture();
		// texture.writeTexture(bytes);

		/* No hay ninguna ventaja en particular al usar un String o un File para especificar la ruta del archivo, la unica
		 * diferencia es que usando un objeto File, este puede ser mas manipulable a travez de sus metodos. */
		// FlujoDeBytes text = new FlujoDeBytes(new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTURE_PATH + S +
		// TEXTURE_FILENAME));
		// text.readText();
		// text.writeText("Tostado", false);

	}

}
