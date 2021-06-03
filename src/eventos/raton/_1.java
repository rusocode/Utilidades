package eventos.raton;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	public Marco() {

		addMouseListener(new Oyente());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

	private class Oyente implements MouseListener {

		@Override
		// @Override = Sobreescritura. Sale cuando se hereda un metodo de una clase padre y lo volvemos a crear en la clase hija.
		public void mouseClicked(MouseEvent e) {
			System.out.println("Se hizo click.");
		}

		public void mouseEntered(MouseEvent e) {
			System.out.println("Acabas de entrar.");
		}

		public void mouseExited(MouseEvent e) {
			System.out.println("Acabas de salir.");
		}

		public void mousePressed(MouseEvent e) {
			System.out.println("Acabas de presionar.");
		}

		public void mouseReleased(MouseEvent e) {
			System.out.println("Acabas de levantar.");
		}

	}

}
