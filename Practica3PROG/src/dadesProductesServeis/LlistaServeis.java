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

}
