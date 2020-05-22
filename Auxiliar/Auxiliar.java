package Auxiliar;

import Decipher.AllTuring;

public class Auxiliar {

    //Método para imprimir arreglo char
    public static void printArray(char [] arreglo){
        for(int x = 0; x < arreglo.length; x++){
            System.out.print(arreglo[x]);
        }
    }

    //Método para imprimir arreglo String
    public static void printArray(String [] arreglo){
        for(int x = 0; x < arreglo.length; x++){
            System.out.print(arreglo[x]);
        }
    }

    public static void printArray(int [] arreglo){
        for(int x = 0; x < arreglo.length; x++){
            System.out.print(String.valueOf(arreglo[x])+ "\t");
        }
    }

    //Verificar si una palabra está en mayúsculas (toda la palabra)
    public static boolean isUpperCase(String string){
        char[] charArray = string.toCharArray();

        for(int i=0; i < charArray.length; i++){
            //if any character is not in upper case, return false
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }
        return true;
    }

    //Da el índice de cada letra según su posición en el abecedario
    public static int [] gimmeIndex(String palabra){

        String [] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int [] indices = new int[palabra.length()];

        for(int x = 0; x < palabra.length(); x ++){
            for(int y = 0; y < alfabeto.length; y++){
                if(String.valueOf(palabra.charAt(x)).equalsIgnoreCase(alfabeto[y])){
                    indices[x] = y;
                }else if(!Auxiliar.isInThere(palabra.charAt(x))){
                    indices[x] = -1;
                }
            }
        }

        return indices;
    }


    public static String gimmeWord(String[] palabraArray){
        String palabra = "";

        for(int x = 0; x < palabraArray.length; x++){
            palabra = palabra + palabraArray[x];
        }

        return palabra;

    }

    public static String[] recorreArray(String[] array){
        for(int x = 0; x < array.length; x++){
            array[x] = array[(x+1)%array.length];
        }
        return array;
    }

    public static boolean isInThere(char a){
        String [] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        boolean bul = false;

        for(int x = 0; x < alfabeto.length; x++){
            if(String.valueOf(a).equalsIgnoreCase(alfabeto[x]))
            bul = true;
        }

        return bul;
    }
}
