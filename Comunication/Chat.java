package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){

        AllTuring al = new AllTuring();

        String[] al22 = al.cesarFall(4, "$KYEHEO7ENEVE");

        Auxiliar.printArray(al22);

        Emisor em = new Emisor("1234");

        em.switchAvailable();

        em.setMensaje("GUADALAJARA");

        String[] polibio = em.cifradoCesar(4);

        Auxiliar.printArray(polibio);




    }

}
