package registro.objetos;

public class Cliente {

	private static int idClase;
	private int idObjeto;
	private String nombre;
	private String apellido;
	private int dni;

	public Cliente(String nombre, String apellido, int dni) {

		this.idObjeto = ++idClase;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;

	}

	public int getId() {
		return idObjeto;
	}

	public void setId(int id) {
		this.idObjeto = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

}
