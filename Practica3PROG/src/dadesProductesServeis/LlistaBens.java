package dadesProductesServeis;

import usuaris.Usuaris;

public class LlistaBens {  //Clase feta per Chenxing Chi
	private int nElem;
	private Bens [] llista;
	
	
	/** Constructor de la llista de béns
	 * 
	 * @param tamany és el num de elements que assignem a la llista
	 */
	public LlistaBens (int tamany) {
		nElem=0;
		llista = new Bens[tamany];
	}
	
	/**
	 * Getter de numElements actuals
	 * @return nElem
	 */

	public int getNumElem() {
		return nElem;
	}
	
	public void afegirBe (Bens b) {
		if (nElem>=llista.length) {
			Bens [] llistanova = new Bens [nElem*2];
			for (int i=0; i<nElem; i++)
			{
				llistanova[i]=llista[i];
			}
			llista=llistanova;
		}
		llista[nElem] = b.copia();
		nElem++;
	}
	
	public boolean comprovaBe (String usuari, String nomProd) {
		
		boolean trobat = false;
		
		for (int i=0; !trobat && i <= nElem; i++) {
			if ((llista[i].getNom().equals(nomProd)) && (usuari.equals(llista[i].getUsuari()))) {
				trobat = true;
			}
		}
		return (trobat);
	}	
	
	public boolean comprovaBeSenseUsuari (String usuari, String nomProd) {
		
		boolean trobat = false;
		
		for (int i=0; !trobat && i < nElem; i++) {
			if ((llista[i].getNom().equals(nomProd)) && !(usuari.equals(llista[i].getUsuari()))) {
				trobat = true;
			}
		}
		return (trobat);
	}	
	
	public String comprovaBeSenseUsuariStr (String usuari, String nomProd) {
		
		boolean trobat = false;
		String us = null;
		for (int i=0; !trobat && i < nElem; i++) {
			if ((llista[i].getNom().equals(nomProd)) && !(usuari.equals(llista[i].getUsuari()))) {
				trobat = true;
				us = llista[i].getUsuari();
			}
		}
		return us;
	}
	
	public void eliminaBe (Usuaris usuari, String nomProd) {
		int i=0;
			while (i<nElem) {
				if ((llista[i].getNom().equals(nomProd)) && (usuari.getAlies().equals(llista[i].getUsuari()))) {
					
					for (int j=i; j<nElem-1; j++)
					{
						llista[j]=llista[j+1];
					}
					nElem--;
				}
				else {
					i++;
				}
			}
	}
	
	public LlistaBens llistaBensNoIntercanvia() {
		LlistaBens noInter = new LlistaBens(100);
		for(int i = 0; i < this.nElem; i++) {
			if (llista[i].getDataIntercanvi() == "0") {
				noInter.afegirBe(llista[i]);
			}
		}
		return noInter;
	}
	
	public String toString() {
		String aux;
		aux="Bens => numBens "+nElem;
		for (int j = 0; j < nElem; j++) {
			aux=aux+"\n\n\tBe "+(j+1)+"\t "+llista[j];
		}
		return aux;

	}
	
}
