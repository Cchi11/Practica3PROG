package aplicacio;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Exceptions.NoEsTrobaException;
import Exceptions.NumeroForaRangException;
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
	
	public static Usuaris iniciasessio(LlistaUsuaris llista) {
		Usuaris nou = new Usuaris();
		System.out.println("Benvingut/da a l'aplicacio");
		System.out.println("\n\nTria una opcio: ");
		System.out.println("\n\t1. Iniciar sessio");
		System.out.println("\t2. Registra't si no tens compte");
		System.out.println("\t3. Sortir de l'aplicacio");
		int opcioini=0;
		boolean error = false;
		while (!error)
		{
			try
			{
				String llegirnum = teclat.nextLine();
				opcioini = Integer.parseInt(llegirnum);
				if (opcioini<1 || opcioini>3)
				{
					throw new NumeroForaRangException();
				}
				error=true;
				
			}
			catch (NumberFormatException e) {
				System.out.println("Indica un numero! No un altre caracter!");
				error=false;
			}
			catch (NumeroForaRangException e) {
				System.out.println("Introdueix una opció valida dintre del rang!!");
				error=false;
			}
		}
		error =false;
		
		if (opcioini == 1) {
			System.out.println("Introdueix el teu alies");
			while (!error) {
				try {
						String codiUsuari = teclat.nextLine();
						if(llista.comprovaUsuari(codiUsuari)) 
						{
							nou=llista.trobaUsuari(codiUsuari);
						}
						else
						{
							throw new NoEsTrobaException("No s'ha pogut trobat aquest usuari. Intenta un altre cop");
						}
					error=true;
				}
				catch (NullPointerException e) {
					System.out.println("No s'ha pogut trobar aquest usuari. Intenta un altre cop:");
					error=false;
				}
				catch (NoEsTrobaException e) {
					System.out.println("No s'ha pogut trobat aquest usuari. Intenta un altre cop");
					error=false;
					
				}
			}
			
		}
		else {
			if (opcioini == 2) {
				String usuari;
				System.out.print("Indica el teu alies:");
				usuari = teclat.nextLine();

				System.out.println("Indica el teu correu electronic:");
				String correu = teclat.nextLine();
				System.out.println("Indica el teu codi postal");
				error =false;
				int codiP=0;
				while (!error)
				{
					try {
						String codiPostal = teclat.nextLine();
						codiP = Integer.parseInt(codiPostal);
						error=true;
					}
					catch (NumberFormatException e)
					{
						System.out.println("Indica un codi postal correcte! Torna a intentar:");
						error=false;
					}
				}
				
				Usuaris newUsuari = new Usuaris (usuari, correu, codiP);
				nou=newUsuari;
				llista.donaAlta(nou);
				
			}
			else {
				System.out.println("Has sortit de l'aplicacio, Adeu!");
			}
		}
		return nou;
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
	
	
	public static LlistaServeis carregarServeis () throws FileNotFoundException {
		
		String [] dadesLinea = new String[6];
		LlistaServeis llista = new LlistaServeis(100);
		
		String result;
		
		
		Scanner f = new Scanner(new File("dadesServeis.txt"));
		
		while (f.hasNextLine()) {
			result=f.nextLine();
			dadesLinea = result.split(";");			
			boolean be = Boolean.parseBoolean(dadesLinea[3]); 
			Serveis s = new Serveis (dadesLinea[0], dadesLinea[1], dadesLinea[2], be, dadesLinea[4], dadesLinea[5]);
			llista.afegirServei(s);
		}
		f.close();
		
		return llista;
	}
	
	
	public static LlistaBens carregarBens () throws FileNotFoundException {
			
			String [] dadesLinea = new String[9];
			LlistaBens llista = new LlistaBens(100);
			String result;
			int[] dadesNum = new int[4];
			
			Scanner f = new Scanner(new File("dadesBens.txt"));

			while (f.hasNextLine()) {
				result=f.nextLine();
				dadesLinea = result.split(";");
				boolean be = Boolean.parseBoolean(dadesLinea[3]); 
				
				int k=0;
				for (int j=5; j<dadesLinea.length; j++) {
					dadesNum[k] =Integer.parseInt(dadesLinea[j]);
					k++;
				}
				k=0;
				Bens b = new Bens (dadesLinea[0], dadesLinea[1], dadesLinea[2], be, dadesLinea[4], dadesNum[0], dadesNum[1], dadesNum[2], dadesNum[3]);
				llista.afegirBe(b);;
			}
			f.close();
			
			return llista;
		}
	
	public static LlistaPeticions carregarPeticions () throws FileNotFoundException {
		
		String [] dadesLinea = new String[5];
		LlistaPeticions llista = new LlistaPeticions(100);
		String result;
		Scanner f = new Scanner(new File("dadesPeticions.txt"));
		
		while (f.hasNextLine()) {
			result=f.nextLine();
			dadesLinea = result.split(";");
			Peticions p = new Peticions (dadesLinea[0], dadesLinea[1], dadesLinea[2], dadesLinea[3], dadesLinea[4]);
			llista.afegirPeticio(p);
		}
		
		f.close();
		
		return llista;
	}
	
	public static void opcio1 (LlistaPeticions llistaPet, LlistaServeis llistaServ, LlistaBens llistaBe, LlistaUsuaris llistaUser) throws FileNotFoundException {
		
		System.out.println("Indica quina classe de dades vols carregar");
		System.out.println("\t1. Peticions");
		System.out.println("\t2. Serveis");
		System.out.println("\t3. Bens");
		System.out.println("\t4. Usuaris");
		
		int opcioll=0;
		boolean error = false;
		while (!error)
		{
			try
			{
				String llegirnum = teclat.nextLine();
				opcioll = Integer.parseInt(llegirnum);
				if (opcioll<1 || opcioll>4)
				{
					throw new NumeroForaRangException();
				}
				error=true;
			}
			catch (NumberFormatException e) {
				System.out.println("Indica un numero! No un altre caracter!");
				error=false;
			}
			catch (NumeroForaRangException e) {
				System.out.println("Introdueix una opció valida dintre del rang!!");
				error=false;
			}
		}
		
		switch (opcioll) {
		case 1: 
			carregarPeticions();
			break;
		case 2:
			llistaServ = carregarServeis();
			break;
		case 3:
			carregarBens();
			break;
		case 4:
			
			break;
		}
		
	}
	
	public static void opcio2 (LlistaPeticions llistaPet, LlistaServeis llistaServ, LlistaBens llistaBe, LlistaUsuaris llistaUser) {
		System.out.println("\n\nLlistes del programa:");
		System.out.println("\t1. Llista de peticions");
		System.out.println("\t2. Llista de serveis");
		System.out.println("\t3. Llista de bens");
		System.out.println("\t4. Llista d'usuaris");
		System.out.println("\t5. Cancel·lar");
		System.out.print("\n\t\t\tIndica quina llista vols mostrar: \n");
		int opcioll=0;
		boolean error = false;
		while (!error)
		{
			try
			{
				String llegirnum = teclat.nextLine();
				opcioll = Integer.parseInt(llegirnum);
				if (opcioll<1 || opcioll>5)
				{
					throw new NumeroForaRangException();
				}
				error=true;
			}
			catch (NumberFormatException e) {
				System.out.println("Indica un numero! No un altre caracter!");
				error=false;
			}
			catch (NumeroForaRangException e) {
				System.out.println("Introdueix una opció valida dintre del rang!!");
				error=false;
			}
		}
			switch (opcioll) {
			case 1: 
				System.out.println(llistaPet);
				break;
			case 2:
				//System.out.println(llistaServ.mostrarLlistaServ());
				break;
			case 3:
				System.out.println(llistaBe);
				break;
			case 4:
				System.out.println(llistaUser);
				break;
				
		}
	}
	
	public static void opcio3 (LlistaServeis llistaServ) {
		llistaServ.mostrarLlistaServ();
	}
	
	public static void opcio4 (LlistaBens llistaBe) {
		System.out.println (llistaBe); //no es correcte
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
		
		FileWriter fw = new FileWriter("dadesServeis.txt", true);
		//continuar
		//fw.write(s);
	}
	
	public static void opcio6(LlistaBens llistaBe) {
		
		boolean error = false;
		int amplada=0, alçada=0, fons=0, pes=0;
		
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
		
		while (!error) {
			try {
				String amp = teclat.nextLine();
				amplada = Integer.parseInt(amp);
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println ("Error, a l'amplada has ficat un caracter que no es un numero!");
			}
		}
		error = false;
		
		System.out.println ("Indica l'alçada del producte fisic");
		
		while (!error) {
			try {
				String alç = teclat.nextLine();
				alçada = Integer.parseInt(alç);
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println ("Error, a l'alçada has ficat un caracter que no es un numero!");
			}
		}
		error = false;
		
		System.out.println ("Indica el fons del producte fisic");
		
		while (!error) {
			try {
				String fos = teclat.nextLine();
				fons = Integer.parseInt(fos);
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println ("Error, al fons has ficat un caracter que no es un numero!");
			}
		}
		error = false;
		
		System.out.println ("Indica el pes del producte fisic");
		
		while (!error) {
			try {
				String p = teclat.nextLine();
				pes = Integer.parseInt(p);
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println ("Error, al pes has ficat un caracter que no es un numero!");
			}
		}
		
		System.out.println ("Indica la data d'intercanvi del producte fisic");
		String datainterc = teclat.nextLine();
		
		Bens b = new Bens(nom, desc, tipus, true, datacrea, amplada, alçada, fons, pes);
		
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
	
	public static void opcio8(LlistaPeticions llistaPet, Usuaris user) {
		
		int opcioAccept = 0, i = 0;
		boolean error = false;
		
		System.out.println("Quina peticio vols acceptar/refusar");
		
		
		System.out.println("Vols acceptar la peticio d'intercanvi?");
		System.out.println("1 Acceptar");
		System.out.println("2 Refusar");
		
		while (!error) {
			try {
				opcioAccept = Integer.parseInt(teclat.nextLine());
				if (opcioAccept != 1 || opcioAccept != 2) {
					throw new NumeroForaRangException();
				}
				error= true;
			}
			catch (NumeroForaRangException e) {
				System.out.println("ERROR, el numero sol pot ser 1 o 2");
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, el caracter posat no es un numero");
			}
		}
		if (opcioAccept == 1) {
			System.out.println("Has acceptat la peticio");
			
			llistaPet.acceptarPet(i);
			System.out.println("Introdueix la valoracio de l'oferta");
			int valoracioRep = Integer.parseInt(teclat.nextLine());
			//continuar
			//p.setValoracioUserRebPet(valoracioRep);
			//si s'accepta canviar variable de producte que son el numero de peticions
		}
		else {
				System.out.println("Has refusat la peticio");
				//continuar
				//p.setResposat(2);
		}
	}
	
	public static void opcio9(LlistaUsuaris llistaUser) {
			
		int codiPost = 0;
		boolean error = false;
		
		System.out.println ("Introdueix els següents camps: ");
			
		System.out.println ("Usuari:");
		String nom = teclat.nextLine();
			
		System.out.println ("Correu del usuari: ");
		String correu = teclat.nextLine();
		
		System.out.println ("Codi postal del usuari");
		
		while (!error) {
			try {
				String cPost = teclat.nextLine();
				codiPost = Integer.parseInt(cPost);
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println ("Error, al codi postal has ficat un caracter que no es un numero!");
			}
		}
		error = false;
		
		Usuaris u1 = new Usuaris(nom, correu, codiPost);
		
		llistaUser.donaAlta(u1);
		
	    try (FileOutputStream fos = new FileOutputStream("serialized_object.bin", true)) {         
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
				
		ObjectInputStream Fit = new ObjectInputStream(new FileInputStream("serialized_object.bin", true));
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
		LlistaBens llistaBe = new LlistaBens(100);
		LlistaServeis llistaServ = new LlistaServeis(100);
		LlistaUsuaris llistaUser = new LlistaUsuaris(100);
		LlistaPeticions llistaPet = new LlistaPeticions(100);
		int opcio=0;
		//Usuaris usuariActual = iniciasessio(llistaUser);
		mostrarMenu();
		while (opcio != 17) {
			opcio = Integer.parseInt(teclat.nextLine());
			switch (opcio) {
			case 1: 
				opcio1(llistaPet, llistaServ, llistaBe, llistaUser);
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
				opcio6(llistaBe);
				break;
			case 7:
				//opcio7();
				break;
			case 8:
				opcio8(llistaPet);
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
