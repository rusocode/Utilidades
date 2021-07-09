package sockets;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Cliente extends JFrame {

	private JPanel panel;
	private JTextField txtTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new MigLayout("", "[grow, align center]")); // Restriccion para la primera fila

		JLabel lblCliente = new JLabel("Cliente");
		panel.add(lblCliente, "wrap");

		txtTexto = new JTextField();
		panel.add(txtTexto, "wrap");
		txtTexto.setColumns(10);

		JButton btnEnviar = new JButton("Enviar");
		panel.add(btnEnviar);
	}

}
