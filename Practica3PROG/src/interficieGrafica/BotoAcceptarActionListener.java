package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import usuaris.Usuaris;

public class BotoAcceptarActionListener implements ActionListener {

	JTextField usuari;
	JTextField correu;
	JTextField cPost;
	
	public BotoAcceptarActionListener (JTextField usuari, JTextField correu, JTextField cPost) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		
		if (usuari.getText().equals("") || correu.getText().equals("")|| cPost.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Introdueix dades, no les deixis en blanc!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		else
		{
			
		}
			
		}
	
		
	}
	


