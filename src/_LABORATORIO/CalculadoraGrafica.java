package _LABORATORIO;

/**
 * @Name: Calculadora
 * @Author: Juan Debenedetti (alias ruso)
 * @Date last changes: 16.08.2019
 * @Version: 1.0.0
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CalculadoraGrafica extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	DecimalFormat decimales = new DecimalFormat("0.00");

	private JPanel panel;
	private JLabel lblN1;
	private JLabel lblN2;
	private JTextField txtN1;
	private JTextField txtN2;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnDivision;
	private JButton btnProducto;
	private JButton btnMayor;
	private JButton btnMenor;
	private JLabel lblTotal;

	private CalculadoraGrafica() {
		createGUI();
		setFrameProperties();
	}

	private void createGUI() {
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 237, 126);
		panel.setLayout(null);
		getContentPane().add(panel);

		lblN1 = new JLabel("N1:");
		lblN1.setBounds(10, 11, 17, 14);
		panel.add(lblN1);
		txtN1 = new JTextField();
		txtN1.setBounds(33, 8, 73, 20);
		panel.add(txtN1);

		lblN2 = new JLabel("N2:");
		lblN2.setBounds(116, 11, 17, 14);
		panel.add(lblN2);
		txtN2 = new JTextField();
		txtN2.setBounds(143, 8, 73, 20);
		panel.add(txtN2);

		btnSuma = new JButton("+");
		btnSuma.setBounds(10, 36, 67, 23);
		btnSuma.setFocusable(false);
		btnSuma.addActionListener(this);
		panel.add(btnSuma);

		btnResta = new JButton("-");
		btnResta.setBounds(88, 36, 67, 23);
		btnResta.setFocusable(false);
		btnResta.addActionListener(this);
		panel.add(btnResta);

		btnDivision = new JButton("/");
		btnDivision.setBounds(10, 70, 67, 23);
		btnDivision.setFocusable(false);
		btnDivision.addActionListener(this);
		panel.add(btnDivision);

		btnProducto = new JButton("*");
		btnProducto.setBounds(88, 70, 67, 23);
		btnProducto.setFocusable(false);
		btnProducto.addActionListener(this);
		panel.add(btnProducto);

		btnMayor = new JButton("Mayor");
		btnMayor.setBounds(165, 36, 67, 23);
		btnMayor.setFocusable(false);
		btnMayor.addActionListener(this);
		panel.add(btnMayor);

		btnMenor = new JButton("Menor");
		btnMenor.setBounds(165, 70, 67, 23);
		btnMenor.setFocusable(false);
		btnMenor.addActionListener(this);
		panel.add(btnMenor);

		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setForeground(Color.GREEN);
		lblTotal.setBounds(10, 104, 145, 14);
		panel.add(lblTotal);

	}

	private void setFrameProperties() {
		getContentPane().setLayout(null);
		setSize(new Dimension(243, 155));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private double getN1() {

		return Double.parseDouble(this.txtN1.getText());

		// try {
		//
		// } catch (NumberFormatException e) {
		// System.out.println("Datos incorrectos!");
		// }

	}

	private double getN2() {
		return Double.valueOf(this.txtN2.getText());
	}

	// Comprueba si hay datos de entrada
	private boolean checkInput() {
		return !this.txtN1.getText().isEmpty() && !this.txtN2.getText().isEmpty();
	}

	// Limpia los dos campos de texto y hace focus en el campo txtN1
	private void clean() {
		this.txtN1.setText("");
		this.txtN2.setText("");
		this.txtN1.requestFocus();
		lblTotal.setForeground(Color.GREEN);
	}

	// Sobreescribe (implementa) el metodo de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent evt)
			throws NumberFormatException /* La clausula throws indica que este metodo puede llegar a lanzar una excepcion de tipo
											 * NumberFormatException. El uso de esta excepcion se podria evitar, ya que NumberFormatException es una
											 * excepcion no controlada y por lo tanto no es obligatorio implementarla. Hacer esto se considera una
											 * mala practica de programacion. */ {

		if (checkInput()) {

			/* El bloque try{}catch(){} evita detener la ejecucion del programa si es que capturo la excepcion. */

			try {

				if (evt.getSource() == this.btnSuma) {
					// El metodo format devuelve un dato de tipo String por lo tanto no hace falta usar la conversion de valueOf
					lblTotal.setText(decimales.format(getN1() + getN2()));
					clean();
				}

				if (evt.getSource() == this.btnResta) {
					lblTotal.setText(decimales.format(getN1() - getN2()));
					clean();
				}

				if (evt.getSource() == this.btnDivision) {
					lblTotal.setText(decimales.format(getN1() / getN2()));
					clean();
				}

				if (evt.getSource() == this.btnProducto) {
					lblTotal.setText(decimales.format(getN1() * getN2()));
					clean();
				}

				if (evt.getSource() == this.btnMayor) {
					lblTotal.setText(String.valueOf(Math.max(getN1(), getN2())));
					clean();
				}

				if (evt.getSource() == this.btnMenor) {
					lblTotal.setText(String.valueOf(Math.min(getN1(), getN2())));
					clean();
				}

			} catch (NumberFormatException e) {
				System.out.println("Datos incorrectos!");
				lblTotal.setForeground(Color.RED);
				lblTotal.setText("Datos incorrectos!");
			}

		} else JOptionPane.showMessageDialog(null, "Faltan datos.", "Error", JOptionPane.ERROR_MESSAGE);

	}

	public static void main(String[] args) {
		/* El metodo setLookAndFeel lanza excepciones controladas por java, por lo tanto es obligatorio encerrar el metodo en un
		 * bloque try{}catch(){}. */
		try {
			// Tomo el aspecto visual (Look and Feel) del OS en el que se esta ejecutando la aplicacion
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new CalculadoraGrafica().setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}
}
