package interficieGrafica;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import peticions.Peticions;

/**
 * Clase per generar la finestra per imprimir informacio per pantalla de la peticio
 * @author Pol Regy
 *
 */
public class FinestraPeticioToString extends JFrame {
	
	/**
	 * Constructor de la finestra
	 * @param finestraP finestra opcio4
	 * @param p peticio a imprimir dades
	 */
	public FinestraPeticioToString (JFrame finestraP, Peticions p) {
		
		//Configuracio basica
		this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(950,120);
	    this.setLayout (new FlowLayout());
	    this.setLocation(400, 150);
	    
	    
	    JButton b1 = new JButton();
	    
	    //creem el panell de text que sera un JTextArea
		JTextArea panellText = new JTextArea();
		
		//imprimim les llistes amb les ofertes actives
		panellText.setText("\n" + p.toString()+ "\n");
		//posem que el panell no es pugui editar

		this.add(panellText);
		//Boto ok per poder tancar la finestra
		b1.setText("OK");
	    b1.setSize (30, 30);
	    //Reciclem codi per poder realitzar aquesta accio
	    Opcio2ActionListenerBotoOk accio2 = new Opcio2ActionListenerBotoOk(finestraP, this);
	    //creem l'accionlistener del boto
	    b1.addActionListener(accio2);
	    
	    this.add(b1);
		//per ultim, afegim el panell de text i el boto a la finestra
		}
}
