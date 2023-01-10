package peticions;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class LlistaPeticions { //Clase realitzada per Pol Regy
	private int nElem;
	private Peticions[] llista;
	
	
	/** Constructor de la llista de peticions
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public LlistaPeticions (int n) {
		nElem = 0;
		llista = new Peticions [n];
	}
	
	 /** getter
	  * 
	  * @return el nombre d'elements de la llista
	  */
	public int getNElem() {
		return(nElem);
	}
	
	/**
	 * 
	 * @param p
	 */
	public void afegirPeticio (Peticions p) {
		if (nElem>=llista.length) {
			Peticions [] llistanova = new Peticions[nElem*2];
			for (int i=0; i<nElem; i++)
			{
				llistanova[i]=llista[i];
			}
			llista=llistanova;
		}
		llista[nElem] = p.copia();
		nElem++;
	}

	
	/* Metode que agafa la llista i retorna la peticio en una posicio concreta de la llista
	 * @param i, l'index de la llista
	 * @return la peticio en aquella posicio de la llista
	 */
	
	public Peticions agafarPeticio (int i) {
		return (llista[i].copia());
	}
	
	/**
	 * Metode que retorna una llista amb totes les instancies de peticions no respostes
	 * @return llistaNova Peticions no respostes
	 */
	public LlistaPeticions mostrarPetNoRespostes () {	
		LlistaPeticions llistaPet = new LlistaPeticions (100);
		for (int i=0; i < nElem; i++) {
			if (llista[i].getResposat() == 0) {
				llistaPet.afegirPeticio(llista[i]);
			}
		}
		return llistaPet;
	}
	


	public void mostrarPetAccept () {		
		for (int i=0; i < llista.length; i++) {
			if (llista[i].getResposat() == 1) {
				llista[i].toString();
			}
		}
	}
	
	public void mostrarPetRefus () {		
		for (int i=0; i < llista.length; i++) {
			if (llista[i].getResposat() == 2) {
				llista[i].toString();
			}
		}
	}

	/* Metode per acceptar una peticio. Canvia l'atribut resposat a 1 
	 * @param i, index de la llista
	 */
	public void acceptarPet (int i) {
		llista[i].setResposat(1);
	}
	
	/* Metode per refusar una peticio. Canvia l'atribut resposat a 2 
	 * @param i, index de la llista
	 */
	public void refusarPet (int i) {
		llista[i].setResposat(2);
	}
	
	/**
	 * Retorna el nElem de la llista+1. Serveis per generar id peticions
	 * @return id peticio
	 */
	public int idSeguentPeticio() {
		int ultimaId;
		ultimaId = nElem+1;
		return ultimaId;
	}
	
	/* Metode per posar valoracio a la peticio. Canvia l'atribut valoracioUserRebPet a v que es un parametre
	 * @param i, l'index de la llista 
	 * @param v, el valor de la valoracio de la peticio
	 */

	public void posarValoracioPet (int i, int v) {
		llista[i].setValoracioUserRebPet(v);
	}
	
	/* Metode que retorna el nom del usuari que rep la peticio
	 * @param i, l'index de la llista
	 * @return el nom del usuari que rep la petició
	 */
	public String comprovarUsuariRepPet (int i) {
		return (llista[i].getUserRebPet());
	}
	
	/* Metode per comprovar la posicio a la llista de la peticio passada per parametre
	 * @param p, la peticio per comprovar a quina posicio de la llista esta
	 * @return la posicio de la llista on es trba la peticio passada per parametre
	 */
	public int comprovarPosicio (Peticions p) {
		int i = 0;
		boolean trobat = false;
		
		for(i = 0; i < nElem && !trobat; i++) {
			//fem una cerca per trobar la peticio passada
			if (llista[i].getIdPeticio() == p.getIdPeticio()) {
				//comprovem si coincideix la peticio de la llista amb la peticio passada per parametre
				trobat = true;
				//si coincideix posem el boolea a true
			}
		}
		i--;
		//restem 1 unitat al index perque al ser un for es suma 1 unitat a la i al trobar la peticio
		return i;
	}
	
	public void escriureLlistaPeticions() {
		try (BufferedWriter g = new BufferedWriter(new FileWriter("dadesPeticions.txt"))) {
			String frase = "";
			int i = 0;

			for(i = 0; i < nElem; i++) {
				frase = llista[i].getIdPeticio()+";"+llista[i].getUserPeticio()+";"+llista[i].getUserRebPet()+";"+llista[i].getProducAcons()+";"+llista[i].getProducOfe();
				g.write(frase);
				g.newLine();
			}
			g.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("L'arxiu d'entrada no existeix");
		}
		catch(IOException e) {
			System.out.println("S'ha produit un error en els arxius");
		}
	}
	
	public String toString() {
		String aux;
		aux="Peticions => numPeticions "+nElem;
		for (int j = 0; j < nElem; j++) {
			aux=aux+"\n\tPeticion "+(j+1)+"\t "+llista[j];
		}
		return aux;
	}
}

