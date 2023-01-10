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

import usuaris.LlistaUsuaris;

/**
 * Variables privads de la finestra IniciaSessio
 * @author chenc
 *
 */
public class IniciaSessio extends JFrame {
	
	private JLabel titolAlies;
	private JTextField alies;
	private JButton acceptar;
	private JPanel panell;
	private JLabel titol;
	
	/**
	 * Finestra per poder iniciar sessio
	 * @param ventana FinestraPrincipal, per poder tancarla just al iniciar aquesta finestra
	 * @param llistaUser Llista Usuaris on es guarden tots els usuaris
	 */
	public IniciaSessio (JFrame ventana, LlistaUsuaris llistaUser) {
		
		//Configuracio de la finestra
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,125);
		this.setVisible(true);
		this.setLocation(800, 450);
		
		//Creem un panell de 2 opcions y afegim tots els components aqui
	    panell = new JPanel(new GridLayout(1,1));
	    //Font
	    Font buttonFont = new Font("Roboto", Font.PLAIN, 16);
	    //Panell de text de l'usuari
	    titolAlies = new JLabel ("Usuari:");
	    titolAlies.setFont(buttonFont);
	    titolAlies.setBounds(10, 20, 80, 25);
	    panell.add(titolAlies);
	    
	    //Per poder introduir les credencials
	    alies = new JTextField();
	    alies.setBounds(100,20,165,25);
	    panell.add(alies);
	    
	    //Titol de la finestra
	    titol = new JLabel ("Iniciar Sessio:");
	    this.add(titol, BorderLayout.NORTH);
	    
	    //Boto d'acceptar
	    acceptar = new JButton("Acceptar");
	    acceptar.setBounds(10, 80, 80, 25);
	    panell.add(acceptar);
	    
	    //afegim el panell a la finestra IniciaSessio
	    this.add(panell, BorderLayout.CENTER);
	    JPanel botons = new JPanel(new FlowLayout());
	    
	    //Configurem l'acció del boto acceptar per poder iniciar Sessio
	    BotoAcceptarIniciarSessio accioBoto = new BotoAcceptarIniciarSessio (ventana, llistaUser, this, alies);
	    acceptar.addActionListener(accioBoto);
	    
	    //afegir el boto al borde sur
	    this.add(botons, BorderLayout.SOUTH);
	    botons.add(acceptar);
	
	    //Posar la finestra visible
	    setVisible(true);

	}
	


}
