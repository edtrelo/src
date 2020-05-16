package Cipher;

import Comunication.*;

import java.util.*;

public class SuperEnigma {

	public void hola() {
		int a = 1+1;
	}
	public void sss() {
		String k="Hola como estas ";
	}
	
	
	//PRIMER MÉTODO DE ENCRIPTACIÓN

    String palabra = "TELEFONO";

    int largodelapalabra = palabra.length();

    char palabracomochar [] = palabra.toCharArray();

    for(int x1 = 0; x < largodelapalabra; x++){
        System.out.print(palabracomochar[x1] + "\t");
    }

    char letrasdelABC [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
    'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    char Arreglochido [] = new char[2*largodelapalabra-1];

    for(int x2 = 0; x < Arreglochido.length; x++){
        Random random = new Random();
        if (x2%2 == 0){
            Arreglochido[x2] = palabracomochar[x2/2];
        }
        if (x2%2 == 1){
            Arreglochido[x2] = letrasdelABC[random.nextInt(letrasdelABC.length)];
        }
    }

    System.out.println("\n");

    for(int x3 = 0; x < Arreglochido.length; x++){
        System.out.print(Arreglochido[x3] + "\t");
    }

    System.out.println("\n");


    //FIN DEL PRIMERO CODIFICADO

    //SEGUNDO MÉTODO DE CODIFICACIÓN

    String letras5x5 [][] = { {"A","B","C","D","E"},{"F","G","H","J","K"},{"L","M","N","O","P"},
            {"Q","R","S","T","U"},{"V","W","X","Y","Z"}};


    String clave [] = {"A","B","C","D","E"};

    String codificado [] = new String[largodelapalabra];

    for (int z = 0; z < largodelapalabra; z++){
        for(int x = 0; x < letras5x5.length; x++){
            for(int y = 0; y < letras5x5[x].length; y++){
                if (String.valueOf(palabracomochar[z]).equals("I")){
                    palabracomochar[z] = 'J';
                }
                if (String.valueOf(palabracomochar[z]).equals(letras5x5[x][y])){
                    codificado[z] = clave[x] + clave[y];
                }
            }
        }
    }

    for(int x4 = 0; x < codificado.length; x++){
        System.out.print(codificado[x4] + "\t");
    }

    //FIN DEL SEGUNDO CODIFICADO

    //TERCER CIFRADO CÉSAR

    System.out.println("\n");
    int clavecesar = 4;

    int clavechidacesar = clavecesar%26;

    String letrasCesar [] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",
            "Q","R","S","T","U","V","W","X","Y","Z"};

    String cesarcodificado [] = new String[largodelapalabra];

    for (int x5 = 0; x < largodelapalabra; x++){
        for (int y = 0; y < letrasCesar.length; y++) {
            if (String.valueOf(palabracomochar[x5]).equals(letrasCesar[y])) {
                cesarcodificado[x5] = letrasCesar[(y + clavechidacesar) % 26];
            }
        }
    }

    for (int x = 0; x < largodelapalabra; x++){
        System.out.print(cesarcodificado[x] + "\t");
    }
}	
}