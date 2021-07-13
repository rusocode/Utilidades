package multiprocesos;

/**
 * La sincronizacion se basa en una entidad interna conocida como bloqueo o monitor. Cada objeto tiene un candado
 * asociado. Por convencion, un hilo que necesita acceso constante a los campos de un objeto tiene que adquirir el
 * bloqueo del objeto antes de acceder a ellos, y luego liberar el bloqueo cuando haya terminado con ellos. Si no hay
 * sincronizacion, la salida es inconsistente.
 * 
 * Siempre se entienden mejor las cosas tomando ejemplos de la realidad...
 * Tenemos un baño en donde entra rulo primero. Al cerrar la puerta adquiere el bloqueo, por lo tanto
 * ruso no puede entrar, evitando asi que se genere un desastre en el inodoro.
 * Esto se podria entender como una sincronizacion de rulo y ruso para usar el baño correctamente, en donde la puerta
 * es el bloqueo.
 * 
 * @author Juan Debenedetti aka Ru$o
 * 
 */

public class Test extends Thread {

	private Printer printer;
	private String name;

	public Test(String name) {
		this.name = name;
		start();
	}

	public Test(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
		start();
	}

	@Override
	public void run() {

		// printer.print(name);
		print(name);
	}

	/* Si crea algun metodo estatico sincronizado, el bloqueo estara en la clase, no en el objeto.
	 * 
	 * Bloqueo de metodo usando una llamada estatica.
	 * El subproceso adquiere el bloqueo asociado con la clase (en este caso, cualquier subproceso puede llamar a cualquier
	 * metodo sincronizado no estatico de una instancia de esa clase porque ese bloqueo de nivel de objeto todavia esta
	 * disponible). Cualquier otro subproceso no podra llamar a ningun metodo sincronizado estatico de la clase siempre que
	 * el bloqueo de nivel de clase no sea liberado por el subproceso que actualmente mantiene el bloqueo. */
	private static synchronized void print(String name) {

		System.out.println(Thread.currentThread().getName());

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
		 * hilos pueden acceder a este metodo simultaneamente.
		 * Cuando un hilo llama al metodo sincronizado 'print' del objeto (aqui el objeto es una instancia de la clase
		 * 'Printer') adquiere el bloqueo de ese objeto, cualquier hilo nuevo no puede llamar a CUALQUIER metodo sincronizado
		 * del mismo objeto siempre que el hilo anterior que habia adquirido la cerradura no libere la cerradura. */
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

		/* Si uso dos objetos (Printer en este caso) para compartir el mismo recurso aunque use el bloqueo de metodo, no se va a
		 * cumplir un orden. En cambio si uso un solo objeto, si cumple el orden sincronizado.
		 * ¿Por que se sincroniza el recurso usando un solo objeto?
		 * Creo que es por que el metodo no es estatico, y por lo tanto se estan usando dos objetos para acceder al mismo
		 * recurso. */

//		Printer printer = new Printer(); // Utiliza un solo objeto para ejecutar los hilos
//		new Test("Thread 1", printer);
//		new Test("Thread 2", printer);

		new Test("Thread 0");
		new Test("Thread 1");

	}

}
