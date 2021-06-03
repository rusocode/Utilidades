package juego.graficos;

// declaramos la clase como final por que no la vamos a extender de ningun otra
public final class Sprite {

	private final int lado;

	private int x; // x = posicion del sprite, EJ: x(pixel) 0
	private int y; // y = posicion del sprite

	public int[] pixeles;

	private final HojaSprites hoja;

	// lado = tamaño o ancho
	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {

		this.lado = lado; // el ancho o lado del sprite es de 32 pixeles
		this.pixeles = new int[lado * lado]; /* calculo el tamaño del sprite 32 * 32 = que son 1024 pixeles
												 * en donde se recogeran esos 1024 valores de la hoja de sprites
												 * indicando la fila y columna en la que se encuentra el sprite requerido en la hoja */

		// con la linea 23 y 24 tomo las coordenadas de x e y(pixeles)en la hoja de sprite
		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;
		for (int y = 0; y < 10; y++) { // fila
			for (int x = 0; x < 10; x++) { // columna
				// el primer array es el de la posicion del sprite en la hoja
				// el segundo array es de la posicion del pixel del sprite. Este array contiene 102400 pixeles que seria el total de la hoja
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja
						.getAncho()]; /* en el array pixeles[me posiciono en la columna y en la fila multiplicado
										 * por el tamaño del sprite(32), EN RESUMEN: ME POSICIONO EN EL SPRITE DE
										 * LA HOJA]. En la segunda parte estamos copiando el valor del array de
										 * pixeles de la hoja de sprites al valor del array de pixeles del sprite
										 * individual, osea que estamos trayendo solo el cuadrado que necesitamos.
										 * EJ: si qremos cargar el pixel 34 tendriamos 32 + 2, ya que una columna
										 * vale 32 y los otros 2 sueltos */
			}
		}
	}
}
