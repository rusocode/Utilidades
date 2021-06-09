package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {

	/* Cuando un unico fichero va a albergar varias clases, solamente una de esas clases tiene que ser publica y
	 * solamente una de esas clase debe de tener el metodo main. */

	public static void main(String[] args) {

		// FORMA COMPLEJA
		// Empleado empleado1 = new Empleado("Juan", 1500, 1990, 12, 17 /* Zona de argumentos */); // Respetar la posicion de
		// los argumentos
		// Empleado empleado2 = new Empleado("Chipi", 55, 1995, 06, 02);
		// Empleado empleado3 = new Empleado("Diego", 2, 2002, 03, 15);
		//
		// empleado1.aumentarSueldo(30);
		// empleado2.aumentarSueldo(10);
		// empleado3.aumentarSueldo(5);
		//
		// System.out.println("Nombre: " + empleado1.getNombre() + " - Sueldo: " + empleado1
		// .getSueldo() + " - Fecha de alta: " + empleado1.getAltaContrato());
		//
		// System.out.println("Nombre: " + empleado2.getNombre() + " - Sueldo: " + empleado2
		// .getSueldo() + " - Fecha de alta: " + empleado2.getAltaContrato());
		//
		// System.out.println("Nombre: " + empleado3.getNombre() + " - Sueldo: " + empleado3
		// .getSueldo() + " - Fecha de alta: " + empleado3.getAltaContrato());

		// FORMA SIMPLIFICADA
		Empleado[] empleados = new Empleado[4];

		// Crea 3 empleados y los alamacena en el vector
		empleados[0] = new Empleado("Juan", 1500, 1990, 12, 17);
		empleados[1] = new Empleado("Chipi", 55, 1995, 06, 02);
		empleados[2] = new Empleado("Diego", 2, 2002, 03, 15);
		empleados[3] = new Empleado("Carlos");

		// for (int i = 0; i < 3; i++)
		// empleados[i].aumentarSueldo(10);

		// Le aumenta el saldo a cada empleado
		for (Empleado empleado : empleados)
			empleado.aumentarSueldo(10);

		// Imprime los datos desde el objeto
		// for (int i = 0; i < 3; i++) {
		// System.out.println("Nombre: " + empleados[i].getNombre() + " - Sueldo: " + empleados[i]
		// .getSueldo() + " - Fecha de alta: " + empleados[i].getAltaContrato());
		// }

		// for (Empleado empleado : empleados)
		// System.out.println("Nombre: " + empleado.getNombre() + " - Sueldo: " + empleado
		// .getSueldo() + " - Fecha de alta: " + empleado.getAltaContrato() + " - ID: " + empleado.getId());

		// Imprime los datos desde la clase
		for (Empleado empleado : empleados)
			empleado.devuelveDatos();

		// ERROR LOGICO: se corrigio encapsulando la variable "id" y creando una variable estatica "idSiguiente" para
		// incrementarla desde su propia clase
		// empleado.id++;

	}

}

class Empleado {

	// Encapsulamiento
	// private final String NOMBRE = "Juan"; // Constante: espacio en memoria en donde se alamacena un valor que no puede
	// ser modificado durante la ejecucion del programa
	private String nombre;
	private double sueldo; // Variable: espacio en memoria en donde se alamacena un valor que puede variar durante la ejecucion del programa
	private Date altaContrato;// altaContrato no es un dato de tipo primitivo (int, double, etc.), es una variabale de tipo objeto (Date)
	private String seccion;

	private int id;
	/* Una variable de clase (static) a diferencia de las variables de objeto, es una variable que no pertenece a
	 * ningun objeto, sino a la clase. */
	private static int idSiguiente = 1; // Solamente la clase es la que tiene una copia de esta variable

	// SOBRECARGA DE CONSTRUCTOR
	// Constructor con 1 parametro
	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	// Constructor con 5 parametros
	public Empleado(String nombre, double sueldo, int ano, int mes, int dia) {

		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(ano, mes - 1, dia);
		this.altaContrato = calendario.getTime();

		// Inicializa una variable en el constructor
		this.seccion = "Administracion";

		/* Esto implica que a la hora de construir objetos y utilizarlos, ya no tengo porque incrementar el
		 * id desde la clase principal (UsoEmpleado), y ni siquiera tengo que tener en cuenta porque id voy,
		 * sino que el programa se va a encargar de asiganar a cada uno su id.
		 * Tambien estamos encapsulando la variable.
		 * 
		 * Asigno en cada llamada al constructor el incremento de la variable estatica a la variable objeto.
		 * 
		 * idSiguiente: Variable compartida (4, 4, 4, 4).
		 * id: Variable unica (1, 2, 3, 4). */
		id = idSiguiente++;

	}

	public void devuelveDatos() {
		System.out.println("Nombre: " + nombre + " - Sueldo: " + sueldo + " - Fecha de alta: " + altaContrato + " - ID: " + id);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	// No se puede modificar
	// public void setNombre(String nombre) {
	// this.NOMBRE = nombre;
	// }

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getAltaContrato() {
		return altaContrato;
	}

	public void setAltaContrato(Date altaContrato) {
		this.altaContrato = altaContrato;
	}

	public void aumentarSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;

		// Incrementa el sueldo que quedo establecido en el constructor mas el aumento
		sueldo += aumento;
	}

}
