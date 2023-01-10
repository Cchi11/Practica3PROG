package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;
import usuaris.Usuaris;

public class Opcio4ActionListener implements ActionListener  {


		private LlistaPeticions llistaPet;
		private Usuaris user;
		private JFrame finestra;
		
		public Opcio4ActionListener(JFrame fin, Usuaris usuariactual,  LlistaPeticions llistaPeti) {
			this.user=usuariactual;
			this.llistaPet = llistaPeti;
			this.finestra = fin; 
		}
		
		public void actionPerformed(ActionEvent e) {
			
			JButton b = (JButton) e.getSource();
			finestra.setVisible(false);
		

		}

		
	}


