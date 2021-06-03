package eventos.multiples_fuentes;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class _2 {

	public static void main(String[] args) {
		new Marco2().setVisible(true);
	}

}

class Marco2 extends JFrame {

	public Marco2() {

		add(new Lamina2());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

}

class Lamina2 extends JPanel {

	// private JButton btnAmarillo;
	private Color color;
	private Oyente accionAmarillo, accionAzul, accionRojo;

	public Lamina2() {

		/* Tenia el problema de que mis ImageIcon eran muy grandes y los botones crecian mucho.
		 * Use este codigo para redimensionarlas:
		 * 
		 * ImageIcon imgIcon1 = new ImageIcon("src/graficos/bola_amarilla.jpg");
		 * Image imgEscalada1 = imgIcon1.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		 * Icon iconoEscalado1 = new ImageIcon(imgEscalada1); */

		accionAmarillo = new Oyente("Amarillo", new ImageIcon("src/img/bola_amarilla2.png"), Color.YELLOW);
		accionAzul = new Oyente("Azul", new ImageIcon("src/img/bola_azul2.png"), Color.BLUE);
		accionRojo = new Oyente("Rojo", new ImageIcon("src/img/bola_roja2.png"), Color.RED);

		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));

		/* InputMap proporciona un enlace entre un evento de entrada (actualmente solo se usan KeyStrokes) y un Object. Los
		 * InputMaps generalmente se usan con un ActionMap, para determinar una Accion a realizar cuando se presiona una tecla.
		 * Un InputMap puede tener un elemento primario en el que se buscan enlaces no definidos en el InputMap.
		 * 
		 * WHEN_IN_FOCUSED_WINDOW: La combinancion de teclas deberia de ser invocada cuando el componente que lo reciba este
		 * en la ventana que tiene el foco. Es decir, el objeto que va a recibir el foco es el boton que esta dentro de la
		 * ventana del foco, como esto lo estamos programado dentro de la lamina, entonces toma como origen la lamina.
		 * En definitiva le estamos diciendo que el objeto del foco se encuentra dentro de la lamina.
		 * 
		 * WHEN_FOCUSED: Incoca la combinancion de teclas cuando el foco esta en la lamina y no en otro componente. */
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		// Representa una accion con la combinacion de una tecla.
		/* modifiers := shift | control | ctrl | meta | alt | altGraph
		 * typedID := typed <typedKey>
		 * typedKey := string of length 1 giving Unicode character.
		 * pressedReleasedID := (pressed | released) key
		 * key := KeyEvent key code name, i.e. the name following "VK_". */
		// KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A"); // Modificador=ctrl Caracter unicode=A.

		// Asigna la combinacion de teclas a un objeto.
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl T"), "fondo amarillo");

		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo rojo");

		// Asigna el objeto a la accion, para poder crear un vinculo entre el objeto creado (fondo amarillo) con la accion.
		ActionMap mapaAccion = getActionMap(); // Es lo mismo que "Empleado empleado = dameEmpleado();". Devuelve el ActionMap utilizado para determinar que Accion disparar para un enlace KeyStroke particular.

		// Asigna ese objeto a la combinacion de teclas
		mapaAccion.put("fondo amarillo", accionAmarillo);
		mapaAccion.put("fondo azul", accionAzul);
		mapaAccion.put("fondo rojo", accionRojo);

		/* CONCLUSION: En definitiva lo que hemos echos es decirle a nuestro programa que el objeto que tiene el foco es el boton.
		 * Hacer que la combinacion de teclas ("ctrl A", "ctrl B" y "ctrl R") incidan en los tres botones, y luego
		 * que cada boton maneje el color de fondo que tenga que poner dependiendo de la accion asignada a cada tecla. */
	}

	// El Oyente es la lamina (this);
	private class Oyente extends AbstractAction {

		public Oyente(String nombre, Icon icono, Color color) {

			// Clave:valor
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
			// Accion
			putValue("color de fondo", color);
		}

		public void actionPerformed(ActionEvent e) {
			// Rescata del objeto del evento el valor correspondiente a una clave, el "color de fondo" se guarda como clave.
			color = (Color) getValue("color de fondo");

			setBackground(color);

			System.out
					.println("Nombre: " + getValue(Action.NAME) + " - Descripcion: " + getValue(Action.SHORT_DESCRIPTION));

		}

	}

}
