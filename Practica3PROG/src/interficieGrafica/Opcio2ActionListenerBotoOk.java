package interficieGrafica;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;

public class Opcio2ActionListenerBotoOk implements ActionListener {
		
	private JFrame finestraP;
	private JFrame finestra2;
		
	/* Constructor per passar parametres
	 * @param finestraP la finestra principal on surten les opcions
	 * @param finestra2 la finestre de la opcio 2 on surt la llista d'ofertes actives
	 */
	public Opcio2ActionListenerBotoOk (JFrame finestraP, JFrame finestra2) {

		this.finestraP = finestraP;
		this.finestra2 = finestra2;
	}
		
	public void actionPerformed(ActionEvent e) {
			
		JButton b = (JButton) e.getSource();
		finestra2.setVisible(false);
		//una vegada es pica el botó ok de la llista, la finestra dos es torna invisible i dona pas a la finestra principal
		finestraP.setVisible(true);	
		//la finestra principal es fa visible per mostrar les altres opcions
	}
}
