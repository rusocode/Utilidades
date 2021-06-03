/* https://www.youtube.com/watch?v=dA5pIY4Na_0&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=54 */

package clases_internas;

import javax.swing.Timer;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * CLASE INTERNA LOCAL
 * Son utiles cuando solo se va a utilizar (instanciar) la clase interna una vez.
 * El objetivo es simplifacar aun mas el codigo.
 * Su ambito queda restringido al metodo donde son declaradas. ¿Ventajas?
 * - Estan muy "encapsuladas". Ni siquiera la clase a la que pertenecen puede acceder a ella. Tan
 * solo puede acceder a ella el metodo donde estan declaradas.
 * - El codigo resulta mas simple.
 * La clase interna local no puede contener ningun modificador de acceso.
 */

public class ClasesInternas2 {

	public static void main(String[] args) {

		Reloj2 reloj2 = new Reloj2();

		reloj2.enMarcha(2000, true);

		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener el temporizador.");

		System.exit(0);

	}

}


class Reloj2 {

	public void enMarcha(int intervalo, boolean sonido) {

		// CLASE INTERNA LOCAL
		class DameLaHora3 implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				Date ahora = new Date();
				System.out.println("Te pongo la hr. cada " + (intervalo / 1000) + " segundos: " + ahora);

				if (sonido) Toolkit.getDefaultToolkit().beep(); // Emite un sonido

			}
		}

		// Solo se puede usar una vez
		DameLaHora3 oyente = new DameLaHora3();

		Timer timer = new Timer(intervalo, oyente);

		timer.start();
	}

}
