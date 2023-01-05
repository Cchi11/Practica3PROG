package dadesProductesServeis;

public class LlistaServeis {   //Clase feta per Chenxing Chi
	private int nElem;
	private Serveis[] llista;
		
		
	/** Constructor de la llista de peticions
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public LlistaServeis (int n) {
		nElem = 0;
		llista = new Serveis[n];
	}
			
	 /** getter
	  * 
	  * @return el nombre d'elements de la llista
	  */
	public int getNElem() {
		return(nElem);
	}
		
	public void afegirServei (Serveis s) {
		if (nElem>=llista.length) {
			Serveis [] llistanova = new Serveis [nElem*2];
			for (int i=0; i<nElem; i++)
			{
				llistanova[i]=llista[i];
			}
			llista=llistanova;
		}
		llista[nElem] = s;
		nElem++;
	}
	
	public void donaBaixaServei (String nomServei)
	{
		for (int i=0; i<nElem; i++) {
			if (llista[i].getNom()==nomServei)
			{
				llista[i].setActiu(false);
			}
		}
	}
	
	public String toString() {
		String aux;
		aux="Serveis => numServeis "+nElem;
		for (int j = 0; j < nElem; j++) {
			aux=aux+"\n\tServei "+(j+1)+"\t "+llista[j];
		}
		return aux;
	}
}
