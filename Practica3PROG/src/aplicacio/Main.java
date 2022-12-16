package aplicacio;

import java.util.Scanner;

public class Main {

	static Scanner teclat = new Scanner(System.in);
	//procediment
	public static void altaUsuari() {
		
		System.out.println ("Posa les dades del usuari: ");
		System.out.println ("Nom del usuari");
		String nom = teclat.nextLine();
		System.out.println ("Correu del usuari: ");
		String correu = teclat.nextLine();
		System.out.println ("Codi postal del usuari");
		String cPost = teclat.nextLine();
		System.out.println ("Oferta produida per l'usuari");
		String oferProd = teclat.nextLine();
		System.out.println ("intercanvi del usuari");
		String inter = teclat.nextLine();
		int codiPost = Integer.parseInt(cPost);
	}
	
	public static void main(String[] args) {
		
	}

}
