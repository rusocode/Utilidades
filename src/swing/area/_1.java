package swing.area;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	private JPanel panelBotones;
	private JButton btnInsertar, btnSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane scroll;

	public Marco() {

		setFrameProperties();
		makeGUI();
	}

	private void setFrameProperties() {

		setTitle("Calculadora");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

	}

	private void makeGUI() {
		panelBotones = new JPanel();

		areaTexto = new JTextArea(8, 20);
		scroll = new JScrollPane(areaTexto);

		btnInsertar = new JButton("Insertar");

		btnInsertar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// El metodo append conserva el texto anterior con el nuevo.
				areaTexto.append("Me llamo juancito, colecciono figuritas y tengo un perro que se llama pipi...");

			}

		});

		btnSaltoLinea = new JButton("Salto linea");
		btnSaltoLinea.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// boolean saltar = !areaTexto.getLineWrap();

				// Establece un salto de linea dependiendo de si hay o no un salto de linea.
				areaTexto.setLineWrap(!areaTexto.getLineWrap());

				// if (saltar)
				// btnSaltoLinea.setText("Quitar salto");
				// else
				// btnSaltoLinea.setText("Salto linea");

				/* Operador TERNARIO
				 * 
				 * El operador (?:) se llama operador condicional, y es ternario porque utiliza 3 operandos.﻿
				 * 
				 * areaTexto.getLineWrap() == true: condicion a evaluar.
				 * ?: indica que finaliza la prueba logica.
				 * 1 opcion: si es verdadero.
				 * : separador.
				 * 2 opcion: si es falso. */

				System.out.println(areaTexto.getLineWrap());
				btnSaltoLinea.setText(areaTexto.getLineWrap() == true ? "Quitar salto" : "Salto linea");

			}

		});

		add(scroll, BorderLayout.CENTER);

		panelBotones.add(btnInsertar);
		panelBotones.add(btnSaltoLinea);
		add(panelBotones, BorderLayout.SOUTH);
	}

}
