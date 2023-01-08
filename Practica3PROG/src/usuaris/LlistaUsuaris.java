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
			llista[nElem] = a;
			nElem++;
		}
		
		/* metode per comprovar si l'usuari pertany a la llista
		 * @param aliesUsuar, el nom del usuari que volem comprovar
		 * 
		 */
		public boolean comprovaUsuari (String aliesUsuari) {
			
			boolean trobat = false;
			int i =0;
			
			for ( i=0; !trobat && i <nElem; i++) {
				//cerquem la llista d'usuaris
				if (llista[i].getAlies().equals(aliesUsuari)) {
					//comprovem si l'alies introduït coincideix amb el de la llista
					trobat = true;
					//si coincideix posem el boolea a true i sortim de la llista
				}
			}
			i--;
			//restem 1 a la i perque al ser un for, la ultima instancia suma 1 unitat a la i
			return (trobat);
		}	
		
		/* metode per trobar si un usuari pertany a la llista (Es el mateix que l'anteror pero ara retorna un usuari i no un boolea)
		 * @param aliesUsuari, el nom del usuari que volem comprovar
		 * @return l'usuari que s'ha trobat, no el nom
		 */
		public Usuaris trobaUsuari (String aliesUsuari) {
			
			boolean trobat = false;
			int i=0;
			for (i=0; !trobat && i <= nElem; i++) {
				//cerquem a la llista
				if (llista[i].getAlies().equals(aliesUsuari)) {
					//comprovem si l'alies introduït coincideix amb el de la llista
					trobat = true;
					//si coincideix posem el boolea a true i sortim de la llista

				}
			}
			i--;
			//restem 1 a la i perque al ser un for, la ultima instancia suma 1 unitat a la i
			Usuaris nou = llista[i];
			//posem l'usuari trobat en una variable local per retornar-la
			return nou;
		}	
		

		
		public Usuaris ultimUsuari (int i) {
			
			Usuaris nou=llista[i].copia();
			return nou;
			
		}
		
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
