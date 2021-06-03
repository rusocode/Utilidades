package colecciones;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * En cuestiones de eficiencia la verdad no sabria decirte que consume mas recursos. Pero Iterator permite "jugar" mas y
 * de manera mas sencilla que un bucle foreach con los elementos de un ArrayList. Los metodos de la clase Iterator
 * permiten eliminar, ir al siguiente y saber si hay mas elementos o no los hay de una manera mas sencilla que un bucle
 * foreach o el for estandar.
 * 
 * ¿Se puede hacer lo mismo con un for? Por ejemplo eliminar un elemento en concreto de un ArrayList, saber si hay mas
 * elementos o no etc. Si, se puede. Pero la sintaxis es mas sencilla con Iterator.
 * 
 * Y ademas, la ventaja fundamental de un Iterator, es que puede recorrer tambien colecciones de objetos.
 */

public class Iterator_ {

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<Integer>();

		numeros.add(4);
		numeros.add(-2);
		numeros.add(77);
		numeros.add(0);

		Iterator<Integer> i = numeros.iterator();

		while (i.hasNext())
			System.out.println(i.next());

	}

}
