package eventos.foco;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _2 {

	public static void main(String[] args) {
		// new Marco2().setVisible(true);

		new FocoVentana().iniciar();

	}

}

class FocoVentana extends JFrame implements WindowFocusListener {

	FocoVentana marco1, marco2;

	public void iniciar() {
		marco1 = new FocoVentana();
		marco2 = new FocoVentana();

		marco1.setBounds(100, 100, 600, 350);
		marco2.setBounds(800, 100, 600, 350);

		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);

		marco1.setVisible(true);
		marco2.setVisible(true);

	}

	public void windowGainedFocus(WindowEvent e) {
		if (e.getSource() == marco1)
			marco1.setTitle("Tengo el foco!");
		else
			marco2.setTitle("Tengo el foco!");
	}

	public void windowLostFocus(WindowEvent e) {
		if (e.getSource() == marco1)
			marco1.setTitle("");
		else
			marco2.setTitle("");
	}

}

class Marco2 extends JFrame {

	public Marco2() {

		add(new Lamina2());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

}

class Lamina2 extends JPanel {

	private JTextField txt1;
	private JTextField txt2;

	public Lamina2() {

		setLayout(null);

		txt1 = new JTextField();
		txt2 = new JTextField();

		txt1.setBounds(120, 10, 150, 20);
		txt2.setBounds(120, 50, 150, 20);

		add(txt1);
		add(txt2);

		txt1.addFocusListener(new Oyente());

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	private class Oyente implements FocusListener {

		public void focusGained(FocusEvent e) {
			System.out.println("He ganado el foco.");
		}

		public void focusLost(FocusEvent e) {

			String email = txt1.getText();

			boolean comprobacion = false;

			// Comprueba si existe un @ en la cadena
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					comprobacion = true;
					break; // Evita iterar hasta el limite de la cadena
				}
			}

			if (comprobacion)
				System.out.println("Correcto");
			else
				System.out.println("Incorrecto");

		}

	}
}