package poo;

public class Coche {

	private int ruedas;
	private int tamano;
	private boolean esFeo;

	/* El constructor es un metodo especial que tiene el mismo nombre de la clase, y que se encarga
	 * de darle un estado inicial a nuestros objetos.
	 * Cuando se crea un objeto de una clase que no tiene constructor, el programa java
	 * asume que se esta utilizando un constructor por defecto: public Clase(){}. */
	public Coche() {

		ruedas = 4; // Atributo original o de clase
		tamano = 2000;

	}

	/* Hay dos tipos de metodos de acceso: Setters o definidores y Getters o captadores. Estos se encargan de acceder a
	 * un dato especifico sin afectarlo. */

	// Obtiene el valor
	public int getRuedas() {
		return ruedas; // Palabra reservada return obligatoria
	}

	// Establece el valor (paso de parametros)
	public void setRuedas(int ruedas /* parametro */) {
		// No manipulamos directamente la variable, por lo tanto el valor va a seguir siendo 4
		this.ruedas = ruedas; // El operador this sirve para hacer referencia al atributo de clase
	}

	public void setEsFeo(String esFeo) {
		if (esFeo == "si") this.esFeo = true;
		else this.esFeo = false;
	}

	public String getEsFeo() {
		if (esFeo == true) return "El auto es feo";
		else return "El auto no es feo";
	}

}
