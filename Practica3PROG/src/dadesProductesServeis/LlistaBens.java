package dadesProductesServeis;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import peticions.Peticions;
import usuaris.Usuaris;

public class LlistaBens {  //Clase feta per Chenxing Chi
	private int nElem;
	private Bens [] llista;
	
	
	/** Constructor de la llista de béns
	 * 
	 * @param tamany és el num de elements que assignem a la llista
	 */
	public LlistaBens (int tamany) {
		nElem=0;
		llista = new Bens[tamany];
	}
	
	/**
	 * Getter de numElements actuals
	 * @return nElem
	 */

	public int getNumElem() {
		return nElem;
	}
	
	/**
	 * Metode per afegir un be a la llista
	 * @param b el be a afegir
	 */
	public void afegirBe (Bens b) {
		//Si la llista esta plena, la fem més gran
		if (nElem>=llista.length) {
			Bens [] llistanova = new Bens [nElem*2];
			for (int i=0; i<nElem; i++)
			{
				llistanova[i]=llista[i];
			}
			llista=llistanova;
		}
		llista[nElem] = b.copia();
		nElem++;
	}
	
	

	/* metode per comprovar si el be pertany al usuari
	 * @param usuari, alies de l'usuari actual que te iniciada la sessio
	 * @param nomProd, nom del producte que volem comprovar
	 * @return un boolea per si es troba el be a la llista
	 */
	public boolean comprovaBe (String usuari, String nomProd) {
		boolean trobat = false;
		
		for (int i=0; !trobat && i < nElem; i++) {
			//fem una cerca per robar si es correspon a la llista
			if ((llista[i].getNom().equals(nomProd)) && (usuari.equals(llista[i].getUsuari()))) {
				//si el producte coincideix
				trobat = true;
				//el boolea sera cert
			}
		}
		return (trobat);
	}	
	/**
	 * Metode per veure si el be pertany al usuari i que no s'hagi intercanviat ningut cop
	 * @param usuari nom del usuari a buscar
	 * @param nomProd nom del usuari a intercanviar
	 * @return boolea si ha trobat o no
	 */
	public boolean comprovaBeSenseIntercanviat (String usuari, String nomProd) {
		
		boolean trobat = false;
		
		for (int i=0; !trobat && i < nElem; i++) {
			//fem una cerca per robar si es correspon a la llista
			if ((llista[i].getNom().equals(nomProd)) && (usuari.equals(llista[i].getUsuari())) && (llista[i].getDataIntercanvi()=="0")) {
				//si el producte coincideix
				trobat = true;
				//el boolea sera cert
			}
		}
		return (trobat);
	}	
	
	
	/**
	 * Metode que realitza el mateix que el metode ComprovaBe, pero ara mira sense tenir en compte l'usuari
	 * @param usuari Nom usuari a buscar
	 * @param nomProd Nom del producte a buscar
	 * @return Retorna si a trobat o no
	 */
	public boolean comprovaBeSenseUsuari (String usuari, String nomProd) {
		
		boolean trobat = false;
		
		for (int i=0; !trobat && i < nElem; i++) {
			//fem una cerca per robar si es correspon a la llista
			if ((llista[i].getNom().equals(nomProd)) && !(usuari.equals(llista[i].getUsuari()))) {
				//si el producte coincideix
				trobat = true;
			}
		}
		return (trobat);
	}	
	
	/**
	 * Metode que realitza el mateix que el metode comprovaBeSenseUsuari, nomes que ara retorna un String amb el nom de l'usuari trobat
	 * @param usuari Usuaria buscar
	 * @param nomProd	nom del producte a buscar
	 * @return Retorna el nom  del usuari
	 */
	
	public String comprovaBeSenseUsuariStr (String usuari, String nomProd) {
		
		boolean trobat = false;
		String us = null;
		//fem una cerca per robar si es correspon a la llista
		for (int i=0; !trobat && i < nElem; i++) {
			if ((llista[i].getNom().equals(nomProd)) && !(usuari.equals(llista[i].getUsuari()))) {
				//si el producte coincideix
				trobat = true;
				us = llista[i].getUsuari();
				//el boolea sera cert i es copia el usuari
			}
		}
		return us;
	}

	/**
	 * Elimina un Be de la llista tenint en compte que nomes es pot esborrar si no s'ha intercanviat
	 * @param usuari Usuari actual
	 * @param nomProd nom del producte a esborrar
	 */
	public void eliminaBe (Usuaris usuari, String nomProd) {
		int i=0;
			while (i<nElem) {
				if ((llista[i].getNom().equals(nomProd)) && (usuari.getAlies().equals(llista[i].getUsuari())) && (llista[i].getDataIntercanvi()=="0")) {
					
					for (int j=i; j<nElem-1; j++)
					{
						llista[j]=llista[j+1];
					}
					nElem--;
				}
				else {
					i++;
				}
			}
	}
	
	/* Metode que retorna una llista amb els bens els quals la data d'intercanvi sigui 0, es a dir els que encar no han estat intercanviats
	 * @return la llista nova amb els bens que no han estats intercanviats
	 */
	public LlistaBens llistaBensNoIntercanvia() {
		LlistaBens noInter = new LlistaBens(100);
		//creem la llista on posarem els bens no intercanviats
		for(int i = 0; i < this.nElem; i++) {
			//recorrem tota la llista
			if (llista[i].getDataIntercanvi() == "0") {
				//si no han estat intercanviats
				noInter.afegirBe(llista[i]);
				//afegim el be a la llista nova
			}
		}
		return noInter;
	}
	

	/**
	 * LLegeix les dades de un fitxer y les copia a la llista 
	 */
	public void escriureLlistaBens() {
		try (BufferedWriter g = new BufferedWriter(new FileWriter("dadesBens.txt"))) {
			String frase = "";
			int i = 0;
			//Recorem tota la llista fins que s'acabi
			for(i = 0; i < nElem; i++) {
				//pasem tots el continguts al un format divit en ;
				frase = llista[i].getUsuari()+";"+llista[i].getNom()+";"+llista[i].getDesc()+";"+llista[i].getTipus()+";true;"+llista[i].getData()+";"+llista[i].getAmplada()+";"+llista[i].getAmplada()+";"+llista[i].getAlçada()+";"+llista[i].getFons()+";"+llista[i].getPes();
				g.write(frase); // escribim frase
				g.newLine(); // y saltem de linia
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
	
	/* Metode que agafa la llista i retorna la peticio en una posicio concreta de la llista
	 * @param i, l'index de la llista
	 * @return la peticio en aquella posicio de la llista
	 */
	
	public Bens agafarBe (String usuari, String nomProd) {
		
		int i = 0;
		boolean trobat = false;
	
		for (i=0; !trobat && i < nElem; i++) {
			//fem una cerca per robar si es correspon a la llista
			if ((llista[i].getNom().equals(nomProd)) && (usuari.equals(llista[i].getUsuari()))) {
				//si el producte coincideix
				trobat = true;
				//el boolea sera cert
			}
		}
		i--;
		return (llista[i].copia());
	}
	
	public void canviarDataInter (String usuari, String nomProd, String data) {
		int i = 0;
		boolean trobat = false;
	
		for (i=0; !trobat && i < nElem; i++) {
			//fem una cerca per robar si es correspon a la llista
			if ((llista[i].getNom().equals(nomProd)) && (usuari.equals(llista[i].getUsuari()))) {
				//si el producte coincideix
				trobat = true;
				//el boolea sera cert
				llista[i].setDataIntercanvi(data);
				//canviem la data d'intercanvi 
			}
		}
	}
	
	public void canviarUsuariBe(String usuari, String nomProd, String userAltre) {
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
	
	/**
	 * Passa la taula a un string
	 */
	public String toString() {
		String aux;
		aux="Bens => numBens "+nElem;
		for (int j = 0; j < nElem; j++) {
			aux=aux+"\n\n\tBe "+(j+1)+"\t "+llista[j];
		}
		return aux;

	}
	
}
