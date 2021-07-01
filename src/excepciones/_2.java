package excepciones;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import static util.Constants.*;

public class _2 {

	public static void main(String[] args) {

		new Marco().setVisible(true);

	}

}

class Marco extends JFrame {

	private static final long serialVersionUID = 8933970992681552655L;

	public Marco() {

		setTitle("Excepciones");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		add(new Lamina());

	}

}

class Lamina extends JPanel {

	private static final long serialVersionUID = -6158405130837597721L;

	private Image imagenBola;

	public Lamina() {

		try {
			imagenBola = ImageIO.read(new File(BOLA));
		} catch (IOException e) {
			System.out.println("La imagen no se encuentra.");
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(imagenBola, 0, 0, null);
	}

}
