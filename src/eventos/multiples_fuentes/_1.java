package eventos.multiples_fuentes;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	public Marco() {

		add(new Lamina());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

}

class Lamina extends JPanel {

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	public Lamina() {

		btn1 = new JButton("Amarillo");
		btn2 = new JButton("Azul");
		btn3 = new JButton("Rojo");

		add(btn1);
		add(btn2);
		add(btn3);

	}

	/* AbstractAction es la clase adaptadora de la interfaz Action.
	 * 
	 * PREGUNTA: ¿Si heredamos de la clase AbstractAction que implementa los metodos de la interfaz Action,
	 * no deberiamos sobreescribir todos los metodos obligadamente? ¿En caso afirmativo, por que la clase es abstracta?.
	 * 
	 * RESPUESTA: Una clase es abstracta cuando al menos (digo al menos, no todos) uno de sus metodos es abstracto. Un metodo
	 * abstracto es aquel que este declarado pero no implementado (nunca completado) en una clase abstracta. Si heredamos de
	 * una clase abstracta, estamos obligados a implementar los metodos abstractos de la clase abstracta pero no los
	 * que no sean abstractos.
	 * 
	 * Bien, la clase AbstractAction implementa la interfaz Action. Esto quiere decir que la clase AbstractAction tiene
	 * obligatoriamente implementados todos los metodos de la interfaz Action, pero eso no quiere decir que dichos metodos
	 * sean abstractos y por lo tanto si heredo de la clase AbstractAction no tengo por que implementar obligatoriamente estos
	 * metodos.
	 * 
	 * La clase AbstractAction la programo muy acertadamente algun programador que quiso evitar que al implementar la interfaz
	 * Action tengamos que implementar (escribir) siete metodos.
	 * 
	 * 
	 * PREGUNTA: ¿Pero por que entonces la clase AbstractAction es abstracta, si ha
	 * declarado todos los metodos como normales?, porque si tuviera alguno nos obligaria a sobreescribirlo y no es el caso.
	 * 
	 * RESPUESTA: Pues habria que preguntarselo al programador, pero te recuerdo que el declarar una clase abstracta no
	 * se hace unicamente porque uno o mas de los metodos es abstracto. Puedes declarar una clase como abstracta y que no
	 * tenga ningun metodo abstracto.
	 * 
	 * ¿Y con que objetivo hacer esto?
	 * 1: Especificar la abstraccion de la clase, es decir, que se encuentra en la cuspide de la jerarquia de la herencia.
	 * 
	 * 2: Para que no se pueda instanciar la clase. Una clase abstracta no se puede instanciar.
	 * 
	 * Segun subes por la jerarquia de la herencia, las clases van siendo cada vez mas genericas, es decir, mas abstractas
	 * y por ende carece de sentido instanciar dicha clase.
	 * 
	 * Es un problema conceptual que explique en el video de clases abstractas. */
	private class Oyente extends AbstractAction {

		// Esperando un evento...
		public void actionPerformed(ActionEvent e) {

		}

	}

}
