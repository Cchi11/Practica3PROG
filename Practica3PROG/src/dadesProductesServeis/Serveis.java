package dadesProductesServeis;

public class Serveis extends Producte{   //Clase realitzada per Pol Regy
	
	private String dataFiOferiment;
	private boolean actiu;
	int repeticions;
	
	
	/** Constructor de la clase producte
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public Serveis (String alies, String name, String descripcio, String tip, boolean b, String dat, String data) {
		super (alies, name, descripcio, tip, b, dat);
		this.dataFiOferiment=data;
		actiu=true;
		repeticions = 0;
		
	}

	
	/** getters
	 */
	public String getDataFiOferiment() {
		return (dataFiOferiment);
	}
	
	public boolean getActiu() {
		return actiu;
	}
	
	public int getRepeticions() {
		return repeticions;
	}
	
	public void setActiu(boolean n) {
		actiu=n;
	}
	
	public void setRepeticions(int rep) {
		repeticions = rep;
	}
	
	public void incremRepe() {
		repeticions = repeticions + 1;
	}
	
	public Serveis copia () {
		Serveis copia =  new Serveis (super.usuari, super.nom, super.desc, super.tipus, super.be, super.data, dataFiOferiment);
		copia.actiu=this.actiu;
		return copia;
	}
	
	public String toString() {
		return ("Alies: "+super.usuari+".\t Nom del servei: " + super.nom +".\t Descripcio del servei: " + super.desc + ".\t\t Tipus de servei: " + super.tipus + ".\t\n\t\tData d'inici del servei: " + super.data + ".\t Data de finalitzacio del sevei: " + dataFiOferiment+".\t Actiu: "+ actiu);
	}
}
