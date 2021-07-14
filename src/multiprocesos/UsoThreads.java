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

class Pelota {

	// Tamaño de la pelota
	private static final int TAMX = 15;
	private static final int TAMY = 15;

	// Coordenadas xy de la pelota
	private double x = 250, y = 250;
	// ?
	private double dx = 1, dy = 1;

	// Mueve la pelota invirtiendo posicion si choca con limites
	public void mover(Rectangle2D limites) {

		x += dx;
		y += dy;

		// Min X = 0
		// Max X = 284
		// System.out.println(limites.getMaxX());
		if (x < limites.getMinX()) {
			// System.out.println("asdd");
			x = limites.getMinX();
			dx = -dx;
		}

		if (x >= limites.getMaxX() - TAMX) {
			x = limites.getMaxX() - TAMX;
			dx = -dx;
		}

		if (y < limites.getMinY()) {
			y = limites.getMinY();
			dy = -dy;
		}

		if (y + TAMY >= limites.getMaxY()) {
			y = limites.getMaxY() - TAMY;
			dy = -dy;
		}

	}

	// Crea e inicializa un Rectangle2D a partir de las coordenadas y el tamaño especificado
	public Rectangle2D getShape() {
		return new Rectangle2D.Double(x, y, TAMX, TAMY);
	}

}

class Lamina extends JPanel {

	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

	// Agrega una pelota al ArrayList
	public void add(Pelota pelota) {
		pelotas.add(pelota);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// Controla cada pelota del ArrayList
		for (Pelota pelota : pelotas)
			/* Rellena el interior de una forma utilizando la configuracion del contexto Graphics2D. Los atributos de renderizado
			 * aplicados incluyen Clip, Transform, Paint y Composite. */
			g2.fill(pelota.getShape());

	}

}

// Marco con lamina y botones
class Marco extends JFrame {

	private Lamina lamina;
	private JButton boton;

	public Marco() {

		setTitle("Test");
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
			public void actionPerformed(ActionEvent evento) {
				start();
			}
		});
		crearBoton(panelBotones, "Salir", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				System.exit(0);
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

		Pelota pelota = new Pelota();

		lamina.add(pelota);

		for (int i = 1; i <= 1000; i++) {

			// Dibuja el cuadrado llamando al metodo paintComponent() de la clase Lamina
			lamina.paint(lamina.getGraphics());

			// Mueve el cuadrado
			pelota.mover(lamina.getBounds());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
