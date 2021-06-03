package _LABORATORIO;

import java.awt.Dimension;
import java.awt.Toolkit;

public class CalcularTamanoPantalla {

	public static void main(String[] args) {

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(windowSize);
		// setSize(windowSize.width / 2, windowSize.height / 2);
	}

}
