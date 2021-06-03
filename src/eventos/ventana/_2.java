package eventos.ventana;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class _2 {

	public static void main(String[] args) {
		new Marco2().setVisible(true);
	}

}

class Marco2 extends JFrame {

	public Marco2() {

		/* PREGUNTA: ¿Cuando hacemos: MarcoOyente oyente = new MarcoOyente();, estamos reservando un espacio en memoria de tipo MarcoOyente
		 * que tiene por nombre oyente para nuestro objeto que es de tipo MarcoOyente?
		 * 
		 * Pero cuando realizamos la MEGASIMPLIFICACION: addWindowListener(new MarcoOyente());, es como si estuviesemos saltando un paso y por ende
		 * podemos pensar que sera mas eficiente en terminos de consumo de memoria no?. Pero lo que no me queda claro es que si java crea
		 * automaticamente de manera implicita un espacio en memoria para reservar el objeto (que no sabemos su nombre) o que sucede? ¿Cuando
		 * nosotros haciamos lo anterior estamos reservando mas espacios en memoria?
		 * 
		 * RESPUESTA
		 * Pues aqui tu mismo te has respondido porque lo que dices es correcto. A la hora de crear una instancia reservas espacio en
		 * memoria, mientras que cuando llamamos al constructor dentro de addWindowListener(new MarcoOyente()); no lo reservas, ya que no hay operador de
		 * asignacion (=). Al no existir operador de asignacion (=) y no existir una variable objeto, no hay reserva de espacio en memoria. Es mas eficiente
		 * por tanto esta segunda forma. ¿Que ocurre internamente en addWindowListener(new MarcoOyente());? Le pasamos al metodo un parametro de
		 * tipo MarcoOyente dinamicamente sin necesidad de reservar espacio en memoria. */
		addWindowListener(new Oyente()); // TAMBIEN SE PUEDE IMPLEMENTAR UNA CLASE ANONIMA

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/* WindowAdapter es como un puente hacia la interfaz WindowListener para evitar implementar todos sus metodos, permitiendo asi,
	 * sobreescribir solo el metodo que se necesite, dejando el codigo mas limpio.
	 * La diferencia entre una clase abstracta y una interfaz, es que la ultima implementa todos sus metodos por obligacion y la otra solo
	 * los metodos abstractos.
	 * 
	 * 
	 * PREGUNTA: Si WindowAdapter es una clase abstracta, se supone que debe tener almenos un metodo abstracto para que esta clase pueda
	 * ser abstracta, y se supone segun la regla que estamos obligados a sobreescribir el metodo abstracto, sin embargo en la api no se encuentra ningun
	 * metodo abstracto. Entonces ¿Que hace que este clase sea abstracta?﻿
	 * 
	 * RESPUESTA: Las clases abstractas generalmente tienen o pueden tener metodos abstractos, pero NO necesariamente estan obligadas a
	 * tenerlas (como en el caso de WindowAdapter).
	 * 
	 * Entonces, una clase abstracta...
	 * - NO puede ser instanciada.
	 * - Si se puede heredar.
	 * - Estoy obligado a implementar los metodos, si y solo SI ellos son metodos abstractos.
	 * - Si tiene metodos NO abstractos (normales), entonces puedo (si es que lo requiero) sobreescribirlos como pasa en este caso
	 * de la clase abstracta WindowAdapter. */
	private class Oyente extends WindowAdapter {

		public void windowIconified(WindowEvent e) {
			System.out.println("Ventana minimizada.");
		}

	}

}
