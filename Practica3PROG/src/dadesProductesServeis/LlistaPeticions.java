package dadesProductesServeis;

public class LlistaPeticions { //Clase realitzada per Pol Regy
	private int nElem;
	private Peticio[] llista;
	
	
	/** Constructor de la llista de peticions
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public LlistaPeticions (int n) {
		nElem = 0;
		llista = new Peticio [n];
	}
	
	
	 /** getter
	  * 
	  * @return el nombre d'elements de la llista
	  */
	public int getNElem() {
		return(nElem);
	}

}
