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
import peticions.Peticions;
import usuaris.LlistaUsuaris;
//import fitxers.LlistaUsuaris;
import usuaris.Usuaris;
import usuaris.LlistaUsuaris;

public class Main {
	static Scanner teclat = new Scanner(System.in);
	
	public static void iniciasessio(LlistaUsuaris llista) {
		System.out.println("Benvingut/da a l'aplicacio");
		System.out.println("\n\nTria una opcio: ");
		System.out.println("\n\t1. Iniciar sessio");
		System.out.println("\t2. Continuar com a convidat");
		System.out.println("\t3. Sortir de l'aplicacio");
		
		int opcioini = Integer.parseInt(teclat.nextLine());
		
		if (opcioini == 1) {
			System.out.println("Introdueix el teu alies");
			String codiUsuari = teclat.nextLine();
			llista.comprovaUsuari(codiUsuari);
		}
		else {
			if (opcioini == 2) {
				System.out.print("Has triat continuar com a convidat");
				System.out.print("Recorda que per afegir nous intercanvis o acceptar-los, has d'iniciar sessio o be registrar-te");
			}
			else {
				System.out.println("Has sortit de l'aplicacio, Adeu!");
			}
		}
	}
	
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
	
	public static void opcio2 (LlistaPeticions llistaPet, LlistaServeis llistaServ, LlistaBens llistaBe, LlistaUsuaris llistaUser) {
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
				//NO ES FA LLISTA PRODUCTES
				break;
			case 2:
				System.out.println(llistaPet);
				break;
			case 3:
				System.out.println(llistaServ);
				break;
			case 4:
				System.out.println(llistaBe);
				break;
			case 5:
				System.out.println(llistaUser);
				break;
			}
		}
	}
	
	public static void opcio3 (LlistaServeis llistaServ) {
		llistaServ.mostrarLlistaServ();
	}
	
	public static void opcio4 (LlistaBens llistaBe) {
		System.out.println (llistaBe);
	}
	
	public static void opcio5(LlistaServeis llistaServ) {
		
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
		
		llistaServ.afegirServei(s);
		
		//FALTA AFEGIR AL FITXER DE TEXT EL NOU SERVEI
	}
	
	public static void opcio6(LlistaBens llistaBe) {
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
		
		llistaBe.afegirBe(b);
		
		//FALTA AFEGIR AL FITXER DE TEXT EL NOU BE
	}
	
	public static void opcio7(LlistaPeticions llistaPet) {
		
		System.out.println ("Introdueix els següents camps: ");
		
		//la identificacio s'ha de generar automaticament
		
		//l'usuari que fa la peticio s'ha de ficar l'alies del usuari que te inicciada la sessio
		
		//l'usuari que rep la peticio s'ha de ficar en relacio amb la oferta
		
		System.out.println ("Indica el nom del producte que vols aconseguir");
		String prodAcon = teclat.nextLine();
		System.out.println ("Indica el nom del producte que ofereixes");
		String prodOfer = teclat.nextLine();
		
		//Peticions p1 = new Peticions (id, userPet, userRep, prodAcon, prodOfer);

	}
	
	public static void opcio8(Peticions p) {
		
		System.out.println("Vols acceptar la peticio d'intercanvi?");
		System.out.println("1 Acceptar");
		System.out.println("2 Refusar");
		
		int opcioAccept = Integer.parseInt(teclat.nextLine());
		
		if (opcioAccept == 1) {
			System.out.println("Has acceptat la peticio");
			p.setResposat(1);
			System.out.println("Introdueix la valoracio de l'oferta");
			int valoracioRep = Integer.parseInt(teclat.nextLine());
			p.setValoracioUserRebPet(valoracioRep);
		}
		else {
			if (opcioAccept == 2) {
				System.out.println("Has refusat la peticio");
				p.setResposat(2);
			}
			else {
				System.out.println("ERROR, fica el numero 1 o 2");
			}
		}
	}
	
	public static void opcio9(LlistaUsuaris llistaUser) {
			
		System.out.println ("Introdueix els següents camps: ");
			
		System.out.println ("Usuari:");
		String nom = teclat.nextLine();
			
		System.out.println ("Correu del usuari: ");
		String correu = teclat.nextLine();
		
		System.out.println ("Codi postal del usuari");
		String cPost = teclat.nextLine();
		int codiPost = Integer.parseInt(cPost);
		
		Usuaris u1 = new Usuaris(nom, correu, codiPost);
		
		llistaUser.donaAlta(u1);
		
	    try (FileOutputStream fos = new FileOutputStream("serialized_object.bin, true")) {         
	    	try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	            oos.writeObject(u1);
	        }
	    }
	  	catch (IOException e) {
	  		System.out.println ("no");
	    }
	}
	
	public static void opcio10(LlistaServeis llistaServ) {
		System.out.println("Indica el nom del servei que vols desactivar");
		String nomServei = teclat.nextLine();
		
		llistaServ.donaBaixaServei(nomServei);	
	}
	
	public static void opcio12(LlistaPeticions llistaPet) {
		
		llistaPet.mostrarPetNoRespostes();
	}
	
	public static void opcio13(LlistaPeticions llistaPet) {
		
		llistaPet.mostrarPetAccept();
	}
	
	public static void opcio14(LlistaPeticions llistaPet) {
		
		llistaPet.mostrarPetRefus();
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
		LlistaBens llistaBe = new LlistaBens(30);
		LlistaServeis llistaServ = new LlistaServeis(30);
		LlistaUsuaris llistaUser = new LlistaUsuaris(30);
		LlistaPeticions llistaPet = new LlistaPeticions(30);
		int opcio=0;
		
		mostrarMenu();
		//Bens a = new Bens ("sabata", "cosa que es fica al peu", "roba", true, "30-12-2022", 12, 23, 45, 2, "3-1-2023"); 
		//prova per veure si funciona la instancia
		//int opcio = Integer.parseInt(teclat.nextLine());
		while (opcio != 17) {
			opcio = Integer.parseInt(teclat.nextLine());
			switch (opcio) {
			case 1: 
				//opcio1();
				break;
			case 2:
				opcio2(llistaPet, llistaServ, llistaBe, llistaUser);
				break;
			case 3:
				opcio3(llistaServ);
				break;
			case 4:
				opcio4(llistaBe);
				break;
			case 5:
				opcio5(llistaServ);
				break;
			case 6:
				//opcio6();
				break;
			case 7:
				//opcio7();
				break;
			case 8:
				//opcio8();
				break;
			case 9:
				//opcio9();
				break;
			case 10:
				//opcio10();
				break;
			case 11:
				//opcio11();
				break;
			case 12:
				opcio12(llistaPet);
				break;
			case 13:
				opcio13(llistaPet);
				break;
			case 14:
				opcio14(llistaPet);
				break;
			case 15:
				//opcio15();
				break;
			case 16:
				//opcio16();
				break;
			}
			mostrarMenu();
		}
		System.out.println("Has sortit de l'aplicacio, adeu!");
		//altaUsuari();
		//llegirFitxerSerial();*/
	}
}
