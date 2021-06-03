package genericos;

// Los parametros de tipo <T> (T, U o K son nombres que se utilizan por convenio) definen una clase como generica
public class ClasePropia<T> {

	// Campo generico de clase
	private T primero;

	public ClasePropia() {
		primero = null;
	}

	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}

	// Define el metodo como generico
	public T getPrimero() {
		return primero;
	}

	// Recibe un parametro de tipo generico concretamente de tipo ClasePropia
	public static void imprimirTrabajador(
			ClasePropia<? extends Empleado> p) { /* Aplico el "tipo comodin" (?) para que el metodo pueda recibir un objeto de tipo Empleado o
													 * cualquier subclase perteneciente a Empleado. */
		Empleado primero = p.getPrimero();
		System.out.println(primero);
	}

}
