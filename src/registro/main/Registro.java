package registro.main;

/**
 * @Name: Registro
 * @Author: Juan Debenedetti (alias ruso)
 * @Date last changes: 27.08.2019
 * @Version: 1.5
 * */

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import registro.gui.ventanas.Principal;

public class Registro {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		new Principal().setVisible(true);

	}

}