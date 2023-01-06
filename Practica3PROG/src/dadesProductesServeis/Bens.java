package dadesProductesServeis;

public class Bens extends Producte{   //Clase feta per Chenxing Chi
	private int amplada;
	private int alçada;
	private int fons;
	private int pes;
	private String dataIntercanvi;
	
	/**
	 * Constructor de Bens
	 * @param name conte el nom del producte
	 * @param descripcio conte la descripcio del producte
	 * @param tip conte el tipus del producte
	 * @param b conte el be del producte
	 * @param dat conte la data de creacio del producte
	 * @param amplada dimensions
	 * @param alçada dimensions
	 * @param fons	dimensions
	 * @param pes	pes del bé
	 * @param data	data d'intercanvi
	 */
	public Bens (String alies, String name, String descripcio, String tip, boolean b, String dat, int amplada, int alçada, int fons, int pes) {
		super (alies, name, descripcio, tip, b, dat);
		this.amplada=amplada;
		this.alçada=alçada;
		this.fons=fons;
		this.pes=pes;
		this.dataIntercanvi = "0";
	}
	
	//Getters
	
	public int getAmplada() {
		return amplada;
	}
	
	public int getAlçada() {
		return alçada;
	}
	
	public int getFons() {
		return fons;
	}
	
	public int getPes() {
		return pes;
	}
	
	public String getDataIntercanvi() {
		return dataIntercanvi;
	}
	
	public Bens copia() {
		Bens copia = new Bens (super.usuari, super.nom, super.desc, super.tipus, super.be, super.data, amplada, alçada, fons, pes);
		copia.dataIntercanvi=this.dataIntercanvi;
		return copia;
	}
	
	public String toString() {
		return ("Alies: "+super.usuari+". Nom del be: " + super.nom +". Descripcio del be: " + super.desc + ". Tipus de be: " + super.tipus + ". Data d'inici del be: " + super.data + ". Amplada: " +amplada+"cm. Alçada: "+alçada+"cm. Fons: "+fons+"cm. Pes"+pes+"g. Data intercanvi: "+dataIntercanvi+".");
	}
}
