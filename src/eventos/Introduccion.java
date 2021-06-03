/* https://www.youtube.com/watch?v=b8rkMBnXuwk&index=65&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk */

package eventos;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * El evento seria "al hacer clic", y la accion "se abrio el menu".
 * Tambien existen eventos de ventana que suceden cuando se cierra, abre o cambia el tamaño de esta. Todos estos eventos van desencadenando diferentes
 * acciones, por eso se define en programacion a la palabra evento como desencadenante de la accion, LOS EVENTOS DESENCADENAN ACCIONES.
 * 
 * Como java es un lenguaje de programacion orientado 100% a objetos, esto tambien incluye a los eventos.
 *
 * Eventos: fuentes y oyentes
 * 
 * Definicion: Desencadenantes de la accion.
 * 
 * 3 factores-
 * ¿Que desencadena la accion? --> Objeto Evento (Evento) / Al hacer clic, presionar una tecla, etc.
 * ¿Quien desencadena la accion? --> Objeto Fuente (Objeto desde el que parte el evento) / Un boton, un menu, una imagen, etc.
 * ¿Quien recibe la accion? --> Objeto Listener (Oyente (Preparado para recibir ese evento y que ocurra algo)) / EJ: Un area de texto que muestra la nueva informacion.
 */

public class Introduccion {

	public static void main(String[] args) {

		new MarcoBotones().setVisible(true);

	}

}

class MarcoBotones extends JFrame {
	public MarcoBotones() {

		LaminaBotones lamina = new LaminaBotones();
		add(lamina);

		setTitle("Botones y Eventos");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

// La lamina es la que tiene que implementar la interfaz ActionListener, porque es la propia lamina quien va a recibir el evento
class LaminaBotones extends JPanel implements ActionListener {

	/* Factores
	 * 
	 * 1- Objeto evento: al hacer clic
	 * 2- Objeto fuente: btnAzul que va a desencadenar el evento
	 * 3- Oyente: this */

	private JButton btnRojo = new JButton("Rojo");
	private JButton btnVerde = new JButton("Verde");
	private JButton btnAzul = new JButton("Azul");

	public LaminaBotones() {

		add(btnRojo);
		add(btnVerde);
		add(btnAzul);

		// Agrega el oyente a los botones.
		/* ¿Que evento va a tener lugar en este programa? Un evento de tipo ActionListener, es decir de tipo raton (addActionListener).
		 * Si fuera un evento de ventana, entonces seria addWindowListener. */
		btnRojo.addActionListener(this);
		btnVerde.addActionListener(this);

		/* De esta forma le estamos diciendo a btnAzul que va a desencadenar un evento al hacer clic, y que ese evento lo tiene que recibir
		 * el objeto this que esta a la escucha.
		 * Para que el metodo addActionListener funcione hay que implementar la interfaz ActionListener. */
		btnAzul.addActionListener(this); // Hay que indicarle como argumento quien va a ser el oyente (this: hace referencia al objeto en donde nos encontramos)

		setBackground(SystemColor.window);
	}

	/* Cuando se hace clic sobre un boton, este lanza un evento al objeto lamina. Como el objeto lamina implementa la interfaz ActionListener,
	 * entonces el objeto del evento entra como parametro (ActionEvent evt) en actionPerformed y se ejecuta el metodo. */
	public void actionPerformed(ActionEvent e) {

		// ¿Como hago para diferenciar el origen de un evento que recibe este metodo?
		// Alamacenando el origen del evento recibido con el metodo getSource.
		Object btnPulsado = e.getSource();

		if (btnPulsado == btnRojo) setBackground(Color.RED);
		if (btnPulsado == btnVerde) setBackground(Color.GREEN);
		if (btnPulsado == btnAzul) setBackground(Color.BLUE);

	}

}