package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import dadesProductesServeis.LlistaBens;
import dadesProductesServeis.LlistaServeis;
import peticions.LlistaPeticions;
import peticions.Peticions;
import usuaris.Usuaris;

public class BotoAcceptarPeticionsActionListener implements ActionListener {

	private JTextField producAconse, producteOfere;
	private LlistaBens llistaBe;
	private LlistaServeis llistaServ;
	private LlistaPeticions llistaPet;
	private String userPet, userReb = " ";
	private int id;
	private boolean trobatBe = false, trobatServ = false, trobatOfeBe = false, trobatOfeServ = false;
	private JFrame finestraFrame, fines2;
	
	
	
	public BotoAcceptarPeticionsActionListener(JFrame fin2, JFrame fin, JTextField acon, JTextField ofe, LlistaBens llistaBen, LlistaServeis llistaServis, LlistaPeticions llistaPeti, String u) {
		
		this.producAconse = acon;
		this.producteOfere = ofe;
		this.llistaBe = llistaBen;
		this.llistaServ = llistaServis;
		this.llistaPet = llistaPeti;
		this.userPet = u;
		this.finestraFrame = fin;
		this.fines2 = fin2;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		
		llistaBe = llistaBe.llistaBensNoIntercanvia();
		llistaServ = llistaServ.llistaServeisActiu();
		
		trobatOfeBe = llistaBe.comprovaBe(userPet, producteOfere.getText());
		trobatOfeServ = llistaServ.comprovaServei(userPet, producteOfere.getText());
		
		if ((producAconse.getText().equals("") || producteOfere.getText().equals("") ||
			producAconse.getText().equals(null) || producteOfere.getText().equals(null)) ) {
			JOptionPane.showMessageDialog(null, "Introdueix dades, no les deixis en blanc!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{	
			if(trobatOfeBe == false && trobatOfeServ == false){
				JOptionPane.showMessageDialog(null, "Introdueix un producte que puguis canviar!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				trobatBe = llistaBe.comprovaBeSenseUsuari(userPet, producAconse.getText());
				trobatServ = llistaServ.comprovaServeiSenseUsuari(userPet, producAconse.getText());
				if(trobatBe == false && trobatServ == false) {
					JOptionPane.showMessageDialog(null, "Assegurat que el producte esta diponible per fer el canvi!", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
				else {
					finestraFrame.setVisible(false);
					JOptionPane.showMessageDialog(null, "S'ha afegit la peticio!", "Felicictats!", JOptionPane.INFORMATION_MESSAGE);
					fines2.setVisible(true);
					id = llistaPet.idSeguentPeticio();
					if(trobatBe == true) {
						userReb = llistaBe.comprovaBeSenseUsuariStr(userPet, producAconse.getText());
					}
					if(trobatServ == true) {
						userReb = llistaServ.comprovaServeiSenseUsuariStr(userPet, producAconse.getText());
					}
					Peticions p = new Peticions(id, userPet, userReb, producAconse.getText(), producteOfere.getText());
					llistaPet.afegirPeticio(p);
					try {
						BufferedWriter w=new BufferedWriter(new FileWriter("dadesPeticions.txt", true));//Anar al final del document 
						String frase = "";
						frase = p.getIdPeticio()+";"+p.getUserPeticio()+";"+p.getUserRebPet()+";"+p.getProducAcons()+";"+p.getProducOfe();
						//System.out.println(frase);
						w.newLine();
						w.write(frase);
						w.close();
					}
					catch(FileNotFoundException x) {
						System.out.println("L'arxiu d'entrada no existeix");
					}
					catch(IOException x) {
						System.out.println("S'ha produit un error en els arxius");
					}
				}
			
			}
		}
		
	}
}
