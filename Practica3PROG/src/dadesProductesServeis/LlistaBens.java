package dadesProductesServeis;


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
	
	public boolean comprovaBe (String nomProd) {
		
		boolean trobat = false;
		
		for (int i=0; !trobat && i <= llista.length; i++) {
			if (llista[i].getNom() == nomProd) {
				trobat = true;
			}
		}
		return (trobat);
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
			aux=aux+"\n\tBe "+(j+1)+"\t "+llista[j];
		}
		return aux;

	}
	
}
