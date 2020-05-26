package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor em = new Emisor("1234");
        em.switchAvailable();
        em.setMensaje("Hola$");

        String [] emoticones = em.cifradoCesarEmoji(8);
        Auxiliar.printArray(emoticones);

        String [] cesarin = em.cifradoCesar(8);
        String [] enigma = em.enigma(4);
        Auxiliar.printArray(enigma);

        AllTuring al = new AllTuring();

        String [] dec = al.cesarEmojiFall(35, emoticones);

        String [] dul = al.cesarFall(8, cesarin);

        String [] hue = al.bombe(4, "Hola$");

        Prueba_cMorse prueba = new Prueba_cMorse();

        String [] morse = prueba.cMorse("Pr ueñba");

        Auxiliar.printArray(morse);

        System.out.println(morse[2]);

    }

}
