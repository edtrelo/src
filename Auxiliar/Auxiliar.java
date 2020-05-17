package Auxiliar;

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

}
