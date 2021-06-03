package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializando {

	/*
	 * La serializacion consiste en convertir un objeto en bytes con el objetivo de distribuirlo a travez de la red a
	 * ordenadores remotos y que en ese ordenador el objeto serializado sea restablecido al estado en el que se serializo.
	 */

	public static void main(String[] args) {

		Administrador jefe = new Administrador("Jose", 50000, 56);

		jefe.setIncentivo(5000);

		Empleado[] empleados = new Empleado[3];

		empleados[0] = jefe; // Polimorfismo = es un = principio de sustitucion

		empleados[1] = new Empleado("Jose", 25000, 26);

		empleados[2] = new Empleado("Miguel", 10000, 44);

//		Empleado juan = new Empleado("Juan", 25000, 26);
//
//		System.out.println(juan.toString());
//
//		System.out.println("Aumento del 20% para el empleado " + juan.getNombre());
//
//		juan.aumentarSueldo(20);
//
//		System.out.println(juan.toString());

		try {

//			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("C:/users/juand/Desktop/empleado.dat"));
//
//			salida.writeObject(empleados);
//
//			salida.close();

			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("C:/users/juand/Desktop/empleado.dat"));

			Empleado[] copia_entrada = (Empleado[]) entrada.readObject();

			entrada.close();

			for (Empleado e : copia_entrada)
				System.out.println(e);

		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error de I/O: " + e.getMessage());
		}

	}

}

// Clase lista para convertirla en bytes
class Empleado implements Serializable {

	// Serial generado automaticamente en donde sera diferente cada vez que se modifique el programa: 6718602386940085512L

	/*
	 * Con la huella se puede leer el objeto serializado a pesar de que se haya modificado el programa, por que la huella es
	 * tomada del serialVersionUID y ese serial no se cambio, es decir que se hicieron cambios en el programa pero no en la
	 * huella, por lo tanto el programa va a correr sin ningun problema aunque se hayan echo cambios en el.
	 */

	private static final long serialVersionUID = 1L; // Huella de 20 bytes

	private String nombre;
	private double sueldo;
	private int edad;

	public Empleado(String nombre, double sueldo, int edad) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public int getEdad() {
		return edad;
	}

	public void aumentarSueldo(double porcentaje) {
		sueldo += sueldo * porcentaje / 100;
	}

	// Este metodo se utiliza para especificar una descripcion de la clase
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", edad=" + edad + "]";
	}

}

class Administrador extends Empleado {

	private static final long serialVersionUID = 1L;

	private double incentivo;

	public Administrador(String nombre, double sueldo, int edad) {
		super(nombre, sueldo, edad); // Llama al constructor de la clase padre con la instruccion super
		incentivo = 0;
	}

	public double getSueldo() {
		return super.getSueldo() + incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	@Override
	public String toString() {
		return "Administrador [incentivo=" + incentivo + "]";
	}

}
