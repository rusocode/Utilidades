package colecciones;

/**
 * La interfaz Map asocia claves a valores. Esta interfaz no puede contener claves duplicadas y; cada una de dichas
 * claves, solo puede tener asociado un valor como maximo.
 * 
 * Dentro de la interfaz Map existen varios tipos de implementaciones realizadas dentro de la plataforma Java. Vamos a
 * analizar cada una de ellas: HashMap, TreeMap y LinkedHashMap.
 * 
 * Ninguna de estas implementaciones son sincronizadas; es decir, no se garantiza el estado del Map si dos o mas hilos
 * acceden de forma concurrente al mismo. Esto se puede solucionar empleando una serie de metodos que actuan de wrapper
 * para dotar a estas colecciones de esta falta de sincronizacion:
 * 
 * Map map = Collections.synchronizedMap(new HashMap());
 * SortedMap mortedMap = Collections.synchronizedSortedMap(new TreeMap());
 * Map map = Collections.synchronizedMap(new LinkedHashMap());
 * 
 * El cuando usar una implementacion u otra de Map variara en funcion de la situacion en la que nos encontremos.
 * Generalmente, HashMap sera la implementacion que usemos en la mayoria de situaciones. HashMap es la implementacion
 * con mejor rendimiento (como se ha podido comprobar en el analisis de Set), pero en algunas ocasiones podemos decidir
 * renunciar a este rendimiento a favor de cierta funcionalidad como la ordenacion de sus elementos.
 */

public class Map_ {

}
