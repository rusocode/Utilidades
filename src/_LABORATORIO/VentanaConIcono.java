package _LABORATORIO;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class VentanaConIcono extends JFrame {

	private static final long serialVersionUID = 1L;

	private Image image;
	private ImageIcon imageIcon;
	private URL imageURL;

	public VentanaConIcono() {

		setLayout(new FlowLayout());

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width / 2, d.height / 2);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Ubicacion de la imagen
		// Carga un recurso externo
		/* 32x32 parace ser el tama�o justo para todos los contextos */
		imageURL = getClass().getClassLoader().getResource("textures" + File.separator + "sub" + File.separator + "torre32.png");

		// REFLEXION
		// getClass().getClassLoader() = VentanaConIcono.class

		imageIcon = new ImageIcon(imageURL); // Crea un objeto de tipo ImageIcon
		image = imageIcon.getImage(); // Devuelve un objeto de tipo Image
		setIconImage(image); // Recibe por parametro un objeto de tipo Image

		ArrayList<Image> images = new ArrayList<Image>();
		images.add(image);
		// setIconImages(images); // Recibe por parametro la LISTA de iconos

		info();

		// Megasimplificacion
		// setIconImage((new ImageIcon(getClass().getClassLoader().getResource("img/logo0.png"))).getImage());
		// setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConIcono.class.getResource("/img/bola.png")));

		// Informacion sobre los distintos tama�os de iconos de marco
		// https://stackoverflow.com/questions/18224184/sizes-of-frame-icons-used-in-swing
		// https://stackoverflow.com/questions/15247653/which-icon-sizes-to-use-with-a-jframes-seticonimages-method

		/* Nota: Los sistemas de ventanas nativas pueden usar diferentes imagenes de diferentes dimensiones para representar una
		 * ventana, dependiendo del contexto (por ejemplo, decoracion de ventanas, lista de ventanas, barra de tareas, etc.).
		 * Tambien podrian usar una sola imagen para todos los contextos o ninguna imagen. */
	}

	public void info() {
		System.out.println("imagen = " + imageIcon.getDescription() + "\nx = " + imageIcon.getIconWidth() + "\ny = " + imageIcon.getIconHeight());
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new VentanaConIcono().setVisible(true);

	}

}
