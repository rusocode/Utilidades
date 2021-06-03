package colecciones.map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Este implementacion almacena las claves en una tabla hash. Es la implementacion con mejor rendimiento de todas pero
 * no garantiza ningun orden a la hora de realizar iteraciones. Esta implementacion proporciona tiempos constantes en
 * las operaciones basicas siempre y cuando la funcion hash disperse de forma correcta los elementos dentro de la tabla
 * hash. Es importante definir el tamaño inicial de la tabla ya que este tamaño marcara el rendimiento de esta
 * implementacion.
 */

public class HashMap_ {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		new Coleccion();

	}

}

class Coleccion {

	private HashMap<String, HashMap<String, String>> data = new HashMap<String, HashMap<String, String>>();

	public Coleccion() throws FileNotFoundException, IOException {
		/* Coleccion de datos de tipo HashMap en donde se le pasa una clave (K) y un valor (V) como datos de tipo generico. */
		HashMap<String, Empleado> empleados = new HashMap<String, Empleado>();

		empleados.put("1", new Empleado("Jose", 22, 15555));
		empleados.put("2", new Empleado("Juan", 48, 155552));
		empleados.put("3", new Empleado("Ruso", 33, 1558));

		// Imprime la coleccion de tipo HashMap
		// System.out.println(map); // Es lo mismo que map.values();

		/* Map.Entry (Entry) es una interfaz interna ubicada dentro de la interfaz Map. Esta interfaz contiene el metodo
		 * entrySet() que devuelve una coleccion de tipo Set, en donde admite como tipo de dato un Map.Entry. */
		// System.out.println(map.entrySet()); // Devuelve la coleccion Map en formato Set y la imprime

		for (Map.Entry<String, Empleado> entrada : empleados.entrySet()) {
			String clave = entrada.getKey();
			Empleado valor = entrada.getValue();
		}

		// ---- Agregar las claves (niveles) de la coleccion al array de niveles

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("1", "15");
		map.put("2", "45");
		map.put("3", "110");

		String[] niveles = new String[map.size()];
		int i = 0;

		for (Map.Entry<String, String> v : map.entrySet()) {
			niveles[i] = v.getKey();
			i++;
		}

		for (String s : niveles) {
			// System.out.println(s);

		}

		// ----------------------------------------------

		// Cargar el archivo .dat en el buffer y almacena sus valores dentro de un coleccion HashMap
		load("C:\\Users\\juand\\Desktop\\niveles.dat");
		// Muetra los datos
		show();

	}

	private void show() {
		String[] niveles = new String[data.size()];
		String[] exp = new String[data.size()];
		int i = 0, j = 0;

		/* Itera la primera clave de la coleccion.
		 * 
		 * Convierte la coleccion en Set para poder trabajarla como un conjuto de datos. */
		for (Map.Entry<String, HashMap<String, String>> v : data.entrySet()) {

			// Almacena las sub claves y valores
			HashMap<String, String> value = v.getValue();

			// Itera las claves y valores de la clave n
			for (Map.Entry<String, String> v2 : value.entrySet()) {
				// Si la clave es igual a "Nivel", entonces...
				if (v2.getKey().equalsIgnoreCase("Nivel")) {
					niveles[i] = v2.getValue(); // Almacena el valor de la clave nivel de la clave n
					i++;
				}
				if (v2.getKey().equalsIgnoreCase("Exp")) {
					exp[j] = v2.getValue();
					j++;
				}

			}

		}

		for (String s : exp)
			System.out.println(s);
	}

	private void load(String filename) throws FileNotFoundException, IOException {

		// La clase InputStreamReader convierte el flujo de bytes en caracteres!
		BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		try {
			loadFromFile(f);
		} finally {
			f.close();
		}

	}

	private void loadFromFile(BufferedReader f) throws FileNotFoundException, IOException {

		int corcheteCierre, separador;
		String section = null, key = null, value = null;
		String srt = "";
		while ((srt = f.readLine()) != null) {
			srt = srt.trim(); // Si hay espacios en blanco al principio o final de la cadena, los elimina
			if (srt.length() > 0) {
				switch (srt.charAt(0)) {
				case '[':
					if ((corcheteCierre = srt.indexOf(']')) > -1) {
						section = srt.substring(1, corcheteCierre).toUpperCase();
						// Si no contiene la seccion
						if (!data.containsKey(section)) data.put(section, new HashMap<String, String>());
					}
					break;
				default:
					// Si esta dentro de una seccion, y hay un signo = en la linea
					if ((section != null) && (separador = srt.indexOf('=')) > -1) {
						key = srt.substring(0, separador).trim().toUpperCase();
						// Si hay algo despues del signo =
						if (srt.length() > separador) value = srt.substring(separador + 1, srt.length()).trim();
						else value = "";

						// Recupera el conjunto de claves de la seccion, y agrega el par (clave, valor)
						data.get(section).put(key, value);

					}

					break;
				}
			}

		}

	}

}

class Empleado {

	private String nombre;
	private int edad;
	private double sueldo;

	public Empleado(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}

}