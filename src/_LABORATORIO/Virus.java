package _LABORATORIO;

import java.io.File;
import java.util.Random;

public class Virus {

	public static void main(String[] args) {
		final int c = 10;
		Random r = new Random();

		for (int i = 0; i < c; i++)
			new File(System.getProperty("user.home") + "/Desktop/" + r.nextInt(1000)).mkdir();

	}

}
