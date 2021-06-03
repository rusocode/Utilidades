package paquete1;

// Cuando se crea un objeto de una clase de otro paquete, hay que importar ese paquete!
import paquete2.clase3;

public class clase2 {

	public static void main(String[] args) {

		clase1 c1 = new clase1(); // Mismo paquete

		// clase3 hereda de clase1, por lo tanto el objeto "c3" tiene todas las variables de la propia clase, pero tambien los de la clase1
		clase3 c3 = new clase3(); // Distinto paquete

		c1.n1 = 0; // public
		c1.n2 = 0; // protected
		// c2.n3 = 0; // private
		c1.n4 = 0; // por defecto

		c3.n1 = 0; // public
		c3.n2 = 0; // protected
		// c3.n3 = 0; // private
		// c3.n4 = 0; // por defecto

	}

}

// Object: la clase COSMICA