package swing.check;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	public Marco() {

		setFrameProperties();

	}

	private void setFrameProperties() {

		setTitle("CheckBox");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		add(new Lamina());

	}
}

class Lamina extends JPanel {

	private JPanel panelTexto, panelChecks;
	private JLabel lblTexto;
	private JCheckBox chbNegrita;
	private JCheckBox chbCursiva;

	public Lamina() {
		setLayout(new BorderLayout());

		panelTexto = new JPanel();
		panelChecks = new JPanel();

		lblTexto = new JLabel("Mi texto");
		lblTexto.setFont(new Font("Serif", Font.PLAIN, 24));

		panelTexto.add(lblTexto);
		add(panelTexto, BorderLayout.CENTER);

		chbNegrita = new JCheckBox("Negrita");
		chbNegrita.addActionListener(new OyenteChecks());
		chbCursiva = new JCheckBox("Cursiva");
		chbCursiva.addActionListener(new OyenteChecks());

		panelChecks.add(chbNegrita);
		panelChecks.add(chbCursiva);
		add(panelChecks, BorderLayout.SOUTH);

	}

	private class OyenteChecks implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int tipo = 0;

			if (chbNegrita.isSelected()) tipo += Font.BOLD;
			if (chbCursiva.isSelected()) tipo += Font.ITALIC;

			lblTexto.setFont(new Font("Serif", tipo, 24));

		}

	}

}
