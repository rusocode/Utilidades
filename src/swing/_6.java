/* https://www.youtube.com/watch?v=VBvRGtEEGGE */

package swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
// Figuras geometricas de la biblioteca Java2D
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class _6 extends JFrame {

	public static void main(String[] args) {

		new Marco4().setVisible(true);

	}

}

class Marco4 extends JFrame {

	public Marco4() {
		this.setTitle("Java2D");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);

		Lamina3 lamina = new Lamina3();
		add(lamina);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class Lamina3 extends JPanel {

	public void paintComponent(Graphics g) {

		final int ANCHO = 200;
		final int ALTO = 150;

		super.paintComponent(g);

		// No se puede instanciar un objeto abstracto.
		// Graphics2D g2 = new Graphics2D();

		// Convierte el objeto de tipo Graphics en un objeto de tipo Graphics2D.
		Graphics2D g2 = (Graphics2D) g; // REFUNDICION para poder dibujar las figuras geometricas desde Graphics2D.

		// Aprovecho para agregar que la siguiente linea de codigo genera anti-aliasing en las lineas (o cualquier figura) para que no se vean como dientes de cocodrilo.
		RenderingHints representacion = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.addRenderingHints(representacion);

		// Como Rectangle2D es una clase abstracta y no se puede instanciar, se crea un objeto de tipo Rectangle2D.Double().
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, ANCHO, ALTO);

		/* Dibuja el rectangulo. Este metodo (draw) de la clase Graphics2D debe recibir por parametro un
		 * objeto que implemente la interfaz Shape (Rectangle2D). */
		g2.draw(rectangulo);

		// Crear un objeto de tipo Ellipse2D.Double.
		Ellipse2D elipse = new Ellipse2D.Double();

		// Utiliza el rectangulo dibujado como LIMITE de la elipse.
		elipse.setFrame(rectangulo);

		// Dibuja la elipse dentro del rectangulo.
		g2.draw(elipse);

		// Instancia directamente la linea 2D dentro del metodo draw.
		g2.draw(new Line2D.Double(100, 100, 300, 250));

		// Obtiene el centro de x e y, y el radio del rectangulo como referencia.
		double centroEnX = rectangulo.getCenterX();
		double centroEnY = rectangulo.getCenterY();
		// double radio = 150;

		/* Para hacer la circunferencia circunscrita al rectangulo hay que aplicar el teorema de Pitagoras para
		 * calcular la diagonal del rectangulo, la mitad de dicha diagonal es el radio de la circunferencia, en el
		 * codigo cambiar donde se calcula el radio por:
		 * double radio = Math.hypot(rectangulo.getWidth(), rectangulo.getHeight()) / 2.; */
		double radio = Math.hypot(rectangulo.getWidth(), rectangulo.getHeight()) / 2; // Hipotenusa / 2

		// Otras formas efectivas para que el circulo exterior encuadre al rectangulo desde las esquinas.
		// double radio = 125;
		// double radio = Math.sqrt(Math.pow(ANCHO, 2) + Math.pow(ALTO, 2)) / 2;

		Ellipse2D circulo = new Ellipse2D.Double();

		// Utiliza el centro del rectangulo (circunferencia) como referencia para dibujar el circulo sobre este.
		circulo.setFrameFromCenter(centroEnX, centroEnY, centroEnX + radio, centroEnY + radio); // Toma los parametros de rectangulo desde el centro.

		// Dibuja el circulo.
		g2.draw(circulo);

		// Estos objetos (rectangulo, elipse, linea y circulo) pertenecen a la biblioteca de Java 2D.

	}
}