package interficieGrafica;

import usuaris.LlistaUsuaris;

public class MainPrincipal {

	public static void main(String[] args) {
		LlistaUsuaris llistaUser = new LlistaUsuaris(100);
		
		MainGrafic finestra = new MainGrafic(llistaUser);

	}

}
