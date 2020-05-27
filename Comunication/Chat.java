package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.AllTuring;

public class Chat {
	
    public static void main(String[] args){


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        Emisor emisor = new Emisor("1234");
        emisor.switchAvailable();
        emisor.setMensaje("Ya es mañana");

        String [] cifrado = emisor.cMorse(2);

        Auxiliar.printArray(cifrado);

        AllTuring decifrador = new AllTuring();

        String [] decifrado = decifrador.goTesla( "-.--  --...  .-  --  .-  .-  .-  -.  .-  ...  .  .  -.  -  .-.  .  -.  .-  .-..  .-  -  .-  .-.  .  .-");

        Auxiliar.printArray(decifrado);
=======
>>>>>>> 76e745c8ed1737b87b4ef193882c88c0fb179373
=======
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> 76e745c8ed1737b87b4ef193882c88c0fb179373
=======
>>>>>>> 76e745c8ed1737b87b4ef193882c88c0fb179373
    }

}
