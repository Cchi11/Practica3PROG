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
	
	public Opcio2ActionListener (LlistaBens llistaBe, LlistaServeis llistaServ) {
		this.llistaBe = llistaBe;
		this.llistaServ = llistaServ;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		Opcio2Finestra o2 = new Opcio2Finestra(llistaBe, llistaServ);
	}
}
