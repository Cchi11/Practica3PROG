package usuaris;

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
			llista[nElem] = a.copia();
			nElem++;
		}
		
		public boolean comprovaUsuari (String aliesUsuari) {
			
			boolean trobat = false;
			
			for (int i=0; !trobat && i <= llista.length; i++) {
				if (llista[i].getAlies() == aliesUsuari) {
					trobat = true;
				}
			}
			return (trobat);
		}	
}
