package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Exceptions.NoEsTrobaException;
import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

/**
 * Variables privades per poder pasar parametres per l'accio del boto de iniciar sessio
 * @author chenc
 *
 */
public class BotoAcceptarIniciarSessio implements ActionListener {
	
	private LlistaUsuaris llistaUser;
	private JFrame iniciar;
	private JTextField usuari;
	private JFrame finestraP;
	
	/**
	 * Pasar els parametres y guardarlos a les variables
	 * @param finP FinestraPrincipal (main grafic)
	 * @param llistaUser Llista d'usuaris on es guarden tots els usuaris
	 * @param iniciarSessio	La finestra de iniciarSessio
	 * @param usuari El component de text on l'usuari escriu les credencials
	 */
	public BotoAcceptarIniciarSessio (JFrame finP, LlistaUsuaris llistaUser, JFrame iniciarSessio, JTextField usuari) {
		this.finestraP=finP;
		this.llistaUser=llistaUser;
		this.usuari=usuari;
		this.iniciar=iniciarSessio;

		
	}
	@Override
	/**
	 * Accio del boto acceptar. Si li dona a acceptar i tot esta perfecte, canvia la sessio del usuari actual per el que acaba de posar
	 */
	public void actionPerformed (ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		try 
		{
			//Si el component del text esta buit a l'hora de clicar el boto, mostrar un missatge d'error
			if (usuari.getText().equals("") || usuari.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "Introdueix dades, no les deixis en blanc!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else
			{
				//Si el codi indicat, es un usuari existent, iniciar sessio
				
				if (llistaUser.comprovaUsuari(usuari.getText())) {
					
					Usuaris nou = llistaUser.trobaUsuari(usuari.getText()); //Retorna una copia del usuari trobat
					MainGrafic.usuari=nou; // Canvia la sessio del usuari actual
					
					iniciar.setVisible(false);
					finestraP.setVisible(true);
				}
				else
				{
					//Si l'usuari indicat no existeix, mostrar missatge d'error
					throw new NoEsTrobaException();
				}
			}
		}
		catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Ha hagut un problema al carregar les dades", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		catch(NoEsTrobaException ex) {
			JOptionPane.showMessageDialog(null, "No es troba aquest Usuari!", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	

}
