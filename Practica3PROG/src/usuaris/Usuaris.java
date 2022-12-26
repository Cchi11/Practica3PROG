package usuaris;

import java.io.Serializable;

public class Usuaris implements Serializable{   //Clase feta per Gerard Altadill
	private String alies;
	private String correu;
	private int codiPost;
	private int ofertaProd;
	private int  intercanvis;
	
	/** Constructor de la classe usuaris
	 * 
	 * @param ali conte el nom/alies de l'usuari
	 * @param corre conte el correu de l'usuari
	 * @param cPost conte el codi postal de l'usuari
	 * @param oferProd conte la oferta produida
	 * @param intercanvi conte l'intercanvi de l'usuari
	 */
	public Usuaris (String ali, String corre, int cPost) {
		alies = ali;
		correu = corre;
		codiPost = cPost;
		ofertaProd = 0;
		intercanvis = 0;
	}
	
	/** getter
	 * 
	 * @return l'alies de l'usuari
	 */
	public String getAlies () {
		return (alies);
	}
	
	/** getter
	 * 
	 * @return el correu de l'usuari
	 */
	public String getCorreu () {
		return (correu);
	}
	
	/** getter
	 * 
	 * @return el codi postal de l'usuari
	 */
	public int getCodiPost () {
		return (codiPost);
	}
	
	/** getter
	 * 
	 * @return l'oferta produida
	 */
	public int getOfertaProd () {
		return (ofertaProd);
	}
	
	/** getter
	 * 
	 * @return l'intercanvi de l'usuari
	 */
	public int getIntercanvis () {
		return (intercanvis);
	}
	
	public Usuaris copia() {
		Usuaris copia = new Usuaris (alies, correu, codiPost);
		copia.intercanvis=this.intercanvis;
		copia.ofertaProd=this.ofertaProd;
		return copia;
		
	}
}
