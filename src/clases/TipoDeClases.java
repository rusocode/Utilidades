package clases;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * -Clase interna
 * Las clases internas pueden acceder a los campos privados de la clase que la engloba, sin tener que crear metodos de
 * acceso, esto es una gran ventaja y se ahorra codigo, ya que solo se usa cuando una clase debe acceder a los campos de
 * ejemplar de otra clase. Tambien sirven para ocultar una clase de otras pertenecientes al mismo paquete y para crear
 * clases internas "anonimas", muy utiles para gestionar eventos y retrollamadas.
 * Sola las clases internas pueden ser privadas. Las clases concretas aceptan modificadores de acceso public y por
 * defecto.
 * 
 * -Clase interna local
 * Son utiles cuando solo se va a instanciar una vez, con el objetivo de simplifacar aun mas el codigo.
 * Su ambito queda restringido al metodo donde son declaradas y no puede contener ningun modificador de acceso.
 * ¿Ventajas?
 * > Estan muy encapsuladas, ni siquiera la clase a la que pertenecen puede acceder a ella. Tan solo puede acceder a
 * ella el metodo donde estan declaradas.
 * > El codigo resulta mas simple.
 * 
 * TODO Falta la clase anonima
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class TipoDeClases {

	public static void main(String[] args) {

		Reloj reloj = new Reloj(2000, true);

		reloj.start1();
		// reloj.start2();

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

		// Clase interna local, solo se puede usar una vez
		class Oyente implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				Date ahora = new Date();
				System.out.println("Te pongo la hr. cada " + (intervalo / 1000) + " segundos: " + ahora);
				if (sonido) Toolkit.getDefaultToolkit().beep();

			}
		}

		new Timer(intervalo, new Oyente()).start();
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
