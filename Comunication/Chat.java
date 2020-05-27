package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor em = new Emisor("1234");
        em.switchAvailable();
        em.setMensaje("Arkh&am");

        String [] emoticones = em.cifradoCesarEmoji(8);
        System.out.println("Este es el cifrado de la palabra: " + em.getMensaje() + " en método cesarEmoji:");
        Auxiliar.printArray(emoticones);

        String [] cesarin = em.cifradoCesar(8);
        String [] enigma = em.enigma(7);
        System.out.println("Este es el cifrado de la palabra: " + em.getMensaje() + " en método enigma:");
        Auxiliar.printArray(enigma);

        AllTuring al = new AllTuring();

        //String [] dec = al.cesarEmojiFall(35, emoticones);

        String [] dul = al.cesarFall(8, cesarin);

        String [] hue = al.bombe(7, Auxiliar.gimmeWord(enigma));
        System.out.println("Este es el decifrado de la palabra: " + Auxiliar.gimmeWord(enigma) + " cifrada en " +
                "método enigma: ");
        Auxiliar.printArray(hue);

    }

}
