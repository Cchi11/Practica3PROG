package interficieGrafica;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;

public class Opcio2Finestra extends JFrame {
	
	public Opcio2Finestra (LlistaBens llistaBe, LlistaServeis llistaServ) {
		
		this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(1250,630);
	    
		JTextArea panellText = new JTextArea();
		panellText.setText(llistaBe.llistaBensNoIntercanvia().toString() + "\n\n" + llistaServ.llistaServeisActiu().toString());
		
		this.add(panellText, BorderLayout.CENTER);
		
	}
}
