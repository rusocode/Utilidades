package sockets;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Servidor extends JFrame {

	private static final long serialVersionUID = -596368938315262612L;

	private JPanel panel;

	private JTextArea area;

	public Servidor() {

		super("Servidor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);

		panel = new JPanel();
		/* Le indica a la restriccion de diseño que reclame todo el espacio disponible en el contenedor para las columnas/filas.
		 * Al menos un componente debe tener un "grow" constante para llenar el contenedor. */
		panel.setLayout(new MigLayout("fill"));

		area = new JTextArea();
		panel.add(area, "grow");

		add(panel);

		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al establecer el LookAndFeel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		new Servidor().setVisible(true);

	}

}
