package multiprocesos;

/**
 * La sincronizacion se basa en una entidad interna conocida como bloqueo o monitor. Cada objeto tiene un candado
 * asociado. Por convencion, un hilo que necesita acceso constante a los campos de un objeto tiene que adquirir el
 * bloqueo del objeto antes de acceder a ellos, y luego liberar el bloqueo cuando haya terminado con ellos.
 * 
 * En este ejemplo, no hay sincronizacion, por lo que la salida es inconsistente. Veamos el ejemplo:
 * 
 * Tomando como ejemplo cosas de la realidad siempre se entienden mejor las cosas...
 * Tenemos un baño en donde entra rulo primero. Al cerrar la puerta adquiere el bloqueo, por lo tanto
 * ruso no puede entrar, evitando asi que se genere un desastre en el inodoro.
 * Esto se podria entender como una sincronizacion de rulo y ruso para usar el baño correctamente.
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class HiloSinSincronizacion extends Thread {

	private Printer printer;
	private String name;

	public HiloSinSincronizacion(String name) {
		this.name = name;
		start();
	}

	public HiloSinSincronizacion(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
		start();
	}

	@Override
	public void run() {
		printer.print(name);
	}

	/* Bloqueo de metodo usando una llamada estatica.
	 * El subproceso adquiere el bloqueo asociado con la clase (en este caso, cualquier subproceso puede llamar a cualquier
	 * metodo sincronizado no estatico de una instancia de esa clase porque ese bloqueo de nivel de objeto todavia esta
	 * disponible). Cualquier otro subproceso no podra llamar a ningun metodo sincronizado estatico de la clase siempre que
	 * el bloqueo de nivel de clase no sea liberado por el subproceso que actualmente mantiene el bloqueo. */
	private static synchronized void print(String name) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(name + " = " + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	// Clas interna para sincronizar objetos no estaticos
	private static class Printer {

		/* Usando synchronized se bloquea la llamada del siguiente hilo al metodo print() siempre que la ejecucion del hilo
		 * anterior no haya finalizado. Los subprocesos pueden acceder a este metodo de uno en uno. Sin synchronized todos los
		 * hilos pueden acceder a este metodo simultaneamente. */
		private synchronized void print(String name) {
			for (int i = 1; i <= 5; i++) {
				System.out.println(name + " = " + i);
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}

	public static void main(String[] args) {

		/* Si uso dos objetos (Printer en este caso) para compartir el mismo recurso aunque use el bloqueo de metodo
		 * "synchronized", no va a cumplir el orden de los numeros imprimidos. En cambio si uso un solo objeto,
		 * si cumple el orden sincronizado.
		 * 
		 * ¿Por que se sincroniza el recurso usando un solo objeto?
		 * Creo que es por que el metodo no es estatico, y por lo tanto se estan usando dos objetos para acceder al mismo
		 * recurso. */
		Printer printer = new Printer();
		new HiloSinSincronizacion("Thread 1", printer);
		new HiloSinSincronizacion("Thread 2", printer);

		// new HiloSinSincronizacion("Thread 1");
		// new HiloSinSincronizacion("Thread 2");

	}

}
