package _LABORATORIO;

public class Prueba {

	public static void main(String[] args) {

		try {
			int[] array = new int[4];
			array[8] = 40 / 0;
			System.out.println("1");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("2");
		} catch (ArithmeticException e) {
			System.out.println("3");
		}

	}

}