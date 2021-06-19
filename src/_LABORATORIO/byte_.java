package _LABORATORIO;

/**
 * 
 * En java, ¿es mas eficiente usar byte o short en lugar de int y float en lugar de double?
 * https://stackoverflow.com/questions/14531235/in-java-is-it-more-efficient-to-use-byte-or-short-instead-of-int-and-float-inst
 * 
 * 
 * ¿Por que la API de Java usa int en lugar de short o byte? *ALTA EXPLICACION!!
 * https://stackoverflow.com/questions/27122610/why-does-the-java-api-use-int-instead-of-short-or-byte
 * 
 * ¿Por que la API de Java usa int en lugar de short o byte?
 * "...(Casi) todas las operaciones en bytes/short promoveran estas primitivas a int"
 * ¿POR QUE se promueve a estos tipos int?
 * Entonces, para ir un nivel mas profundo: la respuesta puede estar simplemente relacionada con el conjunto de
 * instrucciones de la maquina virtual Java. Como se resume en la Tabla en la Especificacion de la maquina virtual de
 * Java, todas las operaciones aritmeticas integrales, como sumar, dividir y otras, solo estan disponibles para el tipo
 * int y el tipo long, y no para los tipos mas pequeños.
 * 
 * (Un aparte: los tipos mas pequeños (bytey y short) basicamente solo estan destinados a matrices. Una matriz como new
 * byte[1000] tomara 1000 bytes, y una matriz como new int[1000] tomara 4000 bytes)
 * byte y short ocupan el mismo espacio que int si fueran variables locales, variables de clase o incluso variables de
 * instancia. ¿Por que? Porque en (la mayoria) de los sistemas informaticos, las direcciones de las variables estan
 * alineadas, por lo que, por ejemplo, si usa un solo byte, en realidad terminara con dos bytes, uno para la variable
 * en si y otro para el relleno.
 * Por otro lado, en las matrices, byte toma 1 byte, short toma 2 bytes y int toma 4 bytes, porque en las matrices
 * solo el inicio y tal vez el final tiene que estar alineado. Esto marcara la diferencia en caso de que quiera usar,
 * por ejemplo System.arraycopy(), entonces realmente notara una diferencia de rendimiento.
 * 
 * Ahora, por supuesto, se podria decir que "... la siguiente pregunta obvia seria: ¿POR QUE estas instrucciones solo se
 * ofrecen para int (y long)?".
 * 
 * Una razon se menciona en la especificacion JVM mencionada anteriormente:
 * 
 * Si cada instruccion escrita admitiera todos los tipos de datos en tiempo de ejecucion de la maquina virtual Java,
 * habria mas instrucciones de las que podrian representarse en un byte.
 * 
 * Ademas, la maquina virtual Java se puede considerar como una abstraccion de un procesador real. E introducir una
 * Unidad Aritmetica Logica dedicada para tipos mas peque�os no valdria la pena el esfuerzo: necesitaria transistores
 * adicionales, pero aun asi solo podria ejecutar una adicion en un ciclo de reloj. La arquitectura dominante cuando se
 * diseño la JVM era de 32 bits, justo para una de 32 bits int. (Las operaciones que involucran un valor long de 64 bits
 * se implementan como un caso especial).
 * 
 * https://asm86.wordpress.com/2008/12/27/%C2%BFcuantos-bits-tiene-un-byte/#:~:text=Si%20sumamos%20128%20%2B%2064%20%2B%2032,representar%20con%20un%20solo%20byte.
 * 
 */

public class byte_ {

	// ¿Por que no se pueden almacenar numeros mayores a 127?
	// https://stackoverflow.com/questions/3621067/why-is-the-range-of-bytes-128-to-127-in-java#:~:text=8%20Answers&text=The%20answer%20is%20two's%20complement,a%207-bit%20unsigned%20integer.
	static byte b = 127;

	public static void main(String[] args) {

		System.out.println("El valor maximo de un byte es = " + Byte.MAX_VALUE);
		System.out.println("El valor minimo de un byte es = " + Byte.MIN_VALUE);

		System.out.println(++b);
	}

}
