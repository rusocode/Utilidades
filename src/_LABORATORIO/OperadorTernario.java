package _LABORATORIO;

public class OperadorTernario {

	public static void main(String[] args) {

		// condicion ? true : false
		int x = 10, y = 15;
		System.out.println("x = " + x + " y = " + y);

		System.out.println((x > y) ? "x es mayor" : "y es mayor");

		int var = (x < y) ? x + 5 : x;
		System.out.println(var);

		System.out.println((var == 15) ? ++x : --x);

		/* https://byspel.com/que-es-y-como-utilizar-el-operador-ternario-en-java/ */

	}

}
