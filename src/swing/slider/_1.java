package swing.slider;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

		setTitle("Slider");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		add(new Lamina());

	}
}

class Lamina extends JPanel {
	private JSlider slider;
	private JLabel lblTexto;
	private static int c;

	public Lamina() {

		setLayout(new BorderLayout());
		JPanel paneSlider = new JPanel();

		lblTexto = new JLabel("Texto");
		lblTexto.setFont(new Font("Serif", Font.PLAIN, 50));
		add(lblTexto, BorderLayout.SOUTH);

		/* 0: el valor minimo del slider.
		 * 100: el valor maximo del slider.
		 * 5: el valor inicial del control deslizante. */
		slider = new JSlider(/* SwingConstants.VERTICAL, */0, 100, 50);

		// Espacio de linea mayores.
		slider.setMajorTickSpacing(25);
		// Espacio de lineas menores.
		slider.setMinorTickSpacing(5);

		// Pinta las lineas.
		slider.setPaintTicks(true);
		// Pinta los numeros.
		slider.setPaintLabels(true);

		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				// System.out.println("estás manipulando el deslizante: " + c);
				lblTexto.setFont(new Font("Serif", Font.PLAIN, slider.getValue()));

			}
		});

		// Iman hacia las lineas.
		// slider.setSnapToTicks(true);

		paneSlider.add(slider);
		add(paneSlider, BorderLayout.NORTH);

	}

}
