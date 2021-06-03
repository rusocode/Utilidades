package juego.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

// si tenemos una hoja de sprite, es mas facil cargarla, por que vamos a cargar las distintas imagenes de la hoja.   
public class HojaSprites {

	private final int ancho;
	private final int alto;

	public final int[] pixeles;

	public HojaSprites(final String ruta, final int ancho, final int alto) throws IOException {

		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];

		// las lineas arriesgadas siempre ponerlas dentro de un try y catch
		try {
			BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho); // x, y, ancho, alto, array, desplazamiento, tamaño de imagen
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Para tomar el valor de la variable ancho podriamos hacerlo de 2 maneras:
	 * 1. Cambiando el modificador de acceso a public y asi podriamos usarlo
	 * desde cualquier otra clase, pero esto suele ser un mal diseño en java.
	 * 
	 * 2. Normalmente hay que seguir una cosa llamada "encapsulacion", que
	 * significa que todas las variables deben ser privadas y si otra clase
	 * quiere acceder a ella debemos darle unos metodos que se lo permitan.
	 * Estos metodos se llaman getters() y setters().
	 * 
	 * Seguramente pensaremos que tonteria... para que usamos dos metodos si
	 * podriamos acceder directamente a la variable. La gracia es que con el
	 * metodo getAncho() solo podriamos ver cual es el ancho pero no modificarlo
	 * y con el setAncho() solo permite modificarlo. */

	// VEMOS
	public int getAncho() {

		return ancho;
	}

	// MODIFICAMOS
	public void setAncho(int ancho) {

	}
}
