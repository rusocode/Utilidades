package _LABORATORIO;

public class Super {

	public static void main(String[] args) {
		Subclase sub1 = new Subclase(1, 2);
		System.out.println("La suma es: " + sub1.sumar());

		Superclase super1 = new Superclase(5, 5);
		System.out.println("La suma es: " + super1.sumar());

	}
}

class Superclase {
	private int test1;
	private int test2;

	public Superclase(int test1, int test2) {
		this.test1 = test1;
		this.test2 = test2;
	}

	public int sumar() {
		return test1 + test2;
	}
}

class Subclase extends Superclase {

	public Subclase(int test1, int test2) {

		/* Si estamos heredando de una superclase, entonces hay que implementar la palabra reserva super() para invocar al
		 * constructor de la superclase. */
		super(test1, test2);
	}

}
