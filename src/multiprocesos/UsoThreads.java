package multiprocesos;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Rectangle {

	static int time = 6;

	// Tamaño del rectangulo
	private static final int RECTANGLE_WIDTH = 15;
	private static final int RECTANGLE_HEIGHT = 15;
	// Coordenadas xy del rectangulo
	private double x = 0, y = 0;
	private double dx = 1, dy = 1; // ?

	// Mueve el rectangulo invirtiendo posicion si choca con los limites
	public void mover(Rectangle2D limites) {

		// FIXME Por que el ancho de la lamina es de 284? Si cree una ventana de 300 de ancho

		x += dx;
		y += dy;

		if (x <= 0) dx = -dx;
		if (x >= limites.getMaxX() - RECTANGLE_WIDTH) dx = -dx; //
		if (y <= 0) dy = -dy;
		if (y > limites.getMaxY() - RECTANGLE_HEIGHT) dy = -dy;

	}

	// Crea e inicializa un Rectangle2D a partir de las coordenadas y el tamaño especificado
	public Rectangle2D getShape() {
		return new Rectangle2D.Double(x, y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
	}

}

class RectangleHile implements Runnable {

	private Rectangle rectangle;
	private Component component;

	public RectangleHile(Rectangle rectangle, Component component) {
		this.rectangle = rectangle;
		this.component = component;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {

			// Dibuja el cuadrado llamando al metodo paintComponent() de la clase Lamina
			component.paint(component.getGraphics());

			// Mueve el cuadrado
			rectangle.mover(component.getBounds());

			try {
				Thread.sleep(Rectangle.time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Lamina extends JPanel {

	private static final long serialVersionUID = -7436842110508511195L;

	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

	// Agrega una pelota al ArrayList
	public void add(Rectangle rectangle) {
		rectangles.add(rectangle);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// Controla cada rectangulo del ArrayList
		for (Rectangle rectangle : rectangles)
			/* Rellena el interior de una forma utilizando la configuracion del contexto Graphics2D. Los atributos de renderizado
			 * aplicados incluyen Clip, Transform, Paint y Composite. */
			g2.fill(rectangle.getShape());

		// Asegura que la pantalla este actualizada siendo util para las animaciones
		Toolkit.getDefaultToolkit().sync();

	}

}

// Marco con lamina y botones
class Marco extends JFrame {

	private Lamina lamina;
	private JButton boton;

	public Marco() {

		setTitle("Blocks");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);

		initialize();

	}

	private void initialize() {

		lamina = new Lamina();

		add(lamina, BorderLayout.CENTER);

		JPanel panelBotones = new JPanel();

		crearBoton(panelBotones, "Dale!", new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				start();
			}
		});

		crearBoton(panelBotones, "Salir", new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		crearBoton(panelBotones, "Relentizar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Rectangle.time = 1000;
			}
		});

		add(panelBotones, BorderLayout.SOUTH);
	}

	private void crearBoton(Container c, String titulo, ActionListener oyente) {
		boton = new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}

	public void start() {

		Rectangle rectangle = new Rectangle();

		lamina.add(rectangle);

		new Thread(new RectangleHile(rectangle, lamina)).start();

	}

}
