package registro.modelo;

import java.util.ArrayList;
import java.util.List;

import registro.objetos.Cliente;

public interface Constantes {

	// Campos
	byte LETRAS = 1; // Da igual si utilizas el modificador "public static final" de la constante o no, porque se dan por supuestos
	byte NUMEROS = 2;

	// Botones
	byte BTN_AGREGAR = 1;
	byte BTN_BUSCAR = 2;
	byte BTN_MODIFICAR = 3;

	// Limites de caracteres
	short LIMITE_CAMPO_ID = 3;
	short LIMITE_CAMPO_NOMBRE = 20;
	short LIMITE_CAMPO_APELLIDO = 30;
	short LIMITE_CAMPO_DNI = 8;

	/* Que tipo de coleccion voy a usar si: 1. No quiero que se repitan clientes (identificador: id) 2. Lectura y escritura
	 * de clientes
	 * 
	 * Coleccion: List
	 * 
	 * List es una interface que admite parametros de tipo genericos (<E>) */

	// Solo lectura
	// public static Set<Cliente> clientes = new HashSet<Cliente>();

	/* Hemos de destacar que la implementacion de ArrayList no esta sincronizada, es decir, si multiples hilos acceden a un
	 * mismo ArrayList concurrentemente podriamos tener problemas en la consistencia de los datos. Por lo tanto, deberemos
	 * tener en cuenta cuando usemos este tipo de datos que debemos controlar la concurrencia de acceso. Tambien podemos
	 * hacer que sea sincronizado como veremos mas adelante. */

	// Coleccion de tipo ArrayList
	List<Cliente> CLIENTES = new ArrayList<>();

}
