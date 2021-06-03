package _LABORATORIO;

public class Binarios {

	public static void main(String[] args) {

		System.out.println((0xff) << (8));

	}

	public static short leShort(short n) {
		return (short) (((n & 0xff) << 8) | (((n & 0xff00) >> 8) & 0xff));
	}

}
