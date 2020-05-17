package Comunication;

import Auxiliar.*;
import Cipher.*;

public class Chat {
	
    public static void main(String[] args){

        Emisor emisor1 = new Emisor("123");
        emisor1.switchAvailable();
        emisor1.setMensaje("grecia");
        System.out.println(emisor1.getMensaje());

        String [] cif1 = emisor1.cifradoDePolibioM(25);
        String [] cif11 = emisor1.cifradoDePolibioM(1);

        Auxiliar.printArray(cif1);
        System.out.println("\n");
        Auxiliar.printArray(cif11);

        System.out.println("\n");

        char [] cif2 = emisor1.transposition(2);

        Auxiliar.printArray(cif2);

        String [] cif3 = emisor1.cifradoCesar(3);

        System.out.println("\n");
        Auxiliar.printArray(cif3);



    }

}
