package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Prueba {

	/* La idea de esta clase es leer desde el cargador de clases el archivo dentro del jar y crear el mismo archivo pero
	 * fuera del jar para poder trabajarlo. */
	public static void main(String[] args) {

		/* Carga desde la ruta de clases el archivo especificado y se lo pasa como parametro al constructor de la clase File
		 * para poder trabajarlo como un archivo. */
		ClassLoader cargador = Prueba.class.getClassLoader();
		URL direccion = cargador.getResource("PJs.dat");

		// FIXME Hace falta usar la clase File o solo le pasaria la cadena al flujo de datos?
		File fromFile = new File(direccion.getFile()); // Archivo origen (.classpath)
		File toFile = new File(System.getProperty("user.home") + File.separator + "PJs.dat"); // Archivo destino

		try {
			
			DataInputStream in = new DataInputStream(new FileInputStream(fromFile));
			
			

			in.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
