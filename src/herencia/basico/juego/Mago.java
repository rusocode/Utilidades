package herencia.basico.juego;

// Subclase de Humano
public class Mago extends Humano {

	// Atributo adicional
	int poder;
	private static final int VIDA = 15;
	private static final int MANA = 20;

	// Constructor de la clase Mago
	protected Mago(String name) {
		this.name = name;
		this.clase = "mago";
		this.magica = true;
		this.vida = VIDA;
		this.mana = MANA;
	}

	// Metodo adicional
	void usarBolaDeFuego() {
		System.out.println("El jugador " + name + " uso bola de fuego.");
	}

}
