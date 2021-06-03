/* https://www.youtube.com/watch?v=MTdly6e-jPU */

package interfaces;

public class Interfaces3 {

	public static void main(String[] args) {

		Empleado3[] empleados = new Empleado3[5];

		empleados[0] = new Empleado3("Juan", 5554);
		empleados[1] = new Empleado3("Hernan", 3560);
		empleados[2] = new Empleado3("Josefina", 4855);

		empleados[3] = new Jefatura2("Truccone", 200);
		Jefatura2 jefeInformatica = (Jefatura2) empleados[3];

		// POLIMORFISMO
		Jefatura2 jefeProgramacion = new Jefatura2("Palacios", 100);
		empleados[4] = jefeProgramacion;
		

		// Bonus para el jefe
		System.out.println("El jefe " + jefeInformatica.getNombre() + " tiene un bonus de: " + jefeInformatica
				.setBonus(500));

		// Bonus para el empleado
		System.out.println(empleados[2].getNombre() + " tiene un bonus de: " + empleados[2].setBonus(500));

		for (Empleado3 e : empleados)
			e.mostrarDatos();

	}

}

// La clase empleados no puede tomar decisiones porque asi se lo habiamos dicho
class Empleado3 implements Comparable, Trabajadores {

	private static int idClase;
	private int idObjeto;
	private String nombre;
	private double sueldo;

	public Empleado3(String nombre, double sueldo) {
		this.idObjeto = ++idClase;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void mostrarDatos() {
		System.out
				.println("ID: " + this.idObjeto + " - Nombre: " + this.getNombre() + " - Sueldo: " + this.getSueldo());
	}

	@Override
	public int compareTo(Object objeto) {

		Empleado3 otroEmpleado = (Empleado3) objeto;

		if (this.sueldo < otroEmpleado.sueldo)
			return -1;

		if (this.sueldo > otroEmpleado.sueldo)
			return 1;

		return 0;
	}

	@Override
	public double setBonus(double gratificacion) {
		return Trabajadores.BONUS_BASE + gratificacion;
	}

}

class Jefatura2 extends Empleado3 implements Jefes {

	public Jefatura2(String nombre, double sueldo) {
		super(nombre, sueldo);
	}

	@Override
	public String tomarDecision(String decision) {
		return "Un miembro de la direccion ha tomado la decision de: " + decision;
	}

	@Override
	public double setBonus(double gratificacion) { // Getter y Setter
		double prima = 2000;
		return Trabajadores.BONUS_BASE + gratificacion + prima;
	}
}
