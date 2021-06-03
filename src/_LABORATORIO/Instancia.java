package _LABORATORIO;

public class Instancia {

	public static void main(String[] args) {

		InstanciaDeClase.setMiNombre("Juan");
		InstanciaDeClase.imprimirMiNombre();

		InstanciaDeObjeto obj = new InstanciaDeObjeto();
		obj.imprimirMiNombre();

	}

}

class InstanciaDeClase {

	private static String miNombre = "Jose";

	public static String getMiNombre() {
		return miNombre;
	}

	public static void setMiNombre(String miNombre) {
		InstanciaDeClase.miNombre = miNombre;
	}

	public static void imprimirMiNombre() {
		System.out.println(InstanciaDeClase.getMiNombre());
	}

}

class InstanciaDeObjeto {

	private String miNombre = "Pepe";

	InstanciaDeObjeto() {
		this.miNombre = InstanciaDeClase.getMiNombre();
	}

	public String getMiNombre() {
		return miNombre;
	}

	public void setMiNombre(String miNombre) {
		this.miNombre = miNombre;
	}

	public void imprimirMiNombre() {
		System.out.println(getMiNombre());
	}

}
