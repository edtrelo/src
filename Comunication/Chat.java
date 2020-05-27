package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor emisor = new Emisor("1234");
        emisor.switchAvailable();
        emisor.setMensaje("Hola Mund*");

        String [] cifrado = emisor.cMorse(3);

        Auxiliar.printArray(cifrado);

        AllTuring decifrador = new AllTuring();

        String[] decifrdo = decifrador.goTesla(".... --- .-.. ...-- .- / -- ..- -. -.. *");

        Auxiliar.printArray(decifrdo);

    }

}
