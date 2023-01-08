package Exceptions;

/**
 * Clase Excepcio per gestionar quan no troba algun element a la llista
 * @author chenc
 *
 */
public class NoEsTrobaException extends Exception {

		/**
		 * Constructor 1, retorna el text de missatge d'error
		 * @param text
		 */
		public NoEsTrobaException(String text) {
			super(text);
		}
		
		/**
		 * Constructor Buit
		 */
		public NoEsTrobaException() {
			
		}
		
}
