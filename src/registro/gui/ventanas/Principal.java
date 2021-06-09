package registro.gui.ventanas;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import registro.gui.paneles.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTabbedPane pestanas;
	private JLabel lblVersion;
	private JButton btnAcerca;
	private int x;
	private int y;

	public Principal() {
		setFrameProperties();
		makeGUI();
	}

	private void setFrameProperties() {
		setTitle("Registro");
		// FIXME - try{}...catch()
		// setIconImage(new
		// ImageIcon(getClass().getClassLoader().getResource("icono.png")).getImage());
		// // 24 x 24px parece ser la dimension correcta para los iconos
		getContentPane().setLayout(null);
		setSize(320, 450);
		setLocationRelativeTo(null);
		setResizable(false);

		/* El metodo recomendado para obtener la posicion de un componente se encuentra
		 * dentro de java.awt.event.ComponentListener.componentMoved(), que se llama una
		 * vez que el sistema operativo ha terminado de mover el componente. */
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {

				// Obtengo los valores x;y de esta ventana y los asigno a las variables x;y de
				// clase
				x = getLocation().x;
				y = getLocation().y;

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void makeGUI() {

		pestanas = new JTabbedPane(JTabbedPane.TOP);
		pestanas.setBounds(10, 11, 285, 356);
		pestanas.setFocusable(false);
		pestanas.add("Nuevo", new Nuevo());
		pestanas.add("Modificar", new Modificar());
		getContentPane().add(pestanas);

		lblVersion = new JLabel("Version 1.5");
		lblVersion.setBounds(10, 378, 74, 14);
		getContentPane().add(lblVersion);

		btnAcerca = new JButton("Acerca de...");
		btnAcerca.setBounds(202, 374, 93, 23);
		btnAcerca.setFocusable(false);
		btnAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (evt.getSource() == btnAcerca) {
					// Establesco la ubicacion de la ventana y la muestro
					Acerca.getInstance().setLocation(x, y);
					Acerca.getInstance().setVisible(true);
				}
			}
		});
		getContentPane().add(btnAcerca);

	}

}
