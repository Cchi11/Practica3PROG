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

	public void escriureLlistaServeis() {
		try (BufferedWriter g = new BufferedWriter(new FileWriter("dadesServeis.txt"))) {
			String frase = "";
			int i = 0;

			for(i = 0; i < nElem; i++) {
				frase = llista[i].getUsuari()+";"+llista[i].getNom()+";"+llista[i].getDesc()+";"+llista[i].getTipus()+";false;"+llista[i].getData()+";"+llista[i].getDataFiOferiment();
				g.write(frase);
				g.newLine();
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
