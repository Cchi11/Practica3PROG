package usuaris;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import dadesProductesServeis.Serveis;
import peticions.LlistaPeticions;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class LlistaUsuaris {			//Clase feta per Oscar Cabre

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
			for (i=0; !trobat && i < nElem; i++) {
				//cerquem a la llista
				if (llista[i].getAlies().equals(aliesUsuari)) {
					//comprovem si l'alies introduït coincideix amb el de la llista
					trobat = true;
					//si coincideix posem el boolea a true i sortim de la llista

				}
			}
			//restem 1 a la i perque al ser un for, la ultima instancia suma 1 unitat a la i
			i--;
			//posem l'usuari trobat en una variable local per retornar-la
			Usuaris nou = llista[i].copia();
			
			return nou;
		}	
		

		/** 
		 * Metode que retorna els usuaris(objecte) que supren el llindar
		 * @param noms usuaris que superen el llindar
		 * @return retorna els usuaris que superen el llindar
		 */
		public LlistaUsuaris mostrarUsuarisValor (String[] usuaris) {	
			LlistaUsuaris usuarisVal = new LlistaUsuaris (100);
			int j;	
	        for (int i=0; i < nElem; i++) {
	        	j=0;
					while (usuaris[i] != llista[j].getAlies()) {
						j++;
					}

				usuarisVal.donaAlta(llista[j]);	
			}
			return usuarisVal;
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
		
		/**
		 * Escriu dades de la llista usuari al fitxer serialitzat
		 */
		public void escriureLlistaUsuaris() {
	        try {
	            FileOutputStream foutput = new FileOutputStream("dadesUsuaris.ser");
	            ObjectOutputStream soutput = new ObjectOutputStream(foutput);
	            int i = 0;
	            while(i < nElem) {
	                soutput.writeObject(llista[i]);
	                i++;
	            }
	            foutput.close();
	            soutput.close();
	        } catch (IOException e) {
	            System.out.println("Error en la creacio del fitxer serialitzat d'usuaris.");
	        }
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
