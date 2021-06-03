package ventanas_emergentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _1 {

	public static void main(String[] args) {

		new Marco().setVisible(true);;

	}

}

class Marco extends JFrame {

	public Marco() {
		
		setTitle("Cuadros de dialogos");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Lamina());

	}

}

class Lamina extends JPanel {

	private JButton btn1, btn2, btn3, btn4;

	public Lamina() {

		btn1 = new JButton("Boton 1");
		btn2 = new JButton("Boton 2");
		btn3 = new JButton("Boton 3");
		btn4 = new JButton("Boton 4");

		btn1.addActionListener(new Oyente());
		btn2.addActionListener(new Oyente());
		btn3.addActionListener(new Oyente());
		btn4.addActionListener(new Oyente());

		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);

	}

	private class Oyente implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1) JOptionPane.showMessageDialog(Lamina.this, "Esto es un mensaje"); 
			if (e.getSource() == btn2) JOptionPane.showInputDialog(null, "Ingrese algo", "Dialogo", 0); // Como no le paso ningun componente (null), entonces la ventana emergente se situa en el centro de la pantalla. 
			if (e.getActionCommand() == "Boton 3") System.out.println("Has pulsado el boton 3");
			if (e.getSource() == btn4) System.out.println("Has pulsado el boton 4");

		}

	}

}
