package registro.gui.ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import registro.objetos.JHyperlink;

public class Acerca extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JTextArea txtArea;
	private JButton btnOk;
	private JHyperlink hyperlink;

	/*
	 * Singleton: garantiza que la clase solo tenga una instancia y proporciona un punto de acceso global a ella. Se debe
	 * proteger (private) el constructor para evitar que se creen nuevos objetos de la clase.
	 */
	private static Acerca instance;

	public static Acerca getInstance() {
		if (instance == null)
			instance = new Acerca();
		return instance;
	}

	private Acerca() {
		setFrameProperties();
		makeGUI();
	}

	private void setFrameProperties() {
		setTitle("Acerca de Registro");
		setSize(311, 108);
		// setLocation(); // La ubicacion de esta ventana se establece desde la clase principal
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void makeGUI() {
		panel = new JPanel();
		panel.setLayout(null);

		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(10, 11, 197, 32);
		txtArea.setBackground(SystemColor.menu);
		txtArea.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// Mueve el cursor al inicio de la linea (\r) y mueve el cursor hacia la siguiente linea (\n)
		String str = "Registro 1.5 \r\n" + "Copyright © 2019-2019 Juan Debenedetti";
		txtArea.append(str);
		panel.add(txtArea);

		btnOk = new JButton("OK");
		btnOk.setBounds(243, 8, 52, 23);
		btnOk.setFocusable(false);
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (btnOk == evt.getSource())
					dispose(); // Cierra la ventana actual y libera los recursos que esa ventana haya estado ocupando
			}
		});
		panel.add(btnOk);

		hyperlink = new JHyperlink("github.com/Registro");
		hyperlink.setURL("https://github.com/Ruso-coding/Sistema-de-registro-con-GUI");
		hyperlink.setToolTipText("Codigo fuente");
		hyperlink.setBounds(10, 54, 97, 14);
		panel.add(hyperlink);

		getContentPane().add(panel, BorderLayout.CENTER);

	}

}
