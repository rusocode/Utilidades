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

	public Marco() {

		propiedades();

	}

	// Establece las propiedades basicas a la ventana: titulo, tamaño, etc.
	private void propiedades() {
		setTitle("Excepciones");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		// Crea una lamina y la agrega al marco
		add(new Lamina());

	}

}

class Lamina extends JPanel {

	// Declara una varibale privada de tipo Image llamada "imageBola"
	private Image imagenBola;

	/**
	 * Explicacion del bloque TRY - CATCH
	 * 
	 * EJ: Cuando alguien borra o mueve el archivo bola.png implica un fallo de tipo IOException y que es ajeno a nuestra
	 * voluntad, entonces
	 * java contempla esta situacion y nos obliga a construir los bloque try (intentar) - catch (capturar) para capturar la
	 * posible excepcion (fallo).
	 * Cuando digo que java nos "obliga" a utilizar los bloques try - catch en la linea "imagenBola = ImageIO.read(new
	 * File("src/img/bola.png"));",
	 * es que el propio lenguaje de programacion para este tipo de excepciones que pudieran ocurrir, nos obliga a construir
	 * un coidgo (try - catch)
	 * para capturar el posible error que puede llegar a ocurrir.
	 * 
	 * Traducido: Intenta (try) guardar esta imagen (bola.png), y en el caso de que no lo consigas, capturame (catch) la
	 * excepcion y me ejecutas
	 * este codigo (imagenBola = ImageIO.read(new File("src/img/bola.png"));), evitando asi, la detencion del programa.
	 * 
	 */

	// Inicializa la imagen en el constructor de la clase
	public Lamina() {

		try {
			imagenBola = ImageIO.read(new File(BOLA));
		} catch (IOException e) {
			System.out.println("La imagen no se encuentra.");
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		// Dibuja una bola en la posicion x=0;Y=0
		g.drawImage(imagenBola, 0, 0, null);
	}

}
