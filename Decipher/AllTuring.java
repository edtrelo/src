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

    public String[] contraPolibio(int clave, String palabra){

        //Nos aseguramos que la clave sea mayor a cero.
        while(clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        //Pasamos la palabra a mayúsculas
        palabra = palabra.toUpperCase();

        String[] abecedario25 = {"A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};

        String matrizLetras [][] = { {"A","B","C","D","E"},{"F","G","H","I","J"},
                {"K","L","M","N","O"}, {"P","Q","R","S","T"},
                {"U","V","X","Y","Z"}};

        palabra = palabra.replace('W', 'X');

        int simbolos = 0;

        for(int x = 0; x < palabra.length(); x++){
            if(!Auxiliar.isInThere(palabra.charAt(x))){
                simbolos = simbolos + 1;
            }
        }

        int[] indicesSimbolos = new int[simbolos];

        //Variable auxiliar para el loop
        int aux = 0;

        for (int y = 0; y < palabra.length(); y++){
            if(!Auxiliar.isInThere(palabra.charAt(y))){
                if(y%2 == 0){
                    indicesSimbolos[aux] = y/2;
                }else{
                    indicesSimbolos[aux] = (y+1)/2;
                }
                aux++;
            }
        }

        Auxiliar.printArray(indicesSimbolos);

        String palabraSinSimbolos = "";

        //me deshago de los símbolos
        for(int x = 0; x < palabra.length(); x++){
            if(Auxiliar.isInThere(palabra.charAt(x))){
                palabraSinSimbolos = palabraSinSimbolos + String.valueOf(palabra.charAt(x));
            }
        }

        String[] arregloClave = new String[5];

        //Relleno el arreglo que va a contener los indices de la tabla
        for(int x = 0; x < 5; x++){
            //El arreglo se va a recorrer según la clave
            arregloClave[x] = abecedario25[(x + clave-1)%25];
        }

        System.out.println(palabraSinSimbolos);

        String palabraDecodificada = "";

        //Verificar que la palabra sin símbolos sea par:
        boolean isWordEven = Auxiliar.isEven(palabraSinSimbolos.length());

        for(int x = 0; x < palabraSinSimbolos.length(); x+=2){
            //Condición para verificar que ambas letras estén en el arreglo de la clave
            if(Auxiliar.isInThere(palabraSinSimbolos.charAt(x)) & Auxiliar.isInThere(palabraSinSimbolos.charAt(x+1))){
                int a = Auxiliar.gimmeIndex(String.valueOf(palabraSinSimbolos.charAt(x)),arregloClave);
                int b = Auxiliar.gimmeIndex(String.valueOf(palabraSinSimbolos.charAt(x+1)),arregloClave);
                palabraDecodificada = palabraDecodificada + matrizLetras[a][b];
            }else{
                palabraDecodificada = "";
            }
        }

        System.out.println(palabraDecodificada);




        String[] hola = {"hola"};

        return hola;
    }
}
