package colecciones;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * La interfaz Set define una coleccion que no puede contener elementos duplicados. Esta interfaz contiene, unicamente,
 * los metodos heredados de Collection añadiendo la restriccion de que los elementos duplicados estan prohibidos. Es
 * importante destacar que, para comprobar si los elementos son elementos duplicados o no lo son, es necesario que
 * dichos elementos tengan implementada, de forma correcta, los metodos equals y hashCode. Para comprobar si dos Set son
 * iguales, se comprobaran si todos los elementos que los componen son iguales sin importar en el orden que ocupen
 * dichos elementos.
 * 
 * Dentro de la interfaz Set existen varios tipos de implementaciones realizadas dentro de la plataforma Java. Vamos a
 * analizar cada una de ellas: HashSet, TreeSet y LinkedHashSet.
 * 
 * Ninguna de estas implementaciones son sincronizadas; es decir, no se garantiza el estado del Set si dos o mas hilos
 * acceden de forma concurrente al mismo. Esto se puede solucionar empleando una serie de metodos que actuan de wrapper
 * para dotar a estas colecciones de esta falta de sincronizacion:
 * 
 * Set set = Collections.synchronizedSet(new HashSet());
 * SortedSet sortedSet = Collections.synchronizedSortedSet(new TreeSet());
 * Set set = Collections.synchronizedSet(new LinkedHashSet());
 * 
 * Una vez explicados los distintos tipos de Set, veremos como se crean y mostraremos sus diferencias en los tiempos de
 * insercion. Como hemos visto anteriormente, el mas rapido deberia ser HashSet mientras que, por otro lado, el mas
 * lento deberia ser TreeSet.
 */

public class Set_ implements Set {

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return null;
	}

	@Override
	public boolean add(Object e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {
	}

}
