package herencia.basico.vehiculo;

public class Main {

	public static void main(String[] args) {

		Auto auto1 = new Auto("Ford", "Fiesta 2015", "Blanco", 1500.50);
		auto1.datosAuto();
		auto1.acelerar();

		Moto moto1 = new Moto("Yamaha");
		System.out
				.println(moto1.marca + " " + moto1.modelo + " tiene " + moto1.ruedas + " ruedas y pesa " + moto1.peso + " kg.");
		moto1.acelerar();
		moto1.frenar();
		moto1.hacerWheelie();

	}

}
