package interficieGrafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;

import java.awt.event.ActionListener;

import peticions.LlistaPeticions;
import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

public class Opcio2ActionListener implements ActionListener {
	
	private LlistaBens llistaBe;
	private LlistaServeis llistaServ;
	private JFrame finestraP;
	
	/* Constructor per passar parametres
	 * @param llistaBe la llista de bens
	 * @param llistaServ la llista de serveis
	 * @param finestraP la finestra principal on surten les opcions
	 */
	public Opcio2ActionListener (LlistaBens llistaBe, LlistaServeis llistaServ, JFrame finestraP) {
		this.llistaBe = llistaBe;
		this.llistaServ = llistaServ;
		this.finestraP = finestraP;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		finestraP.setVisible(false);
		//una vegada s'acciona el boto, la finestra principal es fa invisible per donar pas a la finestra de la opcio 2
		Opcio2Finestra o2 = new Opcio2Finestra(llistaBe, llistaServ, finestraP);
		//es crea una instancia de la opcio 2
	}
}
