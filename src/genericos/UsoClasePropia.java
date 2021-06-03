package genericos;

public class UsoClasePropia {

	public static void main(String[] args) {

		/* En este caso, la clase generica se adapta a un objeto String, de tal forma que los metodos de esa clase ya estaran
		 * preparados para recibir objetos de ese tipo. */
		ClasePropia<String> frases = new ClasePropia<String>();

		frases.setPrimero("ola k ase!");

		System.out.println(frases.getPrimero()); // Devuelve el objeto especificado en la declaracion de la instancia

		// ---

		Persona juan = new Persona("Juan");
		Persona jose = new Persona("Jose");

		// Ahora la clase generica se adapta a un objeto de tipo Persona
		ClasePropia<Persona> personas = new ClasePropia<Persona>();

		personas.setPrimero(juan);

		System.out.println(personas.getPrimero()); // Devuelve un objeto persona

	}

}

class Persona {

	private String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	// En vez de devolver el nombre del objeto (genericos.Persona@15db9742), devuelve el nombre de la persona
	@Override
	public String toString() {
		return nombre;
	}

}
