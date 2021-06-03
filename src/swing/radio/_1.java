package swing.radio;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Ctrl+Sift+o: Importa los paquetes necesarios.
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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

		setTitle("CheckBox");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		add(new Lamina());

	}
}

class Lamina extends JPanel {

	private JPanel panelBotones;
	private JLabel lblTexto;
	private ButtonGroup grupo1;
	private JRadioButton rbtn;

	public Lamina() {

		// Los grupos de botones no se pueden agregar a un panel, solo los radio.
		/* grupo1 = new ButtonGroup();
		 * 
		 * rbtn1 = new JRadioButton("Azul", false);
		 * rbtn2 = new JRadioButton("Rojo", true);
		 * rbtn3 = new JRadioButton("Verde", false);
		 * rbtn4 = new JRadioButton("Masculino", false);
		 * 
		 * grupo1.add(rbtn1);
		 * grupo1.add(rbtn2);
		 * grupo1.add(rbtn3);
		 * 
		 * add(rbtn1);
		 * add(rbtn2);
		 * add(rbtn3);
		 * add(rbtn4); */

		setLayout(new BorderLayout());

		panelBotones = new JPanel();
		grupo1 = new ButtonGroup();

		lblTexto = new JLabel("Texto");
		lblTexto.setFont(new Font("Serif", Font.PLAIN, 12));

		colocarBotones("Pequeño", false, 8);
		colocarBotones("Mediano", false, 10);
		colocarBotones("Grande", true, 18);
		colocarBotones("Muy grande", false, 24);

		add(lblTexto, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

	}

	// A partir de Java SE 8, una clase local puede acceder a las variables y parametros del bloque que lo contiene que son finales o locales con total eficacia.﻿
	private void colocarBotones(String nombre, boolean seleccionado, /* final */ int size) {

		// Crea el radio con un nombre y un estado de seleccion, lo agrega al grupo y despues al panel.
		rbtn = new JRadioButton(nombre, seleccionado);
		grupo1.add(rbtn);
		panelBotones.add(rbtn);

		// Pone a la escucha los radio.
		rbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				lblTexto.setFont(new Font("Serif", Font.PLAIN, size));

			}

		});
	}

}
