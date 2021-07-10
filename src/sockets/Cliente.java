package sockets;

import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Cliente extends JFrame {

	private static final long serialVersionUID = 5005050569041620935L;

	private JPanel panel;
	private JLabel lblCliente;
	private JTextField txtTexto;
	private JButton btnEnviar;

	public Cliente() {

		super("Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		initialize();

	}

	private void initialize() {

		panel = new JPanel();

		panel.setLayout(new MigLayout("", "[grow, align center]")); // Restriccion para la primera columna

		lblCliente = new JLabel("Cliente");
		panel.add(lblCliente, "wrap");

		txtTexto = new JTextField();
		txtTexto.setColumns(20);
		panel.add(txtTexto, "wrap");

		btnEnviar = new JButton("Enviar");
		btnEnviar.setFocusable(false);
		btnEnviar.addActionListener(new Oyente());
		panel.add(btnEnviar);

		add(panel);

		setLocationRelativeTo(null);

	}

	private class Oyente implements ActionListener {

		private DataOutputStream output;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnEnviar) {

				try {

					// Crea un puente virtual con el servidor especificado
					Socket socket = new Socket("192.168.10.106", 7666);
					/* Crea un flujo para escribir bytes formateados (Bytes, Integer, Cadenas UTF-8 y otras) a traves del socket
					 * especificado. */
					output = new DataOutputStream(socket.getOutputStream());

					// Escribe en el flujo lo que hay en el campo de texto
					output.writeUTF(txtTexto.getText());

				} catch (UnknownHostException e1) {
					System.err.println("No se pudo determinar la direccion IP del host!\nMas informacion...");
					e1.printStackTrace();
				} catch (IOException e1) {
					System.err.println("Error de I/O!\nMas informacion...");
					e1.printStackTrace();
				} finally {
					try {
						if (output != null) output.close();
					} catch (IOException e1) {
						System.err.println("No se pudo cerrar el flujo de salida!\nMas informacion...");
						e1.printStackTrace();
					}
				}

			}

		}

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al establecer el LookAndFeel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		new Cliente().setVisible(true);
	}

}
