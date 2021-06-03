package eventos.foco;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	public Marco() {

		add(new Lamina());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

}

class Lamina extends JPanel {

	// Las declaro como ambito de clase.
	private JTextField txt1;
	private JTextField txt2;

	public Lamina() {

		// Coloca los componentes por defecto.
		setLayout(null);

		txt1 = new JTextField();
		txt2 = new JTextField();

		txt1.setBounds(120, 10, 150, 20);
		txt2.setBounds(120, 50, 150, 20);

		add(txt1);
		add(txt2);

		txt1.addFocusListener(new Oyente());
		// txt2.addFocusListener(new Oyente());

	}

	/* Este metodo se invoca automaticamente cada vez que realizamos un cambio en nuestra ventana (mover, dimensionar,
	 * maximizar, etc), por lo cual, si hemos instanciado componentes dentro del mismo, se vuelven a instanciar, por lo que
	 * en mi caso puedo observar un aumento considerable de la memoria. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	private class Oyente implements FocusListener {

		// Cuando gana el foco.
		public void focusGained(FocusEvent e) {
			System.out.println("He ganado el foco.");
		}

		// Cuando se pierde el foco.
		public void focusLost(FocusEvent e) {
			System.out.println("He perdido el foco.");
		}

	}
}
