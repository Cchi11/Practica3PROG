package peticions;

import dadesProductesServeis.Serveis;

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
	
	public void afegirPeticio (Peticions p) {
		if (nElem>=llista.length) {
			Peticions [] llistanova = new Peticions[nElem*2];
			for (int i=0; i<nElem; i++)
			{
				llistanova[i]=llista[i];
			}
			llista=llistanova;
		}
		llista[nElem] = p;
		nElem++;
	}
	
	public void mostrarPetNoRespostes () {		
		for (int i=0; i < llista.length; i++) {
			if (llista[i].getResposat() == 0) {
				llista[i].toString();
			}
		}
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
	
	public String toString() {
		String aux;
		aux="Peticions => numPeticions "+nElem;
		for (int j = 0; j < nElem; j++) {
			aux=aux+"\n\tPeticion "+(j+1)+"\t "+llista[j];
		}
		return aux;
	}
}
