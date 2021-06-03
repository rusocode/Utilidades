package genericos;

public class ArrayList2 {

	private Object[] elemento;
	private int i;

	public ArrayList2(int n) {

		elemento = new Object[n];

	}

	public Object get(int i) {
		return elemento[i];
	}

	public void add(Object o) {
		elemento[i] = o;
		i++;
	}

}
