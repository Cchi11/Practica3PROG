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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import usuaris.LlistaUsuaris;
import usuaris.Usuaris;


public class MainGrafic extends JFrame {
	private Usuaris usuari;

	public MainGrafic(LlistaUsuaris llistaUser) {
		setVisible(false);
		usuari = IniciaSessio(llistaUser);
		//setVisible(true);
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
		buttons[1].setText("Afegir una peticiÃ³ dâ€™intercanvi dâ€™alguna de les ofertes actives");
		Opcio2ActionListener opcio2 = new Opcio2ActionListener();
		buttons[1].addActionListener(opcio2);
<<<<<<< HEAD
		buttons[2].setText("Consultar els intercanvis que ha fet l'usuari");
		Opcio2ActionListener opcio3 = new Opcio2ActionListener();
		buttons[1].addActionListener(opcio3);
		buttons[3].setText("Canviar el codi d'usuari que esta  utilitzant lâ€™aplicaciÃ³");
=======
		buttons[2].setText("Consultar els intercanvis que ha fet l’usuari");
		buttons[3].setText("Canviar el codi d’usuari que està utilitzant l’aplicació");
		Opcio5ActionListener opcio5 = new Opcio5ActionListener(llistaUser, usuari);
		buttons[3].addActionListener(opcio5);
>>>>>>> 5b2824c435ed4b24b0ca1a21428b603bba98b78f
	
		JTextField titol = new JTextField();
		titol.setText("Indica quina opciÃ³ vols");
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
		//setVisible(true);
		 
	}

	 
<<<<<<< HEAD
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
=======
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
					
					if (intents!=2)
					{
						String nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
						if (nom == null || nom.equals("")) {
							/*if (nom == JOptionPane.CANCEL_OPTION)
							{
								break;
							}
							*/
							// Missatge d'error.
							JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
							nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
						}				
						try
						{
							if (llistaUser.comprovaUsuari(nom)) {
								error=true;
								usuari = llistaUser.trobaUsuari(nom).copia();
								setVisible(true);
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
						}
					
					}
					else
>>>>>>> 5b2824c435ed4b24b0ca1a21428b603bba98b78f
						{
							sortir=true;
							setVisible(false);
						}
<<<<<<< HEAD
						else
							intents=0;
					}
					intents++;
				}
			}
		}
		else{
			
			if (resultat == JOptionPane.YES_OPTION) {
				Registrarse finestraRegistrar = new Registrarse(this, llistaUser);
=======
						
					intents++;
				}
			}
			 
			else{
>>>>>>> 5b2824c435ed4b24b0ca1a21428b603bba98b78f
				
			}

		}
		return usuari;
	 }
}
		