package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Las clases FileInputStream y FileOutputStream, hacen posible leer y escribir un archivo como un flujo de bytes.
 * 
 * -Codificacion Unicode UTF-8
 * Supongamos que tenemos una hoja de texto con el mensaje "Tostado", entonces si nosotros creamos un flujo
 * que lo podriamos definir como un "tubo", este se encargaria de transformar el "code point" a su representacion
 * en un caracter.
 * Tomando como ejemplo el "code point" U+0054 definido por el formato Unicode, podriamos tomar ese codigo para
 * decodificarlo a un caracter, en este caso U+0054 representa la T mayuscula.
 * Unicode es un formato universal y unico, que representa mas de 130000+ caracteres de todo el mundo.
 * Es importante aclarar que el "code point" es un numero decimal sin firmar, es decir un numero entre 0 y 255 ambos
 * incluidos, que representa 1 byte en memoria. En el ejemplo anterior usamos el codigo U+0054 que seria 54 en
 * en hexadecimal, 84 en decimal y finalmente 01010100 en binario, haciendo posible su envio a travez de la red.
 * 
 * -Rendimiento de lectura usando buffers
 * Teniendo una base del funcionamiento de Unicode, podriamos decir que el "tubo" almacena el "code point" en un buffer
 * de x bytes. Usamos un buffer para que el "tubo" pueda leer los "code point" mucho mas rapido que las lecturas nativas
 * de bytes uno por uno.
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
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class ByteStream implements Constants {

	private File file;
	private FileInputStream input;
	private FileOutputStream output;

	/** Crea un flujo para el archivo usando un objeto File. */
	public ByteStream(File file) {
		this.file = file;
	}

	/**
	 * Crea un flujo de entrada para el archivo de imagen, lee los bytes y los alamcena en un array.
	 * 
	 * @return Devuelve el array de bytes con los datos de la imagen o null si no se pudo leer.
	 */
	private byte[] readTexture() {

		byte[] bytes = null;

		try {

			input = new FileInputStream(file);

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.available() + " bytes");

			bytes = new byte[input.available()];

			while (input.read(bytes) != -1) {
				for (int i = 0; i < bytes.length; i++)
					System.out.println("bloque " + i + " > byte = " + bytes[i]);
			}

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
			System.err.println("El archivo no existe!\nMas informacion...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informacion...");
			e.printStackTrace();
		} finally {
			try {
				if (output != null) output.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de salida!\nMas informacion...");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Crea un flujo de entrada para el archivo de imagen, lee la secuencia y muestra los bytes con signo y sin signo.
	 */
	private void showTextureInfo() {

		// https://stackoverflow.com/questions/3621067/why-is-the-range-of-bytes-128-to-127-in-java#:~:text=8%20Answers&text=The%20answer%20is%20two's%20complement,a%207-bit%20unsigned%20integer.
		byte[] bytes = null; // Array para alamcenar bytes con signo (-128 a 127)
		int[] Ubytes = null; // Array para almacenar bytes sin singo/sin firmar (0 a 255)

		int byte_, i = 0;

		try {

			input = new FileInputStream(file);

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.available() + " bytes");

			/* Inicializa el array tomando el tamaño total de la imagen. Esto resulta eficiente en terminos de rendimiento ya que no
			 * se estarian creando espacios sobrantes como en el caso de un array convencional (new byte[1024]). */
			bytes = new byte[(int) input.getChannel().size()];
			Ubytes = new int[(int) input.getChannel().size()];

			/* Lee un byte de los datos del flujo de entrada. Si devuelve -1, no hay mas datos para leer y se puede cerrar. Es
			 * decir, -1 como int, no como byte. ¡Hay una diferencia aqui! Por lo tanto, es necesario inspeccionar el valor devuelto
			 * por estas llamadas al metodo read() por medio de un bucle while. */
			while ((byte_ = input.read()) != -1) {
				bytes[i] = (byte) byte_; // Convierte el byte sin firma a un byte con signo y lo almacena
				Ubytes[i] = byte_; // Almacena el byte sin firma (U = unsigned)
				i++;
			}

			for (i = 0; i < bytes.length; i++)
				System.out.println("bloque " + i + " > byte = " + bytes[i] + ", Ubyte = " + Ubytes[i]);

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

	/**
	 * Crea un flujo de entrada para el archivo de texto y hace llamadas nativas o llamadas a un buffer dependiendo del
	 * caso, en donde decodifica el "code point" utilizando el formato predetermiando de la plataforma.
	 * Este metodo se bloquea si aun no hay ninguna entrada disponible.
	 */
	private void readText() {

		/* Si el tamaño del archivo es menor al espacio del array, entonces se asignaran caracteres de espacio a los lugares
		 * sobrantes del array. */
		byte[] buffer = new byte[BUFFER_SIZE];

		try {

			input = new FileInputStream(file);

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.available() + " bytes");
			System.out.println("-Texto-");

			/* Podemos usar la lectura read(byte[] b) para leer bytes predefinidos en un array de bytes; aumentara
			 * significativamente el rendimiento de lectura. En este caso lee 8192 bytes a la vez, si es el final del archivo,
			 * devuelve -1.
			 * Por ejemplo, si un archivo contiene 81920 bytes (80 kb), el archivo input.read() predeterminado requerira 81920
			 * llamadas nativas para leer todos los bytes del archivo; Mientras que input.read(buf) (para un tamaño de 8192), solo
			 * necesitamos 10 llamadas nativas. La diferencia es enorme. */
			while (input.read(buffer) != -1)
				System.out.println(new String(buffer)); // Decodifica la matriz de bytes en el formato predeterminado del host

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe!\nMas informacion...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informacion...");
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

	/**
	 * Crea un flujo de salida hacia el archivo de texto y escribe los bytes del mensaje.
	 * <p>
	 * FileOutputStream esta diseñado para escribir flujos de bytes sin procesar, como datos de imagen. Para escribir
	 * secuencias de caracteres, considere usar FileWriter (ver {@link CharacterStream#write}).
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
			System.err.println("El archivo no existe!\nMas informacion...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de I/O!\nMas informacion...");
			e.printStackTrace();
		} finally {
			try {
				if (output != null) output.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el flujo de salida!\nMas informacion...");
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		ByteStream texture = new ByteStream(new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTURE_PATH + S + TEXTURE_FILENAME));
		// texture.readTexture();
		// texture.writeTexture(bytes);

		ByteStream text = new ByteStream(new File(System.getProperty("user.dir") + S + ASSETS + S + TEXTS_PATH + S + TEXT_FILENAME));
		text.readText();
		// text.writeText("Tostado", false);

	}

}
