package _LABORATORIO;

import java.util.Date;

public class GC {

	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime(); // Patron Singleton?
		Date d = null;

		System.out.println("--Garbage Collector--");
		/* totalMemory(): El valor devuelto por este metodo puede variar con el tiempo, segun el entorno del host. Tenga en
		 * cuenta que la cantidad de memoria requerida para contener un objeto de cualquier tipo puede depender de la
		 * implementacion. freeMemory(): Devuelve la cantidad de memoria libre en la maquina virtual Java. Llamar al metodo gc
		 * puede aumentar el valor devuelto por freeMemory(). */
		System.out.println("Total de memoria en la JVM: " + run.totalMemory() / 1024 / 1024 + " MB.");
		System.out.println("Total de memoria libre en la JVM: " + run.freeMemory() / 1024 / 1024 + " MB.");

		for (int i = 0; i < 10000; i++)
			d = new Date();

		System.out.println("Se crearon 10000 objetos tipo Date!");

		System.out.println("Memoria libre antes de pasar el recolector de basura: " + run.freeMemory() / 1024 / 1024 + " MB.");
		run.gc();
		System.out.println("Memoria libre despues de pasar el recolector de basura: " + run.freeMemory() / 1024 / 1024 + " MB.");

	}

}
