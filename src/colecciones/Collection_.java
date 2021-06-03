package colecciones;

import java.util.Collection;
import java.util.Iterator;

// https://www.adictosaltrabajo.com/2015/09/25/introduccion-a-colecciones-en-java/

/**
 * Una coleccion representa un grupo de objetos. Esto objetos son conocidos como elementos. Cuando queremos trabajar con
 * un conjunto de elementos, necesitamos un almacen donde poder guardarlos. En Java, se emplea la interfaz generica
 * Collection para este proposito. Gracias a esta interfaz, podemos almacenar cualquier tipo de objeto y podemos usar
 * una serie de metodos comunes, como pueden ser: añadir, eliminar, obtener el tamaño de la coleccion… Partiendo de la
 * interfaz generica Collection extienden otra serie de interfaces genericas. Estas subinterfaces aportan distintas
 * funcionalidades sobre la interfaz anterior: Set, Map y List.
 */

public class Collection_ implements Collection {

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
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {
	}

}
