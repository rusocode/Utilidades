package prueba;

public class PrueblaAlumno {

	public static void main(String[] args) {
		// int id = 1;
		// String nombre = "juan";
		// int nota1 = 6;
		// int nota2 = 7;
		// double promedio = (double) (nota1 + nota2) / 2;
		//
		// System.out.println("ID: " + id + " - Nombre: " + nombre + " - Promedio: " + promedio);
		//
		// id = 2; // ++id - id++ - id += 1;
		// nombre = "jose"; // String nombre2 = "jose";
		// nota1 = 5;
		// nota2 = 6;
		// promedio = (double) (nota1 + nota2) / 2;
		//
		// System.out.println("ID: " + id + " - Nombre: " + nombre + " - Promedio: " + promedio);

		// // Creo un objeto de tipo Alumno sin argumentos
		// Alumno juan = new Alumno("juan", "H");
		// // Le paso los valores
		// // juan.setIdObjeto(1); // ERROR LOGICO!
		// // juan.setNombre("juan");
		// juan.setNota1(5);
		// juan.setNota2(6);
		// // Muestro el objeto creado en consola
		// juan.mostrarDatos();
		//
		// Alumno mica = new Alumno("mica", "M");
		// // jose.setNombre("mica");
		// mica.setNota1(8);;
		// mica.setNota2(10);
		// mica.mostrarDatos();
		//
		// Alumno desconocido = new Alumno(null, null);
		// // Muestra los datos por defecto
		// desconocido.mostrarDatos();
		//
		// Alumno diego = new Alumno("diego", "H");
		// // diego.setNombre("diego");
		// diego.setNota1(1);
		// diego.setNota2(2);
		// System.out.println("ID: " + diego.getId() + " - Nombre: " + diego.getNombre() + " - Promedio: " + diego
		// .getPromedio());
		//
		// Alumno franco = new Alumno("franco", "H", 3, 8);
		// franco.mostrarDatos();

		Alumno[] alumnos = new Alumno[3];
		
		// EN ESE MOMENTO SE ALMACENO: "fede", "H", "Matematicas", 4 y 6 en la posicion [0] del array de tipo Alumno
		alumnos[0] = new Alumno("fede", "H", "Matematicas", 4, 6);
		alumnos[1] = new Alumno("sofi", "M", "Fisica", 4, 2);

		// Pasando valores por setters
		alumnos[2] = new Alumno("juan", "H");
		alumnos[2].setMateria("Programacion");
		alumnos[2].setNota1(10);
		alumnos[2].setNota2(10);

		System.out.println(alumnos[2].mostrarColegio("IESS"));

		for (int i = 0; i < alumnos.length; i++)
			alumnos[i].mostrarDatos();

		// for (Alumno a : alumnos)
		// a.mostrarDatos();

	}

}
