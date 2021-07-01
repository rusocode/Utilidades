package clases;

import java.lang.reflect.Field;

// https://mundosica.com/el-metodo-getclass-explicacion-y-uso-practico-construyendo-librerias-en-java-i/

// Accediendo a la informacion de clase
public class Clase {

	/* "Clase.class" es lo mismo que "this.getClass()", con la diferencia que "this" no se puede usar en un contexto
	 * estatico. */

	// Atributos
	private String valor1 = "valor default";
	private String valor2;
	private double decimal = 12.5;

	// Constructor por defecto
	public Clase() {
	}

	// Constructor con parametros
	public Clase(String valor1) {
		this.valor1 = valor1;
	}

	/**
	 * Devuelve una instancia de Clase dinamica a partir de un constructor vacio
	 * 
	 * @return
	 */
	public static Clase constructor() {
		try {
			return Clase.class.newInstance(); // newInstance() crea un objeto de esta clase
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Devuelve una instancia de Clase dinamica a partir de un constructor con atributos
	 * 
	 * @param valor1
	 * @return
	 */
	public static Clase constructor(String valor1) {
		try {
			return Clase.class.getConstructor(String.class).newInstance(valor1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Mostrando el nombre de la clase
	/* El metodo getClass() se encuentra definido en Object como un metodo final, dicho metodo devuelve una representacion
	 * en tiempo de ejecucion de la clase del objeto sobre el cual podemos acceder a una serie de caracteristicas del objeto
	 * por ejemplo: el nombre de la clase, el nombre de su superclase y los nombres de los interfaces que implementa. */
	public String getNombreClase() {
		return "Nombre de clase: " + this.getClass().getSimpleName();
	}

	// Muestra los atributos existentes en la clase (nombre y valor)
	public void imprimirAtributos() {
		System.out.println("Atributos>");
		Field[] fields = this.getClass().getDeclaredFields();
		if (fields.length != 0) {
			for (Field field : fields) {
				try {
					String fieldName = field.getName();
					Object fieldValue = field.get(this);
					System.out.println(fieldName + ": " + fieldValue);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} else System.out.println("No existen atributos.");

	}

	public static void main(String[] args) {
		Clase clase1 = new Clase("valor 1");
		System.out.println(clase1.valor1);

		String nombre = "";
		// Devuelve el nombre completo (ruta) de la variable clase1
		System.out.println("Clase de la variable clase1: " + clase1.getClass());
		System.out.println("Clase de la variable nombre: " + nombre.getClass());

		Clase clase2 = Clase.constructor();
		System.out.println(clase2.valor1);

		// Creando un objeto desde un constructor dinamico
		Clase clase3 = Clase.constructor("valor 1 - constructor dinamico");
		System.out.println(clase3.valor1);

		// Otra forma de crear objetos de la propia clase
		try {
			Clase clase4 = Clase.class.newInstance();
			System.out.println(clase4.getNombreClase());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		// System.out.println(clase.getNombreClase());
		// clase.imprimirAtributos();

		/* System.out.println("Ruta de clase en los paquetes de la API de java: " + sb.getClass().getName());
		 * System.out.println("Nombre de clase: " + sb.getClass().getSimpleName());
		 * System.out.println("sb es instancia de String?: " + sb.getClass().isInstance(args)); */

	}

}
