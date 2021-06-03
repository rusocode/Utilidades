package herencia.basico.juego;

// Subclase de Personaje
public class Humano extends Personaje {

	// Atributo adicional
	String descendencia;

	// Metodo adicional
	void diplomancia() {
		System.out.println("El jugador " + name + " uso diplomancia.");
	}

}
