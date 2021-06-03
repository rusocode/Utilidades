package swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class _8 extends JFrame {

	public static void main(String[] args) {

		new Marco6().setVisible(true);

	}

}

class Marco6 extends JFrame {

	public Marco6() {

		setTitle("Manejando fuentes");
		setSize(400, 400);
		setLocationRelativeTo(null);

		Lamina5 lamina = new Lamina5();
		add(lamina);
		lamina.setBackground(SystemColor.window);

		// Establece el color por defecto de todo lo que vayamos a escribir en la lamina.
		lamina.setForeground(Color.RED);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class Lamina5 extends JPanel {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		Font fuente = new Font("Arial", Font.BOLD, 20);
		g2.setFont(fuente);
		// g2.setColor(Color.GREEN.darker().darker());
		g2.drawString("Juan", 100, 100);

		g2.setFont(new Font("Courier", Font.ITALIC, 25));
		// g2.setColor(new Color(255, 41, 65));
		g2.drawString("Ruso", 100, 200);

	}
}

final class Fuente {

	// Almacena en el array de tipo String todos los tipos de fuentes instaladas en el OS.
	private static String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // FIXME: La declaro como final? Ya que las fuentes no se pueden modificar.

	public static void mostrarFuentes() {

		// Imprime las fuentes.
		for (String fuente : fuentes)
			System.out.println(fuente);

	}

	public static void buscarFuente() {

		String fuenteIngresada = JOptionPane.showInputDialog("Introduce fuente");
		boolean estaLaFuente = false;

		for (String fuente : fuentes) {
			if (fuente.equalsIgnoreCase(fuenteIngresada))
				estaLaFuente = true;
		}

		if (estaLaFuente)
			System.out.println("Fuente instalada.");
		else
			System.out.println("No esta instalada la fuente.");

	}

}
