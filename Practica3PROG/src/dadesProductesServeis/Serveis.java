package dadesProductesServeis;

public class Serveis extends Producte{   //Clase realitzada per Pol Regy
	
	private String dataFiOferiment;
	private boolean actiu;
	
	
	/** Constructor de la clase producte
	 * 
	 * @param n el nombre d'espais que assignem a la llista
	 */
	public Serveis (String alies, String name, String descripcio, String tip, boolean b, String dat, String data) {
		super (alies, name, descripcio, tip, b, dat);
		this.dataFiOferiment=data;
		actiu=true;
	}
	
	/** getter
	 * 
	 * @return data limit de l'oferiment
	 */
	public String getDataFiOferiment() {
		return (dataFiOferiment);
	}
	
	public boolean getActiu() {
		return actiu;
	}
	
	public void setActiu(boolean n) {
		actiu=n;
	}
	
	public Serveis copia () {
		Serveis copia =  new Serveis (super.usuari, super.nom, super.desc, super.tipus, super.be, super.data, dataFiOferiment);
		copia.actiu=this.actiu;
		return copia;
	}
	
	public String toString() {
		return ("Alies: "+super.usuari+". Nom del servei: " + super.nom +". Descripcio del servei: " + super.desc + ". Tipus de servei: " + super.tipus + ". Data d'inici del servei: " + super.data + ". Data de finalitzacio del sevei: " + dataFiOferiment+". Actiu: "+ actiu);
	}
}
