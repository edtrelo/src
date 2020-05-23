package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){

        AllTuring al = new AllTuring();

        String[] al22 = al.cesarFall(29, "IWCFCNCLCTC");

        Auxiliar.printArray(al22);

        Emisor em = new Emisor("1234");

        em.switchAvailable();

        em.setMensaje("GRECIA");

        String[] polibio = em.cifradoCesar(29);

        Auxiliar.printArray(polibio);

        String[] emjois = em.cifradoCesarEmoji(1);

        Auxiliar.printArray(emjois);
    }

}
