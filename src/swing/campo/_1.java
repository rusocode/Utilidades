package swing.campo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _1 {

	public static void main(String[] args) {

		new Marco().setVisible(true);

	}

}

class Marco extends JFrame {

	public Marco() {

		setFrameProperties();

	}

	private void setFrameProperties() {

		setTitle("Calculadora");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		add(new Lamina());

	}

}

class Lamina extends JPanel {

	private JLabel lblEmail;
	private JLabel lblResultado;
	private JTextField txt1;
	private JButton btn;

	public Lamina() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina2 = new JPanel();
		lamina2.setLayout(new FlowLayout());
		
		lblEmail = new JLabel("Email: ");
		lamina2.add(lblEmail);
		
		txt1 = new JTextField(20);
		lamina2.add(txt1);
		
		btn = new JButton("Go!");
		ActionListener oyente = new Oyente();
		btn.addActionListener(oyente);
		lamina2.add(btn);
		add(lamina2, BorderLayout.NORTH);
	
		lblResultado = new JLabel("", JLabel.CENTER);
		add(lblResultado, BorderLayout.CENTER);
		
		
	}

	private class Oyente implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int correcto = 0;
			String email = txt1.getText().trim();

			for (int i = 0; i < email.length(); i++)
				if (email.charAt(i) == '@') correcto++;

			if (correcto != 1)
				lblResultado.setText("Incorrecto");
			else
				lblResultado.setText("Correcto");
			
			
			

		}

	}

}