/* https://www.youtube.com/watch?v=z3CGPfjSYN8&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=63 */

package swing;

import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;

/* Captura imagenes que estan fuera del programa utilizando el metodo read. El metodo read tambien permite leer imagenes 
 * que estan en una direccion web, especificandole una URL.
 * Definicion de la API:
 * Devuelve un BufferedImage como resultado de la decodificacion de un Archivo suministrado con un ImageReader 
 * seleccionado automaticamente entre los que estan actualmente registrados. */
import javax.imageio.ImageIO; // I = Input (entrada) - O = Out (Salida)

import javax.swing.JFrame;
import javax.swing.JPanel;

public class _9 extends JFrame {

	public static void main(String[] args) {

		new Marco7().setVisible(true);

	}

}

class Marco7 extends JFrame {

	public Marco7() {

		setTitle("Incluyendo imagenes");
		setBounds(750, 300, 300, 200);

		Lamina6 lamina = new Lamina6();
		add(lamina);
		lamina.setBackground(SystemColor.window);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class Lamina6 extends JPanel {

	// Declaro private a la variable de tipo Image por que solo la uso en esta clase.
	private Image imagenBola;

	// Con el constructor ya tenemos una lamina cargada en memoria, no pintada.
	public Lamina6() {
		/* Las excepciones sirven para lanzar un fallo del programa y mostrar un mensaje de error correspondiente.
		 * Para aquellos metodos como pj. el metodo read que es susceptible a detener un fallo durante su ejecucion, nos obliga
		 * a programar un codigo que solucione esa situacion. Es decir, como es probable que el metodo read falle, entonces tenemos
		 * que crear un codigo que solucione esa circunstancia para que nuestro programa no se caiga cuando intente capturar la
		 * imagen. */
		try {
			imagenBola = ImageIO.read(new File("src/img/bola.png")); // Este metodo esta preparado para lanzar una excepcion, por lo cual hay que crear un codigo que este preparado para solucionar ese problema
		} catch (IOException e) { // Especifica el tipo de excepcion que podria ocurrir
			System.out.println("La imagen no se encuentra.");
		}
		/* try: intenta esto, y si no puedes... intenta lo otro (catch).
		 * Las excepciones son errores que pueden ocurrir en tiempo de ejecucion. */
	}

	/* RECUERDO: Cada vez que redimensionas un frame, lo cambias de tamaño, etc., estas volviendo a llamar al metodo
	 * paintComponent para que se vuelvan a pintar los componentes. Por eso, cada informacion que tienes en el marco,
	 * se actualiza. */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// La clase File trabaja con archivos que estan almacenados en el disco duro.
		File rutaAuto = new File("src/img/auto.png");

		/* Si no sabes el ancho o largo de la imagen, entonces tomas los valores de la imagen con los siguientes metodos,
		 * pasandole como argumento el componente en donde se estan usando esas imagenes, osea la lamina.
		 * Con la palabra reservada this indicamos quien es el objeto (en este caso la lamina) que esta esperando a
		 * que la imagen se carge. */
		int anchoBola = imagenBola.getWidth(this); // El operador this hace referencia al objeto en donde me encuentro.
		int largoBola = imagenBola.getHeight(this);

		// Para que dibuje las bolas hasta los limites del marco inicial.
		int anchoBolaRedondeado = Math.round(300 / anchoBola);
		int largoBolaRedondeado = Math.round(200 / largoBola);

		// Dibuja la imagen en la lamina.
		g.drawImage(imagenBola, 0, 0, null);

		// Controla el eje horizontal x.
		for (int x = 0; x < anchoBolaRedondeado; x++) {
			// Controla el eje vertical y.
			for (int y = 0; y < largoBolaRedondeado; y++) {
				// Evita copiar la bola en la misma posicion que se creo la primera vez.
				if (x + y > 0) {
					g.copyArea(0, 0, anchoBola, largoBola, anchoBola * x, largoBola * y); // Multiplico para que las bolas no salga unas encima de otra.
				}
			}
		}

		// x, y, widht, height, dx, dy
		// g.copyArea(0, 0, 16, 16, 0, 32); // Copia la imagen (x, y, widht(pixeles) y height(pixeles)) a dx y dy (destino), cordenadas x;y.
		// Los 4 primeros parametros determinan que es lo que quiero copiar y los ultimos 2, el destino.

	}
}
