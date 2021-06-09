package _LABORATORIO;

import java.util.Arrays;

public class MoveSpell {

	private static final int DIRECCION_ARRIBA = 1;
	private static final int DIRECCION_ABAJO = 2;

	private static final int DARDO = 5;
	private static final int PARALIZAR = 14;
	private static final int FURIA = 7;
	private static final int AGILIDAD = 1;

	private int[] spells = new int[5];

	public void add() {
		spells[0] = AGILIDAD;
		spells[1] = PARALIZAR;
		spells[2] = FURIA;
		spells[3] = DARDO;
	}

	public int get(int i) {
		return spells[i];
	}

	public void set(int i, int spell) {
		spells[i] = spell;
	}

	public void move(int i, int direction) {
		if (direction == 1) {

			int spell = get(i); // DARDO

			// Establece en la posicion 3 el hechizo FURIA
			set(i, get(i - 1));
			// Establece en la posicion 2 el hechizo DARDO
			set(i - 1, spell);

		} else if (direction == 2) {

		}
	}

	@Override
	public String toString() {
		return "Prueba [spells=" + Arrays.toString(spells) + "]";
	}

	public static void main(String[] args) {
		MoveSpell spell = new MoveSpell();
		spell.add();
		System.out.println(spell.toString());

		// Quiero mover el hechizo DARDO una posicion arriba
		spell.move(3, DIRECCION_ARRIBA);

		System.out.println(spell.toString());

	}

}
