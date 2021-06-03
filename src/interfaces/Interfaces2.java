/* https://www.youtube.com/watch?v=59Tpg7XbIEo&pbjreload=10 */

package interfaces;

public class Interfaces2 {

	public static void main(String[] args) {

		Empleado2[] empleados = new Empleado2[4];

		empleados[0] = new Empleado2("Juan", 5554);
		empleados[1] = new Empleado2("Hernan", 3560);
		empleados[2] = new Empleado2("Josefina", 4855);

		empleados[3] = new Jefatura("Palacios", 1444);
		Jefatura jefeInformatica = (Jefatura) empleados[3]; // Casteo el empleado a jefe

		/* No se puede instanciar directamente una interfaz, pero si que se puede utilizar el
		 * principio de sustitucion (polimorfismo), de tal forma que si la clase Empleado implementa la interfaz
		 * Comparable, podemos crearnos una instancia perteneciente a la interfaz, pero luego a la
		 * hora de instanciarla decirle que es de tipo Empleado. */
		Comparable ejemplo = new Empleado2("Ejemplo", 111);

		/* Cuando tienes un monton de clases que van heredando unas de otra, pues es probable que te
		 * veas en la necesidad de comprobar si una instancia pertenece a una clase o no. */
		if (jefeInformatica instanceof Empleado2)
			System.out.println("La instancia 'jefeInformatica' es de tipo Jefatura");

		if (ejemplo instanceof Comparable) // Es decir... si implementa o no la interfaz Comparable
			System.out.println("La instancia 'ejemplo' implementa la interfaz Comparable");

		// Prueba llamar al metodo de la interfaz
		System.out.println(jefeInformatica.tomarDecision("Tomar parcial"));

		// Arrays.sort(empleados);

		for (Empleado2 e : empleados)
			e.mostrarDatos();

	}

}

class Empleado2 implements Comparable {

	private static int idClase;
	private int idObjeto;
	private String nombre;
	private double sueldo;

	public Empleado2(String nombre, double sueldo) {
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

	@Override
	public int compareTo(Object objeto) {

		Empleado2 otroEmpleado = (Empleado2) objeto;

		if (this.sueldo < otroEmpleado.sueldo) return -1;

		if (this.sueldo > otroEmpleado.sueldo) return 1;

		return 0;
	}

}

// Como en java no existe la herencia multiple, entonces se utilizan las interfaces
class Jefatura extends Empleado2 implements Jefes { // Cuando se implementa una interfaz, entonces se sobreescriben los metodos de la interfaz por obligacion

	public Jefatura(String nombre, double sueldo) {
		super(nombre, sueldo);
	}

	@Override
	public String tomarDecision(String decision) {
		return "Un miembro de la direccion ha tomado la decision de: " + decision;
	}

	@Override
	public double setBonus(double gratificacion) {
		return 0;
	}

}
