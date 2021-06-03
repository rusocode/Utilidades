/* https://www.youtube.com/watch?v=rQS5P63GTU8&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=53 */

package clases_internas;

import javax.swing.Timer;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * CLASE INTERNA
 * Las clases internas o inner class, pueden acceder a los campos privados de la clase que
 * la engloba, sin tener que crear metodos de acceso, esto es una gran ventaja y se ahorra codigo,
 * ya que solo se usa cuando solo una clase debe acceder a los campos de ejemplar de otra clase.
 * Tambien sirven para ocultar una clase de otras pertenecientes al mismo paquete.
 * Tambien sirven para crear clases internas "anonimas", muy utiles para gestionar eventos y retrollamadas.
 * 
 * Sola las clases internas pueden ser privadas. Las clases publicas aceptan modificadore
 * de acceso public y por defecto.
 */

public class ClasesInternas1 {

	public static void main(String[] args) {

		Reloj reloj = new Reloj(2000, true);

		reloj.enMarcha();

		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener el temporizador.");

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

	public void enMarcha() {

		DameLaHora2 oyente = new DameLaHora2();
		// ActionListener oyente = new DameLaHora2();

		Timer timer = new Timer(intervalo, oyente);

		timer.start();
	}

	// CLASE INTERNA
	private class DameLaHora2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Date ahora = new Date();
			System.out.println("Te pongo la hr. cada " + (intervalo / 1000) + " segundos: " + ahora);

			if (sonido)
				/* getDefaultToolkit(): Devuelve el entorno de trabajo que estamos utilizando para programar.
				 * Toolkit entorno = Toolkit.getDefaultToolkit(); Esta instruccion almacena
				 * en la variable entorno nuestro entrono de trabajo. Nuestro entorno de trabajo como objeto
				 * que es tiene sus propiedades y sus metodos.
				 * 
				 * Aqui lo he hecho en dos pasos Toolkit entorno = Toolkit.getDefaultToolkit(); y luego
				 * entorno.beep(); Pero ¿por que hacerlo en dos pasos si se puede simplificar el codigo y hacerlo
				 * en uno? Toolkit.getDefaultToolkit().beep(); */
				Toolkit.getDefaultToolkit().beep(); // Emite un sonido

		}
	}
}
