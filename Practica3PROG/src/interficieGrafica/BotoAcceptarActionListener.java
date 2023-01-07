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

public class BotoAcceptarActionListener implements ActionListener {

	private LlistaUsuaris llistaUser;
	private JFrame registrar;
	private JTextField usuari;
	private JTextField correu;
	private JTextField cPost;
	private boolean registrat;
	private JFrame ventana;
	
	public BotoAcceptarActionListener (JFrame ventana, LlistaUsuaris llistaUser, JFrame registrarse, JTextField usuari, JTextField correu, JTextField cPost) {
		this.ventana=ventana;
		this.llistaUser=llistaUser;
		this.registrar=registrarse;
		this.usuari=usuari;
		this.correu=correu;
		this.cPost=cPost;
		registrat=false;
	}
	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		
		try {
			
			if (usuari.getText().equals("") || correu.getText().equals("")|| cPost.getText().equals("") ||
					usuari.getText().equals(null) || correu.getText().equals(null) || cPost.getText().equals(null)) {
	
					JOptionPane.showMessageDialog(null, "Introdueix dades, no les deixis en blanc!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else
			{

					int cPostInt = Integer.parseInt(cPost.getText());
					if (llistaUser.comprovaUsuari(usuari.getText())) {
						throw new NoEsTrobaException();
					}
					Usuaris nou = new Usuaris (usuari.getText(), correu.getText(), cPostInt);
					registrat=true;
					llistaUser.donaAlta(nou);
					MainGrafic.usuari=nou;
					//System.out.println(nouUsuari.toString());
					registrar.setVisible(false);
					//si tot va be
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
	

	
	public boolean getRegistrat() {
		return registrat;
	}
	public LlistaUsuaris getLlistaUser() {
		return llistaUser;
	}
}
	


