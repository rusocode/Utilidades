package colecciones;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

import javax.swing.JOptionPane;

import static _LABORATORIO.ColeccionDeConstantes.*;

/**
 * Clase para leer y escribir archivos ini y jar.
 * 
 * https://es.wikipedia.org/wiki/INI_(extensi%C3%B3n_de_archivo)
 *
 * @author Ru$o
 */

public class IniFile {

	/* A tener en cuenta...
	 * Si el orden no importa, entonces usamos una coleccion de tipo HashMap para manipular los datos del archivo.
	 * Si el orden importa:
	 * ¿Ordenacion? TreeMap (la mas lenta)
	 * ¿Insercion? LinkedHashMap */
	private HashMap<String, HashMap<String, String>> coleccion = new HashMap<String, HashMap<String, String>>();

	private String filename;

	// Un constructor sin argumentos supone que ya hay un archivo en el proyecto
	public IniFile() {
	}

	/* FIXME Si quiero cargar un jar, entonces esto no sucedera ya que solo estoy llamando al metodo que carga un ini. Para
	 * solucionarlo tendria que crear un constructor sin parametros y llamar al metodo correspondiente. */
	public IniFile(String filename) {
		this.filename = filename;
		loadIniFile(filename);
	}

	/**
	 * Carga un archivo ini y le agrega un buffer de lectura.
	 * 
	 * @param filename - El nombre del archivo ini.
	 * @throws FileNotFoundException Archivo no encontrado.
	 * @throws IOException           Error de I/O (entrada y salida).
	 */
	public void loadIniFile(String filename) {

		BufferedReader buffer = null;

		try {
			// Agrega un buffer para los bytes de entrada (optimizacion)
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			readBuffer(buffer);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo especificado: " + filename, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error de I/O: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (buffer != null) buffer.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar el flujo de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	// Carga un archivo jar y le agrega un buffer de lectura
	public void loadJarFile(String filename) {

		URL url;
		BufferedReader buffer = null;

		try {

			/* La sintaxis de una URL JAR es:
			 * jar:<url>!/{entry}
			 * 
			 * por ejemplo:
			 * jar:http://www.foo.com/bar/baz.jar!/COM/foo/Quux.class
			 * 
			 * Las URL Jar deben usarse para hacer referencia a un archivo JAR o entradas en un archivo JAR. El ejemplo anterior es
			 * una URL JAR que se refiere a una entrada JAR. Si se omite el nombre de la entrada, la URL hace referencia a todo el
			 * archivo JAR: jar:http://www.foo.com/bar/baz.jar!/
			 * 
			 * Los usuarios deben convertir la URLConnection generica a JarURLConnection cuando saben que la URL que crearon es una
			 * URL JAR y necesitan una funcionalidad especifica de JAR.
			 * 
			 * URL url = new URL("jar:file:/home/duke/duke.jar!/");
			 * JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
			 * Manifest manifest = jarConnection.getManifest();
			 * 
			 * 
			 * Ejemplos de URL Jar
			 * 
			 * Entrada al Jar
			 * jar:http://www.foo.com/bar/baz.jar!/COM/foo/Quux.class
			 * 
			 * Archivo Jar
			 * jar:http://www.foo.com/bar/baz.jar!/
			 * 
			 * Directorio Jar
			 * jar:http://www.foo.com/bar/baz.jar!/COM/foo/
			 * 
			 * '!/' es el separador.
			 * 
			 * Al construir una URL JAR a traves de una nueva URL (contexto, especificacion), se aplican las siguientes reglas:
			 * .Si no hay una URL de contexto y la especificacion pasada al constructor de URL no contiene un separador, se
			 * considera que la URL hace referencia a un JarFile.
			 * .Si hay una URL de contexto, se supone que la URL de contexto hace referencia a un archivo JAR o un directorio Jar.
			 * .Si la especificacion comienza con '/', el directorio Jar se ignora y se considera que la especificacion esta en la
			 * raiz del archivo Jar. */

			// Crea una URL con la direccion especificada
			url = new URL("jar:file:mapas.jar!/" + filename);

			/* El metodo openConnection() devuelve una instancia de URLConnection que representa una conexion al objeto remoto al
			 * que hace referencia la URL. Luego se hace un cast de la instancia URLConnection a JarURLConnection para usar la
			 * conexion con archivos JAR. */
			JarURLConnection jarConnection = (JarURLConnection) url.openConnection();

			buffer = new BufferedReader(new InputStreamReader(jarConnection.getInputStream()));

			readBuffer(buffer);

		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "URL con formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException e) { // FileNotFoundException no cumplia ninguna funcionalidad
			JOptionPane.showMessageDialog(null, "No se encontro el archivo especificado", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error de I/O: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (buffer != null) buffer.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar el flujo de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Carga un archivo y le agrega un buffer de escritura
	public void store(String filename) {

		BufferedWriter buffer = null;

		try {
			// Agrega un buffer para los bytes de salida (optimizacion)
			buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
			writeBuffer(buffer, filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(null, "No se admite la codificacion de caracteres", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error de I/O: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (buffer != null) buffer.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar el flujo de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	// Lee en buffer y carga los datos a la coleccion
	private void readBuffer(BufferedReader buffer) throws IOException {

		int corcheteCierre, separador, comentario;
		String line, seccion = null, clave, valor;

		while ((line = buffer.readLine()) != null) {
			line = line.trim(); // Si hay espacios en blanco al principio o final de la cadena, los elimina
			if (line.length() > 0) { // Si no es un espacio en blanco, entonces...
				switch (line.charAt(0)) {
				// COMENTARIOS
				case ';':
				case '*':
				case '#':
				case '\'':
					break;
				case '[': // SECCIONES
					if ((corcheteCierre = line.indexOf(']')) != -1) {
						// Almacena la seccion que va del indice 1 al corcheteCierre sin incluirlo
						seccion = line.substring(1, corcheteCierre).toUpperCase();
						// Si la coleccion no contiene la seccion, entonces agrega la seccion a la coleccion
						if (!coleccion.containsKey(seccion)) coleccion.put(seccion, new HashMap<String, String>());
					}
					break;
				default: // PARES
					// Si esta dentro de una seccion y hay un signo '=' en la linea, entonces...
					if ((seccion != null) && (separador = line.indexOf('=')) != -1) {

						clave = line.substring(0, separador).trim(); // FIXME Q funcionalidad tiene el metodo trim() en esta linea?

						// Si hay algo despues del signo =
						if (line.length() > separador) {

							valor = line.substring(separador + 1, line.length()).trim();

							// Si hay un comentario al final de la linea, lo quita
							if ((comentario = valor.indexOf(';')) != -1) valor = valor.substring(0, comentario);

						} else valor = "";

						// Recupera la seccion y agrega el par clave/valor a la coleccion = linea
						coleccion.get(seccion).put(clave, valor);
					}

					break;
				}
			}
		}
	}

	// Escribe en buffer y carga los datos al archivo
	private void writeBuffer(BufferedWriter buffer, String filename) throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		buffer.write(";Archivo: " + filename);
		buffer.write("\n;Ultima modificacion: " + sdf.format(new Date()) + "\n\n");

		/* Crea un coleccion de tipo TreeSet que contiene los elementos de la coleccion especificada (keySet() metodo que
		 * devuelve el conjunto de claves (secciones) del HashMap), ordenados segun el orden natural de sus elementos. */
		TreeSet<String> secciones = new TreeSet<String>(coleccion.keySet()); // "Lo convierto en un TreeSet para ordenarlo... bien al pedo.

		// El primer for agrega las secciones
		for (String seccion : secciones) {

			buffer.write("[" + seccion + "]\n");

			// Obtiene el par clave/valor de la seccion dada
			HashMap<String, String> par = coleccion.get(seccion);

			// Obtiene el conjunto de claves de la seccion dada
			TreeSet<String> claves = new TreeSet<String>(par.keySet()); // Ordena las claves

			// El segundo for agrega el par clave/valor
			for (String clave : claves) {
				String valor = par.get(clave); // Obtiene el valor de la clave especificada
				buffer.write(clave + "=" + valor + "\n");
			}

			buffer.write("\n");
		}

	}

	/**
	 * Agrega a la coleccion, la seccion, la clave y el valor. En caso de que ya existan, los modifica.
	 * 
	 * FIXME Agregar los cambios en el archivo.
	 * FIXME Convertir el metodo en generico para que pueda recibir cualquier tipo de dato, evitando asi
	 * la sobrecarga de metodos.
	 * 
	 * @param seccion - El nombre de la seccion en el archivo.
	 * @param clave   - El nombre de la clave en el archivo.
	 * @param valor   - El valor de la seccion/clave.
	 */
	public void setValue(/* String filename, */String seccion, String clave, String valor) {
		seccion = seccion.toUpperCase();
		// Si la seccion no existe, la agrega a la coleccion
		if (!coleccion.containsKey(seccion)) coleccion.put(seccion, new HashMap<String, String>());
		/* Agrega/Modifica la clave/valor en la seccion, si la coleccion anteriormente contenia un mapeo para la clave, se
		 * reemplaza el valor antiguo. */
		coleccion.get(seccion).put(clave, valor);

		// Agrega los cambios en el archivo
		// loadOuputFile(filename);
	}

	public void setValue(String seccion, String clave, int valor) {
		seccion = seccion.toUpperCase();
		if (!coleccion.containsKey(seccion)) coleccion.put(seccion, new HashMap<String, String>());
		coleccion.get(seccion).put(clave, "" + valor);
	}

	public void setValue(String seccion, String clave, double valor) {
		seccion = seccion.toUpperCase();
		if (!coleccion.containsKey(seccion)) coleccion.put(seccion, new HashMap<String, String>());
		coleccion.get(seccion).put(clave, "" + valor);
	}

	public void setValue(String seccion, String clave, boolean valor) {
		seccion = seccion.toUpperCase();
		if (!coleccion.containsKey(seccion)) coleccion.put(seccion, new HashMap<String, String>());
		coleccion.get(seccion).put(clave, valor ? "1" : "0");
	}

	/**
	 * Devuelve el valor String de la seccion/clave.
	 * El valor por defecto es "".
	 * 
	 * Este metodo supone que la seccion/clave existen en el archivo. Por eso es IMPORTANTE (por ahora)
	 * pasar bien los parametros, ya que saltaria un NPE.
	 * FIXME Crear un metodo para comprobar los parametros.
	 * FIXME Agregar dafaultValor a la coleccion.
	 * FIXME Crear metodo generico para que reciba cualquier tipo de valor.
	 * 
	 * @param seccion      - El nombre de la seccion en el archivo.
	 * @param clave        - El nombre de la clave en el archivo.
	 * @param defaultValue - El valor por defecto si la clave no tiene ningun valor.
	 * @return El valor de la seccion/clave.
	 */
	public String getString(String seccion, String clave, String defaultValor) {

		// Convierte a mayusculas el nombre de la seccion
		seccion = seccion.toUpperCase();
		String valor = null;

		/* Si la coleccion contiene la seccion especificada, entonces se asigna a valor el valor devuelto
		 * de la seccion/clave. En caso de que el valor contenga espacios al final de la cadena, los elimina. */
		if (coleccion.containsKey(seccion)) valor = coleccion.get(seccion).get(clave).trim();
		// Esto podria tomarse como una solucion a los NPE
		/* else {
		 * Log.getLogger().warning("Parametros incorectos!");
		 * return defaultValor;
		 * } */

		// Si el valor esta vacio, devuelve defaultValor
		return !valor.isEmpty() ? valor : defaultValor;

	}

	public int getInt(String seccion, String clave, int defaultValor) {
		seccion = seccion.toUpperCase();
		String valor = null;
		if (coleccion.containsKey(seccion)) valor = coleccion.get(seccion).get(clave).trim();
		return !valor.isEmpty() ? Integer.parseInt(valor) : defaultValor;
	}

	public long getLong(String seccion, String clave, long defaultValor) {
		seccion = seccion.toUpperCase();
		String valor = null;
		if (coleccion.containsKey(seccion)) valor = coleccion.get(seccion).get(clave).trim();
		return !valor.isEmpty() ? Long.parseLong(valor) : defaultValor;
	}

	public double getDouble(String seccion, String clave, double defaultValor) {
		seccion = seccion.toUpperCase();
		String valor = null;
		if (coleccion.containsKey(seccion)) valor = coleccion.get(seccion).get(clave).trim();
		return !valor.isEmpty() ? Double.parseDouble(valor) : defaultValor;
	}

	public static void main(String args[]) {

		// Crea una nueva instancia para agregar/modificar en el archivo Motd.ini
		// IniFile iniMotd = new IniFile();
		// Agrega los datos a la coleccion
		// iniMotd.setValue("INIT", "NUMLINES", 4);
		// Carga los datos de la coleccion al archivo Motd.ini
		// iniMotd.store(DATDIR + SEPARADOR + "Motd.ini");

		// Carga (en la coleccion) y lee el archivo Prueba.dat
		// IniFile iniPrueba = new IniFile(DATDIR + SEPARADOR + "Prueba.dat");
		// System.out.println(iniPrueba.getInt("OBJ1", "Valor", 0));

		// for (int i = 1; i <= iniPrueba.coleccion.size(); i++)
		// System.out.println(iniPrueba.getString("OBJ" + i, "Name", "default"));

		// Modifica el valor especificado
		// iniPrueba.setValue("OBJ2", "Name", "Espada Mata Dragones");

		// Agrega una seccion con clave/valor
		// iniPrueba.setValue("OBJ4", "Name", "Puerta");

		// Muestra los valores agregados y modificados
		// for (int i = 1; i <= iniPrueba.coleccion.size(); i++)
		// System.out.println(iniPrueba.getString("OBJ" + i, "Name", ""));

		// System.out.println(iniPrueba.coleccion.toString());

	}

}
