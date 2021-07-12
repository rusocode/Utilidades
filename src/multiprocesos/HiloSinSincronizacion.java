package multiprocesos;

/**
 * La sincronizacion se basa en una entidad interna conocida como bloqueo o monitor. Cada objeto tiene un candado
 * asociado. Por convencion, un hilo que necesita acceso constante a los campos de un objeto tiene que adquirir el
 * bloqueo del objeto antes de acceder a ellos, y luego liberar el bloqueo cuando haya terminado con ellos.
 * 
 * En este ejemplo, no hay sincronizacion, por lo que la salida es inconsistente. Veamos el ejemplo:
 * 
 */

public class HiloSinSincronizacion extends Thread {

	private int n;

	public HiloSinSincronizacion(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		print();
	}

	private void print() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		HiloSinSincronizacion h1 = new HiloSinSincronizacion(5);
		h1.start();
		HiloSinSincronizacion h2 = new HiloSinSincronizacion(100);
		h2.start();

	}

}
