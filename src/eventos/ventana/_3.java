/* https://www.youtube.com/watch?v=H_1kldp-d7I&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=70 */

package eventos.ventana;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

/**
 * WindowListener: La interfaz del oyente para recibir eventos de la ventana.
 * WindowAdapter: Una clase de adaptador abstracta para recibir eventos de ventana.
 * WindowStateListener: La interfaz del oyente para recibir eventos del estado de la ventana. LA MAS SIMPLE!
 */

/**
 * Al final, por lo que veo, siempre hay Evento (minimizar, cerrar, etc.), Fuente (boton) y Oyente (ventana). Segun que tipo de Eventos se implementa una Interfaz u otra.
 * El que implementa la Interfaz es siempre el Oyente. El Evento, es el metodo al que se invoca. Y la Fuente, es el Objeto que
 * tenga el metodo add…Listener.
 */

public class _3 {

	public static void main(String[] args) {
		new Marco3().setVisible(true);
	}

}

class Marco3 extends JFrame {

	public Marco3() {

		addWindowStateListener(new Oyente());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

	// CLASE ANONIMA
	private class Oyente implements WindowStateListener {

		// Se llama cuando cambia el estado de la ventana, es decir cuando la ventana desencadena una accion (eventos: maximizada, normal, minimizada, etc.).
		public void windowStateChanged(WindowEvent e) {
			// System.out.println("La ventana a cambiado de estado.");

			if (e.getNewState() == Frame.MAXIMIZED_BOTH) System.out.println("La ventana esta a pantalla completa."); // o 6
			if (e.getNewState() == Frame.NORMAL) System.out.println("La ventana esta normal.");
			if (e.getNewState() == Frame.ICONIFIED) System.out.println("La ventana esta minimizada.");
			// ¿Por que no funcionan las constantes de WindowEvent?
			// if (evt.getNewState() == WindowEvent.WINDOW_ICONIFIED) System.out.println("La ventana esta minimizada.");

		}

	}

}
