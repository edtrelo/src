package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor em = new Emisor("1234");

        em.switchAvailable();

        em.setMensaje("Hola$");

        String[] polibio = em.cifradoCesarEmoji(29);

        Auxiliar.printArray(polibio);

        AllTuring al = new AllTuring();

        String[] al22 = al.cesarFall(29, "IWCFCNCLCTC");

        Auxiliar.printArray(al22);


        String[] gg = em.HASH();

        Auxiliar.printArray(gg);





    }

}
