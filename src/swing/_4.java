/* https://www.youtube.com/watch?v=zWUMgcFbOlg&index=58&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk */

package swing;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class _4 extends JFrame {

	public static void main(String[] args) {

		// La instruccion setVisible(true) debe estar siempre en ultimo lugar.
		new Marco2().setVisible(true);

	}

}

// ventana = marco
class Marco2 extends JFrame {

	public Marco2() {
		setTitle("Primer texto");
		setSize(600, 450);
		setLocation(400, 200);

		// Crea la lamina y la agrega al marco.
		/* El metodo paintComponent es llamado cuando se crea la lamina (es un metodo perteneciente a la clase JComponent
		 * y que hereda JPanel) de forma automatica y cada vez que realizamos alguna operacion del tipo minimizar,
		 * maximizar, o redimensionar, la lamina que a su vez esta dentro del marco tambien es llamado.
		 * 
		 * El objeto grafico que se le pasa por parametro es lo que haya dibujado en ese momento en la lamina, de tal
		 * forma que cuando cargas la lamina por primera vez se llama a pintComponent y se le pasa por parametro
		 * Graphics g, siendo g lo que tengamos en ese momento en la lamina. Si redimensionamos, minimizamos, etc.,
		 * volvemos a llamar a paintComponent pasandole por parametro lo que tengamos dibujado en ese momento.
		 * En realidad estamos llamando continuamente a paintComponent cuando realizamos operaciones con la
		 * ventana y pasandole por parametro lo que haya dibujado que a su vez es pasado al metodo paintComponent
		 * de la clase JComponent con la instruccion super. */
		Lamina lamina = new Lamina();
		add(lamina);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

// panel = lamina
class Lamina extends JPanel {

	/* paintComponent pertenece a la clase JComponent, y se encarga de dibujar componentes (botones, textos, etc.)
	 * encima de la lamina. Este metodo recibe por parametro un objeto de tipo Graphics.
	 * Graphics es una clase que se encarga de proporcionar todas las herramientas (metodos) para poder dibujar
	 * graficos. */
	public void paintComponent(Graphics g) {

		/* Invoca al metodo paintComponent de la clase JComponent para que haga su trabajo y ademas de eso,
		 * dibuje un texto. */
		super.paintComponent(g);

		g.drawString("Hola ruso!", 100, 100);
	}

}