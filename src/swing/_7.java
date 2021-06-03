/* https://www.youtube.com/watch?v=mMTlAQwi1Cg&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=61 */

package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class _7 extends JFrame {

	public static void main(String[] args) {

		new Marco5().setVisible(true);

	}

}

// RGB: Red, Green and Blue, son los 3 colores basicos para crear otro tipo de colores (0 - 255).

/* Diferencia entre white y WHITE: Antes de la API 1.4, las constantes se declaraban en minusculas.
 * 
 * The color white. In the default sRGB space.
 * 
 * public final static Color white = new Color(255, 255, 255);
 * 
 * The color white. In the default sRGB space.
 * 
 * @since 1.4
 * 
 * public final static Color WHITE = white; */

class Marco5 extends JFrame {

	public Marco5() {

		setTitle("Manejando colores");
		setSize(400, 400);
		setLocationRelativeTo(null);

		Lamina4 lamina = new Lamina4();
		// Agrega la lamina al marco.
		add(lamina);

		// Establece un color de fondo para la lamina.
		// lamina4.setBackground(Color.GRAY);
		// setBackground(SystemColor.window);

		// Establece un color de fondo correspondiente al color por defecto del OS.
		lamina.setBackground(SystemColor.window);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class Lamina4 extends JPanel {

	public void paintComponent(Graphics g) {

		final int ANCHO = 200;
		final int ALTO = 150;

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, ANCHO, ALTO);

		// Establece un color.
		g2.setPaint(Color.BLUE);
		// Rellena el rectangulo de color azul.
		g2.fill(rectangulo);
		// Cambiar el color del trazo.
		g2.setPaint(Color.RED);
		// "Y con ese color en la mano", lo que hago es dibujar el trazo del rectangulo con draw.
		g2.draw(rectangulo);

		/* La clase Graphics2D hereda de Graphics. Graphics tiene el metodo setColor y Graphics2D setPaint,
		 * luego entonces Graphics2D tiene los dos y por ese motivo puedes utilizar ambos con el mismo resultado
		 * excepto si te da por hacer degradados que deberias utilizar setPaint porque setColor no va. */

		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);

		Color color = new Color(155, 200, 152);
		// Blanco vendria hacer la luz total: Color(255,255,255);

		// Crea un color de tipo RGB.
		// g2.setPaint(new Color(220, 71, 175).brighter().brighter()); // El metodo brighter deja mas claro el color, y se puede aplicar varias veces
		// g2.setPaint(new Color(220, 71, 175).darker()); // Lo contrario al metodo brighter, es decir, lo deja mas oscuro

		g2.setPaint(color);
		g2.fill(elipse);

	}
}