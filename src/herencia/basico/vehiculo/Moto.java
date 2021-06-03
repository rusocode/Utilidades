package herencia.basico.vehiculo;

// Subclase de Vehiculo
public class Moto extends Vehiculo {

	// Atributo adicional
	private final int RUDAS = 2;

	// Constructor de la clase Moto con 1 parametro
	public Moto(String marca) {
		// super(); Solo hace falta si la Superclase posee un constructor
		this.marca = marca;
		
		// Inicializa las variables en el constructor
		this.modelo = "YZF-R6";
		this.color = "Negro";
		this.ruedas = RUDAS;
		this.peso = 500;
	}

	// Metodo adicional
	void hacerWheelie() {
		System.out.println("La moto " + marca + " " + modelo + " hizo wheelie.");
	}

}
