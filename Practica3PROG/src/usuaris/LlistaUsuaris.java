package usuaris;

import dadesProductesServeis.Serveis;

public class LlistaUsuaris {			//Clase feta per Chenxing Chi
		private int nElem;
		private Usuaris [] llista;
		
		/** Constructor de la llista de Usuaris
		 * 
		 * @param tamany és el num de elements que assignem a la llista
		 */
		public LlistaUsuaris (int tamany) {
			nElem=0;
			llista = new Usuaris[tamany];
		}
		
		/**
		 * Getter de numElements actuals
		 * @return nElem
		 */

		public int getNumElem() {
			return nElem;
		}
		
		/**
		 * Afegeix un usuari nou a la llista
		 * @param a Usuari a afegir
		 */
		public void donaAlta (Usuaris a) {
			//Si la llista esta plena, ferla mes gran
			if (nElem>=llista.length) {
				Usuaris [] llistanova = new Usuaris [nElem*2];
				for (int i=0; i<nElem; i++)
				{
					llistanova[i]=llista[i];
				}
				llista=llistanova;
			}
			llista[nElem] = a.copia();
			nElem++;
		}
		
		public boolean comprovaUsuari (String aliesUsuari) {
			
			boolean trobat = false;
			int i =0;
			
			for ( i=0; !trobat && i <nElem; i++) {
				if (llista[i].getAlies().equals(aliesUsuari)) {
					trobat = true;
				}
			}
			i--;
			return (trobat);
		}	
		
		public Usuaris trobaUsuari (String aliesUsuari) {
			
			boolean trobat = false;
			int i=0;
			for (i=0; !trobat && i <= nElem; i++) {
				if (llista[i].getAlies().equals(aliesUsuari)) {
					trobat = true;
				}
			}
			i--;
			Usuaris nou = llista[i].copia();
			return nou;
		}	
		

		/**
		 * Retorna la copia de lultim usuari de la llista
		 * @param i posicio
		 * @return retorna copia de usuari a partir del index a la llistas
		 */
		public Usuaris ultimUsuari (int i) {
			
			Usuaris nou=llista[i].copia();
			return nou;
			
		}
		/**
		 * retorna lindex de lultim element de la llsita
		 * @return index
		 */
		
		public int retornarIndex () {
			return nElem-1;
		}
		
		
		public String toString() {
			String aux;
			aux="Usuaris => numUsuaris "+nElem;
			for (int j = 0; j < nElem; j++) {
				aux=aux+"\n\tUsuari "+(j+1)+"\t "+llista[j];
			}
			return aux;
		}

}
