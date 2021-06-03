package eventos.multiples_oyentes;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _1 {

	public static void main(String[] args) {

		new Marco().setVisible(true);

	}

}

class Marco extends JFrame {

	public Marco() {

		/* private VentanaPrincipal() {
		 * createGUI();
		 * setFrameProperties();
		 * } */

		add(new Lamina());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

// MULTIPLES OYENTES
class Lamina extends JPanel {

	private JButton btnNuevo, btnCerrar;

	public Lamina() {

		// Componentes swing
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new Oyente());
		add(btnNuevo);

		btnCerrar = new JButton("Cerrar todo");
		add(btnCerrar);

	}

	private class Oyente implements ActionListener {

		// Action performed = accion realizada.
		public void actionPerformed(ActionEvent e) {
			new MarcoEmergente(btnCerrar).setVisible(true);

		}

	}
}

class MarcoEmergente extends JFrame {
	private static int i;

	public MarcoEmergente(JButton btnDePrincipal) {
		setTitle("Ventana " + (++i));
		setBounds(40 * i, 40 * i, 100, 100);

		/* Por parametro le estamos diciendo al constructor que ese boton (btnDePrincipal) es el desencadenante del
		 * evento (la fuente). Mueve la referencia de ese boton a la clase MarcoEmergente para poder decirle dentro del
		 * constructor de esta clase que ese boton es la fuente. */
		btnDePrincipal.addActionListener(new CierraTodos());

	}

	private class CierraTodos implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			// Libera todo los recursos de la lamina
			dispose();

			// Resetea el indice
			i = 0;
		}

	}

}
