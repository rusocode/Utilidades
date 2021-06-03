package pizzeria.modelo;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Mecanica {

	public static void habilitarBotones(JButton btnModificar, JButton btnEliminar, JButton btnEliminarTodo) {
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnEliminarTodo.setEnabled(true);
	}

	public static void deshabilitarBotones(JButton btnModificar, JButton btnEliminar, JButton btnEliminarTodo) {
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnEliminarTodo.setEnabled(false);
	}

	public static void accion1(JTextField txtActivo, JTextField txt1, JTextField txt2, JComboBox<String> combo1, JComboBox<String> combo2) {

		// Activa el texto actual
		txtActivo.setEnabled(true);
		txtActivo.requestFocus();
		txtActivo.setText("1");
		txtActivo.selectAll();

		// Deshabilita el texto, lo limpia y vuelve el combo a -1
		txt1.setEnabled(false);
		txt1.setText("");
		combo1.setSelectedIndex(-1);

		txt2.setEnabled(false);
		txt2.setText("");
		combo2.setSelectedIndex(-1);

	}

	// Limpia el combo y el txt
	public static void accion2(JTextField txt, JComboBox<String> combo) {
		txt.setEnabled(false); // La diferencia con el metodo setEditable() es que en este no se puede copiar ni pegar, osea no se puede editar
		txt.setText("");
		combo.setSelectedIndex(-1);
	}

}
