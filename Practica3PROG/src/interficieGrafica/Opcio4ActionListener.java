package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import peticions.LlistaPeticions;

/**
 * Clase ActionListener per obrir la opcio4
 * @author Pol Regy
 *
 */
public class Opcio4ActionListener implements ActionListener  {

	private JFrame finestraP;
	private LlistaPeticions peticions;
	
	/**
	 * Constructor de la accionListener per guardar parametres
	 * @param P Finestra principal
	 * @param peticions LlistaPeticions principal
	 */
	public Opcio4ActionListener (JFrame P, LlistaPeticions peticions) {
		this.finestraP = P;
		this.peticions=peticions;
	}
	

	public void actionPerformed(ActionEvent e) {
		
		LlistaPeticions llistaOpcio4 = new LlistaPeticions (100);
		boolean error =false;
		int nElem=0;
		
		//li pasem com a parametre a la finestra 4 la llista de peticions intercanviats
		llistaOpcio4 = peticions.PeticionsUsuariAcceptades();
		//nElems de la llistaOpcio4
		nElem = peticions.numPeticionsUsuari();
		//Genera la finestra de la opcio4
		Opcio4Finestra finestra4 = new Opcio4Finestra (finestraP, llistaOpcio4, nElem);
		finestraP.setVisible(false);
				

	
		
		
		
	}

}
