package dadesProductesServeis;

public abstract class Producte {	//Clase feta per Gerard Altadill
	protected String nom;
	protected String desc;
	protected String tipus;
	protected boolean be;			//true=bé  //false=servei
	protected String data;
	
	/** Constructor de la classe producte
	 * 
	 * @param name conte el nom del producte
	 * @param descripcio conte la descripcio del producte
	 * @param tip conte el tipus del producte
	 * @param b conte el be del producte
	 * @param dat conte la data de creacio del producte
	 */
	public Producte (String name, String descripcio, String tip, boolean b, String dat) {
		nom = name;
		desc = descripcio;
		tipus = tip;
		be = b;
		data = dat;
	}
	
	/** getter
	 * 
	 * @return el nom del producte
	 */
	public String getNom () {
		return (nom);
	}
	
	/** getter
	 * 
	 * @return la descripcio del producte
	 */
	public String getDesc () {
		return (desc);
	}
	
	/** getter
	 * 
	 * @return el tipus de producte
	 */
	public String getTipus () {
		return (tipus);
	}
	
	/** getter
	 * 
	 * @return el be del producte
	 */
	public boolean getBe () {
		return (be);
	}
	
	/** getter
	 * 
	 * @return la data de creacio del producte
	 */
	public String getData () {
		return (data);
	}

}
