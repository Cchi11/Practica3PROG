package dadesProductesServeis;

public class Serveis extends Producte{   //Clase realitzada per Pol Regy
	
	private String dataFiOferiment;
	private int actiu;
	
	
	/** Constructor de la clase producte
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public Serveis (String name, String descripcio, String tip, boolean b, String dat, String data) {
		super (name, descripcio, tip, b, dat);
		this.dataFiOferiment=data;
		actiu=1;
	}
	
	/** getter
	 * 
	 * @return data limit de l'oferiment
	 */
	public String getDataFiOferiment() {
		return (dataFiOferiment);
	}
	
	public int getActiu() {
		return actiu;
	}
	
	public void setActiu(int n) {
		actiu=n;
	}
	
	public Serveis copia () {
		Serveis copia =  new Serveis (super.nom, super.desc, super.tipus, super.be, super.data, dataFiOferiment);
		copia.actiu=this.actiu;
		return copia;
	}
}
