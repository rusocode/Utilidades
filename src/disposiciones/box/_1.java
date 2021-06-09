package disposiciones.box;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	private JLabel lblNombre, lblContrasena;
	private JTextField txtNombre, txtContrasena;
	private JButton btnOk, btnCancelar;

	public Marco() {
		setFrameProperties();
		makeGUI();

	}

	private void setFrameProperties() {
		setTitle("Box");
		setSize(200, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
	}

	private void makeGUI() {
		// Crea la caja vertical y las horizontales.
		Box cajaV1 = Box.createVerticalBox();

		Box cajaH1 = Box.createHorizontalBox();
		Box cajaH2 = Box.createHorizontalBox();
		Box cajaH3 = Box.createHorizontalBox();

		lblNombre = new JLabel("Nombre");
		txtNombre = new JTextField(10);
		txtNombre.setMaximumSize(txtNombre.getPreferredSize()); // Es una forma de controlar que el tamaño del campo de texto no se descontrole.
		cajaH1.add(lblNombre);
		cajaH1.add(Box.createHorizontalStrut(10)); // Crea una separacion con 10 pixeles de ancho entre los dos componentes.
		cajaH1.add(txtNombre);

		lblContrasena = new JLabel("Contraseña");
		txtContrasena = new JTextField(10);
		txtContrasena.setMaximumSize(txtContrasena.getPreferredSize());
		cajaH2.add(lblContrasena);
		cajaH2.add(Box.createHorizontalStrut(10));
		cajaH2.add(txtContrasena);

		btnOk = new JButton("Ok");
		btnCancelar = new JButton("Cancelar");
		cajaH3.add(btnOk);
		cajaH3.add(Box.createGlue()); // Adapta la distancia que hay entre los dos componentes cuando se redimienciona el marco.
		cajaH3.add(btnCancelar);

		// Agrega las cajas horizontales a la caja vertical.
		cajaV1.add(cajaH1);
		cajaV1.add(cajaH2);
		cajaV1.add(cajaH3);

		add(cajaV1);

	}

}
