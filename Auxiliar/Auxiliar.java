package Auxiliar;

public class Auxiliar {

    //Regresa true si el numero es par
    public static boolean isEven(int a){
        boolean isEven;

        if(a%2 == 0){
            isEven = true;
        }
        else {
            isEven = false;
        }

        return isEven;
    }

    //Método para imprimir arreglo char
    public static void printArray(char [] arreglo){
        for(int x = 0; x < arreglo.length; x++){
            System.out.print(arreglo[x]);
        }
        System.out.println("\n");
    }

    //Método para imprimir arreglo String
    public static void printArray(String [] arreglo){
        for(int x = 0; x < arreglo.length; x++){
            System.out.print(arreglo[x]);
        }
        System.out.println("\n");
    }

    public static void printArray(int [] arreglo){
        for(int x = 0; x < arreglo.length; x++){
            System.out.print(String.valueOf(arreglo[x])+ "\t");
        }
        System.out.println("\n");
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

    public static int gimmeIndex(String palabra, String [] array){

        int indice = 0;

        for(int x = 0; x < palabra.length(); x ++){
            for(int y = 0; y < array.length; y++){
                if(String.valueOf(palabra.charAt(x)).equalsIgnoreCase(array[y])){
                    indice = y;
                }else if(!Auxiliar.isInThere(palabra.charAt(x))){
                    indice = -1;
                }
            }
        }

        return indice;
    }

    //Regresa como un solo string, una cadena de strings
    public static String gimmeWord(String[] palabraArray){
        String palabra = "";

        for(int x = 0; x < palabraArray.length; x++){
            palabra = palabra + palabraArray[x];
        }

        return palabra;

    }

    //Recorre las posiciones de un array dado
    public static String[] recorreArray(String[] array){
        String temp = array[0]; //Este es el primer elemento y es el que pondremos al último
        for(int x = 0; x < array.length - 1; x++){
            array[x] = array[x+1]; //at index=0 put A[1]..and so on.
        }
        //Colocamos el primer elemento en el último lugar
        array[array.length-1] = temp;
        return array;
    }

    public static String[] retrasaArray(String[] array){
        String temp = array[array.length-1]; //Este es el primer elemento y es el que pondremos al último
        for(int x = array.length-1; x > 0; x--){
            array[x] = array[x-1]; //at index=0 put A[1]..and so on.
        }
        //Colocamos el primer elemento en el último lugar
        array[0] = temp;
        return array;
    }

    //Regresa si un símbolo está en el abecedario
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

    //Para verificar si un entero está en un arreglo de enteros
    public static boolean isInThere(int numero, int[] array){
        boolean isInThere = false;

        for (int element : array) {
            if (element == numero) {
                isInThere = true;
            }
        }

        return isInThere;
    }

    public static boolean isInThere(char a, String [] array){
        boolean isInThere = false;

        for (int x = 0; x < array.length; x++) {
            if (String.valueOf(a).equalsIgnoreCase(array[x])) {
                isInThere = true;
            }
        }

        return isInThere;
    }


}
