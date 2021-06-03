/* https://www.youtube.com/watch?v=8xF_BSpSATw */

package interfaces;

import java.util.Arrays;

public class Interfaces1 {

	public static void main(String[] args) {

		Empleado[] empleados = new Empleado[3];

		empleados[0] = new Empleado("Juan", 5554);
		empleados[1] = new Empleado("Hernan", 3560);
		empleados[2] = new Empleado("Josefina", 4855);

		/* Ordena el array especificado de objetos en orden ascendente.
		 * Todos los elementos en el array deben implementar la interfaz Comparable. */
		Arrays.sort(empleados); // Metodo predefinido de la API de java

		for (Empleado e : empleados)
			e.mostrarDatos();

	}

}

// Implementa la interfaz Comparable
class Empleado implements Comparable {

	private static int idClase;
	private int idObjeto;
	private String nombre;
	private double sueldo;

	public Empleado(String nombre, double sueldo) {
		this.idObjeto = ++idClase;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	private String getNombre() {
		return nombre;
	}

	private double getSueldo() {
		return sueldo;
	}

	public void mostrarDatos() {
		System.out
				.println("ID: " + this.idObjeto + " - Nombre: " + this.getNombre() + " - Sueldo: " + this.getSueldo());
	}

	// Compara objetos
	@Override
	public int compareTo(Object objeto) {

		Empleado otroEmpleado = (Empleado) objeto;

		// "this" hace referencia al parametro implicito, es decir a un empleado cualquiera
		if (this.sueldo < otroEmpleado.sueldo) // Compara el sueldo de un empleado con otro
			return -1;

		if (this.sueldo > otroEmpleado.sueldo) return 1;

		return 0;
	}

}