/* https://www.youtube.com/watch?v=0fifCsOYbXw&index=52&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk */

package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

// 1000 milisegundos = 1 segundo

public class Interfaces4 {

	public static void main(String[] args) {

		// RECORDAR que una interfaz no se puede instanciar
		DameLaHora oyente = new DameLaHora(); // Constructor por defecto: es aquel que no recibe parametros y se da por supuesto
		// ActionListener oyente = new DameLaHora(); // Es valido

		/* Primer parametro: tiempo en milisegundos del temporizador para desencadenar
		 * una accion. Es decir, la frecuencia con la que queremos que se ejecute esa accion.
		 * Segundo parametro: Una accion. Objeto de tipo interfaz y ActionListener. */
		Timer timer = new Timer(5000, oyente); /* Cada 5 segundos se va a ejecutar el metodo
												 * actionPerformed(). Cada 5 segundos se le asigna la hora de ese instante a la variable "ahora",
												 * y justo despues se imprime el mensaje de esa hora. */

		// Ejecuta el temporizador
		timer.start();

		/* Mientras esta ventana este en ejecucion, el programa va a estar ejecutandose.
		 * Cuando pulsemos en Aceptar, el programa va a continuar la ejecucion del codigo hacia abajo. */
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para deterlo");

		// Detiene la ejecucion del programa
		System.exit(0);

	}

}

/**
 * Siempre que se desencadena un evento, esa accion (evento) tiene que llamar a un metodo "actionPerformed()".
 * Debido a esto, todas aquellas clases que desencadenen eventos, tienen que implementar la interfaz ActionListener,
 * simplemente, para asegurarse de que construimos el metodo "actionPerformed()".
 * Es decir, ¿Por que la API de java en el constructor de la clase Timer, como segundo parametro nos obliga
 * a pasarle un parametro de tipo interfaz ActionListener? Simplemte para asegurarse que a la hora de construir
 * nuestros programas, este metodo actionPerformed(), que es invocado siempre que ocurre un evento,
 * esta desarrollado.
 * Uno de los objetivos de las interfaces, es marcar el diseño que tienen que tener aquellas clases que
 * implementan la interfaz.
 */
class DameLaHora implements ActionListener {

	/**
	 * El metodo actionPerformed es invocado (llamado) automaticamente cuando se produce el evento. Cuando
	 * hacemos click en un boton se esta produciendo un evento y por lo tanto en ese momento se llama al
	 * metodo actionPerformed ademas de pasarle por parametro un objeto evento. Esto es complicado de ver
	 * sobre todo si se viene de otros lenguajes.
	 * 
	 * Tal y como comentamos en los videos, los eventos en Java estan 100% orientados a objetos, es decir,
	 * se considera a los eventos como objetos. Es por este motivo por lo que cuando pulsamos en un boton,
	 * aunque no lo veamos, realmente estamos construyendo en ese momento un objeto de tipo evento
	 * (concretamente actionEvent) y se lo pasamos por parametro al metodo actionPerformed (al que
	 * tambien llamamos de forma automatica simplemente pulsando un boton). Respecto el argumento,
	 * vemos en los videos tambien como podemos utilizar el objeto evento para detectar la fuente del
	 * evento con el metodo getSource(), o sea que si lo usamos.
	 */
	@Override
	public void actionPerformed(ActionEvent e) { // Accion realizada

		Date ahora = new Date();
		System.out.println("Te muestro la hora cada 5s: " + ahora);

	}

}
