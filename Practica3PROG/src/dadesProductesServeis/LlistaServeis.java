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
		
	/**
	 * 	Afegir servei a un a llista
	 * @param s Servei a afegir a la llista
	 */
	public void afegirServei (Serveis s) {
		//Si la llista esta plena, la fem mes gran
		if (nElem>=llista.length) {
			Serveis [] llistanova = new Serveis [nElem*2];
			for (int i=0; i<nElem; i++)
			{
				llistanova[i]=llista[i];
			}
			llista=llistanova;
		}
		llista[nElem] = s.copia();
		nElem++;
	}
	
	public boolean comprovaServei (String usuari, String nomServ) {

        boolean trobat = false;

        for (int i=0; !trobat && i < nElem; i++) {
            if ((llista[i].getNom().equals(nomServ)) && (usuari.equals(llista[i].getUsuari()))) {
                trobat = true;
            }
        }
        return (trobat);
    }
	
	public boolean comprovaServeiSenseUsuari (String usuari, String nomServ) {

        boolean trobat = false;

        for (int i=0; !trobat && i < nElem; i++) {
            if ((llista[i].getNom().equals(nomServ)) && !(usuari.equals(llista[i].getUsuari()))) {
                trobat = true;
            }
        }
        return (trobat);
    }
	
	public String comprovaServeiSenseUsuariStr (String usuari, String nomProd) {
		
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
	
	public LlistaServeis llistaServeisActiu() {
		LlistaServeis actius = new LlistaServeis(100);
		for(int i = 0; i < this.nElem; i++) {
			if (llista[i].getActiu()) {
				actius.afegirServei(llista[i]);
			}
		}
		return actius;
	}

	/**
	 * Dona de baixa un servei sense esborrarlo de la llista
	 * @param usuari
	 * @param nomServei
	 * @return boolea que indica si s'ha donat de baixa o no
	 */
	public boolean donaBaixaServei (Usuaris usuari, String nomServei) {
		boolean trobat=false;
		for (int i=0; i<nElem; i++) {
			if (llista[i].getNom().equals(nomServei) && llista[i].getUsuari().equals(usuari.getAlies()))
			{
				llista[i].setActiu(false);
				trobat=true;
			}		
				
		}
		return trobat;
	}
	
	
	public String toString() {
		String aux;
		aux="Serveis => numServeis "+nElem;
		for (int j = 0; j < nElem; j++) {
			aux=aux+"\n\n\tServei "+(j+1)+"\t "+llista[j];
		}
		return aux;
	}
}
