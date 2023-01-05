package interficieGrafica;
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
	