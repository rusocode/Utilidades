package herencia.basico.juego;

// Clase principal
public class Personaje {

	protected String name;
	protected String clase;
	protected boolean magica;
	protected int nivel;
	protected int vida;
	protected int mana;

	void mover() {
		System.out.println("Se movio el personaje " + name);
	}

	void atacar() {
		System.out.println("Ataco el personaje " + name);
	}

	// Para saber si es magica
	boolean esMagica() {
		if (this.magica == true)
			return true;
		else
			return false;
	}

}
