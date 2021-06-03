package registro.modelo;

import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// En esta clase van todos los metodos logicos
public class Mecanica {

	public static void validarCampo(short id, JTextField txt, KeyEvent evt, int limite) {

		char tecla = evt.getKeyChar();

		switch (id) {
		case Constantes.LETRAS:
			soloLetras(txt, evt, tecla, limite);
			break;
		case Constantes.NUMEROS:
			soloNumeros(txt, evt, tecla, limite);
			break;
		}

	}

	public static void habilitarBtn(short id, JTextField txt1, JTextField txt2, JTextField txt3, JButton btn) {
		switch (id) {
		case Constantes.BTN_AGREGAR:
			habilitarBtnAgregar(txt1, txt2, txt3, btn);
			break;
		case Constantes.BTN_BUSCAR:
			habilitarBtnBuscar(txt1, btn);
			break;
		case Constantes.BTN_MODIFICAR:
			habilitarBtnModificar(txt1, txt2, txt3, btn);
			break;
		}

	}

	public static void actualizarPanelAgregar(JTextField txtNombre, JTextField txtApellido, JTextField txtDNI, JButton btnAgregar) {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtNombre.requestFocus();
		btnAgregar.setEnabled(false);
	}

	public static void actualizarPanelBuscar1(JTextField txtID, JTextField txtNombre, JTextField txtApellido, JTextField txtDNI, JButton btnBuscarID,
			JButton btnModificar, JButton btnCancelar) {
		// PANEL BUSCAR
		txtID.setText("");
		btnBuscarID.setEnabled(false);
		// PANEL MODIFICAR
		// Habilita los JTextField y el JButton
		txtNombre.setEnabled(true);
		txtApellido.setEnabled(true);
		txtDNI.setEnabled(true);
		btnModificar.setEnabled(true);
		btnCancelar.setEnabled(true);
	}

	public static void actualizarPanelBuscar2(JTextField txtID, JButton btnBuscarID) {
		// PANEL BUSCAR
		txtID.setText("");
		btnBuscarID.setEnabled(false);
	}

	public static void actualizarPanelBuscar3(JLabel lblID, JTextField txtID, JTextField txtNombre, JTextField txtApellido, JTextField txtDNI,
			JButton btnBuscarID, JButton btnModificar, JButton btnCancelar) {
		// PANEL BUSCAR
		txtID.setText("");
		btnBuscarID.setEnabled(false);
		// PANEL MODIFICAR
		// Si hay valores pero el cliente no existe, entonces limpia y deshabilita los JTextField
		lblID.setText("Desconocido");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtDNI.setEnabled(false);
		btnModificar.setEnabled(false);
		btnCancelar.setEnabled(false);

	}

	public static void actualizarPanelModificar(JLabel lblID, JTextField txtNombre, JTextField txtApellido, JTextField txtDNI, JButton btnModificar,
			JButton btnCancelar, JComboBox<String> comboNombres) {
		// Si hay valores, entonces limpia y deshabilita los JTextField
		lblID.setText("Desconocido");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");

		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtDNI.setEnabled(false);

		btnModificar.setEnabled(false);
		btnCancelar.setEnabled(false);

		comboNombres.setSelectedIndex(0);
	}

	private static void habilitarBtnAgregar(JTextField txtNombre, JTextField txtApellido, JTextField txtDNI, JButton btnAgregar) {
		if (txtNombre != null && txtApellido != null && txtDNI != null) {
			if (!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtDNI.getText().isEmpty()) btnAgregar.setEnabled(true);
			else btnAgregar.setEnabled(false);
		}
	}

	private static void habilitarBtnBuscar(JTextField txtID, JButton btnBuscar) {
		if (txtID != null) {
			if (!txtID.getText().isEmpty()) btnBuscar.setEnabled(true);
			else btnBuscar.setEnabled(false);
		}
	}

	private static void habilitarBtnModificar(JTextField txtNombre, JTextField txtApellido, JTextField txtDNI, JButton btnModificar) {
		if (txtNombre != null && txtApellido != null && txtDNI != null) {
			if (!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtDNI.getText().isEmpty()) btnModificar.setEnabled(true);
			else btnModificar.setEnabled(false);
		}
	}

	/**
	 * FUNCIONAMIENTO soloLetras()
	 * 
	 * CONDICION PRINCIPAL -Primera condicion: Condiciona si la tecla ingresada no es una letra y si es distinta a la barra
	 * espaciadora, es decir que esta opcion solo permite letras y la barra espaciadora. Tambien pregunta si la longitud del
	 * campo de texto es igual al limite, en caso de que esto sea cierto consume la tecla. En resumen, esta condicion se va
	 * a ejecutar si la tecla ingresada no es una letra y si es distinta a la barra espaciadora, o si la longitud del campo
	 * de texto es igual al limite.
	 * 
	 * CONDICIONES SECUNDARIAS: Estas condiciones se implementaron para darle un toque profesional al sistema. Se agregaron
	 * cuadros de dialogos para informar al usuario los distintos tipos de restricciones sobre los campos de texto. -Primera
	 * condicion: Muestra un mensaje informativo en donde indica que no se permiten ingresar espacios en blanco sobre el
	 * campo de texto. Solo se va a mostrar cuando la tecla ingresada sea la barra espaciadora. -Segunda condicion: Muestra
	 * un mensaje informativo en donde indica que no se permiten ingresar mas letras, ya que la longitud del campo de texto
	 * llego al limite. Solo se va a mostrar cuando la tecla ingresada sea una letra y la longitud del campo de texto sea
	 * igual al limite. -Tercera condicion: Muestra un mensaje informativo en donde indica que solo se permiten letras. Solo
	 * se va a mostrar si ninguna de las condiciones anteriores son verdaderas.
	 */

	private static void soloLetras(JTextField txt, KeyEvent evt, char tecla, int limite) {
		// SOLO LETRAS (minusculas y/o mayusculas) y la tecla backspace (para poder borrar sin que me consuma la tecla).

		/**
		 * Si la tecla es menor al caracter a o mayor al caracter z, y menor al caracter A o mayor al caracter Z, y distinco a
		 * backspace, o la longitud del campo de texto es igual al limite, entonces...
		 */
		if ((((tecla < 'a' || tecla > 'z') && (tecla < 'A' || tecla > 'Z')) && (tecla != KeyEvent.VK_BACK_SPACE))
				|| (txt.getText().length() == limite)) {

			// Primero consume la tecla y luego muestra el mensaje dependiendo del caso
			evt.consume();

			// Si la tecla es igual a space, entonces...
			if (tecla == KeyEvent.VK_SPACE)
				JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			// Si la tecla es una letra y la longitud del campo de texto es igual al limite, entonces...
			else if ((!((tecla < 'a' || tecla > 'z') && (tecla < 'A' || tecla > 'Z'))) && (txt.getText().length() == limite))
				JOptionPane.showMessageDialog(null, "No se pueden ingresar mas letras!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			// Si no se cumple ninguna de las otras condiciones, entonces...
			else JOptionPane.showMessageDialog(null, "Solo se permiten letras!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	/**
	 * FUNCIONAMIENTO soloNumeros()
	 * 
	 * CONDICION PRINCIPAL -Primera condicion: Condiciona si la tecla ingresada no es un numero y si es distinta a la barra
	 * espaciadora, es decir que esta opcion solo permite numeros y la barra espaciadora. Tambien pregunta si la longitud
	 * del campo de texto es igual al limite, en caso de que esto sea cierto consume la tecla. En resumen, esta condicion se
	 * va a ejecutar si la tecla ingresada no es un numero y si es distinta a la barra espaciadora, o si la longitud del
	 * campo de texto es igual al limite.
	 * 
	 * CONDICIONES SECUNDARIAS: Estas condiciones se implementaron para darle un toque profesional al sistema. Se agregaron
	 * cuadros de dialogos para informar al usuario los distintos tipos de restricciones sobre los campos de texto. -Primera
	 * condicion: Muestra un mensaje informativo en donde indica que no se permiten ingresar espacios en blanco sobre el
	 * campo de texto. Solo se va a mostrar cuando la tecla ingresada sea la barra espaciadora. -Segunda condicion: Muestra
	 * un mensaje informativo en donde indica que no se permiten ingresar mas numeros, ya que la longitud del campo de texto
	 * llego al limite. Solo se va a mostrar cuando la tecla ingresada sea un numero y la longitud del campo de texto sea
	 * igual al limite. -Tercera condicion: Muestra un mensaje informativo en donde indica que solo se permiten numeros.
	 * Solo se va a mostrar si ninguna de las condiciones anteriores son verdaderas.
	 */

	private static void soloNumeros(JTextField txt, KeyEvent evt, char tecla, int limite) {
		// SOLO NUMEROS y la tecla backspace (para poder borrar sin que me consuma la tecla)

		// Si la tecla es menor a 0 o mayor a 9 (no es un numero), y distinco a backspace, o la longitud del campo de texto es
		// igual al limite, entonces...
		if (((tecla < '0' || tecla > '9') && (tecla != KeyEvent.VK_BACK_SPACE)) || (txt.getText().length() == limite)) {

			evt.consume();

			// Si la tecla es igual a space, entonces...
			if (tecla == KeyEvent.VK_SPACE)
				JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			// Si la tecla es un numero y la longitud del campo de texto es igual al limite, entonces...
			else if ((!(tecla < '0' || tecla > '9')) && (txt.getText().length() == limite))
				JOptionPane.showMessageDialog(null, "No se pueden ingresar mas numeros!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			// Si no se cumple ninguna de las otras condiciones, entonces...
			else JOptionPane.showMessageDialog(null, "Solo se permiten numeros!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
