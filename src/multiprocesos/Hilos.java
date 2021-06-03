package multiprocesos;

public class Hilos {

	/*
	 * Usa sleep para esperar tiempo. Los wait son para otra cosa (sincronización) y
	 * sufren de despertares espúreos.
	 */

	private static final int TIEMPO_BLOQUEADO = 1000;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Hilo pirncipal (" + Thread.currentThread().getName() + ") iniciando...");

		// CICLO DEL HILO
		// 1. Nuevo
		Hilo h1 = new Hilo("Hilo 1");

		// 2. Ejecutando
		h1.iniciar();

		// 3. Bloqueado
		// ------- El hilo principal se encarga de suspender y reaundar los hilos
		// creados
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

	static class Hilo implements Runnable {

		private Thread hilo;
		private boolean suspendido;
		private boolean pausado;
		private final int TIEMPO_BLOQUEADO = 250;

		/*
		 * Crea un nuevo hilo/proceso/tarea y le pasa como parametro al constructor de
		 * la clase Thread el objeto Runnable (this) que contiene el metodo run() y lo
		 * alamacena en una instancia de la clase Thread.
		 */
		public Hilo(String nombre) {
			hilo = new Thread(this, nombre);
		}

		// El metodo run() contiene el codigo a ser ejecutado “asincronicamente”
		@Override
		public void run() {

			boolean bandera = false;

			System.out.println("[" + Thread.currentThread().getName() + "] iniciando...");

			try {
				for (int i = 1; i < 100; i++) {

					if (i == 99)
						bandera = true;

					System.out.print(i + " ");

					// Salta linea cada 10 numeros y duerme el hilo
					if ((i % 10) == 0) {
						System.out.println();
						Thread.sleep(TIEMPO_BLOQUEADO); // Bloquea el hilo actual x tiempo sin perder la prioridad de
														// ningun monitor
					}

					// Sincroniza los hilos y los deja a la espera mientras esten suspendidos
					synchronized (this) {

						while (suspendido)
							wait();

						if (pausado)
							break;
					}

				}
			} catch (InterruptedException e) {
				System.out.println(hilo.getName() + " interrumpido.");
			}

			if (bandera)
				System.out.println();
			System.out.println("[" + hilo.getName() + "] finalizado.");

		}

		// Inicia un hilo
		private void iniciar() {
			hilo.start();
		}

		// Finaliza un hilo
		/*
		 * El metodo join() que se llamamo al final, hace que el programa principal
		 * espere (synchronized) hasta que el hilo este “muerto” (finalize su
		 * ejecucion).
		 */
		private void matar() {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		// Suspende un hilo
		private void suspender() {
			suspendido = true;
			System.out.println("[" + hilo.getName() + "] suspendido.");
		}

		// Reanuda un hilo
		private synchronized void reanudar() { // Si los metodos no se sincronizan lanza un IllegalMonitorStateException
			suspendido = false;
			notify(); // A diferencia de notifyAll(), este despierta uno de los hilos en espera
			System.out.println("[" + hilo.getName() + "] reanudado.");
		}

		// Pausa un hilo
		private void pausar() {
			pausado = true;
			System.out.println("[" + hilo.getName() + "] pausado.");
		}

	}

}