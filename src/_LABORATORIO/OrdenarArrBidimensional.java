package _LABORATORIO;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class OrdenarArrBidimensional extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private Object[][] objetos = { { "Juan", 20, 100 }, { "Jose", 15, 10 }, { "Miguel", 5, 20 }, { "Chirola", 20, 30 }, { "RX7", 1, 99 } };

	private JComboBox<String> combo;
	private JButton btnOrdenar;
	private JTextField txtEdad;
	private JTextField txtNivel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenarArrBidimensional frame = new OrdenarArrBidimensional();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OrdenarArrBidimensional() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);

		txtEdad = new JTextField(10);
		txtNivel = new JTextField(10);

		combo = new JComboBox<String>();
		combo.setModel(new DefaultComboBoxModel<String>(getNombres()));
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (evt.getSource() == combo) {
					if (combo.getSelectedIndex() != -1) {
						for (int i = 0; i < objetos.length; i++) {
							if (combo.getSelectedItem().equals("" + objetos[i][0])) {
								txtEdad.setText("" + objetos[i][1]);
								txtNivel.setText("" + objetos[i][2]);
								break;
							}
						}
					}
				}
			}
		});
		panel.add(combo);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (evt.getSource() == btnOrdenar) {
					ordenar();
				}

			}
		});
		panel.add(btnOrdenar);

		panel.add(txtEdad);
		panel.add(txtNivel);

	}

	// { "Juan", 20 }, { "Jose", 15 }, { "Miguel", 5 }, { "Chirola", 20 }
	private void ordenar() {
		String auxNombre;
		int auxEdad;

		combo.removeAllItems();

		// El primer for controlada cada item y el segundo el intercambio
		for (int i = 0; i < objetos.length - 1; i++) {
			/* Se le resta - 1 al tamaño del array ya que el limite se llega en la suma de j + 1, evitando asi tambien un
			 * ArrayIndexOutOfBoundsException. */
			for (int j = 0; j < objetos.length - 1 - i; j++) {

				// Si x es mayor a y, entonces se intercambia el nombre y la edad
				if ((int) objetos[j][1] > (int) objetos[j + 1][1]) {
					auxNombre = "" + objetos[j + 1][0];
					objetos[j + 1][0] = objetos[j][0];
					objetos[j][0] = auxNombre;

					auxEdad = (int) objetos[j + 1][1];
					objetos[j + 1][1] = objetos[j][1];
					objetos[j][1] = auxEdad;

				}

			}
		}

		for (int i = 0; i < objetos.length; i++) {
			for (int j = 0; j < objetos[i].length; j++)
				System.out.print(objetos[i][j] + " ");
			System.out.println();
		}

		for (int i = 0; i < objetos.length; i++)
			combo.addItem("" + objetos[i][0]);

	}

	private String[] getNombres() {
		ArrayList<String> nombres = new ArrayList<String>();

		for (int i = 0; i < objetos.length; i++)
			nombres.add((String) objetos[i][0]);

		return nombres.toArray(new String[0]);
	}

}
