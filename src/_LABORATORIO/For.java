package _LABORATORIO;

import javax.swing.JOptionPane;

public class For {

	public static void main(String[] args) {

		int[] n = { 2, 4, 56, 9 };
		int c = 0;

		for (int i = 0; i < n.length; i++)
			System.out.println("Elemento[" + i + "] = " + n[i]);

		for (int i : n)
			System.out.println("Elemento[" + c++ + "] = " + i);

	}

	static void validacionGmail() {

		boolean arroba = false;

		String gmail = JOptionPane.showInputDialog("Ingrese el gmail");

		for (int i = 0; i < gmail.length(); i++)
			if (gmail.charAt(i) == '@') arroba = true;

		if (arroba) System.out.println("Gmail correcto!");
		else System.out.println("Gmail incorrecto!");
	}

}
