package interficieGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;
import usuaris.Usuaris;

public class Opcio3Finestra extends JFrame {
	
	private JLabel textOfe;
	private JLabel TextAco;
	private JTextField producOfe;
	private JTextField producAco;

	private JButton acceptar;
	private JPanel panell;
	/**
	 * 	
	 * @param fines		Fienstre principal
	 * @param u	usuari
	 * @param llistaBe llisat be
	 * @param llistaServis llisat serveis
	 * @param llistaPeti llista peti
	 */
	public Opcio3Finestra(JFrame fines, Usuaris u, LlistaBens llistaBe, LlistaServeis llistaServis, LlistaPeticions llistaPeti) {
		super("Crear peticio");
		this.pack();
		this.setLocation(100, 200);
		this.setSize(500,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//Creem finestre
		this.add(new JLabel("Usuari: "+u.getAlies()), BorderLayout.NORTH);
		
		panell = new JPanel(new GridLayout(2,2));
	    Font buttonFont = new Font("Roboto", Font.PLAIN, 16);
	    
	    textOfe = new JLabel ("Producte que ofereixes:");
	    textOfe.setFont(buttonFont);
	    textOfe.setBounds(10,50,80,25);
	    panell.add(textOfe);
	    
	    producOfe = new JTextField();
	    producOfe.setBounds(100, 50, 165, 25);
	    panell.add(producOfe);
	    
	    TextAco = new JLabel ("Producte que vols aconseguir:");
	    TextAco.setFont(buttonFont);
	    TextAco.setBounds(10, 50, 80, 25);
	    panell.add(TextAco);
	    
	    producAco = new JTextField();
	    producAco.setBounds(100, 50, 165, 25);
	    panell.add (producAco);
	    
	    
	    acceptar = new JButton("Acceptar");
	    acceptar.setBounds(10, 80, 80, 25);
	    this.add(acceptar,BorderLayout.SOUTH);
	    
	    this.add(panell, BorderLayout.CENTER);
	    JPanel botons = new JPanel(new FlowLayout());
	    
	    //al donar boto de aceptar fa questa accio
	    BotoAcceptarPeticionsActionListener accioBoto = new BotoAcceptarPeticionsActionListener(fines, this, producAco, producOfe, llistaBe, llistaServis, llistaPeti, u.getAlies());
	    acceptar.addActionListener(accioBoto);
	    this.setVisible(true);
	
		}
}


