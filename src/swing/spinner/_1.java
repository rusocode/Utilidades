package swing.spinner;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	public Marco() {

		setFrameProperties();

	}

	private void setFrameProperties() {

		setTitle("Spinner");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		add(new Lamina());

	}
}

class Lamina extends JPanel {
	private JLabel lblTexto;
	private JSpinner spinner;

	public Lamina() {

		// Crea un objeto JSpinner pasando como argumento una CLASE INTERNA ANONIMA de tipo SpinnerNumberModel.
		spinner = new JSpinner(new SpinnerNumberModel(5, 1, 10, 1) {

			public Object getNextValue() {
				return super.getPreviousValue();
			}

			public Object getPreviousValue() {
				return super.getNextValue();
			}
			
		});
		spinner.setPreferredSize(new Dimension(50, 20));

		add(spinner);

	}

	// private class MiModeloJSpinner extends SpinnerNumberModel {
	//
	// public MiModeloJSpinner() {
	// super(5, 1, 10, 1); // Inicia en 5, con un valor minimo de 0 y un maximo de 10 incrementando estos valores en 1.
	// }
	//
	// /*
	// * Sobreescribimos los metodos de la clase SpinnerNumberModel cambiandole la logica a la inversa,
	// * es decir que el proximo valor devuelve el anterior y asi sucesivamente.
	// *
	// * */
	// public Object getNextValue() {
	// return super.getPreviousValue();
	// }
	//
	// public Object getPreviousValue() {
	// return super.getNextValue();
	// }
	//
	// }

}
