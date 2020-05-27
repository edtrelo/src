package Comunication;

import Auxiliar.*;
import Cipher.*;
import Decipher.*;

import java.util.Scanner;
import java.util.SortedMap;

public class Chat {
	
    public static void main(String[] args){

        System.out.println("Bienvenido. Usted tiene la importante misión de enviar un mensaje decodificado. ");
        System.out.println("Primero, ingrese una contraseña que le permitiría realizar sus labores: ");

        Scanner scan = new Scanner(System.in);
        String contraseña = scan.nextLine();

        Emisor emisor = new Emisor(contraseña);
        emisor.switchAvailable();

        System.out.println("¿Qué mensaje desea decodificar? recuerde que usted podría acortar una guerra: ");
        String mensaje = scan.nextLine();
        emisor.setMensaje(mensaje);

        System.out.println("Seleccione un método para encriptar: ");
        System.out.println(" 1. transposition \n 2. cifradoPolibioM \n 3. cifradoCesar \n 4. cifradoCesarEmoji " +
                "\n 5. enigma \n 6. Hash \n 7. cMorse");
        int elección = scan.nextInt();


        System.out.println("¿Qué clave usará? Recuerde que esto cambiará la forma de codificación: ");
        int clave = scan.nextInt();

        while (!(elección>=1 && elección<=7)){
            System.out.println("Esa opción es inválida. Pruebe de nuevo. ");
            elección = scan.nextInt();
        }

        String [] codificado = {" "};

        switch (elección){
            case 1:
                codificado = Auxiliar.fromCharToString(emisor.transposition(clave));
                break;
            case 2:
                codificado = emisor.cifradoDePolibioM(clave);
                break;
            case 3:
                codificado = emisor.cifradoCesar(clave);
                break;
            case 4:
                codificado = emisor.cifradoCesarEmoji(clave);
                break;
            case 5:
                codificado = emisor.enigma(clave);
                break;
            case 6:
                codificado = emisor.HASH();
                break;
            case 7:
                codificado = emisor.cMorse(clave);
                break;
        }

        System.out.println("Este es su mensaje codificado: ");
        Auxiliar.printArray(codificado);
        System.out.println("Su trabajo aquí ha terminado. Adiós.");

        System.out.println("\nBienvenido. Han pasado varios días desde que alguien mandó un mensaje codificado y solo" +
                "usted puede desencriptarlo. ");

        System.out.println("Introduzca su nueva clave privada: ");

        String contraseñaReceptor = scan.nextLine();
        Receptor receptor = new Receptor(contraseñaReceptor);

        System.out.println("El mensaje ha desencriptar es el siguiente: ");
        Auxiliar.printArray(codificado);

        System.out.println("Por favor, ayúdenos a soucionar este problema. ");

    }

}
