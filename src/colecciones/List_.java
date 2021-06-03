package colecciones;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * La interfaz List define una sucesion de elementos. A diferencia de la interfaz Set, la interfaz List si admite
 * elementos duplicados. A parte de los metodos heredados de Collection, añade metodos que permiten mejorar los
 * siguientes puntos:
 * Acceso posicional a elementos: manipula elementos en funcion de su posicion en la lista.
 * Busqueda de elementos: busca un elemento concreto de la lista y devuelve su posicion.
 * Iteracion sobre elementos: mejora el Iterator por defecto.
 * Rango de operacion: permite realizar ciertas operaciones sobre ragos de elementos dentro de la propia lista.
 * 
 * Dentro de la interfaz List existen varios tipos de implementaciones realizadas dentro de la plataforma Java. Vamos a
 * analizar cada una de ellas: ArrayList y LinkedList.
 * 
 * Ninguna de estas implementaciones son sincronizadas; es decir, no se garantiza el estado del List si dos o mas hilos
 * acceden de forma concurrente al mismo. Esto se puede solucionar empleando una serie de metodos que actuan de wrapper
 * para dotar a estas colecciones de esta falta de sincronizacion:
 * 
 * List list = Collections.synchronizedList(new ArrayList());
 * List list = Collections.synchronizedList(new LinkedList());
 * 
 * El cuando usar una implementacion u otra de List variara en funcion de la situacion en la que nos encontremos.
 * Generalmente, ArrayList sera la implementacion que usemos en la mayoria de situaciones. Sobretodo, varian los tiempos
 * de insercion, busqueda y eliminacion de elementos, siendo en unos casos una solucion mas optima que la otra.
 */

public class List_ implements List {

	@Override
	public boolean add(Object arg0) {
		return false;
	}

	@Override
	public void add(int arg0, Object arg1) {

	}

	@Override
	public boolean addAll(Collection arg0) {
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection arg1) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object arg0) {
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		return false;
	}

	@Override
	public Object get(int arg0) {
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		return null;
	}

	@Override
	public ListIterator listIterator(int arg0) {
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		return false;
	}

	@Override
	public Object remove(int arg0) {
		return null;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		return false;
	}

	@Override
	public Object set(int arg0, Object arg1) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public List subList(int arg0, int arg1) {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		return null;
	}

}
