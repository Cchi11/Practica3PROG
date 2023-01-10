package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import usuaris.LlistaUsuaris;

/**
 * Clase per configurar l'accio del boto 5, el de canviar d'usuari
 * @author chenc
 *
 */
public class Opcio5ActionListener implements ActionListener {
	
	private LlistaUsuaris llistaUser;
	private JFrame finestraP;
	
	/**
	 * Pasem parametres y les guardem a les nostres variables
	 * @param finestraP Finestra principal (Interficie Grafica)
	 * @param llistaUser Llista d'usuaris on es guarden tots els usuaris
	 */
	public Opcio5ActionListener(JFrame finestraP, LlistaUsuaris llistaUser) {
		this.llistaUser=llistaUser;
		this.finestraP=finestraP;
	}

	/**
	 * Metode de accionar el boto5. Crea una instancia nova per poder iniciar sessio graficament
	 */
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		IniciaSessio canviarUsuari = new IniciaSessio (finestraP, llistaUser);
		//quan s'inicia, oculta la finestraPrincipal
		finestraP.setVisible(false);
	}


}
