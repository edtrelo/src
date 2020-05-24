package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor em = new Emisor("1234");

        em.switchAvailable();

        em.setMensaje("Zoologico");

        String[] polibio = em.cifradoCesar(3);

        String[] eneigma = em.enigma(2);

        Auxiliar.printArray(eneigma);

        Auxiliar.printArray(polibio);

        AllTuring al = new AllTuring();

        String[] al22 = al.cesarEmojiFall(29,
                "\uD83D\uDE08\uD83D\uDE17\uD83D\uDE02\uD83D\uDE05\uD83D" +
                        "\uDE02\uD83D\uDE0D\uD83D\uDE02\uD83D\uDE0B\uD83D\uDE02\uD83D\uDE14\uD83D\uDE02");

        Auxiliar.printArray(al22);

        String[] gg = em.HASH();

        Auxiliar.printArray(gg);


    }

}
