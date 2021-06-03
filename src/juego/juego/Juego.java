package juego.juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import juego.control.Teclado;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;
	private static final int ALTO = 600;

	private static final String NOMBRE = "Juego";

	private static int aps = 0; // actualizaciones por segundo
	private static int fps = 0; // frames por segundo, cantidad de veces que se dibuja en la pantalla

	private static volatile boolean enFuncionamiento = false;

	private static JFrame ventana;
	private static Thread thread; // el thread de java sirve para ejecutar varios procesos a la vez desde el metodo run() que es implementado a partir de Runnable
	private static Teclado teclado;

	// CONSTRUCTOR
	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		// con esto lo que hacemos es decirle a java que detecte todas las teclas que se pulsen dentro de esta clase
		teclado = new Teclado();
		addKeyListener(teclado);

		ventana = new JFrame(NOMBRE); // <-- no esta de mas?
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true); // siempre la hacemos visible al ultimo una vez que se armo la ventana con los componentes
	}

	public static void main(String[] args) {

		Juego juego = new Juego();
		juego.iniciar();
	}

	private synchronized void iniciar() { /* synchronized se asegura de que no puedan cambiar esta variable(enFuncionamiento)
											 * de forma simultanea. Igual es poco probable de que iniciar() y detener() puedan ejecutarse a la vez,
											 * pero nos aseguraremos de que esto no suceda utilizando la palabra clave. */

		enFuncionamiento = true;
		thread = new Thread(this, "Graficos");
		thread.start();
	}

	private synchronized void detener() {

		enFuncionamiento = false;
		try {
			thread.join(); // join() a diferencia de stop() no corta la aplicacion de forma inmediata, espera a que el thread acabe lo que estaba haciendo y entonces si que lo detiene
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// este metodo se ejecuta 60 veces por segundo
	private void actualizar() {

		teclado.actualizar();
		if (teclado.arriba) {
			System.out.println("arriba");
		}
		if (teclado.abajo) {
			System.out.println("abajo");
		}
		if (teclado.izquierda) {
			System.out.println("izquierda");
		}
		if (teclado.derecha) {
			System.out.println("derecha");
		}
		aps++;
	}

	private void mostrar() {

		fps++;
	}

	// ACTUA COMO SEGUNDO PROCESO
	@Override
	public void run() {

		final int NS_POR_SEGUNDO = 1000000000; // 1000000000 NS = 1 S

		// declaro byte por que son para numero muy pequeños: -128 a 127
		final byte APS_OBJETIVO = 60;/* son 60 actualizaciones por segundo, cuanto mas bajo sea este numero.. mejor,
										 * por que menos veces se actualizara el juego y menos cargara el equipo
										 * que este ejecutandolo, tampoco puede ser muy bajo por que el juego
										 * iria lento y tampoco muy alto */

		// declarado como double por que se toma un valor grande de decimales
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO; // el fin de esta variable es saber cuantos NS tienen que transcurrir para actualizar al objetivo 60 por segundo

		long referenciaActualizacion = System.nanoTime(); // este metodo(System.nanoTime()) no depende del SO, sino del microprocesador y mide el tiempo en nanosegundos tomando como referencia los ciclos de reloj del procesador
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;

		double delta = 0; // delta es la cantidad de tiempo que a transcurrido hasta que se realiza una actualizacion

		requestFocus();

		// bucle principal
		while (enFuncionamiento) {/* si deseamos cambiar la variable enFuncionamiento desde el metodo main,
									 * entonces el bucle principal lo tomaria como una variable corrompida,
									 * para que esto no suceda cambiaremos la variable a volatil */

			// tomamos una referencia del tiempo, es decir que iniciamos el cronometro
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;

			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				delta--;
			}
			mostrar(); // mostrar() lo dejamos afuera, por que lo importante es la velocidad a la que cambia el estado del juego
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps); // muestra en 1 seg cuantas aps y fps hay
				// despues de 1 seg, vuelvo los valores a 0 para que no se vayan al infinito
				aps = 0;
				fps = 0;
				// mientras mejor sea el procesador, mayores seran las actualizaciones
				referenciaContador = System.nanoTime();
			}
		}
	}
}