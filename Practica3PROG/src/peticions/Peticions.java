package peticions;


public class Peticions {		//Clase feta per Òscar Cabré
	private String idPeticio, userPeticio, userRebPet, producAcons, producOfe;
	private int resposat, valoracioUserPeticio, valoracioUserRebPet;
	/**
	 * Constructor
	 * @param peticioId		ID de la petició
	 * @param petUser 		Nom de l'usuari que fa la petició
	 * @param rebUser 		Nom de l'usuari que rep la petició
	 * @param aconsProduc 	Nom del producte que vols aconseguir
	 * @param ofeProduc 	Nom del producte que ofereixes
	 */
	public Peticions (String peticioId, String petUser, String rebUser, String aconsProduc, String ofeProduc) {
		idPeticio = peticioId;
		userPeticio = petUser;
		userRebPet = rebUser; 
		producAcons = aconsProduc; 
		producOfe = ofeProduc;
		resposat = 0;	// 0 = No contestada; 1 = acceptada; 2 = rebutjada
		valoracioUserPeticio = 0;
		valoracioUserRebPet = 0;
	}
	
	/** 
 	 * getter
	 * @return	ID de la petició
	 */
	public String getIdPeticio () {
		return (idPeticio);
	}
	
	/**
	 * getter
	 * @return	Nom de l'usuari que fa la petició
	 */
	public String getUserPeticio() {
		return(userPeticio);
	}
	
	/**
	 * getter
	 * @return	Nom de l'usuari que rep la petició
	 */
	public String getUserRebPet() {
		return(userRebPet);
	}
	
	/**
	 * getter
	 * @return	Nom del producte que vols aconseguir
	 */
	public String getProducAcons() {
		return(producAcons);
	}
	
	/**
	 * getter
	 * @return	Nom del producte que ofereixes
	 */
	public String getProducOfe() {
		return(producOfe);
	}
	
	/**
	 * getter
	 * @return	Estat de la resposta (0 = No contestada; 1 = acceptada; 2 = rebutjada)
	 */
	public int getResposat() {
		return(resposat);
	}
	
	/**
	 * getter
	 * @return	Valoració de l'usuari que fa la petició (Número del 0 al 5)
	 */
	public int getValoracioUserPeticio() {
		return(valoracioUserPeticio);
	}
	
	/**
	 * getter
	 * @return	Valoració de l'usuari que rep la petició (Número del 0 al 5)
	 */
	public int getValoracioUserRebPet() {
		return(valoracioUserRebPet);
	}
	
	/**
	 * setter
	 * @param resopsta
	 */
	public void setResposat(int resopsta) {
		this.resposat = resopsta;
	}
	
	/**
	 * setter
	 * @param valoracioUserPeticio
	 */
	public void setValoracioUserPeticio(int valoracioUserPeticio) {
		this.valoracioUserPeticio = valoracioUserPeticio;
	}
	
	/**
	 * setter
	 * @param valoracioUserRebPet
	 */
	public void setValoracioUserRebPet(int valoracioUserRebPet) {
		this.valoracioUserRebPet = valoracioUserRebPet;
	}
	
	public String toString() {
		return ("PETICIO => idPeticio:\t"+idPeticio+"\tuserPeticio:\t"+userPeticio+"\tuserRebPet:\t"+userRebPet+"\tproducAcons:\t"+producAcons+"\tproducOfe:\t"+producOfe+"\tresposat:\t"+resposat+"\tvaloracioUserPeticio:\t"+valoracioUserPeticio+"\tvaloracioUserRebPet:\t"+valoracioUserRebPet);
	}
}
