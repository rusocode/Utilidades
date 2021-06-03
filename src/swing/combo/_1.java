package swing.combo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
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
	private JPanel panelNorte;
	private JLabel lblTexto;
	private JComboBox cbFuentes;

	public Lamina() {
		setLayout(new BorderLayout());

		lblTexto = new JLabel("Texto");
		lblTexto.setFont(new Font("Serif", Font.PLAIN, 18));
		add(lblTexto, BorderLayout.CENTER);

		panelNorte = new JPanel();

		cbFuentes = new JComboBox();
		cbFuentes.setEditable(true);
		cbFuentes.addItem("Serif");
		cbFuentes.addItem("SansSerif");
		cbFuentes.addItem("Monospaced");
		cbFuentes.addItem("Dialog");
		cbFuentes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/* Formas de convertir a String el comboBox:
				 * cbFuentes.getSelectedItem().toString()
				 * (String) cbFuentes.getSelectedItem()
				 * "" + cbFuentes.getSelectedItem() */
				lblTexto.setFont(new Font("" + cbFuentes.getSelectedItem(), Font.PLAIN, 18));

			}

		});

		panelNorte.add(cbFuentes);

		add(panelNorte, BorderLayout.NORTH);

	}

}