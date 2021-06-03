package registro.gui.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import registro.modelo.Constantes;
import registro.modelo.Mecanica;

import registro.objetos.Cliente;

import java.awt.SystemColor;

public class Nuevo extends JPanel {
	private static final long serialVersionUID = 1L;

	// Componentes visuales del paquete swing
	private JLabel lblCliente;
	private JLabel lblID;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JButton btnAgregar;

	// Identificador de cliente para lblID.
	private int id = 1;

	public Nuevo() {
		setBackground(SystemColor.menu);
		setLayout(null);
		makeGUI();
	}

	private void makeGUI() {

		lblCliente = new JLabel("ID:");
		lblCliente.setBounds(10, 12, 46, 14);

		lblID = new JLabel(String.valueOf(id));
		lblID.setBounds(60, 12, 46, 14);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 42, 46, 14);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 72, 46, 14);

		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 102, 46, 14);

		txtNombre = new JTextField();
		txtNombre.setBounds(60, 41, 116, 20);
		txtNombre.addKeyListener(new OyenteTeclado());

		txtApellido = new JTextField();
		txtApellido.setBounds(60, 70, 116, 20);
		txtApellido.addKeyListener(new OyenteTeclado());

		txtDNI = new JTextField();
		txtDNI.setBounds(60, 99, 116, 20);
		txtDNI.addKeyListener(new OyenteTeclado());

		btnAgregar = new JButton("Registrar");
		btnAgregar.setBounds(60, 130, 77, 23);
		btnAgregar.setFocusable(false);
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});

		// Orden de los componentes.
		add(lblCliente);
		add(lblID);
		add(lblNombre);
		add(txtNombre);
		add(lblApellido);
		add(txtApellido);
		add(lblDNI);
		add(txtDNI);
		add(btnAgregar);

	}

	private void registrar() {
		/* Crea un objeto de tipo Cliente y se le pasa como argumento los datos ingresados por teclado, luego lo almacena dentro
		 * de la coleccion de clientes. */
		Constantes.CLIENTES.add(new Cliente(txtNombre.getText(), txtApellido.getText(), Integer.parseInt(txtDNI.getText())));

		// Agrega el nombre del nuevo cliente al JComboBox.
		Modificar.agregarNombre(txtNombre.getText());

		// Preincrementa el id y lo actualiza en lblID.
		lblID.setText("" + (++id));

		// Actualiza el panel a su estado original.
		Mecanica.actualizarPanelAgregar(txtNombre, txtApellido, txtDNI, btnAgregar);

	}

	private class OyenteTeclado extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			if (e.getSource() == txtNombre || e.getSource() == txtApellido || e.getSource() == txtDNI)
				// Argumentos: boton, nombre, apellido, dni y evento.
				Mecanica.habilitarBtn(Constantes.BTN_AGREGAR, txtNombre, txtApellido, txtDNI, btnAgregar);
		}

		public void keyTyped(KeyEvent e) {
			if (e.getSource() == txtNombre)
				// Argumentos: solo letras, nombre, evento y limite de caracteres.
				Mecanica.validarCampo(Constantes.LETRAS, txtNombre, e, Constantes.LIMITE_CAMPO_NOMBRE);

			if (e.getSource() == txtApellido) Mecanica.validarCampo(Constantes.LETRAS, txtApellido, e, Constantes.LIMITE_CAMPO_APELLIDO);

		}
	}
}
