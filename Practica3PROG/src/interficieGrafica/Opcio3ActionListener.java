package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;

import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

public class Opcio3ActionListener implements ActionListener {


	private LlistaBens llistaBe;
	private LlistaServeis llistaServ;
	private LlistaPeticions llistaPet;
	private Usuaris user;
	private JFrame fines;
	
	public Opcio3ActionListener(JFrame fin, Usuaris usuariactual, LlistaBens llistaBen, LlistaServeis llistaServis, LlistaPeticions llistaPeti) {
		this.user=usuariactual;
		this.llistaBe = llistaBen;
		this.llistaServ = llistaServis;
		this.llistaPet = llistaPeti;
		this.fines = fin; 
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		fines.setVisible(false);
		Opcio3Finestra finestra = new Opcio3Finestra(fines, MainGrafic.usuari, llistaBe, llistaServ, llistaPet);

	}

}
