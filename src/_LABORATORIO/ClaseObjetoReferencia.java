package _LABORATORIO;

// Diferencia entre objeto y referencia
// https://ichi.pro/es/cual-es-la-diferencia-entre-referencia-objeto-instancia-y-clase-40072553590683
// https://stackoverflow.com/questions/6395754/difference-between-reference-and-instance-in-javascript

/**
 * Clase: Una clase es la estructura de un objeto, es decir, la definicion de todos los elementos que componen un
 * objeto, en otras palabras, es un molde para crear objetos.
 * 
 * Objeto/Instancia: Un objeto es, por lo tanto, el "resultado" de una clase. En realidad, un objeto es una instancia de
 * una clase, por lo que se pueden intercambiar los terminos objeto o instancia (o incluso evento).
 * 
 * Referencia: Una referencia, en terminos informaticos, es un indicativo hacia un objeto.
 * Al igual que el puntero, una referencia es un alias para una entidad, en otras palabras, una variable
 * cualitativa que contiene la direccion de otra variable cualitativa.
 * Por ejemplo, "La casa de rulo" es un Objeto de la clase "LugarQuemado", entonces para llegar a "La casa
 * de rulo" necesito una referencia. Esa referencia esta mejor explicada en la siguiente metafora...
 * 
 * La metafora de "La casa de rulo"
 * Una vez existio "La casa de rulo", en donde se rumoreaba que tenia buenas hierbas. Ruso queria probarlas
 * pero no sabia como llegar a "La casa de rulo", entonces de casualidad encontro un papel (referencia)
 * con la direccion de la calle (direccion de memoria) a "La casa de rulo" (objeto). Una vez que llego a "La casa de
 * rulo", le pregunto a "La casa de rulo" si podia (public, private, protected o default) darle un poco de esas ricas
 * flores (propiedad). El buen rulo le dio las flores y ademas un picador (funcion).
 * En Java, "La casa de rulo" es la referencia.
 */

public class ClaseObjetoReferencia {

	public static void main(String[] args) {

		System.out.println(LugarQuemado.MENSAJE_PARA_LOS_QUEMADOS);

		// Se crea un objeto a traves del operador new y se usa La_casa_de_rulo como referencia a esa instancia
		LugarQuemado La_casa_de_rulo = new LugarQuemado("La_casa_de_rulo", "OG Kush", true);
		System.out.println(La_casa_de_rulo.LUGAR_QUEMADO + " tiene unas " + La_casa_de_rulo.getFlor());
		La_casa_de_rulo.picar();
		La_casa_de_rulo.fumar(11);

		LugarQuemado El_depto_de_ruso = new LugarQuemado("El_depto_de_ruso", "AK-47", false);
		System.out.println(El_depto_de_ruso.LUGAR_QUEMADO + " tiene unas " + El_depto_de_ruso.getFlor());
		El_depto_de_ruso.picar();
		El_depto_de_ruso.fumar(1);

		System.out.println("\nCantidad de flores: " + LugarQuemado.cantidadDeFlores + "g");

		/* Al asignar una variable de tipo referencia a objeto a otra variable, se asigna la direccion y no el objeto
		 * referenciado por esa direccion. Esto significa que ambas variables quedan referenciado al mismo objeto.
		 * Esto tiene implicancias mayores ya que si se modifica el objeto referenciado por El_depto_de_ruso, entonces tambien
		 * se modifica el objeto referenciado por La_casa_de_rulo, puesto que son el mismo objeto. */
		// La_casa_de_rulo = El_depto_de_ruso;
		// System.out.println("La_casa_de_rulo tiene unas " + La_casa_de_rulo.getFlor());

	}

}

// "Molde"
class LugarQuemado {

	/* Un atributo en Java es un identificador que representa una palabra en memoria que contiene informacion. El tipo de
	 * informacion almacenada en un atributo solo puede ser del tipo con que se declaro ese atributo.
	 * Es incorrecto decir que un atributo (variable o constante) almacena datos ya que es solo una manera de representar
	 * los datos en la memoria RAM. El atributo actua como una "etiqueta" de la celda que almacena los datos.
	 * 
	 * Los atributos de instancia son aplicables a un solo objeto. Determinan el estado en el que se encuentra un objeto.
	 * Ejemplo: El atributo flor en la clase LugarQuemado es de instancia, debido a que cada LugarQuemado
	 * tendra su propia flor. Es importante remarcar que el aributo flor es non-static, osea que se almacena en
	 * un nuevo bloque de memoria dinamica. */
	private String flor;
	private boolean picador;

	/* Las constantes simpre deben inicializarse en su declaracion, pero en este caso se hace desde el constructor.
	 * Como es una constante, no hace falta encapsularla con private ya que saltaria un error en tiempo de compilacion
	 * al modificar su valor. */
	public final String LUGAR_QUEMADO;

	/* Las variables estaticas (memoria fija) comparten la misma ubicacion de memoria. En este caso se prodria decir que
	 * rulo y ruso comparten las flores. */
	public static int cantidadDeFlores = 10;

	// Constante de clase
	public static final String MENSAJE_PARA_LOS_QUEMADOS = "El señor sin cara los esta mirando";

	// PRO TIP!
	// Por convenio es habitual que los modificadores de atributo se orden de la siguiente forma:
	// public protected private static final transient volatile
	// https://stackoverflow.com/questions/11219556/difference-between-final-static-and-static-final

	public LugarQuemado(final String LUGAR_QUEMADO, String flor, boolean picador) {
		this.LUGAR_QUEMADO = LUGAR_QUEMADO;
		this.flor = flor;
		this.picador = picador;
	}

	// Los metodos "getters" devuelven el valor del atributo privado, evitando asi, la modificacion del mismo
	public String getFlor() {
		return flor;
	}

	public void picar() {
		if (picador) System.out.println("Se picaron las hierbas :)");
		else System.out.println("No tenes picachu.");
	}

	public void fumar(int cantidadFumada) {

		if (!picador) {
			System.out.println("Las flores no se pueden fumar por que estan sin picar!");
			return;
		}

		if (cantidadFumada > cantidadDeFlores) {
			System.out.println("No hay esa cantidad de flores!");
			return;
		}

		if (cantidadDeFlores <= 0) {
			System.out.println("No hay mas flores!");
			return;
		}

		System.out.println(LUGAR_QUEMADO + " se tosto " + cantidadFumada + "g");
		cantidadDeFlores -= cantidadFumada;
	}

}