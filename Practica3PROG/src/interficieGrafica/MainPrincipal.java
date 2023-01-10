package interficieGrafica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import dadesProductesServeis.Bens;
import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import dadesProductesServeis.Serveis;
import peticions.LlistaPeticions;
import peticions.Peticions;
import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

public class MainPrincipal {
	
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
		
		while (f.hasNextLine()) {
			cat=f.nextLine();
			lSplited = cat.split(";");
			Boolean b = Boolean.parseBoolean(lSplited[4]);
			Serveis serveis = new Serveis(lSplited[0], lSplited[1], lSplited[2], lSplited[3], b, lSplited[5], lSplited[6]);
			llista.afegirServei(serveis);
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
		
		while (f.hasNextLine()) {
			cat=f.nextLine();
			lSplited = cat.split(";");
			Boolean b = Boolean.parseBoolean(lSplited[3]);
			numInt[0] = Integer.parseInt(lSplited[6]);
			numInt[1] = Integer.parseInt(lSplited[7]);
			numInt[2] = Integer.parseInt(lSplited[8]);
			numInt[3] = Integer.parseInt(lSplited[9]);
			Bens bens = new Bens(lSplited[0], lSplited[1], lSplited[2], lSplited[3], b, lSplited[5], numInt[0], numInt[1], numInt[2], numInt[3]);
			llista.afegirBe(bens);
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
		
		while (f.hasNextLine()) {
			cat=f.nextLine();
			lSplited = cat.split(";");
			int numInt = Integer.parseInt(lSplited[0]);
			Peticions peticions = new Peticions(numInt, lSplited[1], lSplited[2], lSplited[3], lSplited[4]);
			llista.afegirPeticio(peticions);
		}
		f.close();
		
		return llista;
	}
	
	/**
	 * carregar llista de peticions
	 */
	public static LlistaPeticions opcio1Pet () throws FileNotFoundException, IOException {
		return carregarPeticions();
	}
	
	/**
	 * carregar llista de Serveis
	 */
	public static LlistaServeis opcio1Serv () throws FileNotFoundException, IOException {
		return carregarServeis();
	}
	
	/**
	 * carregar llista de Peticions
	 */
	public static LlistaBens opcio1Be () throws FileNotFoundException, IOException {
		return carregarBens();
	}
	
	/**
	 * Procediment que llegeix un fitxer serialitzat i retorna les dades
	 * @return retorna la llista que ha llegit del fitxer
	 */
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
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		LlistaUsuaris llistaUser = new LlistaUsuaris(100);		
		LlistaBens llistaBe = new LlistaBens(100);
		LlistaServeis llistaServ = new LlistaServeis(100);
		LlistaPeticions llistaPet = new LlistaPeticions(100);
		
		Peticions p1 = new Peticions (9, "srgerard", "oscarcabre03", "sabata", "pilota");
		Peticions p2 = new Peticions (10, "chen", "oscarcabre03", "sabata", "polvoro");
		Peticions p3 = new Peticions (11, "oscarcabre", "srgerard", "pilota", "sabata");
		Peticions p4 = new Peticions (12, "chen", "srgerard", "pilota", "polovoro");
		Peticions p5 = new Peticions (13, "chen", "srgerard", "comprar", "polovoro");
		Peticions p6 = new Peticions (14, "chen", "srgerard", "taulas", "polovoro");
		
		p4.setResposat(1);
		p2.setResposat(1);
		p4.setValoracioUserPeticio(5);
		p2.setValoracioUserPeticio(3);
		
		
		p5.setResposat(1);
		p6.setResposat(1);
		p5.setValoracioUserPeticio(0);
		p6.setValoracioUserPeticio(2);
		
		llistaPet = opcio1Pet();
		llistaServ = opcio1Serv();
		llistaBe = opcio1Be();
		llistaUser=carregarUsuaris();
		

		
		MainGrafic finestra = new MainGrafic(llistaUser, llistaBe, llistaServ, llistaPet);
	}

}