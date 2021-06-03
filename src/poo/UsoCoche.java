package poo;

public class UsoCoche {

	public static void main(String[] args) {
		Coche ford = new Coche();

		/* Con esto estamos cometiendo una violacion de datos (incongruencia). La incongruencia consiste en que si en la
		 * clase Coche, se esta utilizando el metodo constructor para darle un estado inicial, que son las caracteristicas
		 * comunes que van a compartir todos los objetos pertenecientes a esta clase, entonces no tiene ningun sentido
		 * que si desde el contructor le estoy dando 4 ruedas a los coches, desde una clase diferente (UsoCoche) yo
		 * pueda decir que un coche tenga 3 ruedas ¿Para que el constructor entonces? Solo se puede acceder a esos
		 * datos desde la propia clase, encapsulando el metodo con un modificador de acceso (private, public o protect). */
		// ford.ruedas = 3; // Manipula directamente la propiedad (violacion de datos)

		// Le pasa como argumento la cantidad de ruedas que va a tener el coche (paso de parametros)
		ford.setRuedas(2/* argumento */);

		// Con los metodos evitamos modificar las propiedades/miembro (atributos=variables o constantes; metodos/funciones) desde otra clase
		System.out.println("El coche tiene " + ford.getRuedas() + " ruedas");

		ford.setEsFeo("si");
		System.out.println(ford.getEsFeo());

	}

}
