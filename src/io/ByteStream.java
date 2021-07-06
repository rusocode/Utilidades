package io;

import java.io.*;

import static util.Constants.*;

/**
 * Las clases FileInputStream y FileOutputStream, hacen posible leer y escribir un archivo como un flujo de bytes.
 * 
 * -Codificacion Unicode UTF-8
 * Supongamos que tenemos una hoja de texto con el mensaje "Tostado", entonces si nosotros creamos un flujo
 * que lo podriamos definir como un "tubo", este se encargaria de transformar el "code point" a su representacion
 * en un caracter en el caso de una lectura. Tomando como ejemplo el code point U+0054 definido por el formato Unicode,
 * este se decodificaria a un caracter representando la letra T mayuscula.
 * Unicode es un formato universal y unico, que representa mas de 130000+ caracteres de todo el mundo.
 * Es importante aclarar que el metodo read() del flujo obtiene el code point como un numero entero entre un rango
 * determinado por Unicode. En el ejemplo anterior usamos el codigo U+0054 que seria 54 en en hexadecimal, 84 en decimal
 * y finalmente 01010100 en binario, haciendo posible su envio a travez de la red. En este caso, el codepoint U+0054
 * ocupa 2 bytes, ya que el byte sobrante...
 * Los bytes sin signo representan los numeros entre 0 y 127 ambos incluidos, que serian los code point usados por el
 * formato ASCII ocupando 1 byte en memoria.
 * https://stackoverflow.com/questions/3621067/why-is-the-range-of-bytes-128-to-127-in-java#:~:text=8%20Answers&text=The%20answer%20is%20two's%20complement,a%207-bit%20unsigned%20integer.
 * 
 * -Rendimiento de lectura usando buffers
 * Teniendo una base del funcionamiento de Unicode, podriamos decir que el tubo (flujo) almacena el code point en un
 * buffer de una capacidad determinada. Usamos un buffer para que el tubo pueda leer los code point mucho mas rapido que
 * las lecturas nativas de bytes uno por uno.
 * La aceleracion exacta obtenida depende del tamaño de el array de bytes que lee y del sistema operativo, hardware,
 * etc. de la computadora en la que esta ejecutando el codigo. Debe estudiar los tamaños de buffer del disco duro, etc.
 * del sistema de destino antes de tomar una decision. Sin embargo, los tamaños de buffer de 8 Kb (8192) y superiores
 * proporcionaran una buena aceleracion. Por ejemplo, si un archivo contiene 81920 bytes (80 kb), el archivo
 * input.read() predeterminado requerira 81920 llamadas nativas para leer todos los bytes del archivo; Mientras que
 * input.read(buffer) (con un tamaño de buffer de 8192), solo necesitamos 10 llamadas nativas. La diferencia es enorme.
 * Sin embargo, una vez que su array de bytes exceda la capacidad del sistema operativo y el hardware subyacentes, no
 * obtendra una mayor aceleracion de un array de bytes mas grande.
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

public class ByteStream {

	private File file;
	private FileInputStream input;
	private FileOutputStream output;

	/** Crea un flujo para el archivo usando un objeto File. */
	public ByteStream(File file) {
		this.file = file;
	}

	/**
	 * Crea un flujo de entrada para el archivo de texto y hace llamadas nativas, en donde decodifica el "code point"
	 * utilizando el formato predetermiando de la plataforma.
	 * Este metodo se bloquea si aun no hay ninguna entrada disponible.
	 */
	private void readText() {

		int codepoint, i = 0;

		char[] chars = null; // Array para almacenar caracteres
		byte[] bytes = null; // Array para alamcenar bytes con signo (-128 a 127)
		int[] Ubytes = null; // Array para almacenar enteros sin singo/sin firmar (0 a 255)

		try {

			input = new FileInputStream(file);

			/* Inicializa los arrays de diferentes formas, tomando el tamaño total del archivo.
			 * 
			 * FIXME ¿Esto resulta eficiente en terminos de rendimiento ya que no se estarian creando espacios sobrantes como en el
			 * caso de un array convencional de 8192 posiciones? */
			chars = new char[(int) input.getChannel().size()];
			bytes = new byte[(int) file.length()];
			Ubytes = new int[input.available()];

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.available() + " bytes");

			/* Lee el archivo de texto byte por byte, en donde se devuelve el code point en cada llamada nativa al sistema
			 * operativo, resultado bastante ineficiente para lecturas de archivos grandes, pero en este caso lo usamos de prueba.
			 * El -1 indica el final del archivo. Es decir, -1 como int, no como byte, por lo tanto, es necesario inspeccionar el
			 * valor devuelto por estas llamadas al metodo read() por medio de un bucle while. */
			while ((codepoint = input.read()) != -1) {
				chars[i] = (char) codepoint; // Decodifica el code point a caracter
				bytes[i] = (byte) codepoint; // Decodifica el code point a byte con signo
				Ubytes[i] = codepoint; // U = unsigned
				i++;
			}

			System.out.println("Decodificando...");

			for (i = 0; i < bytes.length; i++)
				System.out.println("bloque " + i + " > caracter = " + chars[i] + ", byte = " + bytes[i] + ", Ubyte = " + Ubytes[i]);

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
	 * Crea un flujo de salida hacia el archivo de texto y escribe el array de bytes del mensaje.
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

	/**
	 * Crea un flujo de entrada para el archivo de imagen y lee desde el buffer.
	 * 
	 * Es importante aclarar que el metodo read del flujo de entrada, recibe un array de bytes (buffer), en donde es llenado
	 * por los bytes del archivo. La lectura la hacemos nosotros mismo a travez del metodo for.
	 */
	private void readTexture() {

		byte[] buffer = new byte[BUFFER_SIZE];

		try {

			input = new FileInputStream(file);

			System.out.println("Archivo: " + file.getName());
			System.out.println("Ruta: " + file.getPath());
			System.out.println("Tamaño: " + input.available() + " bytes");

			while (input.read(buffer) != -1) {
				for (int i = 0; i < buffer.length; i++)
					System.out.println("bloque " + i + " > byte = " + buffer[i]);
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

	}

	/**
	 * Crea un flujo de salida hacia un nuevo archivo de imagen y escribe los bytes recibidos en una nueva imagen.
	 * 
	 * @param bytes[] - Los bytes leidos de la imagen.
	 */
	private void writeTexture(byte[] bytes) {
		try {

			// Crea un archivo llamado "dragon_copia.png"
			output = new FileOutputStream(new File(getTextureDir() + "dragon_copia.png"));

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

		ByteStream texture = new ByteStream(new File(BOLA_AMARILLA2));
		// texture.readTexture();
		// texture.writeTexture(bytes);

		ByteStream text = new ByteStream(new File(TEXT));
		text.readText();
		// text.writeText("Tostado", false);

	}

}
