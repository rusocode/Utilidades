package _LABORATORIO;

import java.io.InputStream;

// https://stackoverflow.com/questions/14739550/difference-between-getclass-getclassloader-getresource-and-getclass-getres
public class Recursos {

	/* Un recurso puede ser algo tan simple como un archivo o un directorio, o puede ser una referencia a un objeto mas
	 * complicado, como una consulta a una base de datos o un motor de busqueda. */

	/* La unica diferencia entre el metodo getResource y getResourceAsStream es que el primero devuelve una URL, mientras
	 * que el segundo abre esa URL y devuelve un InputStream. */

	/* Ruta absoluta: se indica toda la ruta del archivo incluyendo el directorio raiz, ej.
	 * C:\carpeta1\carpeta2\archivo1.doc.
	 * 
	 * Ruta relativa: se indica la ruta a partir de donde este en ese momento situada. No se incluye el directorio raiz. Por
	 * ejemplo, si estamos en la ruta C:\carpeta1 y queremos acceder al archivo1 que esta dentro de la carpeta2, seria
	 * carpeta2\archivo1.
	 * 
	 * - StackOverflow (https://stackoverrun.com/es/q/3990978)
	 * 
	 * getClass().getClassLoader().getResource() toma rutas que no comienzan con /, y siempre comienzan en la raiz de la
	 * ruta de clases.
	 * 
	 * getClass().getResource() toma un camino que puede comenzar con /. Si es asi, comienza en la raiz del classpath. De lo
	 * contrario, comienza en el paquete de la clase en la que se llama al metodo.
	 * 
	 * Entonces getClass().getClassLoader().getResource("foo/bar.txt") es quivalente a
	 * getClass().getResource("/foo/bar.txt").
	 * 
	 * Y, asumiendo que getClass() devuelve una clase que esta en el paquete foo, getClass().getResource("bar.txt") es
	 * equivalente a getClass().getClassLoader().getResource("foo/bar.txt"). */

	public static void main(String[] args) {

		InputStream stream;

		/* Desde class, la ruta es relativa (depende) al paquete de la clase a menos que incluya una barra inclinada, por lo que
		 * si no quiere usar el paquete actual, incluya una barra. */
		stream = Recursos.class.getResourceAsStream("/bola.png");
		System.out.println(stream != null);

		/* Desde classLoader(), todas las rutas ya son "absolutas", no hay contexto de los cuales podrian ser relativas. Por lo
		 * tanto, no necesita una barra inclinada. */
		stream = Recursos.class.getClassLoader().getResourceAsStream("bola.png");
		System.out.println(stream != null);

	}

	// Estos dos metodos ubican el recurso de manera diferente
	/* La ruta se interpreta como una ruta local al paquete de la clase desde la que lo esta llamando. Si su ruta comienza
	 * con /, entonces se considerara una ruta absoluta y comenzara a buscar desde la raiz de la ruta de clases. */
	// InputStream clase1 = Recursos.class.getResourceAsStream("");
	/* Considerara todos los caminos como caminos absolutos. */
	// InputStream clase2 = classLoader.getResourceAsStream("");
	/* Cada vez que menciono una ubicacion en esta publicacion, podria ser una ubicacion en su propio sistema de archivos, o
	 * dentro del archivo jar correspondiente, dependiendo de la clase y / o ClassLoader desde donde esta cargando el
	 * recurso. */

}
