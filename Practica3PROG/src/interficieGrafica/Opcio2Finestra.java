package interficieGrafica;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;

public class Opcio2Finestra extends JFrame {
	
	public Opcio2Finestra (LlistaBens llistaBe, LlistaServeis llistaServ, JFrame finestraP) {
		
		this.setVisible(true);
		//posem la finestra visible
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //donem acces a l'usuari a poder tancar la finestra clickant a la creu
	    this.setSize(1250,630);
	    //configurem la mida de a finestra
	    this.setLayout (new FlowLayout());
	    //posem la finestra amb FlowLayout
	    this.setLocation(400, 150);
	    
	    JButton b1 = new JButton();
	    //creem un boto ok per quan l'usuari el premi quan hagi acabat de mirar la llista
	    b1.setText("OK");
	    //posem el text ok
	    b1.setSize (30, 30);
	    //posem la mida del boto
	    Opcio2ActionListenerBotoOk accio2 = new Opcio2ActionListenerBotoOk(finestraP, this);
	    //creem l'accionlistener del boto
	    b1.addActionListener(accio2);
	    //l'afegim al boto
		JTextArea panellText = new JTextArea();
		//creem el panell de text que sera un JTextArea
		panellText.setText("\n" + llistaBe.llistaBensNoIntercanvia().toString() + "\n\n" + llistaServ.llistaServeisActiu().toString() + "\n");
		//imprimim les llistes amb les ofertes actives
		panellText.setEditable(false);
		//posem que el panell no es pugui editar
		this.add(panellText);
		this.add(b1); 
		//per ultim, afegim el panell de text i el boto a la finestra
	}
}
