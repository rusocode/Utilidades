package registro.gui.paneles;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import registro.modelo.Constantes;
import registro.modelo.Mecanica;

public class Modificar extends JPanel {

	private static final long serialVersionUID = 1L;

	// Componentes visuales del paquete swing
	private JPanel panelBuscar;
	private JPanel panelModificar;
	private JPanel panelID;
	private JPanel panelNombre;
	private JLabel lblCliente;
	private JLabel lblID;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDNI;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JButton btnBuscarID;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JRadioButton radioID;
	private JRadioButton radioNombre;
	private ButtonGroup grupo;
	private static JComboBox<String> cbNombres; // FIXME: Moverlo a Constantes

	// Variables auxiliares
	private int index;
	private String nombreOriginal;

	public Modificar() {
		setBackground(SystemColor.menu);
		setLayout(null);
		makeGUI();
	}

	private void makeGUI() {

		// PANEL BUSCAR
		panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		panelBuscar.setBackground(SystemColor.menu);
		panelBuscar.setBounds(10, 11, 182, 108);
		panelBuscar.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		// Grupos
		grupo = new ButtonGroup();

		// Grupo ID
		radioID = new JRadioButton("ID", true); // Crea un objeto JRadioButton, le pasa como argumento el nombre y lo deja seleccionado.
		radioID.setBackground(SystemColor.menu);
		radioID.setBounds(10, 21, 60, 23);
		radioID.setFocusable(false);
		radioID.addActionListener(new OyenteBotones());
		grupo.add(radioID);

		// Grupo Nombre
		radioNombre = new JRadioButton("Nombre");
		radioNombre.setBackground(SystemColor.menu);
		radioNombre.setBounds(86, 21, 79, 23);
		radioNombre.setFocusable(false);
		radioNombre.addActionListener(new OyenteBotones());
		grupo.add(radioNombre);

		// Panel ID
		panelID = new JPanel();
		panelID.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelID.setBackground(SystemColor.menu);
		panelID.setBounds(10, 60, 155, 35);

		txtID = new JTextField();
		txtID.setColumns(7);
		txtID.setHorizontalAlignment(SwingConstants.LEFT);
		txtID.addKeyListener(new OyenteTeclado());

		btnBuscarID = new JButton("Buscar ID");
		btnBuscarID.setFocusable(false);
		btnBuscarID.setEnabled(false);
		btnBuscarID.addActionListener(new OyenteBotones());

		// Panel Nombre
		panelNombre = new JPanel();
		panelNombre.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelNombre.setBackground(SystemColor.menu);
		panelNombre.setBounds(10, 60, 155, 35);
		panelNombre.setVisible(false); // Viene invisible por defecto

		cbNombres = new JComboBox<String>();
		cbNombres.setModel(new DefaultComboBoxModel<String>(new String[] { "Nombre" }));
		cbNombres.setFocusable(false);
		cbNombres.addActionListener(new OyenteBotones());

		// Orden de los componentes
		panelID.add(txtID);
		panelID.add(btnBuscarID);
		panelNombre.add(cbNombres);
		panelBuscar.add(panelID);
		panelBuscar.add(panelNombre);
		panelBuscar.add(radioID);
		panelBuscar.add(radioNombre);
		add(panelBuscar);

		// PANEL MODIFICAR
		panelModificar = new JPanel();
		panelModificar.setLayout(null);
		panelModificar.setBackground(SystemColor.menu);
		panelModificar.setBounds(10, 137, 261, 186);
		panelModificar.setBorder(new TitledBorder(null, "Modificar", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblCliente = new JLabel("ID:");
		lblCliente.setBounds(16, 25, 15, 14);

		lblID = new JLabel("Desconocido");
		lblID.setBounds(66, 25, 60, 14);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(16, 56, 46, 14);

		txtNombre = new JTextField();
		txtNombre.setBounds(66, 53, 160, 20);
		txtNombre.setEnabled(false);
		txtNombre.addKeyListener(new OyenteTeclado());

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(16, 87, 46, 14);

		txtApellido = new JTextField();
		txtApellido.setBounds(66, 84, 160, 20);
		txtApellido.setEnabled(false);
		txtApellido.addKeyListener(new OyenteTeclado());

		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(16, 118, 46, 14);

		txtDNI = new JTextField();
		txtDNI.setBounds(66, 115, 160, 20);
		txtDNI.setEnabled(false);
		txtDNI.addKeyListener(new OyenteTeclado());

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(66, 146, 75, 23);
		btnModificar.setFocusable(false);
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new OyenteBotones());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(151, 146, 75, 23);
		btnCancelar.setFocusable(false);
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(new OyenteBotones());

		// Orden de los componentes
		panelModificar.add(lblCliente);
		panelModificar.add(lblID);
		panelModificar.add(lblNombre);
		panelModificar.add(txtNombre);
		panelModificar.add(lblApellido);
		panelModificar.add(txtApellido);
		panelModificar.add(lblDNI);
		panelModificar.add(txtDNI);
		panelModificar.add(btnModificar);
		panelModificar.add(btnCancelar);
		add(panelModificar);

	}

	public static void agregarNombre(String nombre) {
		cbNombres.addItem(nombre);
	}

	private void buscarID() {

		boolean existeID = false;

		// Si el array no esta vacio
		if (!Constantes.CLIENTES.isEmpty()) {

			// Itera hasta el limite del array
			for (int i = 0; i < Constantes.CLIENTES.size(); i++) {

				// Condiciona si el ID es igual al cliente de la posicion i
				if (Integer.parseInt(txtID.getText()) == (Constantes.CLIENTES.get(i).getId())) {

					// Guarda el ID del cliente seleccionado
					index = i;

					// Limpia el panel buscar y habilita los JTextField
					Mecanica.actualizarPanelBuscar1(txtID, txtNombre, txtApellido, txtDNI, btnBuscarID, btnModificar, btnCancelar);

					// Le pasa los valores del cliente especificado a los JTextField
					lblID.setText(String.valueOf(Constantes.CLIENTES.get(i).getId()));
					txtNombre.setText(Constantes.CLIENTES.get(i).getNombre());
					txtApellido.setText(Constantes.CLIENTES.get(i).getApellido());
					txtDNI.setText(String.valueOf(Constantes.CLIENTES.get(i).getDni()));

					// Almacena el nombre original
					nombreOriginal = txtNombre.getText(); // Colector.clientes.get(i).getNombre()

					// ID existente
					existeID = true;

					// Rompe el primer if y sus instrucciones anidadas para evitar que el for itere hasta el limite
					break;
				}

			}

		} else { // Si el array esta vacio se muestra un mensaje
			Mecanica.actualizarPanelBuscar2(txtID, btnBuscarID);
			JOptionPane.showMessageDialog(null, "Todavia no ingreso ningun cliente!", "Error", JOptionPane.ERROR_MESSAGE);
		}

		// Si el array no esta vacio y no existe el ID
		if (!Constantes.CLIENTES.isEmpty() && existeID == false) {
			Mecanica.actualizarPanelBuscar3(lblID, txtID, txtNombre, txtApellido, txtDNI, btnBuscarID, btnModificar, btnCancelar);
			JOptionPane.showMessageDialog(null, "El cliente no existe!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void buscarNombre() {

		if (cbNombres.getSelectedIndex() != -1) {

			for (int i = 0; i < Constantes.CLIENTES.size(); i++) {

				if (cbNombres.getSelectedItem().toString().equals(Constantes.CLIENTES.get(i).getNombre())) {

					index = i;

					// FIXME
					Mecanica.actualizarPanelBuscar1(txtID, txtNombre, txtApellido, txtDNI, btnBuscarID, btnModificar, btnCancelar);

					lblID.setText(String.valueOf(Constantes.CLIENTES.get(i).getId()));
					txtNombre.setText(Constantes.CLIENTES.get(i).getNombre());
					txtApellido.setText(Constantes.CLIENTES.get(i).getApellido());
					txtDNI.setText(String.valueOf(Constantes.CLIENTES.get(i).getDni()));

					nombreOriginal = txtNombre.getText();

					break;
				}

			}

		}

	}

	private void modificar() {
		int op = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios efectuados en el cliente?", "Administracion",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (JOptionPane.YES_OPTION == op) {
			// Establece los nuevos valores al cliente
			Constantes.CLIENTES.get(index).setNombre(txtNombre.getText());
			Constantes.CLIENTES.get(index).setApellido(txtApellido.getText());
			Constantes.CLIENTES.get(index).setDni(Integer.parseInt(txtDNI.getText()));

			// Actualiza comboNombres despues de editar el nombre del cliente
			actualizarComboNombres(txtNombre.getText());

			Mecanica.actualizarPanelModificar(lblID, txtNombre, txtApellido, txtDNI, btnModificar, btnCancelar, cbNombres);
		} else {
			// Restablece los valores originales al cliente
			txtNombre.setText(Constantes.CLIENTES.get(index).getNombre());
			txtApellido.setText(Constantes.CLIENTES.get(index).getApellido());
			txtDNI.setText(String.valueOf(Constantes.CLIENTES.get(index).getDni()));
		}
	}

	private void cancelar() {
		Mecanica.actualizarPanelModificar(lblID, txtNombre, txtApellido, txtDNI, btnModificar, btnCancelar, cbNombres);
	}

	private void actualizarComboNombres(String nuevoNombre) {
		// Elimina el nombre original
		cbNombres.removeItem(nombreOriginal);
		// Agrega el nuevo nombre
		cbNombres.addItem(nuevoNombre);
	}

	private void doRadioID() {
		panelID.setVisible(true);
		panelNombre.setVisible(false);
	}

	private void doRadioNombre() {
		panelID.setVisible(false);
		panelNombre.setVisible(true);
	}

	// OYENTES
	private class OyenteTeclado extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			if (e.getSource() == txtID) Mecanica.habilitarBtn(Constantes.BTN_BUSCAR, txtID, null, null, btnBuscarID);

			if (e.getSource() == txtNombre || e.getSource() == txtApellido || e.getSource() == txtDNI)
				Mecanica.habilitarBtn(Constantes.BTN_MODIFICAR, txtNombre, txtApellido, txtDNI, btnModificar);
		}

		public void keyTyped(KeyEvent e) {
			if (e.getSource() == txtID) Mecanica.validarCampo(Constantes.NUMEROS, txtID, e, Constantes.LIMITE_CAMPO_ID);
			if (e.getSource() == txtNombre) Mecanica.validarCampo(Constantes.LETRAS, txtNombre, e, Constantes.LIMITE_CAMPO_NOMBRE);
			if (e.getSource() == txtApellido) Mecanica.validarCampo(Constantes.LETRAS, txtApellido, e, Constantes.LIMITE_CAMPO_APELLIDO);
			if (e.getSource() == txtDNI) Mecanica.validarCampo(Constantes.NUMEROS, txtDNI, e, Constantes.LIMITE_CAMPO_DNI);
		}
	}

	private class OyenteBotones implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == radioID) doRadioID();
			if (e.getSource() == radioNombre) doRadioNombre();
			if (e.getSource() == btnBuscarID) buscarID();
			if (e.getSource() == cbNombres) buscarNombre();
			if (e.getSource() == btnModificar) modificar();
			if (e.getSource() == btnCancelar) cancelar();

		}

	}

}
