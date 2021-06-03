package swing.layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//char[] etiquetas = { '7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', ',', '=', '+' };

public class _2 {

	public static void main(String[] args) {
		new Marco2().setVisible(true);
	}

}

class Marco2 extends JFrame {

	public Marco2() {

		setFrameProperties();

	}

	private void setFrameProperties() {
		setTitle("Calculadora");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		// Agrega la lamina al marco.
		add(new PanelCalculadora());

		// pack();

	}

}

class PanelCalculadora extends JPanel {

	private JPanel panelBotones;
	private JButton btnPantalla;
	private boolean principio;
	private double resultado;
	private String operador;

	public PanelCalculadora() {

		principio = true;

		operador = "=";

		// Esta lamina va a administrar los componentes con un BorderLayout.
		setLayout(new BorderLayout());

		btnPantalla = new JButton("0");
		btnPantalla.setEnabled(false);
		// Agrega el boton al panel.
		add(btnPantalla, BorderLayout.NORTH);

		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(4, 4));

		ponerBotones();

		// Agrega la lamina de botones dentro de la lamina de la calculadora.
		add(panelBotones, BorderLayout.CENTER);

	}

	private void ponerBotones() {

		String[] etiquetas = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ",", "=", "+" };
		JButton btn;

		// CLASES INTERNAS LOCALES.
		// Oyentes para los numeros.
		class OyenteNumero implements ActionListener {

			public void actionPerformed(ActionEvent e) {

				if (principio) {
					btnPantalla.setText("");
					principio = false;
				}

				// Toma el texto anterior.
				btnPantalla.setText(btnPantalla.getText() + e.getActionCommand()); // getActionCommand captura el texto que esta asociado a ese boton.
			}

		}

		// Oyente para los operadores.
		class OyenteOperador implements ActionListener {

			// Inicializo a true la variable principio para que la proxima vez que pulse un boton, se limpie el texto y no se concatene el operador aritmetico.
			public void actionPerformed(ActionEvent e) {

				calcular(Double.parseDouble(btnPantalla.getText()));
				operador = e.getActionCommand();

				principio = true;
			}

			private void calcular(Double numero) {

				switch (operador) {
					case "+":
						resultado += numero;
						break;
					case "-":
						resultado -= numero;
						break;
					case "/":
						resultado /= numero;
						break;
					case "*":
						resultado *= numero;
						break;
					case "=":
						resultado = numero;
						break;

				}

				btnPantalla.setText("" + resultado); // String.valueOf(resultado)

			}

		}

		// Oyente oyente = new Oyente();
		// Principio de sustitucion.
		ActionListener oyenteNumero = new OyenteNumero(); // Veo claramente que estoy trabajando en el evento ya que ahi esta la clase ActionListener.
		ActionListener oyenteOperador = new OyenteOperador();

		for (String etiqueta : etiquetas) {

			btn = new JButton(etiqueta);

			if (etiqueta.equals("/") || etiqueta.equals("*") || etiqueta.equals("-") || etiqueta.equals("+") || etiqueta
					.equals("="))
				btn.addActionListener(oyenteOperador);
			else
				btn.addActionListener(oyenteNumero);

			// Agrega los botones al panel interno respetando el orden del array etiquetas.
			panelBotones.add(btn);

		}

	}

}
