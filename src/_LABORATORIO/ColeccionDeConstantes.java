package _LABORATORIO;

/**
 * COLECCION DE CONSTANTES SIN RELACION.
 * 
 * Clase final con constructor privado, haciendo imposible extenderla o crear instancias, enviando
 * un fuerte mensaje de que no contiene funcionalidad/datos no estaticos.
 * 
 * Conceptualmente, una enumeracion es una mala eleccion si las constantes no estan relacionadas (como en este caso).
 * Una enumeracion representa valores alternativos del mismo tipo. Estas constantes no son alternativas y es posible que
 * ni siquiera sean del mismo tipo (algunas pueden ser cadenas, algunas enteras, etc.).
 * 
 * https://en.wikipedia.org/wiki/Constant_interface
 * https://stackoverflow.com/questions/320588/interfaces-with-static-fields-in-java-for-sharing-constants
 * https://stackoverflow.com/questions/479565/how-do-you-define-a-class-of-constants-in-java
 */

public final class ColeccionDeConstantes {

	private ColeccionDeConstantes() {
	}

	/**
	 * Es buena practica declarar matrices de bytes para la asignacion de valores chicos, ya que los tipos mas pequeños
	 * (byte y short) basicamente solo estan destinados a matrices. Una matriz como new byte[1000] tomara 1000 bytes, y una
	 * matriz como new int[1000] tomara 4000 bytes. byte y short ocupan el mismo espacio que int si fueran variables
	 * locales, variables de clase o incluso variables de instancia. ¿Por que? Porque en (la mayoria) los sistemas
	 * informaticos, las direcciones de las variables estan alineadas, por lo que, por ejemplo, si usa un solo byte, en
	 * realidad terminara con dos bytes, uno para la variable en si y otro para el relleno.
	 * 
	 * De nada :)
	 * https://stackoverflow.com/questions/14531235/in-java-is-it-more-efficient-to-use-byte-or-short-instead-of-int-and-float-inst/14532302#14532302
	 * https://stackoverflow.com/questions/27122610/why-does-the-java-api-use-int-instead-of-short-or-byte
	 *
	 * Si nos fijamos en la constantes de las famosas clases GL11 (lwjgl) y Calendar (API Java), todas estan declaradas como
	 * int.
	 */
	public static final byte[] MODIFICADOR_FUERZA = { 1, 2, 3 };

	public static final int N1 = 1;
	public static final int N2 = 2;
	public static final int N3 = 3;

	public static final String[] SKILLS = { "Numero 1", "Numero 2", "Numero 3" };

	public static final String SEPARADOR = java.io.File.separator;
	public static final String DATDIR = "assets" + SEPARADOR + "dat";

}
