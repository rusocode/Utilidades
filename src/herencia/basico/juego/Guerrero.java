package herencia.basico.juego;

// Subclase de Humano
public class Guerrero extends Humano {

	// Atributo adicional
	int durabilidad;
	private static final int VIDA = 30;

	// Constructor de la clase Guerrero
	protected Guerrero(String name) {
		this.name = name;
		this.clase = "guerrero";
		this.vida = VIDA;

	}

	// Metodo adicional
	void usarSuperGolpe() {
		System.out.println("El jugador " + name + " uso super golpe.");
	}

}
