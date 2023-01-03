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
		
		public void donaAlta (Usuaris a) {
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
		
		
}
