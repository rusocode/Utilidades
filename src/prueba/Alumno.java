package prueba;

// Planilla para crear objetos ilimitados
// Molde = Clase / Masa = Propiedades / Galleta = Objeto 
public class Alumno extends Persona implements Colegio {

	// Atributos adicionales
	private static int idClase; /* Un atributo estatico permanece en un mismo estado y no experimenta cambios, por lo tanto
								 * todos los objetos comparten la misma variable. */
	private int idObjeto;
	private int nota1;
	private int nota2;
	private String materia;

	public Alumno(String nombre, String genero) {
		super(nombre, genero);
		idObjeto = ++idClase;
	}

	// Sobrecarga de constructor
	public Alumno(String nombre, String genero, String materia, int nota1, int nota2) {
		super(nombre, genero);
		idObjeto = ++idClase;
		this.materia = materia;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	private double getPromedio() {
		return (double) (nota1 + nota2) / 2;
	}

	public void mostrarDatos() {
		System.out.println("ID: " + this.idObjeto + " - Nombre: " + this.getNombre() + " - Genero: " + this
				.getGenero() + " - Materia: " + this.getMateria() + " - Promedio: " + this.getPromedio());
	}

	@Override
	public String mostrarColegio(String colegio) {
		return this.getNombre() + " es del colegio: " + colegio;
	}

}
