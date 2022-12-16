package dadesProductesServeis;

public class Serveis extends Producte{   //Clase realitzada per Pol Regy
	private String dataFiOferiment;
	
	
	/** Constructor de la clase producte
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public Serveis (String name, String descripcio, String tip, boolean b, String dat, String data) {
		super (name, descripcio, tip, b, dat);
		this.dataFiOferiment=data;
	}
	
	/** getter
	 * 
	 * @return data limit de l'oferiment
	 */
	public int getDataFiOferiment() {
		return dataFiOferiment;
	}
}
