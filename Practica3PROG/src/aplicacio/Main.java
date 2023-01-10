
package aplicacio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.util.Random;
import java.io.*;
import Exceptions.NoEsTrobaException;
import Exceptions.NumeroForaRangException;
import dadesProductesServeis.Bens;
import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import dadesProductesServeis.Serveis;
//import dadesUsuaris.Usuaris;
import peticions.LlistaPeticions;
import peticions.Peticions;
import usuaris.LlistaUsuaris;
import usuaris.Usuaris;
import usuaris.LlistaUsuaris;

public class Main {
	static Scanner teclat = new Scanner(System.in);
	
	
	/* Procediment per inicia sessio o registrar-se a l'aplicatiu
	 * 
	 * @param llista, la llista d'usuaris
	 * @return el usuari que ha iniciat sessio o be el que s'acaba de registrar
	 */

	public static Usuaris iniciasessio (LlistaUsuaris llista) {
		Usuaris nou = new Usuaris();
		//Creem instancia d'usuari
		System.out.println("Benvingut/da a l'aplicacio");    
		System.out.println("\n\nTria una opcio: ");
		System.out.println("\n\t1. Iniciar sessio");
		System.out.println("\t2. Registra't si no tens compte");

		//mostrem menu d'opcions

		int opcioini = 0;
		boolean error = false;
		while (!error)
		{
			try
			{
				String llegirnum = teclat.nextLine();
				opcioini = Integer.parseInt(llegirnum);
				if (opcioini<1 || opcioini>2)
				{
					throw new NumeroForaRangException();
					//excepcio creada per detectar numeros fora del rang indicat al menu d'opcions
				}
				error=true;
				//si no hi ha excpecio error = true continua amb el codi
				
			}
			//Controlem que no passi l'error de convertir un caracter a int
			catch (NumberFormatException e) {
				//Si no fica un nombre enter
				System.out.println("Indica un numero! No un altre caracter!");
				error=false;
			} 
			catch (NumeroForaRangException e) {
				//si fica un numero fora del rang indicat
				System.out.println("Introdueix una opció valida dintre del rang!!");
				error=false;
			}
		}
		
		error =false;
		
		if (opcioini == 1) {
			//Si l'usuari vol iniciar sessio 
			System.out.println("Introdueix el teu alies");
			while (!error) {
				try {
						String codiUsuari = teclat.nextLine();
						if(llista.comprovaUsuari(codiUsuari)) 
						{
							nou=llista.trobaUsuari(codiUsuari);
							//comprovem que l'usuari que inicia sessio existeix i esta registrat
						}
						else
						{
							throw new NoEsTrobaException("No s'ha pogut trobat aquest usuari. Intenta un altre cop");
							//Creem una excepcio per si hi ha un objecte que no es troba a les llistes
						}
					error=true;
				}
				catch (NullPointerException e) {
					System.out.println("No s'ha pogut trobar aquest usuari. Intenta un altre cop:");
					//si l'usuari no introdueix res
					error=false;
				} //No troba usuari a la llista
				catch (NoEsTrobaException e) {
					System.out.println("No s'ha pogut trobat aquest usuari. Intenta un altre cop");
					//si l'usuari introdueix un usuari no registrat
					error=false;
				}
			}
		}
		else {
			if (opcioini == 2) {
				String usuari = new String();
				error =false;
				while (!error)
				{
					System.out.print("Indica el teu alies:");
					usuari = teclat.nextLine();
					
					if (llista.comprovaUsuari(usuari)) {
						System.out.println("Aquest alies ja existeix!!");
					}
					else {
						error=true;
					}
				}

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
					//Controlem que no passi l'error de convertir un caracter a int
					catch (NumberFormatException e)
					{
						System.out.println("Indica un codi postal correcte! Torna a intentar:");
						//si l'usuari introduix un numero no enter en el codi postal
						error=false;
					}
				}
				
				Usuaris newUsuari = new Usuaris (usuari, correu, codiP);
				//es crea la instancia usuari amb les dades que s'han introduit per teclat
				nou=newUsuari;
				llista.donaAlta(nou);		
				//es crida la funcio donaAlta per afegir-lo a la llista d'usuaris
			}
		//retornem l'usuari recent registrat
		}
		return nou;
	}
	

	/**
	 * Procediment per imprimir per pantall un ventall d'opcions per fer a l'aplicatiu
	 */
	public static void mostrarMenu () {
		//mostrem menu d'opcions per pantalla
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
	/**
	 * Carrga les dades de un ritxer a una llista
	 * @return la llista
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static LlistaServeis carregarServeis () throws FileNotFoundException, IOException {
		Scanner f = new Scanner(new File("dadesServeis.txt")); 	
		LlistaServeis llista = new LlistaServeis(100);			
		String [] lSplited  = new String[7];;				
		String cat;
		
		while (f.hasNextLine()) {	// Mentres el fitxer tingui lines								
			cat=f.nextLine();	//cat te la lina									
			lSplited = cat.split(";");	//Separem							
			Boolean b = Boolean.parseBoolean(lSplited[4]);	//pasem un parametre a bolea	
			// Crem la instancia
			Serveis serveis = new Serveis(lSplited[0], lSplited[1], lSplited[2], lSplited[3], b, lSplited[5], lSplited[6]);
			llista.afegirServei(serveis);	//Afegim a la llista					
		}
		
		f.close();												
		return llista;											
	}
	
	/**
	 * Carrga les dades de un ritxer a una llista
	 * @return la llista
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static LlistaBens carregarBens () throws FileNotFoundException, IOException {
		Scanner f = new Scanner(new File("dadesBens.txt"));		
		LlistaBens llista = new LlistaBens(100);				
		String [] lSplited  = new String[10];;			
		int [] numInt = new int[4]; 
		String cat;
		
		while (f.hasNextLine()) {	// Mentres el fitxer tingui lines								
			cat=f.nextLine();		//cat te la lina							
			lSplited = cat.split(";");			//Separem				
			Boolean b = Boolean.parseBoolean(lSplited[3]);		//pasem un parametre a int
			numInt[0] = Integer.parseInt(lSplited[6]);				
			numInt[1] = Integer.parseInt(lSplited[7]);				
			numInt[2] = Integer.parseInt(lSplited[8]);				
			numInt[3] = Integer.parseInt(lSplited[9]);		
			// Crem la instancia
			Bens bens = new Bens(lSplited[0], lSplited[1], lSplited[2], lSplited[3], b, lSplited[5], numInt[0], numInt[1], numInt[2], numInt[3]);
			llista.afegirBe(bens); //Afegim a la llista									
		}
		f.close();												
		return llista;
	}
	
	/**
	 * Carrga les dades de un ritxer a una llista
	 * @return la llista
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static LlistaPeticions carregarPeticions () throws FileNotFoundException, IOException {
		Scanner f = new Scanner(new File("dadesPeticions.txt"));
		LlistaPeticions llista = new LlistaPeticions(100);
		String [] lSplited  = new String[5];;
		String cat;
		
		while (f.hasNextLine()) {// Mentres el fitxer tingui lines
			cat=f.nextLine();//cat te la lina
			lSplited = cat.split(";");//Separem
			int numInt = Integer.parseInt(lSplited[0]); //pasem un parametre a int
			// Crem la instancia
			Peticions peticions = new Peticions(numInt, lSplited[1], lSplited[2], lSplited[3], lSplited[4]);
			llista.afegirPeticio(peticions); //Afegim a la llista	
		}
		f.close();
		
		return llista;
	}
	



	/**
	 * Opcio 1.1 carregar llista de peticions
	 */

	public static LlistaPeticions opcio1Pet () throws FileNotFoundException, IOException {
		return carregarPeticions();
	}
	
	/**
	 * Opcio 1.2 carregar llista de serveis
	 */
	public static LlistaServeis opcio1Serv () throws FileNotFoundException, IOException {
		return carregarServeis();
	}
	
	/**
	 * Opcio 1.3 carregar llista de bens
	 */

	public static LlistaBens opcio1Be () throws FileNotFoundException, IOException {
		return carregarBens();
	}
	
	/**
	 * Mostra per pantalla llista de usuaris, peticion, serveis, bens 
	 * @param llistaPet  llista de peticions
	 * @param llistaServ llista de serveis
	 * @param llistaBe	llista de bens 
	 * @param llistaUser llista de usuaris
	 */
	public static void opcio2 (LlistaPeticions llistaPet, LlistaServeis llistaServ, LlistaBens llistaBe, LlistaUsuaris llistaUser) {
		int opcioll=0;
		while (opcioll != 6) { // Menu per intracciona amb el usuari
			System.out.println("\n\nLlistes del programa:");
			System.out.println("\t1. Mostra totes le llistes");
			System.out.println("\t2. Llista de peticions");
			System.out.println("\t3. Llista de serveis");
			System.out.println("\t4. Llista de bens");
			System.out.println("\t5. Llista d'usuaris");
			System.out.println("\t6. Sortir");
			System.out.print("\n\t\t\tIndica quina llista vols mostrar: \n");
			boolean error = false;
			while (!error)
			{
				try
				{
					String llegirnum = teclat.nextLine();		//LLegim un numero
					opcioll = Integer.parseInt(llegirnum);		
					if (opcioll<1 || opcioll>6)					// Si no esta dintre de rang salra a la exepcio
					{
						throw new NumeroForaRangException();
					}
					error=true;
				}
				catch (NumberFormatException e) {
					System.out.println("Indica un numero! No un altre caracter!");
					error=false;								// Ho torna fer
				}
				catch (NumeroForaRangException e) {
					System.out.println("Introdueix una opció valida dintre del rang!!");
					error=false;								// Ho torna fer
				}
			}
				switch (opcioll) { //switch que fa les diferentes opcions del menu
				case 1: 
					System.out.println(llistaPet.toString());
					System.out.println(llistaServ.toString());
					System.out.println(llistaBe.toString());
					System.out.println(llistaUser.toString());
					break;
				case 2:
					System.out.println(llistaPet.toString());
					break;
				case 3:
					System.out.println(llistaServ.toString());
					break;
				case 4:
					System.out.println(llistaBe.toString());
					break;
				case 5:
					System.out.println(llistaUser.toString());
					break;
			}
		}
	}
	
	/**
	 * Mostra per pantalla la llista de serveis actius
	 * @param llistaServ llista de serveis
	 */
	public static void opcio3 (LlistaServeis llistaServ) {
		System.out.println(llistaServ.llistaServeisActiu().toString());
	}
	
	/**
	* Mostra per pantalla la llista de bens actius
	* @param llistaBe llista de bens
	*/
	public static void opcio4 (LlistaBens llistaBe) {
		System.out.println(llistaBe.llistaBensNoIntercanvia().toString());
	}
	
	
	/** Procediment que conte la opcio 5 per afegir un nou servei
	 * 
	 * @param actual, es l'usuari que te actualment la sessio iniciada
	 * @param llistaServ, la llista de serveis per afegir el nou servei
	 * @return la llista de serveis on hem afegit la nova instancia
	 */
	public static LlistaServeis opcio5(Usuaris actual, LlistaServeis llistaServ) {
		
		System.out.println ("Introdueix els següents camps: ");
		//es demanen els parametres per teclat
		
		System.out.println ("Indica el nom del servei");
		String nom = teclat.nextLine();
		//l'usuari introdueix el nom del servei
		
		System.out.println ("Indica la descripcio del servei");
		String desc = teclat.nextLine();
		//l'usuari introdueix la descripicio del servei
		
		System.out.println ("Indica el tipus del servei");
		String tipus = teclat.nextLine();
		//l'usuari introdueix el tipus de servei
		
		System.out.println ("Indica la data d'inici del servei");
		String dataini = teclat.nextLine();
		//l'usuari introdueix la data d'inici del servei
		
		System.out.println ("Indica la data de finalitzacio del servei");
		String datafi = teclat.nextLine();
		//l'usuari introdueix la data de finalitzacio del servei
		
		Serveis s = new Serveis(actual.getAlies(), nom, desc, tipus, false, dataini, datafi);
		//es crea una nova instancia serveis amb les dades que s'han introduit per teclat
		
		llistaServ.afegirServei(s);
		//s'afegeix a la llista de serveis
		
		return llistaServ;
	}
	
	/** 
	 * Procediment que conte la opcio 6 per afegir un nou be 
	 * @param alies, l'usuari que te actualment la sessio iniciada
	 * @param llistaBe, la llista de bens per afegir un nou be 
	 * @return la llista de bens amb la nova instancia afegida
	 */
	public static LlistaBens opcio6(Usuaris alies, LlistaBens llistaBe) {
		
		boolean error = false;
		int amplada = 0, alçada = 0, fons = 0, pes = 0;
		//inicialitzem parametres enters
		
		System.out.println ("Introdueix els següents camps: ");
		//demanem per teclat al usuari els atribus del objecte be
		
		System.out.println ("Indica el nom del producte fisic");
		String nom = teclat.nextLine();
		
		System.out.println ("Indica la descripcio del producte fisic");
		String desc = teclat.nextLine();
		
		System.out.println ("Indica el tipus del producte fisic");
		String tipus = teclat.nextLine();
		
		System.out.println ("Indica la data de creacio del producte fisic");
		String datacrea = teclat.nextLine();
		
		System.out.println ("Indica l'amplada del producte fisic");
		//com que aquest es una variable entera, hem de fer un control per que fiqui valors numerics
		
		while (!error) {
			try {
				amplada = Integer.parseInt(teclat.nextLine());
				//demanem per teclat l'amplada del be
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
				//si l'usuari introdueix caracters que no son numeros
			}
		}
		error = false;
		
		System.out.println ("Indica l'alçada del producte fisic");
		
		while (!error) {
			try {
				alçada = Integer.parseInt(teclat.nextLine());
				//demanem per teclat l'alçada del be
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
				//si l'usuari introdueix caracters que no son numeros
			}
		}
		error = false;
		
		System.out.println ("Indica el fons del producte fisic");
		
		while (!error) {
			try {
				fons = Integer.parseInt(teclat.nextLine());
				//demanem per teclat el fons del be
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
				//si l'usuari introdueix caracters que no son numeros
			}
		}
		error = false;
		
		System.out.println ("Indica el pes del producte fisic");
		
		while (!error) {
			try {
				pes = Integer.parseInt(teclat.nextLine());
				//demanem per teclat el pes del be
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
				//si l'usuari introdueix caracters que no son numeros
			}
		}
		
		Bens b = new Bens(alies.getAlies(), nom, desc, tipus, true, datacrea, amplada, alçada, fons, pes);
		//creem la nova instancia del be amb els parametres que l'usuari a introduit per teclat
		
		llistaBe.afegirBe(b);
		//l'afegim a la llista de bens
		
		return(llistaBe);
	}
	
	/* Procediment que conte la opcio 7 que crea una peticio on l'usuari actual es el emisor de la oferta
	 * @param u, que es l'usuari que actualent te iniciada la ssessio
	 * @param llistaPet que conte la llista de peticions per afegir la nova peticio que es creeara en aquest procediment
	 * @param llistaUser que conte la llisat d'usaris per controlar que els productes que s'afegeixen a la peticio es realacionen amb l'usuari
	 * @param llistaBe per controlar que el producte existeixi en el cas de que sigui un be
	 * @param llistaServ per controlar que el servei existeixi en el cas de que sigui un servei
	 * @return la llista de peticions amb la peticio creada en aquest procediment
	 */
	public static LlistaPeticions opcio7(Usuaris u, LlistaPeticions llistaPet, LlistaUsuaris llistaUser, LlistaBens llistaBe, LlistaServeis llistaServ) {
		
		String userRep = null, prodAcon = null, prodOfer = null;
		boolean error = false;
		
		System.out.println ("Introdueix els següents camps: ");
		
		int id = llistaPet.idSeguentPeticio();
		//es crida un procediment per crear una id. aquesta començara per 1 i anira sumant 1 cada cop que es creï una peticio
		
		String userPet = u.getAlies();
		//l'usuari que fa la peticio es l'usuari que te iniciada la sessio
		
		System.out.println ("A quin usuari vols oferir la peticio? (Indica l'alies del usuari)");
		
		while (!error) {
			try {
				userRep = "";
				userRep = teclat.nextLine();
				//l'usuari introdueix a qui vol enviar la peticio
				if (llistaUser.comprovaUsuari(userRep)) {
					//es controla que l'usuari no introdueixi un alies no registrat
					error = true;
				}
				else {
					throw new NoEsTrobaException();
					//en cas de que no es trobi l'usuari a la llista d'usuaris
				}
			}
			catch (NullPointerException e) {
				System.out.println ("No s'ha trobat l'usuari");
				//si l'usuari no introdueix res
			}
			catch (NoEsTrobaException e) {
				System.out.println ("No s'ha trobat l'usuari. Introdueix un usuari registrat");
				//si l'usuari introduiex un alies que no es troba a la llista
			}
		}
		error = false;
		
		System.out.println ("Indica el nom del producte que vols aconseguir");
		//demanem a l'usuari el producte que vol aconseguir 
		
		while (!error) {
			try {
				prodAcon = "";
				prodAcon = teclat.nextLine();
				if (llistaBe.comprovaBe(userRep, prodAcon)) {
					//comprovem si el producte esta afegida a la llista de bens
					//tambe comprovem que el producte que demana es propietat del usuari que ha introduït abans
					error = true;
				}
				else {
					//en cas contrari comprovarem si el producte esta afegit a la llista de serveis
					if (llistaServ.comprovaServei(userRep, prodAcon)) {
						//tambe comprovem que el producte que demana es propietat del usuari que ha introduït abans
						error = true;
					}
					else {
						throw new NoEsTrobaException();
						//si tampoc es troba a la llista, salta la excepcio de que no es troba la llista
					}
				}
			}
			catch (NullPointerException e) {
				System.out.println ("No s'ha trobat el producte");
				//si l'usuari no intodueix res
			}
			catch (NoEsTrobaException e) {
				System.out.println ("No s'ha trobat el producte. Introduieix un producte registrat a l'aplicatiu");
				//si l'usuari introdueix un be o servei que no esta a les llistes
			}
		}
		error = false;
		
		System.out.println ("Indica el nom del producte que ofereixes");
		//demanem a l'usuari el nom del prducte que ofereix 

		while (!error) {
			try {
				prodOfer = "";
				prodOfer = teclat.nextLine();
				if (llistaBe.comprovaBe(u.getAlies(), prodOfer) || llistaServ.comprovaServei(u.getAlies(), prodOfer)) {
					//comprovem si el producte esta afegida a la llista de bens
					//tambe comprovem que el producte que demana es propietat del usuari que actualment te inciada la sessio
					error = true;
				}
				else {

					if (llistaServ.comprovaServei(u.getAlies(), prodOfer)) {
						//en cas contrari comprovarem si el producte esta afegit a la llista de serveis
						//tambe comprovem que el producte que demana es propietat del usuari que actualment te inciada la sessio
						error = true;
					}
					else {
						throw new NoEsTrobaException();
					}
				}
			}
			catch (NullPointerException e) {
				System.out.println ("No s'ha trobat el producte");
				// en cas de que l'usuari no introdueixi res
			}
			catch (NoEsTrobaException e) {
				System.out.println ("No s'ha trobat el producte. Introduieix un producte registrat a l'aplicatiu");
				// en cas de que l'usuari introdueixi algun be o servei que no es trobi a les llistes
			}
		}
		
		System.out.println("La peticio s'ha creat correctament amb codi " + id);
		u.setOfertaProd((u.getOfertaProd())+1);
		//es suma una unitat a l'atribut de l'usuari d'ofertes produides
		
		Peticions p1 = new Peticions (id, userPet, userRep, prodAcon, prodOfer);
		//es crea la instancia de peticio amb els atributs coresponents
		
		llistaPet.afegirPeticio(p1);
		//s'afegeix la nova instancia a la llista de peticions
		
        return llistaPet;
    }
	
	/* Procediment que conte la opcio 8 que dona la opcio a l'usuari d'acceptar o refusar les peticions on l'usuari que actualment te iniciada la sessio es qui rep la peticio
	 * @param u, l'usuari que te actualment la sessio inciciada
	 * @param llistaPet la llista de peticions
	 * @param llistaUser la llista d'usuaris
	 */
	public static void opcio8(Usuaris u, LlistaPeticions llistaPet, LlistaUsuaris llistaUser, LlistaBens llistaBe, LlistaServeis llistaServ) {
			
		int opcioAccept = 0, opcioAccept2 = 0, i = 0;
		boolean error = false;
		LlistaPeticions llistaPetNova = new LlistaPeticions(100);
		//Creem una nova llista per guardar unicament les peticions les quals el usuari que te iniciada la sessio es el receptor de la peticio
		int valoracioRep = 0;

		try {
			for (i = 0; i < llistaPet.getNElem(); i++) {
				if (llistaPet.comprovarUsuariRepPet(i).equals(u.getAlies())) {
					//fem un recorregut per totes les peticions i agafem unicament les que coincideixi que el nom del usuari que te la sessio iniciada sigui el mateix que el nom del receptor de les peticions de la llista
					Peticions peticioAgafa = llistaPet.agafarPeticio(i);
					//cridem la fucio agafarpeticio(i) per agafar l'objecte peticio de la llista
					llistaPetNova.afegirPeticio(peticioAgafa);
					//afegim aquesta peticio que hem agafat a la llista nova per imprimir-la despres
				}
			}
		}
		catch (NullPointerException e){
			System.out.println("No tens peticions per acceptar/refusar");
			//en cas de que no hi hagi res a la llista salta la excepcio
		}
		
		System.out.println ("Aquestes son les peticions que has d'acceptar/refusar");
			
		System.out.println(llistaPetNova.mostrarPetNoRespostes().toString());
		//s'imprimeix la llista nova per mostrar unicament les peticions que ha d'acceptar. 
		//Aquestes peticions estaran numerades per que despres l'usuari pugui dir quina vol acceptar o refusar
			
		System.out.println ("Selecciona quina peticio vols acceptar/refusar");
		
		while(!error) {	
			try {
				opcioAccept = Integer.parseInt(teclat.nextLine());
				//demanem a l'usuari el numero de peticio que vol acceptar/refusar
				if (opcioAccept < 1 || opcioAccept > llistaPetNova.getNElem()) {
					//es crea el rang segons el numero de peticions que hi hagi a la nova llista
					throw new NumeroForaRangException();
				}
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
				//si l'usuari fica un caracter que no sigui un numero
			}
			catch (NumeroForaRangException e) {
				System.out.println("ERROR, has ficat un numero fora del rang indicat");
				//si l'usuari fica un numero fora del rang indicat abans a la llista
			}
		}
		error = false;
			
		System.out.println("Vols acceptar la peticio d'intercanvi?");
		System.out.println("1 Acceptar");
		System.out.println("2 Refusar");
		//demanem a l'usuari si vol acceptar o refusar la peticio
		
		while (!error) {
			try {
				opcioAccept2 = Integer.parseInt(teclat.nextLine());
				if (opcioAccept2 < 1 || opcioAccept2 > 2) {
					//comprovem que l'usuari fiqui 1 o 2 
					throw new NumeroForaRangException ();
				}
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
				//si l'usuari no fica un numero
			}
			catch (NumeroForaRangException e) {
				System.out.println("ERROR, has introduit un numbero que no es ni 1 ni 2!");
				//si l'usuari fica un numero que no sigui 1 o 2
			}
		}
		
		if (opcioAccept2 == 1) {
			//si accepta la peticio
			System.out.println("Has acceptat la peticio");
			Peticions peticioAgafa = llistaPetNova.agafarPeticio(opcioAccept-1);
			//agafem la peticio de la mateixa manera que hem fet abans
			llistaPet.acceptarPet(llistaPet.comprovarPosicio(peticioAgafa));
			//posem el parametre resposat de la peticio a 1 a la llista peticions
			llistaPetNova.acceptarPet(opcioAccept-1);
			//tambe ho fem amb la llista nova que em creat anteriorment
			System.out.println("Introdueix la valoracio de l'oferta");
			
			error = false;
			while (!error) {
				try {
					valoracioRep = Integer.parseInt(teclat.nextLine());
					//demanem a l'usuari la valoracio de la peticio ja que ha acceptat la oferta
					//la guardem a valoracioRep perque ho esta valorant l'usuari que te iniciada la sessio que es qui ha rebut la oferta
					error = true;
				}
				catch (NumberFormatException e) {
					System.out.println("ERROR, has ficat un caracter que no es un numero!!");
					//si l'usuari introdueix un caracter que no es un numero
				}
			}
			
			llistaPet.posarValoracioPet(llistaPet.comprovarPosicio(peticioAgafa), valoracioRep);
			//canviem el parametre valoracioRep de la peticio i el fiquem al numero que ha introduit l'usuari
			u.setIntercanvis((u.getIntercanvis())+1);
			//canviem el parametre de setIntercanvis del usuari i sumem 1 intercanvi
			Usuaris userAltre = llistaUser.trobaUsuari(peticioAgafa.getUserPeticio());
			userAltre.setIntercanvis((userAltre.getIntercanvis())+1);
			
			String dataAvui = "";
			
			if (llistaBe.comprovaBe(u.getAlies(), peticioAgafa.getProducAcons())) {
				Bens beAgafa =  llistaBe.agafarBe (u.getAlies(), peticioAgafa.getProducAcons());
				if (beAgafa.getDataIntercanvi().equals("0")){
					System.out.println ("Introdueix la data d'avui");
					dataAvui = teclat.nextLine();
					llistaBe.canviarDataInter(u.getAlies(), peticioAgafa.getProducAcons(), dataAvui);
					llistaBe.canviarUsuariBe(u.getAlies(), peticioAgafa.getProducAcons(), peticioAgafa.getUserPeticio());
				}
			}
			else {
				if (llistaServ.comprovaServei(u.getAlies(), peticioAgafa.getProducAcons())) {
					llistaServ.canviarUsuariServei(u.getAlies(), peticioAgafa.getProducAcons(), peticioAgafa.getUserPeticio());
				}
			}
			
			if (llistaBe.comprovaBe(peticioAgafa.getUserPeticio(), peticioAgafa.getProducOfe())) {
				Bens beAgafa =  llistaBe.agafarBe (peticioAgafa.getUserPeticio(), peticioAgafa.getProducOfe());
				if (beAgafa.getDataIntercanvi().equals("0")){
					llistaBe.canviarDataInter(peticioAgafa.getUserPeticio(), peticioAgafa.getProducOfe(), dataAvui);
					llistaBe.canviarUsuariBe(peticioAgafa.getUserPeticio(), peticioAgafa.getProducOfe(), u.getAlies());
					
				}
			}
			else {
				if (llistaServ.comprovaServei(peticioAgafa.getUserPeticio(), peticioAgafa.getProducOfe())) {
					llistaServ.canviarUsuariServei(peticioAgafa.getUserPeticio(), peticioAgafa.getProducAcons(), u.getAlies());
				}
			}	
		}
		else {
			//si l'usuari refusa la peticio
			System.out.println("Has refusat la peticio");
			Peticions peticioAgafa = llistaPetNova.agafarPeticio(opcioAccept-1);
			//agafem la peticio de la llista nova i l'editem
			llistaPet.refusarPet(llistaPet.comprovarPosicio(peticioAgafa));
			//canviem el parametre de refusarPet de la peticio i el posem a 2
			llistaPetNova.refusarPet(opcioAccept-1);
			//ho fem tambe amb la peticio de la llista nova creada anteriorment
		}
	}
	
	
	/**
	 * Dona alta a un usuari, pasant per parametre la llistaUsuaris on es guarda
	 * @param llistaUser Llista on es guarden tots els Usuaris
	 */
	public static void opcio9(LlistaUsuaris llistaUser) {
			
		boolean error = false;
		int codiPost = 0;
		
		System.out.println ("Introdueix els següents camps: ");
		String nom = new String();
		//Si introdueix un nom d'usuari que existeix, mostrar missatge d'error i tornar a començar
		
		while (!error)
		{
			try 
			{
				System.out.println ("Usuari:");
				nom = teclat.nextLine();
				
				//Si el nom ja existeix, mostra error
				if (llistaUser.comprovaUsuari(nom)) {
					throw new NoEsTrobaException();
				}
				else
				{
					error=true;
				}
			}
			catch (NoEsTrobaException e) {
				System.out.println("Aquest Alies ja existeix!");
			}
			
		}
		
		//reiniciem la variable
		error=false;
			
		System.out.println ("Correu del usuari: ");
		String correu = teclat.nextLine();
		
		System.out.println ("Codi postal del usuari:");
		
		//Controlar que l'usuari introdueixi una variable enterea i no altres caracters
		
		while (!error) {
			try {
				codiPost = Integer.parseInt(teclat.nextLine());
				error = true;
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
			}
		}
		
		//Si tot va be, crear un nou usuari i afegirlo a la llista;
		Usuaris u1 = new Usuaris(nom, correu, codiPost);
		
		llistaUser.donaAlta(u1);
		
		//Falta Afegir i crear fitxer serialitzat
		
	    /*try (FileOutputStream fos = new FileOutputStream("serialized_object.bin", true)) {         
	    	try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	            oos.writeObject(u1);
	        }
	    }
	  	catch (IOException e) {
	  		System.out.println ("no");
	    }*/
	}
	
	/**
	 * Donar de baixa un bé o producte físic a intercanviar i eliminar-lo de la llista. Només es podrà
	 * de donar de baixa si encara no s’ha fet cap intercanvi amb ell.
	 * @param usuariactual
	 * @param llistaBens
	 */
	public static void opcio10(Usuaris usuariactual, LlistaBens llistaBens) {
		
		System.out.println("Indica quin be vols eliminar de la llista");
		String nom = teclat.nextLine();
		
		try {
			if (!llistaBens.comprovaBeSenseIntercanviat(usuariactual.getAlies(), nom)){
				System.out.println("No s'ha pogut trobat el be que volies eliminar o el bé s'ha intercanviat més d'un cop");
			}
			else {
				llistaBens.eliminaBe(usuariactual, nom);
				System.out.println("S'ha eliminat el be correctament");
				System.out.println (llistaBens.toString());
			}
		}
		catch (NullPointerException e) {
			System.out.println("No hi ha cap producte que es digui " + nom);
		}
	}
		
	/**
	 * Dona de baixa un servei del usuari
	 * @param usuariactual  Usuari actual
	 * @param llistaServ	llistadeServeis
	 */
	public static void opcio11(Usuaris usuariactual, LlistaServeis llistaServ) {
		System.out.println("Indica el nom del servei que vols desactivar");
		String nomServei = teclat.nextLine();

			if (!llistaServ.donaBaixaServei(usuariactual, nomServei)) {
				System.out.println("No s'ha trobat el servei per donar de baixa");
			}
			else
				System.out.println("S'ha donat de baixa correctament el servei");
	}
	
	/**
	 * Mostrar les peticions d’intercanvi pendents de respondre amb un toString de la llista
	 * @param llistaPet Llista amb totes les peticions
	 */
	public static void opcio12(LlistaPeticions llistaPet) {

		System.out.println(llistaPet.mostrarPetNoRespostes().toString());
	}
	
	public static void opcio13(LlistaPeticions mostrarPetAc) {

		System.out.println(mostrarPetAc.mostrarPetAccept().toString());												//////////////AQUIII///////////////////
	}
	
	public static void opcio14(LlistaPeticions mostrarPetRef) {

		System.out.println(mostrarPetRef.mostrarPetRefus().toString());
	}
	
	
	
	public static void opcio15(LlistaUsuaris usuarisVal, LlistaPeticions pet) {
	int numero = 0;
    boolean error = false;
    
		while (!error)
		{
			try
			{
				//printf
				String llegirnum = teclat.nextLine();
				numero = Integer.parseInt(llegirnum);
				if (numero < 0 || numero > 5)
				{
					throw new NumeroForaRangException();
					//excepcio creada per detectar numeros fora del rang indicat al menu d'opcions
				}
				error=true;
				//si no hi ha excpecio error = true continua amb el codi
				
			}
			catch (NumberFormatException e) {
				//Si no fica un nombre enter
				System.out.println("Indica un numero! No un altre caracter!");
				error=false;
			}
			catch (NumeroForaRangException e) {
				//si fica un numero fora del rang indicat
				System.out.println("Introdueix una opció valida dintre del rang!!");
				error=false;
			}
		}
		
		String[]  sobreLlindar = pet.sobreLlindar(numero);
		
		LlistaUsuaris  usuarisLlindar = new LlistaUsuaris (100);
		

		System.out.println(usuarisLlindar.mostrarUsuarisValor(sobreLlindar).toString());
	}
	

	public static void opcio16(LlistaServeis serv) {
		
		Serveis mesRepetit = serv.mesRepeticion();
		System.out.println(mesRepetit.toString());
	}
	
	
	public static LlistaUsuaris carregarUsuaris() {
		LlistaUsuaris llista = new LlistaUsuaris(100);
        try {
            FileInputStream finput = new FileInputStream("dadesUsuaris.ser");
            ObjectInputStream sinput = new ObjectInputStream(finput);
            Usuaris aux;
            while(finput.available() > 0) {
                aux = (Usuaris) sinput.readObject();
                llista.donaAlta(aux);
            }
            finput.close();
            sinput.close();
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer.");
        } catch (IOException e) {
            System.out.println("Error");
        } catch(ClassNotFoundException e) {
            System.out.println("Error en la càrrega de dades.");
        }
        return llista;
    }
	

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		LlistaBens llistaBe = new LlistaBens(100);
		LlistaServeis llistaServ = new LlistaServeis(100);
		LlistaUsuaris llistaUser = new LlistaUsuaris(100);
		LlistaPeticions llistaPet = new LlistaPeticions(100);
		
		
		int opcio=0;
		
		llistaUser = carregarUsuaris();
		
		Usuaris usuari1 = new Usuaris ("chen", "ioqjeoi", 2365);

		llistaUser.donaAlta(usuari1);
		Usuaris usuariActual = iniciasessio(llistaUser);
		
		Usuaris roger = new Usuaris("Roger", "kms", 231);
		llistaUser.donaAlta(roger);
		
		mostrarMenu();
		while (opcio != 17) {
			opcio = Integer.parseInt(teclat.nextLine());
			switch (opcio) {
			case 1: 
				llistaPet = opcio1Pet();
				llistaServ = opcio1Serv();
				llistaBe = opcio1Be();
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
				llistaServ = opcio5(usuariActual, llistaServ);
				break;
			case 6:
				llistaBe = opcio6(usuariActual, llistaBe);
				break;
			case 7:
				llistaPet = opcio7(usuariActual, llistaPet, llistaUser, llistaBe, llistaServ);
				break;
			case 8:
				opcio8(usuariActual, llistaPet, llistaUser, llistaBe, llistaServ);
				break;
			case 9:
				opcio9(llistaUser);
				break;
			case 10:
				opcio10(usuariActual, llistaBe);
				break;
			case 11:
				opcio11(usuariActual, llistaServ);
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
				opcio15(llistaUser, llistaPet);
				break;
			case 16:
				opcio16(llistaServ);
				break;
			}
			mostrarMenu();
		}
		System.out.println("Vols guardar les llistes en un fitxer?!");
		
		boolean error= false;
		
		System.out.println("1 Acceptar");
		System.out.println("2 Refusar");
		
		int opcioAccept2;
		while (!error) {
			try {
				opcioAccept2 = Integer.parseInt(teclat.nextLine());
				if (opcioAccept2 < 1 || opcioAccept2 > 2) {
					throw new NumeroForaRangException ();
				}
				else {
					if(opcioAccept2 == 1) {
						llistaBe.escriureLlistaBens();
						llistaServ.escriureLlistaServeis();
						llistaPet.escriureLlistaPeticions();
						llistaUser.escriureLlistaUsuaris();
						
						System.out.println("S'han carrgat les dades!!");
					}
					else {
						System.out.println("Gracies");
					}
					error = true;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, has ficat un caracter que no es un numero!!");
			}
			catch (NumeroForaRangException e) {
				System.out.println("ERROR, has introduit un numbero que no es ni 1 ni 2!");
			}
		}
		System.out.println("Has sortit de l'aplicacio, adeu!");
	}
}
