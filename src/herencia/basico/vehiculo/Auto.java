package herencia.basico.vehiculo;

// Subclase de Vehiculo
public class Auto extends Vehiculo {

	// Atributo adicional
	private final int RUDAS = 4;

	// Constructor de la clase Auto con 4 parametros
	public Auto(String marca, String modelo, String color, double peso) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.ruedas = RUDAS;
		this.peso = peso;
	}

	// Metodo adicional
	public void datosAuto() {
		System.out
				.println("Marca: " + marca + " - Modelo: " + modelo + " - Color: " + color + " - Rudedas: " + ruedas + " - Peso: " + peso + " kg.");
	}

}
