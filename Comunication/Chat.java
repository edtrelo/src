package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor emisor = new Emisor("1234");
        emisor.switchAvailable();
        emisor.setMensaje("Ya ma1ñana se. entre&ga la tarea");

        String [] cifrado = emisor.cifradoCesarEmoji(3);

        Auxiliar.printArray(cifrado);

        AllTuring decifrador = new AllTuring();

        String [] decifrado = decifrador.cesarEmojiFall(3, cifrado);

        Auxiliar.printArray(decifrado);
    }

}
