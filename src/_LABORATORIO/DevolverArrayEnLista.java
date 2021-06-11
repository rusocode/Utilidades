package _LABORATORIO;

import java.util.LinkedList;
import java.util.List;

// https://stackoverflow.com/questions/12869741/returning-arrays-in-java
public class DevolverArrayEnLista {

	byte[] numeros = { 1, 2, 3 };

	/* Ambos metodos devuelven una matriz de numeros, ya sea en una lista o en un array, es lo mismo.
	 * Por lo tanto parece ser menos eficiente el metodo que devuelve una lista, ya que se esta creando
	 * un objeto de tipo LinkedList, se agregan los valores del array a la lista y se convierte a un array. */

	byte[] getNumerosEnArray() {
		/* Cuando una funcion devuelve algo, esencialmente esta reemplazando la linea en la que se llama (numeros en este
		 * caso) con el valor de retorno ([B@6d06d69c). */
		return numeros;
	}

	// Devuelve el array como una lista enlazada de objetos
	Object[] getNumerosEnLista() {
		List<Object> lista = new LinkedList<>();
		for (byte numero : numeros)
			lista.add(numero);
		return lista.toArray();
	}

	public static void main(String[] args) {

		DevolverArrayEnLista prueba = new DevolverArrayEnLista();

		System.out.println(prueba.getNumerosEnLista());
		System.out.println(prueba.getNumerosEnArray());

		byte[] numeros = prueba.getNumerosEnArray();
		Object[] n = prueba.getNumerosEnLista();

		System.out.println("Valores devueltos por el array...");
		for (int i = 0; i < numeros.length; i++)
			System.out.print(numeros[i]);

		System.out.println();

		System.out.println("Valores devueltos por la lista...");
		for (int i = 0; i < n.length; i++)
			System.out.print(n[i]);

	}

}
