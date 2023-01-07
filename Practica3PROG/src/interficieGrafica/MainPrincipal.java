package interficieGrafica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import dadesProductesServeis.Bens;
import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import dadesProductesServeis.Serveis;
import peticions.LlistaPeticions;
import peticions.Peticions;
import usuaris.LlistaUsuaris;

public class MainPrincipal {

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
	
	public static LlistaPeticions carregarPeticions () throws FileNotFoundException, IOException {
		Scanner f = new Scanner(new File("dadesPeticions.txt"));
		LlistaPeticions llista = new LlistaPeticions(100);
		String [] lSplited  = new String[5];;
		String cat;
		
		while (f.hasNextLine()) {
			cat=f.nextLine();
			lSplited = cat.split(";");
			Peticions peticions = new Peticions(lSplited[0], lSplited[1], lSplited[2], lSplited[3], lSplited[4]);
			llista.afegirPeticio(peticions);
		}
		f.close();
		
		return llista;
	}
	
	public static LlistaPeticions opcio1Pet () throws FileNotFoundException, IOException {
		return carregarPeticions();
	}
	
	public static LlistaServeis opcio1Serv () throws FileNotFoundException, IOException {
		return carregarServeis();
	}
	
	public static LlistaBens opcio1Be () throws FileNotFoundException, IOException {
		return carregarBens();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		LlistaUsuaris llistaUser = new LlistaUsuaris(100);		
		LlistaBens llistaBe = new LlistaBens(100);
		LlistaServeis llistaServ = new LlistaServeis(100);
		LlistaPeticions llistaPet = new LlistaPeticions(100);
		int opcio = 0;
		//llistaUser = carregarUsuaris();
		//Usuaris usuariActual = iniciasessio(llistaUser);
		//llistaUser.donaAlta(usuariActual);
		llistaPet = opcio1Pet();
		llistaServ = opcio1Serv();
		llistaBe = opcio1Be();
		
		MainGrafic finestra = new MainGrafic(llistaUser);
		

	}

}
