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
 * Clase per implementar l'accio del boto acceptar de la finestra Registrarse
 * @author chenc
 *
 */
public class BotoAcceptarActionListener implements ActionListener {

	private LlistaUsuaris llistaUser;
	private JFrame registrar;
	private JTextField usuari;
	private JTextField correu;
	private JTextField cPost;
	private JFrame ventana;
	
	/**
	 * Pasar parametres pel constructor i guardarles en les nostres variables privades
	 * @param ventana FinestraRegistrarse
	 * @param llistaUser Llista d'usuaris on es guarden tots els usuaris
	 * @param usuari JTextField de la part de esciure usuari
	 * @param correu JTextField de la part de esciure correu
	 * @param cPost JTextField de la part de esciure cPost
	 */
	
	public BotoAcceptarActionListener (JFrame ventana, LlistaUsuaris llistaUser, JFrame registrarse, JTextField usuari, JTextField correu, JTextField cPost) {
		this.ventana=ventana;
		this.llistaUser=llistaUser;
		this.registrar=registrarse;
		this.usuari=usuari;
		this.correu=correu;
		this.cPost=cPost;
		
	}
	@Override
	
	/**
	 * Creacio de la accio
	 */
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		//Si al donarli al boto d'acceptar esta buit, mostrar Missatge d'error
		try {
			if (usuari.getText().equals("") || correu.getText().equals("")|| cPost.getText().equals("") ||
					usuari.getText().equals(null) || correu.getText().equals(null) || cPost.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "Introdueix dades, no les deixis en blanc!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else
			{
					//Intenta passar el codi postal a un int. Si l'usuari pasa caracters, mostra missatge d'error
				
					int cPostInt = Integer.parseInt(cPost.getText());
					
					//Si el nom d'usuari indicat es un nom que ja existerix, mostrar missatge d'error
					if (llistaUser.comprovaUsuari(usuari.getText())) {
						throw new NoEsTrobaException();
					}
					Usuaris nou = new Usuaris (usuari.getText(), correu.getText(), cPostInt);
				
					llistaUser.donaAlta(nou); //Afegeix a la llista l'usuari
					MainGrafic.usuari=nou; //Cambia la sessio del usuari actual pel nou registrat
					
					//si tot va be, amaga la finestra de registrarse y mostra la de la finestra principal
					registrar.setVisible(false);
					ventana.setVisible(true);
			}
		}
		catch (NumberFormatException ex)
		{
				JOptionPane.showMessageDialog(null, "Indica un codi postal correcte! Torna a intentar:", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Usuari esta buit:", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		catch(NoEsTrobaException ex) {
			JOptionPane.showMessageDialog(null, "Un usuari amb aquest Alies ja existeix!", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
}
	


