package peticions;



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
		llista[nElem] = p.copia();
		nElem++;
	}
	
	public Peticions agafarPeticio (int i) {
		return (llista[i]);
	}
	
	public LlistaPeticions mostrarPetNoRespostes () {	
		LlistaPeticions llistaPet = new LlistaPeticions (100);
		for (int i=0; i < nElem; i++) {
			if (llista[i].getResposat() == 0) {
				llistaPet.afegirPeticio(llista[i]);
			}
		}
		return llistaPet;
	}
	
	/*public LlistaPeticions BuscarOfertesActives () {
		LlistaPeticions llistaNova = new LlistaPeticions (100);
		for (int i = 0; i < nElem ; i++) {
			//if (llista[i].get)
			llistaNova.afegirPeticio(llista[i]);
		}
		return llistaNova;
	}*/
	
	
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

	public void acceptarPet (int i) {
		llista[i].setResposat(1);
	}
	
	public void refusarPet (int i) {
		llista[i].setResposat(2);
	}
	
	public void posarValoracioPet (int i, int v) {
		llista[i].setValoracioUserRebPet(v);
	}
	
	public String comprovarUsuariRepPet (int i) {
		return (llista[i].getUserRebPet());
	}
	
	public int comprovarPosicio (Peticions p) {
		int i = 0;
		boolean trobat = false;
		
		for(i = 0; i < nElem && !trobat; i++) {
			if (llista[i].getIdPeticio() == p.getIdPeticio()) {
				trobat = true;
			}
		}
		i--;
		return i;
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

