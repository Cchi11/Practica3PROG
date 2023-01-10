package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import peticions.Peticions;

/**
 * Clase Accio per poder generar una finestra nova de toString de la peticio pasada per parametre
 * @author Pol Regy
 *
 */
public class ActionListenerBotonsPeticions implements ActionListener {

	private Peticions p;
	private JFrame finestraP;

	/**Constructor
	 * @param finestraP finestra opcio4
	 * @param p peticio a imprimir per pantalla
	 */
	public ActionListenerBotonsPeticions (JFrame finestraP, Peticions p) {
		this.p=p;
		this.finestraP=finestraP;
	}
	
	/**
	 * Genera la finestra per poder realitzar el toString
	 */
	public void actionPerformed(ActionEvent e) {
		
		
		FinestraPeticioToString finestra = new FinestraPeticioToString (finestraP, p);
		
		
		// TODO Auto-generated method stub
		
	}

}
