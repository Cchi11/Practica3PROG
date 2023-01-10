package interficieGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;
import usuaris.Usuaris;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import peticions.LlistaPeticions;
import peticions.Peticions;

/**
 * Clase per generar la finesta 4
 * @author Pol Regy
 *
 */
public class Opcio4Finestra extends JFrame {
	
	/**
	 * Constructor
	 * @param P finestra principal (per ocultarla quan sobre aquesta d'aqui)
	 * @param llistapeti Llistapeticions de nomes peticions intercanviades
	 * @param nElem nElems de llistapeti
	 */
	public Opcio4Finestra (JFrame P, LlistaPeticions llistapeti, int nElem) {
		//Si resulta que no te cap be intercanviat, mostra missatge d'error
		if (nElem==0) {
			JOptionPane.showMessageDialog(null, "No tens intercanvis fets!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//Configuració de finestra
			P.setVisible(false);
			this.pack();
			this.setLocation(100, 200);
			this.setSize(500,200);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);

			//Creacio de panell i de botons 
			JPanel panell= new JPanel();
			panell.setLayout(new FlowLayout());
			
			//generem tants botons com nElems de la llista
			JButton [] botons = new JButton [nElem];
			int j=0;
			
			
			for (int i=0; i<nElem; i++) {
				
				botons[i] = new JButton();
				botons[i].setSize(100, 30);
				//A cada boto li pasem una peticio com a parametre per poder mostrar les dades de cada peticio
				Peticions p=llistapeti.agafarPeticio(i); //agafa la peticio a partir de la posicio pasada per parametre de la llista
				ActionListenerBotonsPeticions accio = new ActionListenerBotonsPeticions(this, p);
				botons[i].addActionListener(accio);
				j=i+1;
				botons[i].setText("Peticio "+j);
				
				//Si la valoracio es entre 0-2 el boto es vermell
				if (p.getValoracioUserPeticio()>=0 && p.getValoracioUserPeticio()<=2) {
					botons[i].setBackground(Color.RED);
				}
				else {
					//Si la valoracio es 3, el boto es groc
					if(p.getValoracioUserPeticio()==3) {
						botons[i].setBackground(Color.YELLOW);
					}
					//Si la valoracio es 4, el boto es verd
					else {
						botons[i].setBackground(Color.GREEN);
					}
					
				}
				//afegim botons al panell
				panell.add(botons[i]);
				
			}
			
			JButton botoOk= new JButton();
			botoOk.setText("Ok");
			
			//boto per tancar la finestra, reciclant codi de la opcio2
			
			Opcio2ActionListenerBotoOk accio2 = new Opcio2ActionListenerBotoOk(P, this);
			botoOk.addActionListener(accio2);
			
			this.add(botoOk, BorderLayout.SOUTH);
			this.add(panell, BorderLayout.CENTER);
			
		}
		
	}

}

	
