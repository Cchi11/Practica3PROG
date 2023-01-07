package interficieGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import peticions.LlistaPeticions;
import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

public class Opcio2ActionListener implements ActionListener {

	private LlistaPeticions u;
	
	public Opcio2ActionListener(LlistaPeticions user) {
		this.u=user;
		
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(u.toString());
	}

}
