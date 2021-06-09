package _LABORATORIO;

import java.util.Arrays;

public class Spell {

	private static final int ARRIBA = 1;
	private static final int ABAJO = 2;

	private static final int AGILIDAD = 1;
	private static final int PARALIZAR = 2;
	private static final int FURIA = 3;
	private static final int DARDO = 4;

	private int[] spells = new int[4];

	public void addSpell() {
		spells[0] = AGILIDAD; // 1
		spells[1] = PARALIZAR; // 2
		spells[2] = FURIA; // 3
		spells[3] = DARDO; // 4
	}

	public int getSpell(int i) {
		return spells[i - 1];
	}

	public void setSpell(int i, int spell) {
		spells[i - 1] = spell;
	}

	// Recibe el indice del hechizo
	public void moveSpell(int i, int direction) {
		if (direction == 1) {

			int spell = getSpell(i); // DARDO

			// Intercambio de posicion
			// Establece en el indice 3 el hechizo FURIA
			setSpell(i, getSpell(i - 1));
			// Establece en el indice 2 el hechizo DARDO
			setSpell(i - 1, spell);

		} else if (direction == 2) {

		}
	}

	@Override
	public String toString() {
		return "spells = " + Arrays.toString(spells);
	}

	public static void main(String[] args) {
		Spell spell = new Spell();
		spell.addSpell();
		System.out.println(spell.toString());

		// Mueve el hechizo DARDO una posicion arriba
		spell.moveSpell(DARDO, ARRIBA);

		System.out.println(spell.toString());

	}

}
