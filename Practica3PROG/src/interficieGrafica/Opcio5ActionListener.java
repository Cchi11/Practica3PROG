package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Exceptions.NoEsTrobaException;
import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

public class Opcio5ActionListener implements ActionListener {
	
	private LlistaUsuaris llistaUser;
	private Usuaris user;
	
	public Opcio5ActionListener(LlistaUsuaris llistaUser, Usuaris usuariactual) {
		this.llistaUser=llistaUser;
		this.user=usuariactual;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		boolean error = false;
		
		boolean sortir=false;
		int intents=0;
		
		while (!error && !sortir){
			
			if (intents!=2)
			{
				String nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
				if (nom == null || nom.equals("")) {
					JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
					nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari");
				}				
				try
				{
					if (llistaUser.comprovaUsuari(nom)) {
						error=true;
						MainGrafic.usuari = llistaUser.trobaUsuari(nom).copia();
					}
					else{
						throw new NoEsTrobaException ();
					}
							
						
				}
				catch (NullPointerException ex1) {
					JOptionPane.showMessageDialog(null, "No s'ha pogut trobar el teu usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
				}	
				catch (NoEsTrobaException ex2) {
					JOptionPane.showMessageDialog(null, "No s'ha pogut trobar el teu usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			
			}
			else
			{
				String [] opcions1 = {"Si", "No"};
				int resultat1 = JOptionPane.showOptionDialog(null, 
								"Vols Sortir?", "", 
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								null, opcions1, 
								0);
				if (resultat1==JOptionPane.YES_OPTION)
					sortir=true;
				else
					intents=0;
			}
				
			intents++;
		}
	}


}
