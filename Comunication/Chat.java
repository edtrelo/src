package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor em = new Emisor("1234");
        em.switchAvailable();
        em.setMensaje("Guadalajara");

        String [] emoticones = em.cifradoCesarEmoji(8);
        Auxiliar.printArray(emoticones);

        String [] cesarin = em.cifradoCesar(8);

        AllTuring al = new AllTuring();

        String [] dec = al.cesarEmojiFall(35, emoticones);

        String [] dul = al.cesarFall(8, cesarin);

    }

}
