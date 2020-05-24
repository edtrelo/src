package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor em = new Emisor("1234");

        em.switchAvailable();

        em.setMensaje("Grecia");

        String[] polibio = em.cifradoCesarEmoji(29);

        Auxiliar.printArray(polibio);

        AllTuring al = new AllTuring();

        String[] al22 = al.cesarEmojiFall(29, "\uD83D\uDE08\uD83D\uDE14\uD83D\uDE06\uD83D\uDE04\uD83D\uDE0A\uD83D\uDE02");

        Auxiliar.printArray(al22);

        String[] gg = em.HASH();

        Auxiliar.printArray(gg);


    }

}
