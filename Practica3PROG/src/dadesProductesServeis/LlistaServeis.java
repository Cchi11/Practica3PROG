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
		llista[nElem] = s.copia();
		nElem++;
	}
	
	/* Metode per comprovar si el servei introduït es troba a la llisa de serveis i si pertany a l'usuari
	 * @param usuari, l'alies de l'usuari que te iniciada la sessio actualment
	 * @param nomServ, el nom del servei que es vol comprovar
	 * @return un boolea que indica si ha trobat o no el servei
	 */
	public boolean comprovaServei (String usuari, String nomServ) {

        boolean trobat = false;

        for (int i=0; !trobat && i < nElem; i++) {
        	//cerquem a la llista de serveis
            if ((llista[i].getNom().equals(nomServ)) && (usuari.equals(llista[i].getUsuari()))) {
            	//si coincideix amb el que ha ficat l'usuari
                trobat = true;
                //posem el boolea a true
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
	
	/* metode que retorna en una llista de serveis tots els que estan actius
	 * @return la llista amb els serveis actius
	 */
	public LlistaServeis llistaServeisActiu() {
		LlistaServeis actius = new LlistaServeis(100);
		//creem la llista on ficarem els serveis actius
		for(int i = 0; i < this.nElem; i++) {
			//recorrem la llista
			if (llista[i].getActiu()) {
				//comprovem si el servei es actiu
				actius.afegirServei(llista[i]);
				//l'afegim a la llista
			}
		}
		return actius;
	}

	
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
