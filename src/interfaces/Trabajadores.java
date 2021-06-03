package interfaces;

// En una interfaz solo se pueden crear constantes y metodos abstractos
public interface Trabajadores {

	/* Por defecto, los metodos de una interfaz son todos publicos y abstractos.
	 * Por lo cual, si no utilizamos "public abstract", java sobreentiende que se estan usando igual.
	 * Por convencion, no se suele usar "public abstract" en los metodos de una interfaz. */
	double setBonus(double gratificacion);

	// Da igual si utilizas el modificador "public static final" de la constante o no, porque se dan por supuestos
	double BONUS_BASE = 1500;

}
