package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


        Emisor emisor = new Emisor("1234");
        emisor.switchAvailable();
        emisor.setMensaje("YaMaaanaSeEntregaLaTarea");

        String [] cifrado = emisor.cMorse(27);

        Auxiliar.printArray(cifrado);

        AllTuring decifrador = new AllTuring();

        String [] decifrado = decifrador.goTesla( "-.--  --...  .-  --  .-  .-  .-  -.  .-  ...  .  .  -.  -  .-.  .  -.  .-  .-..  .-  -  .-  .-.  .  .-");

        Auxiliar.printArray(decifrado);
    }

}
