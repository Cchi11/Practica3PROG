package dadesProductesServeis;

public class Bens extends Producte{   //Clase feta per Chenxing Chi
	private int amplada;
	private int alçada;
	private int fons;
	private int pes;
	private String dataIntercanvi;
	
	/**
	 * Constructor de Bens
	 * @param name
	 * @param descripcio
	 * @param tip
	 * @param b
	 * @param dat		
	 * @param amplada  dimensions
	 * @param alçada	dimensions
	 * @param fons		dimensions
	 * @param pes		pes del bé
	 * @param data		data d'intercanvi
	 */
	public Bens (String name, String descripcio, String tip, boolean b, String dat, int amplada, int alçada, int fons, int pes, String data) {
		super (name, descripcio, tip, b, dat);
		this.amplada=amplada;
		this.alçada=alçada;
		this.fons=fons;
		this.pes=pes;
		this.dataIntercanvi=data;
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
	
}
