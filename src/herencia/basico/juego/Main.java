package herencia.basico.juego;

// Principal herada de Object
public class Main {

	public static void main(String[] args) {
		Mago m1 = new Mago("Merlin");
		System.out.println(m1.name + " es un " + m1.clase + " con " + m1.vida + " de vida y " + m1.mana + " de mana.");
		m1.mover();
		m1.atacar();

		Guerrero g1 = new Guerrero("Aquiles");
		System.out.println(g1.name + " es un " + g1.clase + " con " + g1.vida + " de vida.");
		g1.diplomancia();
		g1.usarSuperGolpe();
	}

}
