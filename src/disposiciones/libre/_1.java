package disposiciones.libre;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Si llevamos esta aplicacion grafica a otra plataforma, quizas no se vea del todo bien.
 * ¿Por que? Porque no todos trabajamos con las mismas resoluciones.
 */

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	public Marco() {
		setFrameProperties();
		makeGUI();

	}

	private void setFrameProperties() {
		setTitle("Ventana");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
	}

	private void makeGUI() {
		add(new Lamina());
	}

}

class Lamina extends JPanel {

	private JLabel lbl1, lbl2;
	private JTextField txt1, txt2;

	public Lamina() {

		// Disposicion libre.
		setLayout(null);

		// setLocation(x, y); <-- No funciona con disposiciones libres.

		lbl1 = new JLabel("Nombre: ");
		lbl2 = new JLabel("Apodo: ");

		txt1 = new JTextField();
		txt2 = new JTextField();

		lbl1.setBounds(10, 10, 60, 10);
		lbl2.setBounds(10, 30, 60, 12);

		txt1.setBounds(60, 10, 80, 15);
		txt2.setBounds(60, 30, 80, 15);

		add(lbl1);
		add(lbl2);
		add(txt1);
		add(txt2);

	}
}
