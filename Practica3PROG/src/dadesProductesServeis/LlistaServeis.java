package dadesProductesServeis;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
	
	/**
	 * Metode que fa el mateix que el comprovaServei, pero ara mira sense tenir en compte l'usuari
	 * @param usuari usuari a busccar
	 * @param nomServ producte a buscar
	 * @return boolea si ha trobat o no
	 */
	public boolean comprovaServeiSenseUsuari (String usuari, String nomServ) {

        boolean trobat = false;

        for (int i=0; !trobat && i < nElem; i++) {
            if ((llista[i].getNom().equals(nomServ)) && !(usuari.equals(llista[i].getUsuari()))) {
                trobat = true;
            }
        }
        return (trobat);
    }
	
	/**
	 * Metode que fa el mateix que el comprovaServei, pero ara mira sense tenir en compte l'usuari y ara retorna un String amb el nom d'aquest usuari trobat
	 * @param usuari usuari a busccar
	 * @param nomServ producte a buscar
	 * @return String amb el nom del usuari trobat i sino retorna null
	 */
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

	/**
	 * Escriu la llista de serveis a un fitxer
	 */
	public void escriureLlistaServeis() {
		try (BufferedWriter g = new BufferedWriter(new FileWriter("dadesServeis.txt"))) {
			String frase = "";
			int i = 0;

			for(i = 0; i < nElem; i++) {
				// Pasem els paramatres a un string saparats per ;
				frase = llista[i].getUsuari()+";"+llista[i].getNom()+";"+llista[i].getDesc()+";"+llista[i].getTipus()+";false;"+llista[i].getData()+";"+llista[i].getDataFiOferiment();
				g.write(frase); //Escrivim la frase al fitxer
				g.newLine();	//SAltem de linia
			}
			g.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("L'arxiu d'entrada no existeix");
		}
		catch(IOException e) {
			System.out.println("S'ha produit un error en els arxius");
		}
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
	
	public Serveis agafaServei (String usuari, String nomServ) {
        
		int i = 0;
		boolean trobat = false;

        for (i=0; !trobat && i < nElem; i++) {
        	//cerquem a la llista de serveis
            if ((llista[i].getNom().equals(nomServ)) && (usuari.equals(llista[i].getUsuari()))) {
            	//si coincideix amb el que ha ficat l'usuari
                trobat = true;
                //posem el boolea a true
            }
        }
        i--;
        return (llista[i].copia());
	}
	
	public void canviarUsuariServei(String usuari, String nomProd, String userAltre) {
		int i = 0;
		boolean trobat = false;
	
		for (i=0; !trobat && i < nElem; i++) {
			//fem una cerca per robar si es correspon a la llista
			if ((llista[i].getNom().equals(nomProd)) && (usuari.equals(llista[i].getUsuari()))) {
				//si el producte coincideix
				trobat = true;
				//el boolea sera cert
				llista[i].setUsuari(userAltre);
				//canviem l'usari propietari del producte
			}
		}
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
