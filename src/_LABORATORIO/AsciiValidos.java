package _LABORATORIO;

public class AsciiValidos {

	public static void main(String[] args) {

		if (asciiValidos("Juan")) System.out.println("Es valido!");
		else System.out.println("No es valido!");

	}

	// Ascii validos de a-z
	static boolean asciiValidos(String srt) {

		byte[] bytes;

		bytes = srt.toLowerCase().getBytes();

		for (byte b : bytes)
			/* Si el caracter es menor a 'a' o mayor a 'z' y distinto a 'espacio en blanco' (32) y distinto a 'espacio sin
			 * separacion', entonces no es una cadena valida. */
			if ((b < 97 || b > 122) && b != 255 && b != 32) return false;
		return true;

	}

}
