package interficieGrafica;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.*;

import Exceptions.NoEsTrobaException;
import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

/**
 * Finestra principal per crear la interficie grafica
 */

public class MainGrafic extends JFrame {
	//creem un Usuari global que sera el usuari que te iniciada la sessio
	public static Usuaris usuari;


	
	/**
	 * Constructor de la finestra principal
	 * @param llistaUser LlistaUsuaris on es guarden els usuaris
	 * @param llistaBe	Llista de bens 
	 * @param llistaServis	Llista de Serveis
	 * @param llistaPeti LlistaPeti
	 */
	public MainGrafic(LlistaUsuaris llistaUser, LlistaBens llistaBe, LlistaServeis llistaServis, LlistaPeticions llistaPeti) {

		setVisible(false);
		//Primer cridem la funcio aquesta per tenir clara qui te la sessio iniciada
		usuari = IniciaSessio(llistaUser);

		//Creem un panell on afegirem Botons per al main
		JPanel panellBotons = new JPanel();
		//Li posem una estructura Grid que ens posara els botons com a matriu de 2x2
		 panellBotons.setLayout(new GridLayout(2, 2));
		 
		 //Creem un array de botons que contindra els 4 botons que seran els 4 metodes de la part gràfica
		 JButton[] buttons = new JButton[4];
		 for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();	
			buttons[i].setPreferredSize(new Dimension(75, 25));
			//els posem de color blanc de moment
			buttons[i].setBackground(Color.WHITE);
		}
		 
		//Posem text per a cada boto opcio i a cada boto li asignem el seu corresponent ActioListener
		buttons[0].setText("Buscar ofertes d'intercanvi actives");
		Opcio2ActionListener opcio2 = new Opcio2ActionListener(llistaBe, llistaServis);
		buttons[0].addActionListener(opcio2);
		
		buttons[1].setText("Afegir una peticio d'intercanvi d'alguna de les ofertes actives");
		Opcio3ActionListener opcio3 = new Opcio3ActionListener(this, usuari, llistaBe, llistaServis, llistaPeti);
		buttons[1].addActionListener(opcio3);
		
		buttons[2].setText("Consultar els intercanvis que ha fet l'usuari");
		
		buttons[3].setText("Canviar el codi d'usuari que esta  utilitzant l'aplicacio");
		Opcio5ActionListener opcio5 = new Opcio5ActionListener (this, llistaUser);
		buttons[3].addActionListener(opcio5);
		
		//El text del titol
		JLabel titol = new JLabel();
		titol.setText("Indica quina opcio vols:");
		this.add(titol, BorderLayout.NORTH);
		
		 //Configurem cada boto amb la seva font y l'afegim al panell 
		for (int i = 0; i < buttons.length; i++) {
			Font buttonFont = new Font("Roboto", Font.PLAIN, 16);
			buttons[i].setFont(buttonFont);
			panellBotons.add(buttons[i]);
		}
		
		//Afegim el panell al centre de tot
		add(panellBotons, BorderLayout.CENTER);
		add(titol, BorderLayout.NORTH);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		 
	}

	 /**
	  * Procediment que retorna un Usuari que sera el usuari que te la sessióActual
	  * @param llistaUser Llista on es guarda l'usuari
	  * @return UsuariActual que te la sessió
	  */
	 private Usuaris IniciaSessio (LlistaUsuaris llistaUser) {
		 
		 	//Panell de opcions
			String [] opcions = {"Registra't", "Ja tinc un compte"};
			boolean error = false;
			
			//Finestra que mostra 2 opcions, la de registrarse o iniciar sessio
			int resultat = JOptionPane.showOptionDialog(null, 
						   "Benvingut! Registra't o ja tens compte", "Plataforma d'intercanvi", 
						   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
						   null, opcions, 
						   0);
			
			
			//L'usuari li dona a iniciar sessió
			 if (resultat == JOptionPane.NO_OPTION) {
				 IniciaSessio finestraSessio = new IniciaSessio(this, llistaUser);
			 }
			 else{
				//Si ha seleccionat el boto de registrarse, crea finestra de registrarse
				if (resultat == JOptionPane.YES_OPTION) {
					Registrarse finestraRegistrar = new Registrarse(this, llistaUser);
				}
			}
			return usuari;
		 }

}
	
		