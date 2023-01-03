package dadesProductesServeis;

public class LlistaProductes { //Clase feta per Gerard Altadill
	private int nElem;
	private Producte[] llista;
	
	/** Constructor de la llista de productes
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public LlistaProductes (int n) {
		nElem = 0;
		llista = new Producte [n];
	}
	
	 /** getter
	  * 
	  * @return el nombre d'elements de la llista
	  */
	public int getNElem() {
		return(nElem);
	}
	
	public void afegirProducte(Producte p) {
		nElem++;
		llista[nElem] = p;
	}

}
