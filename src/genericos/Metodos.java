package genericos;

public class Metodos {

	public static void main(String[] args) {

		String[] nombres = { "Juan", "A" };

		System.out.println(getMenor(nombres));

		System.out.println(getElementos(nombres));

		Empleado[] empleados = { new Empleado("Juan", 26, 1400000), new Empleado("Manolo", 33, 55555), new Empleado("A", 24, 454545) };

		// System.out.println(getMenor(empleados));

		// System.out.println(getElementos(empleados));

		/* El principio de sustitucion no se puede aplicar en la programacion generica, salvo que se agrege el tipo comdin en
		 * los parametros del metodo. */
		ClasePropia<Empleado> jose = new ClasePropia<Empleado>();
		ClasePropia<Jefe> tito = new ClasePropia<Jefe>();
		// ClasePropia<Empleado> polimorfismo = tito;

		ClasePropia.imprimirTrabajador(jose);
		ClasePropia.imprimirTrabajador(tito);
	}

	// Los metodos genericos se adaptan al tipo de dato que se le pasa por parametro
	public static <T> String getElementos(T[] e) { // Devuelve un String
		return "El array contiene " + e.length + " elementos.";
	}

	public static <T extends Comparable> T getMenor(T[] nombres) {
		if (nombres == null || nombres.length == 0) return null;

		// Se crea una variable generia para poder hacer un retorno
		T elementoMenor = nombres[0];

		// i se inicializa en 1 ya que la primera posicion del array (0) esta almacenada en elementoMenor
		for (int i = 1; i < nombres.length; i++)
			/* Para poder llamar al metodo compareTo se necesita extender la interfaz Comparable en la especificacion del metodo
			 * generico y que todos los objeto a comparar implementen la interfaz Comparable, en este caso la clase String ya la
			 * tiene implementada.
			 * 
			 * Compara el elementoMenor con el elemento de la posicion i, y si es mayor que 0 entonces es menor. */
			if (elementoMenor.compareTo(nombres[i]) > 0) elementoMenor = nombres[i];

		// Devuelve el elemento menor
		return elementoMenor;

	}

}
