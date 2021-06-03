package pizzeria.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pizzeria.clases.Software;

public class Pizzeria {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Software().setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}
}
