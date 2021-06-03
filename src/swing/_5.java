/* https://www.youtube.com/watch?v=nNu6ideyyGs&index=59&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk */

package swing;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class _5 extends JFrame {

	public static void main(String[] args) {

		new Marco3().setVisible(true);

	}

}

class Marco3 extends JFrame {

	public Marco3() {
		this.setTitle("Prueba dibujo");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);

		Lamina2 lamina = new Lamina2();
		add(lamina);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class Lamina2 extends JPanel {

	/* Con el tiempo la clase Graphics se ha ido quedando corta.
	 * Hay un monto de cosas que no permite, ej: modificar el grosor del trazo, rotar las figuras geometricas, etc.
	 * Debido a esto, se agrego la biblioteca Java2D (Graphics2D). A diferencia de la clase Graphics, Java2D permite hacer
	 * operaciones mas complejas.
	 * En Java2D, a las figuras geometricas se les da un enfoque orientado a objetos. Esto quiere decir, que en esta
	 * biblioteca 2D tenemos clases como Rectangle2D, Ellipse2D, etc., pertenecientes al paquete java.awt.geom.*; */
	public void paintComponent(Graphics g) {
		// Hace su trabajo con el objeto de tipo Graphics que le estamos pasando cuando dibujamos en la lamina.
		super.paintComponent(g);

		// Dibuja un rectangulo en la posicion x=50;y=80, con un ancho de 250px y un alto de 200px.
		// g.drawRect(50, 80, 250, 200);

		// Dibuja 10 rectangulos en diferentes posiciones.
		// for (int i = 1; i <= 10; i++)
		// g.drawRect(i * 10, i * 10, 200, 200);

		// g.drawLine(100, 100, 300, 200);

		// g.drawArc(50, 100, 100, 200, 120, 150);

	}
}