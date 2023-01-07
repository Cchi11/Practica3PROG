package interficieGrafica;

import usuaris.LlistaUsuaris;
import usuaris.Usuaris;

public class MainPrincipal {

	public static void main(String[] args) {
		LlistaUsuaris llistaUser = new LlistaUsuaris(100);
		Usuaris usuari1 = new Usuaris ("chen", "ioqjeoi", 2365);
		llistaUser.donaAlta(usuari1);
		
		MainGrafic finestra = new MainGrafic(llistaUser);

	}

}
