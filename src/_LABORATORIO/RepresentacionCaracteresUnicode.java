package _LABORATORIO;

/*
 * Representaciones de caracteres Unicode
 * https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#unicode
 * 
 * Para obtener mas informacion sobre la terminologia Unicode, consulte el glosario Unicode
 * https://www.unicode.org/glossary/
 * */
public class RepresentacionCaracteresUnicode {

	public static void main(String[] args) {

		String str = "Estoy quemado";
		String tabulacion = "\ta";

		/* -Clase String - https://docs.oracle.com/javase/8/docs/api/
		 * Una cadena representa una cadena en formato UTF-16 en la que los caracteres suplementarios estan representados por
		 * pares sustitutos (consulte la seccion Representaciones de caracteres Unicode en la clase Caracter para obtener mas
		 * informacion). Los valores de indice se refieren a unidades de codigo de caracteres, por lo que un caracter
		 * complementario utiliza dos posiciones en una cadena (2 bytes?).
		 * 
		 * La clase String proporciona metodos para tratar con puntos de codigo Unicode (es decir, caracteres), ademas de
		 * aquellos para tratar con unidades de codigo Unicode (es decir, valores char).
		 * 
		 * -Metodo indexOf(int ch)
		 * Devuelve el indice dentro de esta cadena de la primera aparicion del caracter especificado. Si aparece un caracter
		 * con valor ch en la secuencia de caracteres representada por este objeto String, se devuelve el indice (en unidades de
		 * codigo Unicode) de la primera aparicion de este tipo.
		 * En cualquier caso, si no aparece tal caracter en esta cadena, se devuelve -1.
		 * 
		 * IMPORTANTE: El punto de codigo Unicode (code point) se especifica con el literal hexadecimal (0x).
		 * Los codigos de caracteres actualizados ASCII estan aca -> https://www.unicode.org/charts/PDF/U0000.pdf */
		System.out.println(str.indexOf(0x6F)); // o
		System.out.println(tabulacion.indexOf(0x09)); // tabulacion
	}

}
