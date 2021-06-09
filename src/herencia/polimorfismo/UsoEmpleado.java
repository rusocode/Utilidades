package herencia.polimorfismo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {

	public static void main(String[] args) {

		Jefatura jefe1 = new Jefatura("Juan", 50000, 1995, 20, 5);
		jefe1.setIncentivo(3000);

		// Se pueden almacenar empleados y jefes en el array
		Empleado[] empleados = new Empleado[4];
		empleados[0] = new Empleado("Porter", 1500, 1990, 12, 17);
		empleados[1] = new Empleado("Limao", 250, 2002, 5, 21);

		/* Almacena un objeto de tipo Jefatura. Es decir que podemos utilizar un objeto de la subclase
		 * cuando el programa espere un objeto de la superclase (principio de sustitucion). */
		empleados[2] = jefe1; // POLIMORFISMO en accion. Principio de sustitucion

		empleados[3] = new Jefatura("Diego", 1000, 1993, 2, 11);
		Jefatura jefe2 = (Jefatura) empleados[3]; // CASTEO el objeto a Jefatura ya que era un objeto de tipo Empleado
		// Ahora puedo acceder a todos sus metodos
		jefe2.setIncentivo(20000);

		/* Un empleado no siempre es un jefe, esto es por el diseño de la herencia.
		 * Esto se debe a una cierta logica y sentido. */
		// Jefatura jefe3 = (Jefatura) empleados[1];

		for (Empleado e : empleados)
			e.aumentarSueldo(10);

		/* Cuando el for llega a la posicion 2 del array de tipo Empleado (posicion en donde se alamaceno un
		 * objeto de tipo Jefatura), lama al metodo getSueldo() de la clase Jefatura y
		 * no al metodo de la clase Empleado (Polimorfismo).
		 * 
		 * ¿Como es posible que la JVM sea capas de detectar
		 * en un bucle for, a que metodo tiene que llamar en unas ocasiones y a que metodo tiene que
		 * llamar en otras ocasiones?
		 * 
		 * Ese comportamiento lo hace la JVM automaticamente, eso es lo que se llama ENLAZADO DINAMICO.
		 * Quiere decir que la JVM es capas (en tiempo de ejecucion) de saber a que metodo perteneciente
		 * a la clase padre o a la subclase tiene que llamar. */
		for (Empleado e : empleados)
			e.mostrarDatos();

	}

}

// Modificador de acceso por defecto
class Empleado {

	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente = 1;

	public Empleado(String nombre, double sueldo, int ano, int mes, int dia) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(ano, mes - 1, dia);
		this.altaContrato = calendario.getTime();
		id = idSiguiente++;
	}

	public double getSueldo() {
		return sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getAltaContrato() {
		return altaContrato;
	}

	public void aumentarSueldo(double porcentaje) {

		sueldo += sueldo * porcentaje / 100;
	}

	public void mostrarDatos() {
		System.out.println("ID: " + id + " - Nombre: " + this.getNombre() + " - Sueldo: " + this.getSueldo() + "$ - Alta de contrato: "
				+ this.getAltaContrato());
	}

}

// "final class" detiene la cadena de la herencia
class Jefatura extends Empleado {
	private double incentivo;

	public Jefatura(String nombre, double sueldo, int ano, int mes, int dia) {
		super(nombre, sueldo, ano, mes, dia);
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	// Sobreescritura de metodo
	public double getSueldo() {
		// Devuelve el sueldo del jefe
		return super.getSueldo() + incentivo;
	}

}
