package dadesProductesServeis;

import usuaris.Usuaris;

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
	
	
	public boolean donaBaixaServei (Usuaris usuari, String nomServei)
	{
		boolean trobat=false;
		for (int i=0; i<nElem; i++) {
			if (llista[i].getNom()==nomServei && llista[i].getUsuari().equals(usuari.getAlies()))
			{
				llista[i].setActiu(false);
				trobat=true;
			}		
				
		}
		return trobat;
	}
	
	public  void mostrarLlistaServ () {
		for (int i=0; i<nElem; i++) {
			llista[i].toString();
		}
	}
}
