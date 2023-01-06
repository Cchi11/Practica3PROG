package interficieGrafica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainGrafic extends JFrame {

	public MainGrafic() {
		// Demanar dades a l'usuari.
		String [] opcions = {"Registra't", "Ja tinc un compte"};
		int resultat = JOptionPane.showOptionDialog(null, 
				"Benvingut! Registra't o ja tens compte", "Plataforma d'intercanvi", 
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, opcions, 
				0);
		 if (resultat == JOptionPane.NO_OPTION) {
			 String nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
				while (nom == null || nom.equals("")) {
					// Missatge d'error.
					JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
					nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
				}
		 }
		 else
		 {
			 if (resultat == JOptionPane.YES_OPTION) {
				 
			 }
		 }
		
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
		 buttons[1].addActionListener(null);
		 buttons[2].setText("Consultar els intercanvis que ha fet l’usuari");
		 buttons[3].setText("Canviar el codi d’usuari que està utilitzant l’aplicació");
		 
		 for (int i = 0; i < buttons.length; i++) {
			    panellBotons.add(buttons[i]);
			}
			//afegim la matriu al centre de tot
			add(panellBotons, BorderLayout.CENTER);
		 
		 
		 
		 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(500, 500);
		 setVisible(true);
		 
		 
	}
	 public void preguntarDades() {
		   
		  }

	public static void main(String[] args) {
		new MainGrafic();

	}

}
	