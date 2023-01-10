package Exceptions;

/**
 * Clase per controlar excepecio de un numero que estigui fora de un rang de numeros
 * @author chenc
 *
 */
public class NumeroForaRangException extends Exception {
	
	/**
	 * Constructor1 mostra el missatge d'error
	 * @param text
	 */
	public NumeroForaRangException(String text) {
		super (text);
	}
	/**
	 * Constructor buit
	 */
	public NumeroForaRangException() {}
	
}
