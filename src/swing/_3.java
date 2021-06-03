package swing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class _3 {

	public static void main(String[] args) {

		// Crea la ventana y la hace visible.
		new Marco().setVisible(true);

	}

}

class Marco extends JFrame {

	public Marco() {
		
		this.setTitle("Ventana");

		/* Claramente "entorno" no es un objeto de la clase Toolkit ya que la misma es abstracta y no puede ser instanciada,
		 * pero si no es un objeto ¿Entonces que es "entorno"?
		 * 
		 * Respuesta: Es una "referencia" a la clase Toolkit. Que una clase no se pueda instanciar no quiere decir
		 * que no se puedan crear "referencias" pertenecientes a esa clase. La pregunta que surge ahora es "¿Que es
		 * una referencia?" Una referencia a una clase es cuando escribes por ejemplo: JButton btn;. En la
		 * instruccion anterior no hay instancia (aunque podriamos crearla con JButton btn = new JButton();).
		 * Lo que hay es un "apunte hacia", una referencia de la clase JButton. Lo mismo ocurre con el codigo del video.
		 * 
		 * "entorno" es un objeto que representa la AWT de la maquina donde se este ejecutando el programa, es decir,
		 * el sistema de representacion grafica con todo lo que ello implica: pantalla, resolucion, look & feel, etc.
		 * De esta forma conseguimos guardar en una variable-objeto "entorno" el AWT de la maquina donde se ejecute
		 * el programa. El AWT sera muy diferente dependiendo de si ejecutamos el programa bajo Windows, Linux, Mac,
		 * Solaris, Unix, etc.
		 * 
		 * Una clase abstracta no permite ser instanciada, pero crear variables-objetos puedes crear todas las que
		 * quieras. Una cosa es instanciar (utilizar el operador "new" para llamar al constructor) y otra diferente
		 * es crear una variable de tipo abstracta. La instrucción "Toolkit entorno" no tiene ningun problema.
		 * Lo que no podras hacer nunca es "Toolkit entorno = new Toolkit();". */
		Toolkit entorno = Toolkit.getDefaultToolkit(); // Almacena el entorno de trabajo que se esta utilizando

		// Almacena la resolucion de la pantalla actual.
		Dimension tamanoPantalla = entorno.getScreenSize();
		// Almacena el ancho y alto de la pantalla en las variables de tipo int.
		int anchoPantalla = tamanoPantalla.width;
		int alturaPantalla = tamanoPantalla.height;

		// Establece la mitad del ancho y alto de la pantalla para el tamaño de la ventana.
		setSize(anchoPantalla / 2, alturaPantalla / 2);

		// Centra la ventana en el medio de la pantalla. Esta linea se coloca despues de definir el tamaño de la ventana.
		// setLocationRelativeTo(null); // Funciona en cualquier OS
		// Centra la ventana en el medio de la pantalla dividiendo el ancho y alto entre 4.
		setLocation(anchoPantalla / 4, alturaPantalla / 4);

		// Image icono = entorno.getImage("src/icono.png");
		// setIconImage(icono);

		setIconImage(entorno.getImage("src/img/icono.png"));

		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

