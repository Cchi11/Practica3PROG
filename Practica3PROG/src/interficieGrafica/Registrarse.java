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
import javax.swing.JTextField;

import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

/**
 * Clase de la finestra per poder registrarse
 * @author chenc
 *
 */
public class Registrarse extends JFrame {
	
	private JLabel titolAlies;
	private JLabel titolCorreu;
	private JTextField alies;
	private JTextField correu;
	private JLabel titolPostal;
	private JTextField cPost;
	private JButton acceptar;
	private JPanel panell;

	/**
	 * Constructor per poder crear la finestra Registrarse
	 * @param ventana
	 * @param llistaUser
	 */
	public Registrarse (JFrame ventana, LlistaUsuaris llistaUser) {
		
		//Configuracio de la finestra
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.setVisible(true);
		
		//Creem un panel de 3x2 components
	    panell = new JPanel(new GridLayout(3,2));
	    Font buttonFont = new Font("Roboto", Font.PLAIN, 16); 	    //Font
	    
	    //Crear les diferents components de text i afegirles al panell de 3x2
	    titolAlies = new JLabel ("Usuari:");
	    titolAlies.setFont(buttonFont);
	    titolAlies.setBounds(10, 20, 80, 25); 
	    panell.add(titolAlies);
	    
	    alies = new JTextField();
	    alies.setBounds(100,20,165,25);
	    panell.add(alies);
	    
	    titolCorreu = new JLabel ("Correu:");
	    titolCorreu.setFont(buttonFont);
	    titolCorreu.setBounds(10,50,80,25);
	    panell.add(titolCorreu);
	    
	    correu = new JTextField();
	    correu.setBounds(100, 50, 165, 25);
	    panell.add(correu);
	    
	    titolPostal = new JLabel ("Codi Postal:");
	    titolPostal.setFont(buttonFont);
	    titolPostal.setBounds(10, 50, 80, 25);
	    panell.add(titolPostal);
	    
	    cPost = new JTextField();
	    cPost.setBounds(100, 50, 165, 25);
	    panell.add (cPost);
	    
	    //Creacio del boto acceptar
	    acceptar = new JButton("Acceptar");
	    acceptar.setBounds(10, 80, 80, 25);
	    panell.add(acceptar);
	    
	    //afegir el panell a la finestra Registrarse
	    this.add(panell, BorderLayout.CENTER);
	    JPanel botons = new JPanel(new FlowLayout());
	    
	    //Crear l'accio pel boto de acceptar
	    BotoAcceptarActionListener accioBoto = new BotoAcceptarActionListener (ventana, llistaUser, this, alies, correu, cPost);
	    acceptar.addActionListener(accioBoto);
	    
	    //afegir el boto al panell y afegir el panell a la finestra registrarse
	    this.add(botons, BorderLayout.SOUTH);
	    botons.add(acceptar);
	
	    
	    setVisible(true);

	}
	

}
