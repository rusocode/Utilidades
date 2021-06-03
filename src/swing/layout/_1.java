package swing.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		setTitle("Prueba acciones");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel panel = new Panel();
		// add(panel);

		add(new PanelFlowLayout(), BorderLayout.NORTH); // Ocupa todo el espacio de su zona.
		add(new PanelBorderLayout(), BorderLayout.SOUTH);

	}

}

class PanelFlowLayout extends JPanel {

	public PanelFlowLayout() {
		// El layout por defecto que utiliza la lamina para administrar los componentes es el FlowLayout Center, en donde adapta la ubicacion de los componentes dependiendo del tamaño de la ventana, con un espacio de 5 pixeles por componente y de la ventana.

		// FlowLayout fLayout = new FlowLayout(FlowLayout.LEFT);
		// setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5)); // 20 pixeles horizontales entre los componentes.

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));

	}
}

class PanelBorderLayout extends JPanel {

	public PanelBorderLayout() {

		// Disposicion.
		setLayout(new BorderLayout(10, 10));

		add(new JButton("Azul"), BorderLayout.WEST);
		add(new JButton("Verde"), BorderLayout.EAST);
		add(new JButton("Negro"), BorderLayout.CENTER);
	}
}
