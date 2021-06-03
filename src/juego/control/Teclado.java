package juego.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {

	private final static int NUMERO_TECLAS = 120; // asignamos la cantidad de teclas
	private final boolean[] TECLAS = new boolean[NUMERO_TECLAS]; // creamos un array de 120 teclas, en donde se almacena true o false

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;

	public void actualizar() {

		arriba = TECLAS[KeyEvent.VK_W]; // esto quiere decir que arriba va a ser igual a la tecla W, entonces lo asignamos a la variable booleana arriba
		abajo = TECLAS[KeyEvent.VK_S];
		izquierda = TECLAS[KeyEvent.VK_A];
		derecha = TECLAS[KeyEvent.VK_D];
	}

	// estos metodos son la interfaz de la clase KeyListener
	public void keyPressed(KeyEvent e) { // tecla presionada

		/* con la instancia 'e' llamamos al metodo getKeyCode() en donde se obtiene la tecla pulsada,
		 * entonces si en el array TECLA tenemos la W le asignamos true al array */
		TECLAS[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) { // tecla soltada

		TECLAS[e.getKeyCode()] = false;
	}

	// este metodo no lo usamos
	public void keyTyped(KeyEvent e) {

	}
}
