package Comunication;

import Auxiliar.*;
import Cipher.*;

public class Chat {
	
    public static void main(String[] args){

        Emisor emisor1 = new Emisor("123");
        emisor1.switchAvailable();
        emisor1.setMensaje("Zip hola");
        System.out.println(emisor1.getMensaje());

        String [] cif1 = emisor1.cifradoDePolibioM(3);

        Auxiliar.printArray(cif1);

        char [] cif2 = emisor1.transposition(2);

        Auxiliar.printArray(cif2);

    }

}
