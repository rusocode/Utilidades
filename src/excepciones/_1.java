package excepciones;

import javax.swing.JOptionPane;

public class _1 {

	/**
	 * ERROR EN TIEMPO DE EJECUCION (error logico)
	 * Esto (matriz[5] = -15;) va a generar una excepcion de tipo ArrayIndexOutOfBoundsException,
	 * queriendo decir que esta ocurriendo un error en el cual el array se sale de limites en el indice.
	 * Como cada vez que ocurre un error de estas caracteristicas, lo que realmente esta pasando, es que esa excepcion de tipo
	 * ArrayIndexOutOfBoundsException ES LA CLASE A LA QUE PERTENECE EL ERROR QUE ACABAMOS DE GENERAR, es decir, ese objeto pertenece
	 * a la clase ArrayIndexOutOfBoundsException.
	 * 
	 * Este tipo de error tiene el mismo inconveniente que el error anterior (error de sintaxis), es decir, si cometes un error
	 * de estas caracteristicas, no se llega a ejecutar ni una sola linea de tu programa.
	 * Esto se vuelve un problema cuando por ejemplo tienes un programa de 5000 lineas y si algo falla no se ejecuta ni una sola,
	 * entonces quizas te interese que ejecute todo el programa pero la linea que falla no.
	 * ESTO LO PODEMOS SOLVENTAR UTILIZANDO EL MANEJO DE EXCEPCIONES HACIENDO QUE NO EJECUTE EL ERROR PERO EL RESTO DEL PROGRAMA SI.
	 * 
	 * Este error que acabamos de cometer es un RuntimeException (excepcion no comprobada).
	 * 
	 * ¿Por que con este tipo de errores (excepciones no comprobadas) se dice que el programador tiene la culpa? Porque tu como buen
	 * programador java debes saber que si declaras un array de 5 posiciones no debes rellenar una sexta o no debes recorrer hasta
	 * la posicion 6, 8, 9, etc. ese array.
	 * Sin embargo hay otro tipo de excepciones que se denominan excepciones comprobadas, y son excepciones en el cual el programador
	 * no tiene culpa en absoluto. Para este tipo de errores, java es un lenguaje de programacion tan robusto que ya tiene previstas
	 * situaciones para este tipo de excepciones, es decir, este tipo de excepciones, el propio lenguje de programacion java ya las
	 * tiene contempladas, por ejemplo, un error de este tipo, un error en el cual nosotros no tengamos la culpa de tipo IOException, por
	 * ejemplo, cuando creamos un programa en el cual necesitamos ir a una carpeta del ordenador donde se esta ejecutando ese programa para
	 * coger una imagen y la imagen no esta.
	 * Como este tipo de error es AJENO a nuestra voluntad, el lenguaje de programacion java lo tiene "planeado" Â¿Como? TRY - CATCH.
	 */

	public static void main(String[] args) {

		int matriz[] = new int[5];

		matriz[0] = 5;
		matriz[1] = 12;
		matriz[2] = 34;
		matriz[3] = 4;
		/* ERROR EN TIEMPO DE COMPILACION (error de sintaxis)
		 * Esto va a generar un error en el hilo (thread) "main" pidiendo que insertes un ";" para completar la sentencia. */
		matriz[4] = 11;

		for (int i = 0; i < matriz.length; i++)
			System.out.println("Posicion " + i + ": " + matriz[i]);

		/*----------------------------------------------------------*/

		// Peticion de datos personales
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));

		System.out.println("Nombre: " + nombre + " - Edad: " + edad);

	}

}
