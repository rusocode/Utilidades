package _LABORATORIO;

/**
 * https://javadesdecero.es/avanzado/enumerados-enum-ejemplos/
 * https://jarroba.com/enum-enumerados-en-java-con-ejemplos/
 * En su forma mas simple, una enumeracion (clase "especial") es una lista de constantes con nombres que definen un
 * nuevo tipo de dato, cuyos objetos solo pueden ser definidos en la clase que la implementa.
 * Un objeto de un tipo de enumeracion solo puede contener los valores definidos por la lista. Por lo tanto, una
 * enumeracion le brinda una manera de definir con precision un nuevo tipo de dato que tiene un numero fijo de valores
 * validos, con el objetivo principal de definir nuestros propios tipos de datos.
 * Por ejemplo, los 4 palos en un mazo de cartas pueden ser 4 enumeradores llamados Flores, Diamantes, Corazones y
 * Espadas, que pertenecen a un tipo enumerado llamado Cartas.
 * Desde una perspectiva de programacion, las enumeraciones son utiles siempre que necesite definir un conjunto de
 * valores que represente una coleccion de elementos. Por ejemplo, puede usar una enumeracion para representar un
 * conjunto de codigos de estado, como exito, espera, error y reintentos, que indican el progreso de alguna accion.
 * Los enumeraciones en Java se usan cuando conocemos todos los valores posibles en tiempo de compilacion, como las
 * opciones en un menu, los modos de redondeo, los indicadores de linea de comando, etc.
 * 
 * Es importante aclarar que estas enumeraciones son mas poderosas que las del lenguaje C/C++, ya que se pueden agregar
 * variables, metodos (getters), constructores privados (para evitar la creacion de objetos) e incluso implementar
 * interfaces.
 */

public class Enumerados {

	/* ¿Por que y para que deberia usar enum en la programacion diaria?
	 * https://stackoverflow.com/questions/4709175/what-are-enums-and-why-are-they-useful
	 * Siempre debe usar enumeraciones cuando una variable (especialmente un parametro de metodo) solo puede tomar uno de un
	 * pequeño conjunto de valores posibles. Algunos ejemplos serian cosas como constantes de tipo (estado del contrato:
	 * "permanente", "temp", "aprendiz") o banderas ("ejecutar ahora", "aplazar ejecucion").
	 * 
	 * Si usa enumeraciones en lugar de numeros enteros (o codigos de cadena), aumenta la verificacion en tiempo de
	 * compilacion y evita errores al pasar constantes no validas, y documenta que valores son legales para usar.
	 * 
	 * Como ejemplo, ¿cual es mejor? */

	// El tipo puede ser: 1=coche, 2=camion, 3=avion, 4=tren, 5=barco, 0=todos los tipos
	public int getTransporte(int tipo) {
		return tipo;
	}

	// VERSUS VERSUS VERSUS VERSUS

	/* Lista finita de objetos relacionados (constantes de enumeracion). Cada uno se declara implicitamente como un miembro
	 * publico y estatico de Transporte. Ademas, el tipo de constantes de enumeracion es el tipo de enumeracion en el que se
	 * declaran las constantes, que es Transporte en este caso. Por lo tanto, en el lenguaje de java, estas constantes se
	 * llaman auto-tipado. */
	enum Transporte {
		COCHE, CAMION, AVION, TREN, BARCO, ALL;
	}

	/* Una vez que haya definido una enumeracion, puede crear una variable de ese tipo. Sin embargo, aunque las
	 * enumeraciones definen un tipo de clase, no crea una instancia de una enumeracion usando new. En cambio, declaras y
	 * utilizas una variable de enumeracion de la misma manera que un tipo primitivo. Por ejemplo, esto declara avion como
	 * una variable del tipo de enumeracion Transporte: */
	// Transporte avion;
	/* Como avion es de tipo Transporte, los unicos valores que se le pueden asignar son los definidos por la
	 * enumeracion: */
	// avion = Transporte.AVION; // La asignacion se hace dentro de un metodo

	public Transporte getTransporte(Transporte tipo) {
		return tipo;
	}

	// COMPARACION!
	// Una llamada a un metodo como:
	int avion1 = getTransporte(3);
	// luego se convierte en:
	Transporte avion2 = getTransporte(Transporte.AVION);
	/* En el segundo ejemplo, queda claro de inmediato que tipos estan permitidos, los documentos y la implementacion no
	 * pueden desincronizarse, y el compilador puede hacer cumplir esto. Ademas, una llamada no valida como: */
	// int avion1 = getTransporte(99);
	// ya no es posible.

}
