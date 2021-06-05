package colecciones;

import java.util.BitSet;

/**
 * Esta clase implementa un vector de bits que crece segun sea necesario. Cada componente del conjunto de bits tiene un
 * valor booleano. Los bits de un BitSet estan indexados por enteros no negativos. Los bits indexados individuales se
 * pueden examinar, establecer o borrar. Un BitSet se puede utilizar para modificar el contenido de otro BitSet a traves
 * de operaciones logicas AND, logicas OR inclusivas y logicas OR exclusivas.
 * 
 * De forma predeterminada, todos los bits del conjunto tienen inicialmente el valor falso.
 */
public class BitSet_ {

	private static final int CORRER = 0;
	private static final int SALTAR = 1;
	private static final int CAMINAR = 2;

	public static void main(String[] args) {

		/* Crea un conjunto de bits cuyo tamaño inicial es lo suficientemente grande como para representar explicitamente bits
		 * con indices en el rango de 0 a nbits-1. */
		BitSet flags = new BitSet(3); // FIXME No veo la diferencia entre el constructor sin argumentos

		// Establece el bit en el indice especificado en verdadero
		flags.set(CORRER);
		// Establece el bit en el indice especificado en el valor especificado
		flags.set(SALTAR, false);

		System.out.println(flags.get(CORRER)); // true
		System.out.println(flags.get(SALTAR)); // false
		System.out.println(flags.get(CAMINAR)); // false

	}

}
