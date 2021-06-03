package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

	/* Crea el registrador con el nombre especificado (debe ser un nombre separado por puntos y normalmente debe basarse en
	 * el nombre del paquete).
	 * 
	 * Los mensajes de registro se reenviaran a los objetos Handler registrados, que pueden reenviar los mensajes a una
	 * variedad de destinos, incluidas consolas, archivos, registros del sistema operativo, etc.
	 * 
	 * Despues de pasar esta prueba inicial (barata), el registrador asignara un LogRecord para describir el mensaje de
	 * registro. Luego llamara a un filtro (si esta presente) para hacer una verificacion mas detallada sobre si el registro
	 * debe publicarse. Si eso pasa, publicara LogRecord en sus controladores de salida.
	 * 
	 * El formateo (incluida la localizacion) es responsabilidad del controlador de salida, que normalmente llamara a un
	 * formateador.
	 * 
	 * Tenga en cuenta que no es necesario que el formateo se realice de forma sincronizada. Puede retrasarse hasta que un
	 * LogRecord se escriba realmente en un receptor externo. */
	private static final Logger LOGGER = Logger.getLogger("kit.log"); // o public?

	private static void setupLogger() {

		// Establece el nivel de registro especificando que niveles de mensajes registrara este LOGGER
		LOGGER.setLevel(Level.FINEST); // https://docs.oracle.com/javase/8/docs/api/java/util/logging/Level.html#SEVERE

		/* Un objeto Handler toma los mensajes de registro de un registrador y los exporta. Podria, por ejemplo, escribirlos en
		 * una consola o escribirlos en un archivo, o enviarlos a un servicio de registro de red, o reenviarlos a un registro
		 * del sistema operativo, o lo que sea. Un Handler se puede deshabilitar haciendo un setLevel (Level.OFF) y se puede
		 * volver a habilitar haciendo un setLevel con un nivel apropiado. Las clases de controlador suelen utilizar las
		 * propiedades de LogManager para establecer valores predeterminados para el filtro, el formateador y el nivel del
		 * controlador. */

		/* FileHandler puede escribir en un archivo especifico o puede escribir en un conjunto rotativo de archivos. Para un
		 * conjunto rotatorio de archivos, a medida que cada archivo alcanza un limite de tamaño determinado, se cierra, se gira
		 * y se abre un nuevo archivo. Los archivos sucesivamente mas antiguos se nombran agregando "0", "1", "2", etc. en el
		 * nombre del archivo base. De forma predeterminada, el almacenamiento en buffer esta habilitado en las bibliotecas de
		 * E/S, pero cada registro de registro se elimina cuando se completa.
		 * 
		 * ¿Puede crear directorios la clase FileHandler?
		 * https://stackoverflow.com/questions/22732247/how-to-create-directories-for-logger-files-through-filehandler
		 * 
		 * ¿Esta roto java.util.logging.FileHandler en Java 8?
		 * https://stackoverflow.com/questions/24321098/is-java-util-logging-filehandler-in-java-8-broken/24327826 */

		try {

			/* Crea un fh con un patron, limite de bytes y cantidad de archivos.
			 * Si se especifica un patron inutilizable, entonces se utiliza el patron predeterminado "%h/java%u.log".
			 * %g es el numero de generacion para distinguir entre los registros rotados (0, 1, etc,). */
			FileHandler controlador = new FileHandler("logs/server%g.log", 1000000, 10);
			controlador.setFormatter(new SimpleFormatter()); // Establece el formateador para el controlador

			// Agrega el controlador de registros para que el archivo pueda recibir mensajes del LOGGER
			LOGGER.addHandler(controlador);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void start() {

		setupLogger();

		/* Registra un mensaje de informacion.
		 * Si el registrador esta habilitado actualmente para el nivel de mensaje INFO, el mensaje dado se reenvia a todos los
		 * objetos de controlador de salida registrados. */
		LOGGER.info("Servidor iniciado!"); // Se lo esta pasando al LogRecord?

	}

	public static void chill() {
		LOGGER.log(Level.FINEST, "Esta todo re piola");
	}

	// Crear metodo de fabrica para el LOGGER

	public static void main(String[] args) {
		Log.start();
		Log.chill();
	}

}
