package eventos;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _3 {

	public static void main(String[] args) {

		new MarcoBotones2().setVisible(true);

	}

}

class MarcoBotones2 extends JFrame {
	public MarcoBotones2() {

		LaminaBotones2 lamina = new LaminaBotones2();
		add(lamina);

		setTitle("Botones y Eventos");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

class LaminaBotones2 extends JPanel {

	private JButton btnRojo = new JButton("Rojo");
	private JButton btnVerde = new JButton("Verde");
	private JButton btnAzul = new JButton("Azul");

	public LaminaBotones2() {

		add(btnRojo);
		add(btnVerde);
		add(btnAzul);

		ColorFondo rojo = new ColorFondo(Color.RED);
		ColorFondo verde = new ColorFondo(Color.GREEN);
		ColorFondo azul = new ColorFondo(Color.BLUE);

		// Le pasa el oyente a cada boton
		btnRojo.addActionListener(rojo);
		btnVerde.addActionListener(verde);
		btnAzul.addActionListener(azul);

		setBackground(SystemColor.window);
	}

	// Clase oyente de los eventos
	private class ColorFondo implements ActionListener {

		private Color colorDeFondo;

		public ColorFondo(Color colorDeFondo) {
			this.colorDeFondo = colorDeFondo;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			setBackground(colorDeFondo);
		}

	}

}
