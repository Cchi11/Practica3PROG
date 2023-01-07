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
import javax.swing.plaf.basic.BasicArrowButton;

import Exceptions.NoEsTrobaException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import usuaris.LlistaUsuaris;
import usuaris.Usuaris;


public class MainGrafic extends JFrame {
	private Usuaris usuari;

	public MainGrafic(LlistaUsuaris llistaUser) {

		usuari = IniciaSessio(llistaUser);
		JPanel panellBotons = new JPanel();
		 panellBotons.setLayout(new GridLayout(2, 2));
		 
		 JButton[] buttons = new JButton[4];
		 for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();	
			buttons[i].setPreferredSize(new Dimension(75, 25));
			//els posem de color blanc de moment
			buttons[i].setBackground(Color.WHITE);
		}
		buttons[0].setText("Buscar ofertes d'intercanvi actives");
		buttons[1].setText("Afegir una petició d’intercanvi d’alguna de les ofertes actives");
		Opcio2ActionListener opcio2 = new Opcio2ActionListener();
		buttons[1].addActionListener(opcio2);
		buttons[2].setText("Consultar els intercanvis que ha fet l’usuari");
		buttons[3].setText("Canviar el codi d’usuari que està utilitzant l’aplicació");
	
		JTextField titol = new JTextField();
		titol.setText("Indica quina opció vols");
		titol.setEditable(false);
		 
		for (int i = 0; i < buttons.length; i++) {
			Font buttonFont = new Font("Arial", Font.PLAIN, 16);
			buttons[i].setFont(buttonFont);
			panellBotons.add(buttons[i]);
		}
		//afegim la matriu al centre de tot
		add(panellBotons, BorderLayout.CENTER);
		add(titol, BorderLayout.NORTH);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setVisible(true);
		 
		 
	}
	public Usuaris preguntarDades() {
		 	
		JFrame registrat = new JFrame ();
	    registrat.pack();
	    registrat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    registrat.setSize(200,200);
	    registrat.setVisible(true);
	    
	    JPanel panell = new JPanel(new GridLayout(3,2));
	    
	    JLabel titolAlies = new JLabel ("Usuari:");
	    titolAlies.setBounds(10, 20, 80, 25); 
	    panell.add(titolAlies);
	    
	    JTextField alies = new JTextField();
	    alies.setBounds(100,20,165,25);
	    panell.add(alies);
	    
	    JLabel titolCorreu = new JLabel ("Correu:");
	    titolCorreu.setBounds(10,50,80,25);
	    panell.add(titolCorreu);
	    
	    JTextField correu = new JTextField();
	    correu.setBounds(100, 50, 165, 25);
	    panell.add(correu);
	    
	    JLabel titolPostal = new JLabel ("Codi Postal:");
	    titolPostal.setBounds(10, 50, 80, 25);
	    panell.add(titolPostal);
	    
	    JTextField cPost = new JTextField();
	    cPost.setBounds(100, 50, 165, 25);
	    panell.add (cPost);
	    
	   		    
	    JButton acceptar = new JButton("Acceptar");
	    acceptar.setBounds(10, 80, 80, 25);
	    panell.add(acceptar);
	    
	    registrat.add(panell, BorderLayout.CENTER);
	    JPanel botons = new JPanel(new FlowLayout());
	    BotoAcceptarActionListener accioBoto = new BotoAcceptarActionListener (alies, correu, cPost);
	    acceptar.addActionListener(accioBoto);
	    botons.add(acceptar);
	    registrat.add(botons, BorderLayout.SOUTH);
		registrat.setVisible(true);
		
		return new Usuaris();
	 }
	 
	 private Usuaris IniciaSessio (LlistaUsuaris llistaUser) {
		 
		String [] opcions = {"Registra't", "Ja tinc un compte"};
		boolean error = false;
			
		int resultat = JOptionPane.showOptionDialog(null, 
					   "Benvingut! Registra't o ja tens compte", "Plataforma d'intercanvi", 
					   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
					   null, opcions, 
					   0);
			
		 if (resultat == JOptionPane.NO_OPTION) {
			boolean sortir=false;
			int intents=0;
			while (!error && !sortir){
				String nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
				while (nom == null || nom.equals("")) {
					// Missatge d'error.
					JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
					nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
				}				
				try
				{
					if (llistaUser.comprovaUsuari(nom)) {
						error=true;
						usuari = llistaUser.trobaUsuari(nom).copia();
					}
					else{
						throw new NoEsTrobaException ();
					}
							
						
				}
				catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "No s'ha pogut trobar el teu usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
						
					if (intents==2)
					{
						String [] opcions1 = {"Si", "No"};
						int resultat1 = JOptionPane.showOptionDialog(null, 
										"Vols Sortir?", "", 
										JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
										null, opcions1, 
										0);
						if (resultat1==JOptionPane.YES_OPTION)
						{
							sortir=true;
							setVisible(false);
						}
					}
					intents++;
				}
				catch (NoEsTrobaException e) {
					JOptionPane.showMessageDialog(null, "No s'ha pogut trobar el teu usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
						
					if (intents==2)
					{
						String [] opcions1 = {"Si", "No"};
						int resultat1 = JOptionPane.showOptionDialog(null, 
										"Vols Sortir?", "", 
										JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
										null, opcions1, 
										0);
						if (resultat1==JOptionPane.YES_OPTION)
						{
							sortir=true;
							setVisible(false);
						}
						else
							intents=0;
					}
					intents++;
				}
			}
		}
		else{
			if (resultat == JOptionPane.YES_OPTION) {
				usuari= preguntarDades();
			}
			else{
					 
			}
		}
		return usuari;
	 }
	
	private void finestraPrincipal () {
		 
	}
		 
		
	public static void main(String[] args) {
		LlistaUsuaris llistaUser = new LlistaUsuaris(100);
			
		new MainGrafic(llistaUser);
	
	}
	
}
		