package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import usuaris.Usuaris;

public class BotoAcceptarActionListener implements ActionListener {

	private JTextField usuari;
	private JTextField correu;
	private JTextField cPost;
	private Usuaris nouUsuari;
	
	public BotoAcceptarActionListener (JTextField usuari, JTextField correu, JTextField cPost) {
		this.usuari=usuari;
		this.correu=correu;
		this.cPost=cPost;
	}
	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		
		try {
			
			if (usuari.getText().equals(" ") || correu.getText().equals(" ")|| cPost.getText().equals(" ") ||
					usuari.getText().equals(null) || correu.getText().equals(null) || cPost.getText().equals(null)) {
	
					JOptionPane.showMessageDialog(null, "Introdueix dades, no les deixis en blanc!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else
			{
				try
				{
					int cPostInt = Integer.parseInt(cPost.getText());
					Usuaris nou = new Usuaris (usuari.getText(), correu.getText(), cPostInt);
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Indica un codi postal correcte! Torna a intentar:", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		catch(NullPointerException ex1) {
			JOptionPane.showMessageDialog(null, "Usuari esta buit:", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
		
	

	public Usuaris getUsuari() {
		
		return nouUsuari.copia();
	}
	
}
	


