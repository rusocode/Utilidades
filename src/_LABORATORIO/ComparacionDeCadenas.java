package _LABORATORIO;

// https://stackoverflow.com/questions/3321526/should-i-use-string-isempty-or-equalsstring/3321548#3321548
// https://stackoverflow.com/questions/6828362/difference-between-string-isempty-and-string-equals/6828386
public class ComparacionDeCadenas {

	private static String str = "asd";

	public static void main(String[] args) {
		System.out.println("valor de srt = " + str);
		prueba2();
	}

	static void prueba1() {

		/* El principal beneficio de "".equals(str) es que no necesita la verificacion nula (equals verificara su argumento y
		 * devolvera false si es nulo), lo que parece no importarle. Si no le preocupa que str sea nulo (o si lo esta
		 * comprobando), definitivamente usaria str.isEmpty(); muestra exactamente lo que esta comprobando, le importa si la
		 * cadena esta vacio o no, no si es igual a la cadena vacia.
		 * 
		 * "null-safe", se refiere a que si str fuera null, esta construccion simplemente se evaluaria a false y no arrojaria un
		 * NullPointerException. */
		System.out.println("\"\".equals(str) = " + "".equals(str));

	}

	static void prueba2() {

		/* isEmpty() compara la variable de conteo con 0, mientras que equals verificara el tipo, la longitud de la cadena y
		 * luego iterara sobre la cadena para comparar si los tamaños coinciden.
		 * 
		 * isEmpty() en realidad hara mucho menos! y eso es bueno. */
		System.out.println("str.isEmpty() = " + str.isEmpty());
	}

}
