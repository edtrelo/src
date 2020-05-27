package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){



        Emisor emisor = new Emisor("1234");
        emisor.switchAvailable();
        emisor.setMensaje("Ya es mañana");

        String [] cifrado = emisor.cifradoCesarEmoji(3);

        Auxiliar.printArray(cifrado);

        AllTuring decifrador = new AllTuring();

        String [] decifrado = decifrador.cesarEmojiFall(3, "\uD83D\uDE01\uD83D\uDE03 \uD83D\uDE07\uD83D\uDE16 0\uD83D\uDE0F\uD83D\uDE03\uD83D\uDE11\uD83D\uDE03\uD83D\uDE10\uD83D\uDE03\n");

        Auxiliar.printArray(decifrado);

    }

}
