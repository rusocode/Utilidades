package _LABORATORIO;

public class Args {

	public Args(String[] args) {
		if (args.length == 1 && "throw".equals(args[0])) throw new IllegalStateException("Exception thrown from Args.");
	}

	public static void main(String[] args) {
		new Args(args);
	}

}
