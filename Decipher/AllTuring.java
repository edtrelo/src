package Decipher;

import Auxiliar.Auxiliar;

import java.util.Scanner;

public class AllTuring {

    public String[] jumpToN(int clave, String palabra){
        //Nos aseguramos que la clave sea mayor a cero.
        while(clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        boolean isKeyEven = Auxiliar.isEven(clave);

        String[] palabraDecifrada;

        if(Auxiliar.isEven(palabra.length())){
            palabraDecifrada = new String[palabra.length()/2];

        }else {
            if(isKeyEven){
                palabraDecifrada = new String[(palabra.length()+1)/2];
            }else {
                palabraDecifrada = new String[(palabra.length()-1)/2];
            }
        }


        if(isKeyEven) {
            for (int x = 0; x < palabra.length() / 2; x++) {
                palabraDecifrada[x] = String.valueOf(palabra.charAt(2 * x));
            }
        } else{
            for (int x = 0; x < palabra.length() / 2; x++) {
                palabraDecifrada[x] = String.valueOf(palabra.charAt((2 * x) + 1));
            }
        }

        return palabraDecifrada;

    }
    
}
