package log;

import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

// Imprime un breve resumen del registro en un formato legible por humanos. El resumen suele ser de 1 o 2 lineas. 
public class SimpleFormatter extends Formatter {

	// Formato para la fecha del registro
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ssZ"); // Q funcion cumple la Z?

	// El formateador toma el mensaje sin procesar del registro y lo convierte en cadena
	@Override
	public String format(LogRecord registro) { // De donde viene el registro? Del controlador?

		StringBuffer sb = new StringBuffer(1000); // Reemplazar por StringBuilder?

		sb.append(registro.getLevel() + ";");

		// Formatea la fecha del registro en "yyyy/MM/dd-HH:mm:ssZ"
		sb.append(sdf.format(registro.getMillis()) + ";");

		// Obtiene el nombre de la clase que (supuestamente) emitio la solicitud de registro
		sb.append(registro.getSourceClassName() + ";");

		// Obtenga el nombre del metodo que (supuestamente) emitio la solicitud de registro
		sb.append(registro.getSourceMethodName() + ";");

		// Devuelve un mensaje localizado y formateado
		sb.append(formatMessage(registro) + "\n");

		// Devuelve la cadena completa formateada
		return sb.toString();

	}

}
