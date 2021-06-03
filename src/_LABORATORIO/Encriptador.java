package _LABORATORIO;

import java.util.Random;
import java.util.Scanner;

public class Encriptador {

	public static void main(String[] args) {

		String c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$%^&*abcdefghijklmnopqrstuvwxyz";

		System.out.print("Mensaje: ");
		String m = new Scanner(System.in).nextLine();

		String mOriginal = m;

		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) == ' ') continue;
			m = m.replace(m.charAt(i), c.charAt(new Random().nextInt(68)));
		}

		System.out.println("Mensaje encriptado: " + m + "\nMensaje original: " + mOriginal);

	}

}
