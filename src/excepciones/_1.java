package excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

/**
 * -Tipos de errores
 * Los errores en java se dividen en errores de compilacion y ejecucion.
 * Los errores de compilacion son los errores de sintaxis (como la falta del famoso ";") y los errores comprobados.
 * Los errores de ejecucion son los errores no comprobados.
 * 
 * Los errores comprobados y no comprobados heredan de la clase Throwable que a su vez esta clase se divide en Error
 * (errores de hardware) y en Exception.
 * De la clase Exception heredan algunas clases como IOException, que por obligacion estas excepciones son comprobadas
 * ya que java tiene previsto este tipo de errores, y por otro lado estan las clases como RuntimeException que son
 * excepciones no comprobadas.
 * La diferencia entre ambas es que las excepciones comprobadas implementan por obligacion la declaracion de control
 * try{}catch(){}, y las no comprobadas, no. Los bloques try{}catch(){} evitan detener el programa por completo
 * capturando la excepcion correspondiente y asi seguir con su ejecucion.
 * 
 * -Excepciones comprobadas
 * Son excepciones en el cual el programador no tiene culpa en absoluto. Para este tipo de errores, java ya tiene
 * previstas situaciones para este tipo de excepciones, es decir, que el propio lenguje de programacion ya las tiene
 * contempladas, por ejemplo, un error en el cual nosotros no tengamos la culpa como es el caso de un IOException, que
 * se produce cuando creamos un programa en el cual necesitamos ir a una carpeta de la computadora donde se esta
 * ejecutando ese programa para obtener una imagen y la imagen no esta. Como este tipo de error es AJENO a nuestra
 * voluntad, java lo tiene "planeado" usando el bloque try-catch.
 * 
 * -Excepciones no comprobadas
 * Las excepciones no comprobadas, no obligan a implementar el bloque try{}catch(){} ya que se
 * podrian evitar mejorando el codigo por parte del programador. Por ejemplo, si queremos acceder a la posicion
 * 6 de un array de 5 posiciones, nos lanzaria la excepcion no comprobada de tipo ArrayIndexOutOfBoundsException. Esto
 * sucede porque estamos pasando el limite del array. ¿Y por que es una excepcion no comprobada? Porque la culpa
 * la tiene el programador, ya que tu como buen programador debes saber que si declaras un array de 5 posiciones no
 * debes rellenar una sexta o no debes recorrer hasta la posicion 6, 8, 9, etc. de ese array.
 * Como cada vez que ocurre un error de estas caracteristicas, lo que realmente esta pasando, es que esa excepcion de
 * tipo ArrayIndexOutOfBoundsException ES LA CLASE A LA QUE PERTENECE EL ERROR QUE ACABAMOS DE GENERAR, es decir, ese
 * objeto pertenece a la clase ArrayIndexOutOfBoundsException.
 * Este tipo de error tiene el inconveniente de que si cometes un error de estas caracteristicas, no se llega a ejecutar
 * ni una sola linea de tu programa. Esto se vuelve un problema cuando por ejemplo tienes un programa de 5000 lineas y
 * si algo falla no se ejecuta ni una sola, entonces quizas te interese que ejecute todo el programa pero la linea que
 * falla no. ESTO LO PODEMOS SOLVENTAR UTILIZANDO EL MANEJO DE EXCEPCIONES HACIENDO QUE NO EJECUTE EL ERROR PERO EL
 * RESTO DEL PROGRAMA SI. Este error que acabamos de cometer es un RuntimeException, siendo una excepcion no comprobada.
 * 
 * -Throws
 * La palabra clave throws (lanzar) en la cabecera de un metodo, indica al programador que el metodo puede llegar a
 * lanzar una excepcion.
 * Capturar siempre lo que lanza un throws o algo mas generico, ej: si lanzo un IOException y capturo con un
 * InpuntMismatchException, daria error. Esto se podria solucionar capturando con la excepcion correcta o con
 * alguna clase mas generica como Exception. Pero si especificamos la excepcion correcta, estamos reduciendo el tipo de
 * error en la jerarquia de herencia sobre las excepciones.
 * La clausula throw (instancia la clase, ej: throw new ArrayIndexOutOfBoundsException) lanza excepciones de forma
 * manual.
 * Es buena practica especificar en la cabecera del metodo, el tipo de excepcion que podria lanzar para alertar
 * a otros programadores el tipo de excepcion que ese metodo podria lanzar. En caso de que no encuentres el tipo de
 * excepcion, la puedes crear manualmente.
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class _1 {

	public static void main(String[] args) {

		// Ejemplo de error en tiempo de ejecucion (no comprobada)

		int numeros[] = new int[5];

		numeros[0] = 5;
		numeros[1] = 12;
		numeros[2] = 34;
		numeros[3] = 4;
		numeros[4] = 11;
		/* Error en tiempo de ejecucion, ya que estamos tratando de acceder a la posicion 6 del array de 5 posiciones, lanzando
		 * una excepcion no comprobada de tipo ArrayIndexOutOfBoundsException. */
		// numeros[5] = 34;

		for (int i = 0; i < numeros.length; i++)
			System.out.println("Posicion " + i + ": " + numeros[i]);

		// -----------

		/* Ejemplo de error en tiempo de ejecucion usando un bloque try{}catch(){} para evitar una posible detencion del
		 * programa, tomando como ejemplo la excepcion de tipo NumberFormatException que hereda obviamente de
		 * RuntimeException. */

		int edad = 0;

		// Peticion de datos personales
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");

		/* Captura la excepcion no comprobada de tipo NumberFormatException en caso de que el usuario ingrese una cadena en
		 * lugar de numero para especificar la edad.
		 * Esto es un error por parte del usuario, ya que se podria evitar logicamente usando un numero para la edad,
		 * pero en caso de que estemos ante un inutil, esto resolveria el problema de que se detenga el programa. */
		try {
			edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
		} catch (NumberFormatException e) {
			System.err.println("Ingresa un numero pelotudo!");
		}

		System.out.println("\nNombre: " + nombre + " - Edad: " + edad);

		// -----------

		/* Ejemplo de error en tiempo de compilacion usando como ejemplo un error de tipo IOException, que es una excepcion
		 * comprobada, por lo tanto estamos obligados a encerrar la linea que puede llegar a lanzar esta excepcion en un
		 * bloque try{}catch(){}. */

		File file = new File("hola.txt");

		try {
			FileReader input = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
