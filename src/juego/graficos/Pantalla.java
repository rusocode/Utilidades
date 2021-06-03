package juego.graficos;

public final class Pantalla {

	private final int ancho;
	private final int alto;
	public final int[] pixeles;

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		pixeles = new int[ancho * alto];
	}

	public void limpiar() {

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0; // en cada pixel de la pantalla dibujo un pixel negro
		}
	}
	/* Las compensaciones X e Y solo podran tener tres valores: -1, 0 y 1
	 * (dependiendo de en que direccion nos movamos, en el eje horizontal -1 es
	 * izquierda, 1 es derecha y 0 es quieto; en el eje vertical -1 es arriba, 1
	 * es abajo y 0 es quieto). Al sumarle esto a la x e y del bucle, puede
	 * suceder que los valores resultantes se salgan del array de pixeles y
	 * tendriamos una IndexOutOfBoundsException (es decir, intentamos acceder a
	 * un valor del array que no existe). */

	// usamos el metodo mostrar, por que ya dibujamos los sprites con programas externos
	public void mostrar(final int compensacionX, final int compensacionY) {

		for (int y = 0; y < compensacionY; y++) {
			int posicionY = y + compensacionY; // la y es la posicion de la fila
			if (posicionY < 0 || posicionY >= alto) {
				continue; // continue, algo así como "con permiso, gracias"﻿
			} /* Esta sentencia if es por si nos pasamos de los limites del
				 * array, entonces salimos del for para evitar errores.
				 * Simplemente evitamos salir de los limites del mapa, por que
				 * la pantalla se forma desde el 0 hasta el alto de la
				 * pantalla(Y). No podemos dibujar fuera de la pantalla, esto
				 * nos daria un IndexOutOfBoundsException, significa que no
				 * podemos acceder a una posicion del array que no existe. */
			for (int x = 0; x < compensacionX; x++) { // x es la posicion de la columna
				int posicionX = x + compensacionX;
				if (posicionX < 0 || posicionX >= ancho) {
					continue;
				}
				// codigo para redibujar
			}
		}
	}
}