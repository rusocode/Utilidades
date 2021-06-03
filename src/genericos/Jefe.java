package genericos;

public class Jefe extends Empleado{
	
	public Jefe(String nombre, int edad, double sueldo) {
		super(nombre, edad, sueldo);
	}
	
	double incentivo(double incentivo) {
		return incentivo;
	}
	
}
