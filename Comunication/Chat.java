package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){

        AllTuring al = new AllTuring();

        String[] al22 = al.contraPolibio(4, "$EEGF$DHDFEG$DD");

        Auxiliar.printArray(al22);

        Emisor em = new Emisor("1234");

        em.switchAvailable();

        em.setMensaje("GRECIA");

        String[] polibio = em.cifradoDePolibioM(4);

        Auxiliar.printArray(polibio);




    }

}
