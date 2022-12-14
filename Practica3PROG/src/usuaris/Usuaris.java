package usuaris;

public class Usuaris {   //Clase feta per Gerard Altadill
	private String alies;
	private String correu;
	private int codiPost;
	private String ofertaProd;
	private String intercanvis;
	
	/** Constructor de la classe usuaris
	 * 
	 * @param ali conte el nom/alies de l'usuari
	 * @param corre conte el correu de l'usuari
	 * @param cPost conte el codi postal de l'usuari
	 * @param oferProd conte la oferta produida
	 * @param intercanvi conte l'intercanvi de l'usuari
	 */
	public Usuaris (String ali, String corre, int cPost, String oferProd, String interc) {
		alies = ali;
		correu = corre;
		codiPost = cPost;
		ofertaProd = oferProd;
		intercanvis = interc;
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
	public String getOfertaProd () {
		return (ofertaProd);
	}
	
	/** getter
	 * 
	 * @return l'intercanvi de l'usuari
	 */
	public String getIntercanvis () {
		return (intercanvis);
	}
}