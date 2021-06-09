package swing.campo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class _2 {

	public static void main(String[] args) {
		new Marco2().setVisible(true);
	}

}

class Marco2 extends JFrame {

	public Marco2() {

		setFrameProperties();

	}

	private void setFrameProperties() {

		setTitle("Calculadora");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		add(new Lamina2());

	}

}

class Lamina2 extends JPanel {

	private JLabel lblUsuario;
	private JLabel lblConstrasena;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnEnviar;

	private char[] contrasena;
	private JPanel lamina2;

	public Lamina2() {

		setLayout(new BorderLayout());

		lamina2 = new JPanel();
		lamina2.setLayout(new GridLayout(2, 2));

		lblUsuario = new JLabel("Usuario:");
		lblConstrasena = new JLabel("Contrase�a:");

		txtUsuario = new JTextField(20);
		txtContrasena = new JPasswordField(20);

		btnEnviar = new JButton("Enviar");

		/* Utiizamos el objeto Document para poner un oyente sobre dicho objeto (addDocumentListener), de esta manera podemos
		 * ejecutar acciones en cada cambio, insercion y eliminacion de dicho documento. Un Document es un modelo del texto que
		 * hay dentro del JTextField. */
		// Document doc = txtContraseña.getDocument(); // Crea un objeto de tipo Document que tiene una representacion del txt.
		// DocumentListener oyente = new Oyente();
		// doc.addDocumentListener(oyente);

		txtContrasena.getDocument().addDocumentListener(new Oyente());

		// Las celdas del GridLayout se agregan de izquierda a derecha, haciendo referencia a la primera fila.
		lamina2.add(lblUsuario);
		lamina2.add(txtUsuario);
		lamina2.add(lblConstrasena);
		lamina2.add(txtContrasena);

		add(lamina2, BorderLayout.NORTH);
		add(btnEnviar, BorderLayout.SOUTH);

	}

	private class Oyente implements DocumentListener {

		public void changedUpdate(DocumentEvent e) {

		}

		public void insertUpdate(DocumentEvent e) {
			// Escribir syso y pulsar CTRL + ESPACIO.
			// System.out.println("Inserto.");

			contrasena = txtContrasena.getPassword();

			if (contrasena.length < 8 || contrasena.length > 12) txtContrasena.setBackground(Color.RED);
			else txtContrasena.setBackground(Color.WHITE);

		}

		public void removeUpdate(DocumentEvent e) {
			contrasena = txtContrasena.getPassword();

			if (contrasena.length < 8 || contrasena.length > 12) txtContrasena.setBackground(Color.RED);
			else txtContrasena.setBackground(Color.WHITE);
		}

	}

}
