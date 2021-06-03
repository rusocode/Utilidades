package herencia.basico.vehiculo;

/* La clase principal "Vehiculo" va a contener menos metodos que todas sus clases hijas, ya que las 
 * subclases van a estar formadas por sus propias funciones mas las funciones de la superclase. 
 * Esto es un orden jerarquico en la que la clase mas alta es la mas abstracta. */
public class Vehiculo {

	protected String marca;
	protected String modelo;
	protected String color;
	protected int ruedas;
	protected double peso;

	void acelerar() {
		System.out.println(marca + " " + modelo + " acelero.");;
	}

	void frenar() {
		System.out.println(marca + " " + modelo + " freno.");
	}

}
