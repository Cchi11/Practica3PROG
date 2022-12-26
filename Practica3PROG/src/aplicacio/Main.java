package aplicacio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

//import fitxers.LlistaUsuaris;
import usuaris.Usuaris;

public class Main {
	static Scanner teclat = new Scanner(System.in);
	
	public static void mostrarMenu () {
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Carregar les dades dels fitxers");
		System.out.println("\t2. Llistar les dades de qualsevol llista que tingueu definida");
		System.out.println("\t3. Llistar les ofertes de serveis que estan actives");
		System.out.println("\t4. Llistar els bens o productes fisics que estan disponibles");
		System.out.println("\t5. Afegir una nova oferta de serveis");
		System.out.println("\t6. Afegir un nou be o producte fisic a intercanviar");
		System.out.println("\t7. Afegir una nova peticio d’intercanvi");
		System.out.println("\t8. Acceptar o refusar una peticio d’intercanvi. Si s’accepta, s’ha d’afegir la valoració de les dues parts");
		System.out.println("\t9. Donar d’alta un nou usuari");
		System.out.println("\t10. Donar de baixa un be o producte fisic a intercanviar i eliminar-lo de la llista. Nomes es podra de donar de baixa si encara no s’ha fet cap intercanvi amb ell");
		System.out.println("\t11. Desactivar un servei. Aquest servei ja no estara operatiu pero no l’esborrem de les llistes");
		System.out.println("\t12. Mostrar les peticions d’intercanvi pendents de respondre");
		System.out.println("\t13. Mostrar les peticions d’intercanvi acceptades");
		System.out.println("\t14. Mostrar les peticions d’intercanvi refusades");
		System.out.println("\t15. Mostrar els usuaris que tenen valoracions en els seus intercanvis superiors a un llindar que indiqui l’usuari");
		System.out.println("\t16. Mostrar el servei del qual s’han fet més intercanvis i indicar el numero d’aquests");
		System.out.println("\t17. Sortir de l’aplicacio");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}
	
	//procediment
	public static void altaUsuari() {
			
		System.out.println ("Introdueix els següents camps: ");
			
		System.out.println ("Usuari:");
		String nom = teclat.nextLine();
			
		System.out.println ("Correu del usuari: ");
		String correu = teclat.nextLine();
		
		System.out.println ("Codi postal del usuari");
		String cPost = teclat.nextLine();
		int codiPost = Integer.parseInt(cPost);
		
		Usuaris objectToSerialize = new Usuaris(nom, correu, codiPost); 
		
	    try (FileOutputStream fos = new FileOutputStream("serialized_object.bin, true")) {         // Crea un flujo de salida de objetos a partir del flujo de salida de archivos
	    	try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	    		// Escribe la instancia de la clase serializable en el archivo
	            oos.writeObject(objectToSerialize);
	        }
	    }
	  	catch (IOException e) {
	  		System.out.println ("no");
	    }
	}
	
	public static void llegirFitxerSerial() {
		for (int i=0; i<3; i++) {
        try (FileInputStream fis = new FileInputStream("serialized_object.bin")) {
            // Crea un flujo de entrada de objetos a partir del flujo de entrada de archivos
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                // Lee la instancia serializada del archivo y la convierte a una instancia de la clase
                Usuaris ala = (Usuaris) ois.readObject();
                System.out.println (ala.getAlies());
            }
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println ("no2");
        }
		}
    }
	
	public static void main(String[] args) {
		altaUsuari();
		llegirFitxerSerial();
	}
}
