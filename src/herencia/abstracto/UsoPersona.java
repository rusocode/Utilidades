package herencia.abstracto;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Una clase abstracta es la que MARCA EL DISE�O EN LA JERARQUIA DE LA HERENCIA, porque todas aquellas clases que
 * hereden de "Persona", estan obligadas a sobreescribir/construir el metodo abstracto que esta heredando de "Persona".
 * Por lo cual, no es ni mas ni menos que un patron o pauta a la hora de dise�ar la herencia entre las clases de tu
 * programa. Tambien quiere decir que esta clase (Persona) tiene POCA funcionalidad en principio, porque esta en la
 * parte mas alta de la jerarquia de nuestra herencia. A medida que subes por la jerarquia de la herencia, las clases
 * son mas abstractas y menos especializadas.
 * 
 * PREGUNTA: Si WindowAdapter es una clase abstracta, se supone que debe tener almenos un metodo abstracto para que esta
 * clase pueda ser abstracta, y se supone segun la regla que estamos obligados a sobreescribir el metodo abstracto, sin
 * embargo en la api no se encuentra ningun metodo abstracto. Entonces �Que hace que este clase sea abstracta?
 * 
 * RESPUESTA: Las clases abstractas generalmente tienen o pueden tener metodos abstractos, pero NO necesariamente estan
 * obligadas a tenerlas (como en el caso de WindowAdapter).
 * 
 * Entonces, una clase abstracta... - NO puede ser instanciada. - Si se puede heredar. - Estoy obligado a implementar
 * los metodos, si y solo SI ellos son metodos abstractos. - Si tiene metodos NO abstractos (normales), entonces puedo
 * (si es que lo requiero) sobreescribirlos como pasa en este caso de la clase abstracta WindowAdapter.
 */

public class UsoPersona {

	public static void main(String[] args) {

		Persona[] personas = new Persona[2];

		personas[0] = new Empleado("Juan", 50000, 2009, 02, 25);
		personas[1] = new Alumno("Porter", "Informatica");

		for (Persona p : personas)
			System.out.println(p.getNombre() + ", " + p.getDescripcion());

	}

}

abstract class Persona {

	private String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	// Este metodo es abstracto ya que hay una descripcion diferente para cada subclase.
	// Si una clase tiene un metodo abstracto, entonces la clase esta obligada a ser abstracta.
	public abstract String getDescripcion(); // Asi se declara un metodo abstracto, solo se define, no se construye.

	public String getNombre() {
		return nombre;
	}

}

class Empleado extends Persona {

	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente = 1;

	public Empleado(String nombre, double sueldo, int ano, int mes, int dia) {

		super(nombre);

		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(ano, mes - 1, dia);
		this.altaContrato = calendario.getTime();
		id = idSiguiente++;
	}

	public String getDescripcion() {
		return "Este empleado tiene un ID = " + id + ", con un sueldo de " + sueldo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public Date getAltaContrato() {
		return altaContrato;
	}

	public void aumentarSueldo(double porcentaje) {
		sueldo += sueldo * porcentaje / 100;
	}

}

class Alumno extends Persona {

	private String carrera;

	public Alumno(String nombre, String carrera) {
		super(nombre);
		this.carrera = carrera;
	}

	public String getDescripcion() {
		return "Esta alumno esta estudiando la carrea de " + carrera;
	}

}
