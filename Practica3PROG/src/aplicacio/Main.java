package aplicacio;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import dadesProductesServeis.Bens;
import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import dadesProductesServeis.Serveis;
import peticions.LlistaPeticions;
import usuaris.LlistaUsuaris;
//import fitxers.LlistaUsuaris;
import usuaris.Usuaris;

public class Main {
	static Scanner teclat = new Scanner(System.in);
	
	public static void mostrarMenu () {
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Carregar les dades dels fitxers");
		System.out.println("\t2. Llistar les dades de qualsevol llista que tingueu definida");
		System.out.println("\t3. Llistar les ofertes de serveis que estan actives");
		System.out.println("\t4. Llistar els bens o productes fisics que estan disponibles");
		System.out.println("\t5. Afegir una nova oferta de serveis");
		System.out.println("\t6. Afegir un nou be o producte fisic a intercanviar");
		System.out.println("\t7. Afegir una nova peticio d’intercanvi");
		System.out.println("\t8. Acceptar o refusar una peticio d’intercanvi. Si s’accepta, s’ha d’afegir la valoració de les dues parts");
		System.out.println("\t9. Donar d’alta un nou usuari");
		System.out.println("\t10. Donar de baixa un be o producte fisic a intercanviar i eliminar-lo de la llista. Nomes es podra de donar de baixa si encara no s’ha fet cap intercanvi amb ell");
		System.out.println("\t11. Desactivar un servei. Aquest servei ja no estara operatiu pero no l’esborrem de les llistes");
		System.out.println("\t12. Mostrar les peticions d’intercanvi pendents de respondre");
		System.out.println("\t13. Mostrar les peticions d’intercanvi acceptades");
		System.out.println("\t14. Mostrar les peticions d’intercanvi refusades");
		System.out.println("\t15. Mostrar els usuaris que tenen valoracions en els seus intercanvis superiors a un llindar que indiqui l’usuari");
		System.out.println("\t16. Mostrar el servei del qual s’han fet més intercanvis i indicar el numero d’aquests");
		System.out.println("\t17. Sortir de l’aplicacio");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}
	
	public static void opcio2 () {
		System.out.println("\n\nLlistes del programa:");
		System.out.println("\n\t1. Llista de productes");
		System.out.println("\t2. Llista de peticions");
		System.out.println("\t3. Llista de serveis");
		System.out.println("\t4. Llista de bens");
		System.out.println("\t5. Llista d'usuaris");
		System.out.println("\t6. Cancel·lar");
		System.out.print("\n\t\t\tIndica quina llista vols mostrar: \n");
		int opcioll = Integer.parseInt(teclat.nextLine());
		while (opcioll != 6) {
			switch (opcioll) {
			case 1: 
				//llista productes
				break;
			case 2:
				//llista peticions
				break;
			case 3:
				//llista serveis
				break;
			case 4:
				//llista bens
				break;
			case 5:
				//llista usuaris
				break;
			}
		}
	}
	
	public static void opcio5() {
		
		System.out.println ("Introdueix els següents camps: ");
		
		System.out.println ("Indica el nom del servei");
		String nom = teclat.nextLine();
		
		System.out.println ("Indica la descripcio del servei");
		String desc = teclat.nextLine();
		
		System.out.println ("Indica el tipus del servei");
		String tipus = teclat.nextLine();
		
		System.out.println ("Indica la data d'inici del servei");
		String dataini = teclat.nextLine();
		
		System.out.println ("Indica la data de finalitzacio del servei");
		String datafi = teclat.nextLine();
		
		Serveis s = new Serveis(nom, desc, tipus, false, dataini, datafi);
		
		//FALTA AFEGIR A LA LLISTA DE SERVEIS EL NOU SERVEI
		
		//FALTA AFEGIR AL FITXER DE TEXT EL NOU SERVEI
	}
	
	public static void opcio6() {
		System.out.println ("Introdueix els següents camps: ");
		
		System.out.println ("Indica el nom del producte fisic");
		String nom = teclat.nextLine();
		
		System.out.println ("Indica la descripcio del producte fisic");
		String desc = teclat.nextLine();
		
		System.out.println ("Indica el tipus del producte fisic");
		String tipus = teclat.nextLine();
		
		System.out.println ("Indica la data de creacio del producte fisic");
		String datacrea = teclat.nextLine();
		
		System.out.println ("Indica l'amplada del producte fisic");
		String amp = teclat.nextLine();
		int amplada = Integer.parseInt(amp);
		
		System.out.println ("Indica l'alçada del producte fisic");
		String alç = teclat.nextLine();
		int alçada = Integer.parseInt(alç);
		
		System.out.println ("Indica el fons del producte fisic");
		String fon = teclat.nextLine();
		int fons = Integer.parseInt(fon);
		
		System.out.println ("Indica el pes del producte fisic");
		String p = teclat.nextLine();
		int pes = Integer.parseInt(p);
		
		System.out.println ("Indica la data d'intercanvi del producte fisic");
		String datainterc = teclat.nextLine();
		
		Bens b = new Bens(nom, desc, tipus, true, datacrea, amplada, alçada, fons, pes, datainterc);
		
		//FALTA AFEGIR A LA LLISTA DE BENS EL NOU BE
		
		//FALTA AFEGIR AL FITXER DE TEXT EL NOU BE
	}
	
	public static void opcio9() {
			
		System.out.println ("Introdueix els següents camps: ");
			
		System.out.println ("Usuari:");
		String nom = teclat.nextLine();
			
		System.out.println ("Correu del usuari: ");
		String correu = teclat.nextLine();
		
		System.out.println ("Codi postal del usuari");
		String cPost = teclat.nextLine();
		int codiPost = Integer.parseInt(cPost);
		
		Usuaris objectToSerialize = new Usuaris(nom, correu, codiPost);
		
		//FALTA AFEGIR A LA LLISTA D'USUARIS EL NOU USUARI
		
	    try (FileOutputStream fos = new FileOutputStream("serialized_object.bin, true")) {         // Crea un flujo de salida de objetos a partir del flujo de salida de archivos
	    	try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	    		// Escribe la instancia de la clase serializable en el archivo
	            oos.writeObject(objectToSerialize);
	        }
	    }
	  	catch (IOException e) {
	  		System.out.println ("no");
	    }
	}
	
	public static void opcio10() {
		System.out.println("Indica el nom del servei que vols desactivar");
		String nomServei = teclat.nextLine();
		
		//llistaServ.donaBaixaServei(nomServei);
		
		
	}

	public static void llegirFitxerSerial() throws IOException, ClassNotFoundException {
				
		ObjectInputStream Fit = new ObjectInputStream(new FileInputStream("serialized_object.bin"));
		Usuaris instancia;
		boolean ok = false;
		
		while (!ok) {
			try { 
				instancia = (Usuaris) Fit.readObject();
				System.out.println(instancia.toString());
			} catch (EOFException e) {
				ok = true;
			}
		}
		Fit.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		LlistaBens llistabe = new LlistaBens(30);
		LlistaServeis llistaServ = new LlistaServeis(30);
		LlistaUsuaris llistaUser = new LlistaUsuaris(30);
		LlistaPeticions llistaPet = new LlistaPeticions(30);
		
		mostrarMenu();
		//Bens a = new Bens ("sabata", "cosa que es fica al peu", "roba", true, "30-12-2022", 12, 23, 45, 2, "3-1-2023"); 
		//prova per veure si funciona la instancia
		int opcio = Integer.parseInt(teclat.nextLine());
		while (opcio != 17) {
			switch (opcio) {
			case 1: 
				//opcio1();
				break;
			case 2:
				opcio2();
				break;
			case 3:
				//opcio3();
				break;
			case 4:
				//opcio4();
				break;
			case 5:
				//opcio5()
				break;
			case 6:
				//opcio6()
				break;
			case 7:
				//opcio7()
				break;
			case 8:
				//opcio8()
				break;
			case 9:
				//opcio9()
				break;
			case 10:
				//opcio10()
				break;
			case 11:
				//opcio11()
				break;
			case 12:
				//opcio12()
				break;
			case 13:
				//opcio13()
				break;
			case 14:
				//opcio14()
				break;
			case 15:
				//opcio15()
				break;
			case 16:
				//opcio16()
				break;
			}
		}
		System.out.println("Has sortit de l'aplicacio, adeu!");
		//altaUsuari();
		//llegirFitxerSerial();*/
	}
}
