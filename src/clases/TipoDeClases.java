package clases;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * <p>
 * <b>Clase interna</b><br>
 * Las clases internas pueden acceder a los campos privados de la clase que la engloba, sin tener que crear metodos de
 * acceso, esto es una gran ventaja y se ahorra codigo, ya que solo se usa cuando una clase debe acceder a los campos de
 * ejemplar de otra clase. Tambien sirven para ocultar una clase de otras pertenecientes al mismo paquete y para crear
 * clases internas "anonimas", muy utiles para gestionar eventos y retrollamadas.
 * Sola las clases internas pueden ser privadas. Las clases concretas aceptan modificadores de acceso public y por
 * defecto.
 * </p>
 * 
 * <p>
 * <b>Clase interna local</b><br>
 * Son utiles cuando solo se va a instanciar una vez, con el objetivo de simplifacar aun mas el codigo.
 * Su ambito queda restringido al metodo donde son declaradas y no puede contener ningun modificador de acceso.
 * ¿Ventajas?
 * > Estan muy encapsuladas, ni siquiera la clase a la que pertenecen puede acceder a ella. Tan solo puede acceder a
 * ella el metodo donde estan declaradas.
 * > El codigo resulta mas simple.
 * </p>
 * 
 * <p>
 * <b>Clas interna anonima</b><br>
 * Una clase interna anonima puede resultar util cuando se crea una instancia de un objeto con ciertos "extras", como
 * los metodos de anulacion, sin tener que subclasificar una clase.
 * Por ejemplo:
 * 
 * <pre>
 * <code>
 * button.addActionListener(new ActionListener() {
 * 	   {@literal @}Override
 * 	   public void actionPerformed(ActionEvent e) {
 * 	       // do something
 *     }
 * });
 * </code>
 * </pre>
 * 
 * El uso de este metodo hace que la codificacion sea un poco mas rapida, ya que no necesito crear una clase adicional
 * que implemente <b>{@code ActionListener}</b> - Puedo instanciar una clase interna anonima sin hacer una clase
 * separada.
 * 
 * Solo uso esta tecnica para tareas "rapidas y sucias" en las que hacer que toda una clase se sienta innecesario. Tener
 * varias clases internas anonimas que hacen exactamente lo mismo debe ser refactorizado a una clase real, ya sea una
 * clase interna o una clase separada.
 * </p>
 * 
 * @see <a href=
 *      "https://www.it-swarm-es.com/es/java/como-se-usan-las-clases-internas-anonimas-en-java/958037391/">www.it-swarm-es.com</a>
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class TipoDeClases {

	public static void main(String[] args) {

		Reloj reloj = new Reloj(2000, true);

		// reloj.start1();
		// reloj.start2();
		reloj.start3();

		JOptionPane.showMessageDialog(null, "Pulsa OK para detener el temporizador!");

		System.exit(0);
	}

}

class Reloj {

	private int intervalo;
	private boolean sonido;

	public Reloj(int intervalo, boolean sonido) {
		this.intervalo = intervalo;
		this.sonido = sonido;
	}

	public void start1() {
		new Timer(intervalo, new Oyente()).start();
	}

	public void start2() {

		// Clase interna local
		class Oyente implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				Date ahora = new Date();
				System.out.println("Te pongo la hr. cada " + (intervalo / 1000) + " segundos: " + ahora);
				if (sonido) Toolkit.getDefaultToolkit().beep();

			}
		}

		new Timer(intervalo, new Oyente()).start();
	}

	// https://programmerclick.com/article/60791397920/
	public void start3() {
		// Clase interna anonima
		new Timer(intervalo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date ahora = new Date();
				System.out.println("Te pongo la hr. cada " + (intervalo / 1000) + " segundos: " + ahora);
				if (sonido) Toolkit.getDefaultToolkit().beep();

			}
		}).start();
	}

	// Clase interna
	private class Oyente implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Date ahora = new Date();
			System.out.println("Te pongo la hr. cada " + (intervalo / 1000) + " segundos: " + ahora);
			if (sonido) Toolkit.getDefaultToolkit().beep();

		}
	}

}
