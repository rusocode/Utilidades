package eventos.raton;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class _2 {

	public static void main(String[] args) {
		new Marco2().setVisible(true);
	}

}

class Marco2 extends JFrame {
	
	public Marco2() {
		
		addMouseListener(new Oyente());
		addMouseMotionListener(new Oyente());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

	private class Oyente extends MouseAdapter /* implements MouseMotionListener */ {

		public void mouseDragged(MouseEvent e) {
			// System.out.println("Estas arrastrando.");
		}

		public void mouseMoved(MouseEvent e) {
			// System.out.println("Estas moviendo.");
			// System.out.println("X=" + e.getX() + " Y=" + e.getY());

		}

		// public void mouseClicked(MouseEvent e) {
		// // System.out.println("X: " + e.getX() + " - Y: " + e.getY());
		// // Cuenta la cantidad de clicks seguidos.
		// // System.out.println(e.getClickCount());
		// }
		//
		// public void mousePressed(MouseEvent e) {
		// if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK)
		// System.out.println("Has pulsado el boton izquierdo.");
		// if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK)
		// System.out.println("Has pulsado la rueda del raton.");
		// if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) System.out.println("Has pulsado el boton derecho.");
		//
		// }

		// Haciendo click dentro del marco y arrastrando el mouse fuera de este, podemos obtener valores (X;Y) fuera de este.
		public void mouseReleased(MouseEvent e) {
			System.out.println(" X=" + e.getX() + " Y=" + e.getY());
		}

	}

}