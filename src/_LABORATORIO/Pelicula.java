package _LABORATORIO;

public class Pelicula {

	private String nombre;
	private String genero;
	private Actor actor;
	private Productora productora;

	Pelicula(String nombre, String genero, Actor actor, Productora productora) {
		this.nombre = nombre;
		this.genero = genero;
		this.actor = actor;
		this.productora = productora;
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", genero=" + genero + ", actor=" + actor.name() + ", productora=" + productora.getNombre() + "]";
	}

	public static void main(String[] args) {

		Pelicula naufrago = new Pelicula("Naufrago", "Drama", Actor.TOM, Productora.IMAGEMOVERS);
		Pelicula gladiador = new Pelicula("Gladiador", "Accion/Aventura/Drama", Actor.RUSSELL, Productora.SCOTT_FREE_PRODUCTIONS);

		System.out.println(naufrago.toString());
		System.out.println(gladiador.toString());

	}
}

enum Actor {

	TOM, RUSSELL;

}

enum Productora {

	SCOTT_FREE_PRODUCTIONS("Scott Free Productions", 1980), IMAGEMOVERS("ImageMovers", 1984);

	private String nombre;
	private int fundacion;

	private Productora(String nombre, int fundacion) {
		this.nombre = nombre;
		this.fundacion = fundacion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getFundacion() {
		return fundacion;
	}

}
