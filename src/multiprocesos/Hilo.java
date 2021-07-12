package multiprocesos;

/**
 * La sincronizacion en Java es la capacidad de controlar el acceso de multiples Thread a cualquier recurso
 * compartido, siendo esta una mejor opcion cuando queremos permitir que solo un Thread acceda al recurso compartido.
 * 
 * ¿Por que utilizar la sincronizacion?
 * La sincronizacion se utiliza principalmente para:
 * 1. Evitar la interferencia del hilo.
 * 2. Evitar problemas de consistencia.
 * 
 * Hay dos tipos de sincronizacion de subprocesos:
 * -La sincronizacion de subprocesos mutua exclusiva que ayuda a evitar que los hilos interfieran entre si mientras
 * comparten datos. Esto se puede hacer de tres formas en Java:
 * 1. Por metodo sincronizado.
 * 2. Por bloque sincronizado.
 * 3. Por sincronizacion estatica.
 * -Cooperacion (comunicacion entre subprocesos en java)
 * 
 * https://stackoverflow.com/questions/13264726/java-syntax-synchronized-this
 * 
 */
public class Hilo implements Runnable {

	private Thread hilo;
	private boolean suspendido;
	private boolean pausado;
	private static final int TIEMPO_BLOQUEADO = 250;

	/* Usa sleep para esperar tiempo. Los wait son para otra cosa (sincronizacion) y
	 * sufren de despertares esp�reos. */

	// Crea un nuevo hilo/proceso/tarea y le pasa un objeto Runnable (this) que contiene el metodo run()
	public Hilo(String nombre) {
		hilo = new Thread(this, nombre);
	}

	// El metodo run() contiene el codigo a ser ejecutado asincronicamente
	@Override
	public void run() {

		boolean bandera = false;

		System.out.println("[" + Thread.currentThread().getName() + "] iniciando...");

		try {

			for (int i = 1; i < 100; i++) {

				if (i == 99) bandera = true;

				System.out.print(i + " ");

				// Cada 10 columnas...
				if ((i % 10) == 0) {
					System.out.println();
					// Suspende el hilo temporalmente por una cantidad determinada en milisegundos
					Thread.sleep(TIEMPO_BLOQUEADO);
				}

				/* Con synchronized(this) el bloque esta custodiado por la instancia. En cada caso, solo un hilo puede entrar en el
				 * bloque. */
				// Sincroniza los hilos y los deja a la espera mientras esten suspendidos
				synchronized (this) {

					while (suspendido)
						wait();

					if (pausado) break;
				}

			}
		} catch (InterruptedException e) {
			System.out.println(hilo.getName() + " interrumpido.");
		}

		if (bandera) System.out.println();
		System.out.println("[" + hilo.getName() + "] finalizado.");

	}

	private void iniciar() {
		hilo.start(); // Ejecuta el metodo run()
	}

	private void suspender() {
		suspendido = true;
		System.out.println("[" + hilo.getName() + "] suspendido.");
	}

	/**
	 * Si declara algun metodo como sincronizado, se conoce como metodo sincronizado. El metodo sincronizado se utiliza para
	 * bloquear un objeto para cualquier recurso compartido. Cuando un hilo invoca un metodo sincronizado, adquiere
	 * automaticamente el bloqueo para ese objeto y lo libera cuando el hilo completa su tarea.
	 * 
	 * Si los metodos no se sincronizan lanza un IllegalMonitorStateException.
	 */
	private synchronized void reanudar() {
		suspendido = false;
		notify(); // A diferencia de notifyAll(), este despierta uno de los hilos en espera
		System.out.println("[" + hilo.getName() + "] reanudado.");
	}

	private void pausar() {
		pausado = true;
		System.out.println("[" + hilo.getName() + "] pausado.");
	}

	private void matar() {
		try {
			/* El metodo join() que se llamamo al final, hace que el programa principal espere (synchronized) hasta que el hilo este
			 * muerto (finalize su ejecucion). */
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Hilo pirncipal (" + Thread.currentThread().getName() + ") iniciando...");

		// CICLO DEL HILO
		// 1. Nuevo
		Hilo h1 = new Hilo("Hilo 1");

		// 2. Ejecutando
		h1.iniciar();

		// 3. Bloqueado
		/* El hilo principal se encarga de suspender y reaundar los hilos
		 * creados. */
		Thread.sleep(TIEMPO_BLOQUEADO); // Espera un segundo antes de suspender el hilo
		h1.suspender();

		Thread.sleep(TIEMPO_BLOQUEADO); // Espera un segundo antes de reanudar el hilo
		h1.reanudar();

		Thread.sleep(TIEMPO_BLOQUEADO); // Espera un segundo antes de suspender el hilo
		h1.pausar();

		// 4. Muerto
		h1.matar();

		Thread.sleep(TIEMPO_BLOQUEADO);

		Hilo h2 = new Hilo("Hilo 2");

		h2.iniciar();

		Thread.sleep(2000);
		h2.pausar();

		h2.matar();

		// Hilo principal (monotarea)
		System.out.println("Hilo principal (main) finalizado.");
	}

}