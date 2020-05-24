package Decipher;

import Auxiliar.Auxiliar;
import com.sun.jdi.event.StepEvent;

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

    //Sobrecarga del método jumToN
    public String[] jumpToN(int clave, String [] palabraComoString){

        //Transformamos el arreglo a un string
        String palabra = Auxiliar.gimmeWord(palabraComoString);

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

        //Con este pedazo de código nos deshacemos de los símbolos de la palabra para poder operarla.
        String palabraSinSimbolos = "";

        for(int x = 0; x < palabra.length(); x++){
            //Sí el símbolo está en el abecedario son la W entonces lo agregamos a palabraSinSimbolos
            if(Auxiliar.isInThere(palabra.charAt(x))){
                palabraSinSimbolos += String.valueOf(palabra.charAt(x));
            }
        }

        //-----------------------------------------------------------------------------------------------

        //Pasamos la palabra a mayúsculas si es que no lo está
        if(!Auxiliar.isUpperCase(palabraSinSimbolos)){
            palabraSinSimbolos = palabraSinSimbolos.toUpperCase();
        }

        String[] abecedario25 = {"A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};

        String matrizLetras [][] = { {"A","B","C","D","E"},{"F","G","H","I","J"},
                {"K","L","M","N","O"}, {"P","Q","R","S","T"},
                {"U","V","X","Y","Z"}};

        //Como en la matriz remplazamos la W por la X, tenemos que remplazar todas las W's de la palabra
        palabra = palabra.replace('W', 'X');

        //Creamos el arreglo que contendrá a las letras que forman la clave
        String[] arregloClave = new String[5];

        //Relleno el arreglo que va a contener los indices de la tabla
        for(int x = 0; x < 5; x++){
            //El arreglo se va a recorrer según la clave
            arregloClave[x] = abecedario25[(x + clave-1)%25];
        }
        //---------------------------------------------------------------------------------------------------

        //Verificar que la palabra sin símbolos sea par:
        boolean isWordEven = Auxiliar.isEven(palabraSinSimbolos.length());

        //Si sí lo es, proseguimos. Si no, no tiene sentido hacerlo, sobrará una letra y ¿cómo saber cuál es?

        String palabraDecodificada = "";

        //Este es el arreglo de strings que vamos a regresar
        String [] palabraToReturn;

        if(isWordEven){

            for(int x = 0; x < palabraSinSimbolos.length(); x+=2){
                //Condición para verificar que ambas letras estén en el arreglo de la clave
                if(Auxiliar.isInThere(palabraSinSimbolos.charAt(x)) & Auxiliar.isInThere(palabraSinSimbolos.charAt(x+1))){
                    int a = Auxiliar.gimmeIndex(String.valueOf(palabraSinSimbolos.charAt(x)),arregloClave);
                    int b = Auxiliar.gimmeIndex(String.valueOf(palabraSinSimbolos.charAt(x+1)),arregloClave);
                    palabraDecodificada = palabraDecodificada + matrizLetras[a][b];
                }else{
                    palabraDecodificada = " ";
                }
            }

            /*Para poder sistituir los símbolos en la posición correcta haremos esto:
            1. Dejamos los símbolos donde están.
            2. Consideramos las parejas de latras (están siempre están en parres), la primer letra la dejmos y la segunda
               la remplazamos por un espacio en blanco.
            */

            String [] palabraConHuecos = new String[palabra.length()];

            //Esta variable auxiliar nos ayudará a recorrer la palabra
            int z = 0;

            while(z< palabra.length()){
                //Si la caractér es un símbolo
                if(!Auxiliar.isInThere(palabra.charAt(z))){
                    //Lo dejamos en la misma posición
                    palabraConHuecos[z] = String.valueOf(palabra.charAt(z));
                    //Los símbolos los consideramos de uno en uno
                    z++;
                }else{ //Si el caracter es una letra
                    //La primera letra la dejamos igual
                    palabraConHuecos[z] = String.valueOf(palabra.charAt(z));
                    if(Auxiliar.isInThere(palabra.charAt(z+1))){
                        palabraConHuecos[z+1] = " ";
                    }else {
                        palabraConHuecos[z+1] = String.valueOf(palabra.charAt(z+1));
                    }
                    //Vamos avanzando por pares
                    z+=2;
                }
            }

            //No ayudará a crear la palabra sustituida
            String palabraFinal = "";

            for(int x = 0; x < palabraConHuecos.length; x++){
                //Vamos a eliminar los espacios
                if(!String.valueOf(palabraConHuecos[x]).equalsIgnoreCase(" ")){
                    palabraFinal = palabraFinal + palabra.charAt(x);
                }
            }

            //Nos ayudará a recorrer la palabraDecodificada
            int y = 0;

            //Creamos este array para poder sustituir lo que hemos decodificado por lo que teníamos
            char [] papa = palabraFinal.toCharArray();

            for(int x = 0; x < palabraFinal.length(); x++){
                //Solo sustituimos los que no son símbolos
                if(Auxiliar.isInThere(palabraFinal.charAt(x))){
                    papa[x] = palabraDecodificada.charAt(y);
                    y++;
                }
            }

            palabraToReturn = new String[papa.length];

            //Transformamos los chars en Strings
            for(int x = 0; x < palabraToReturn.length; x++){
                //Si la palabra no era mayúsculas, la haremos mayúsculas
                if(!Auxiliar.isUpperCase(palabraSinSimbolos)){
                    if(Auxiliar.isInThere(papa[x])){
                        palabraToReturn[x] = String.valueOf(papa[x]).toLowerCase();
                    }else{
                        palabraToReturn[x] = String.valueOf(papa[x]);
                    }
                }else{
                    palabraToReturn[x] = String.valueOf(papa[x]);
                }
            }

            return palabraToReturn;
        }else {

            //Este es el caso en que la palabra sin símbolos no es par, o sea no podemos formar parejas

            palabraToReturn = new String[1];

            palabraToReturn[1] = " ";

            return palabraToReturn;
        }

    }

    //Sobrecarga del método contraPolibio
    public String[] contraPolibio(int clave, String [] palabraComoString){

        //Transformamos el arreglo a un string
        String palabra = Auxiliar.gimmeWord(palabraComoString);

        //Nos aseguramos que la clave sea mayor a cero.
        while(clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        //Con este pedazo de código nos deshacemos de los símbolos de la palabra para poder operarla.
        String palabraSinSimbolos = "";

        for(int x = 0; x < palabra.length(); x++){
            //Sí el símbolo está en el abecedario son la W entonces lo agregamos a palabraSinSimbolos
            if(Auxiliar.isInThere(palabra.charAt(x))){
                palabraSinSimbolos += String.valueOf(palabra.charAt(x));
            }
        }

        //-----------------------------------------------------------------------------------------------

        //Pasamos la palabra a mayúsculas si es que no lo está
        if(!Auxiliar.isUpperCase(palabraSinSimbolos)){
            palabraSinSimbolos = palabraSinSimbolos.toUpperCase();
        }

        String[] abecedario25 = {"A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};

        String matrizLetras [][] = { {"A","B","C","D","E"},{"F","G","H","I","J"},
                {"K","L","M","N","O"}, {"P","Q","R","S","T"},
                {"U","V","X","Y","Z"}};

        //Como en la matriz remplazamos la W por la X, tenemos que remplazar todas las W's de la palabra
        palabra = palabra.replace('W', 'X');

        //Creamos el arreglo que contendrá a las letras que forman la clave
        String[] arregloClave = new String[5];

        //Relleno el arreglo que va a contener los indices de la tabla
        for(int x = 0; x < 5; x++){
            //El arreglo se va a recorrer según la clave
            arregloClave[x] = abecedario25[(x + clave-1)%25];
        }
        //---------------------------------------------------------------------------------------------------

        //Verificar que la palabra sin símbolos sea par:
        boolean isWordEven = Auxiliar.isEven(palabraSinSimbolos.length());

        //Si sí lo es, proseguimos. Si no, no tiene sentido hacerlo, sobrará una letra y ¿cómo saber cuál es?

        String palabraDecodificada = "";

        //Este es el arreglo de strings que vamos a regresar
        String [] palabraToReturn;

        if(isWordEven){

            for(int x = 0; x < palabraSinSimbolos.length(); x+=2){
                //Condición para verificar que ambas letras estén en el arreglo de la clave
                if(Auxiliar.isInThere(palabraSinSimbolos.charAt(x)) & Auxiliar.isInThere(palabraSinSimbolos.charAt(x+1))){
                    int a = Auxiliar.gimmeIndex(String.valueOf(palabraSinSimbolos.charAt(x)),arregloClave);
                    int b = Auxiliar.gimmeIndex(String.valueOf(palabraSinSimbolos.charAt(x+1)),arregloClave);
                    palabraDecodificada = palabraDecodificada + matrizLetras[a][b];
                }else{
                    palabraDecodificada = " ";
                }
            }

            /*Para poder sistituir los símbolos en la posición correcta haremos esto:
            1. Dejamos los símbolos donde están.
            2. Consideramos las parejas de latras (están siempre están en parres), la primer letra la dejmos y la segunda
               la remplazamos por un espacio en blanco.
            */

            String [] palabraConHuecos = new String[palabra.length()];

            //Esta variable auxiliar nos ayudará a recorrer la palabra
            int z = 0;

            while(z< palabra.length()){
                //Si la caractér es un símbolo
                if(!Auxiliar.isInThere(palabra.charAt(z))){
                    //Lo dejamos en la misma posición
                    palabraConHuecos[z] = String.valueOf(palabra.charAt(z));
                    //Los símbolos los consideramos de uno en uno
                    z++;
                }else{ //Si el caracter es una letra
                    //La primera letra la dejamos igual
                    palabraConHuecos[z] = String.valueOf(palabra.charAt(z));
                    if(Auxiliar.isInThere(palabra.charAt(z+1))){
                        palabraConHuecos[z+1] = " ";
                    }else {
                        palabraConHuecos[z+1] = String.valueOf(palabra.charAt(z+1));
                    }
                    //Vamos avanzando por pares
                    z+=2;
                }
            }

            //No ayudará a crear la palabra sustituida
            String palabraFinal = "";

            for(int x = 0; x < palabraConHuecos.length; x++){
                //Vamos a eliminar los espacios
                if(!String.valueOf(palabraConHuecos[x]).equalsIgnoreCase(" ")){
                    palabraFinal = palabraFinal + palabra.charAt(x);
                }
            }

            //Nos ayudará a recorrer la palabraDecodificada
            int y = 0;

            //Creamos este array para poder sustituir lo que hemos decodificado por lo que teníamos
            char [] papa = palabraFinal.toCharArray();

            for(int x = 0; x < palabraFinal.length(); x++){
                //Solo sustituimos los que no son símbolos
                if(Auxiliar.isInThere(palabraFinal.charAt(x))){
                    papa[x] = palabraDecodificada.charAt(y);
                    y++;
                }
            }

            palabraToReturn = new String[papa.length];

            //Transformamos los chars en Strings
            for(int x = 0; x < palabraToReturn.length; x++){
                //Si la palabra no era mayúsculas, la haremos mayúsculas
                if(!Auxiliar.isUpperCase(palabraSinSimbolos)){
                    if(Auxiliar.isInThere(papa[x])){
                        palabraToReturn[x] = String.valueOf(papa[x]).toLowerCase();
                    }else{
                        palabraToReturn[x] = String.valueOf(papa[x]);
                    }
                }else{
                    palabraToReturn[x] = String.valueOf(papa[x]);
                }
            }

            return palabraToReturn;
        }else {

            //Este es el caso en que la palabra sin símbolos no es par, o sea no podemos formar parejas

            palabraToReturn = new String[1];

            palabraToReturn[1] = " ";

            return palabraToReturn;
        }

    }

    public String[] cesarFall(int clave, String palabra){

        //Nos aseguramos que la clave sea mayor a cero.
        while (clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        String letrasCesar[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int claveCesar = clave % 27;
        char [] palabraComoArreglo = palabra.toCharArray();
        String[] cesarDecodificado= new String[palabra.length()];

        for (int x = 0; x < palabra.length(); x++) {
            for (int y = 0; y < letrasCesar.length; y++) {
                if (String.valueOf(palabraComoArreglo[x]).equalsIgnoreCase(letrasCesar[y])) {
                    cesarDecodificado[x] = letrasCesar[(y - claveCesar) % 27];
                }
            }
        }

        //Esto soluciona lo de los símbolos y espacios
        for (int x = 0; x < cesarDecodificado.length; x++) {
            if (cesarDecodificado[x] == null) {
                cesarDecodificado[x] = String.valueOf(palabra.charAt(x));
            }
        }

        //Volvemos a transformar  a minúsulas
        if (!Auxiliar.isUpperCase(palabra)) {
            for(int x = 0; x < cesarDecodificado.length; x++) {
                if(!Auxiliar.isInThere(palabra.charAt(x))){
                    cesarDecodificado[x] = String.valueOf(palabra.charAt(x));
                }else{
                    cesarDecodificado[x] = cesarDecodificado[x].toUpperCase();
                }
            }
        }

        return cesarDecodificado;
    }

    //Sobrecarga del método cesarFall
    public String[] cesarFall(int clave, String [] palabraComoString){

        //Transformamos el arreglo a un string
        String palabra = Auxiliar.gimmeWord(palabraComoString);

        //Nos aseguramos que la clave sea mayor a cero.
        while (clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        String letrasCesar[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int claveCesar = clave % 27;
        char [] palabraComoArreglo = palabra.toCharArray();
        String[] cesarDecodificado= new String[palabra.length()];

        for (int x = 0; x < palabra.length(); x++) {
            for (int y = 0; y < letrasCesar.length; y++) {
                if (String.valueOf(palabraComoArreglo[x]).equalsIgnoreCase(letrasCesar[y])) {
                    cesarDecodificado[x] = letrasCesar[(y - claveCesar) % 27];
                }
            }
        }

        //Esto soluciona lo de los símbolos y espacios
        for (int x = 0; x < cesarDecodificado.length; x++) {
            if (cesarDecodificado[x] == null) {
                cesarDecodificado[x] = String.valueOf(palabra.charAt(x));
            }
        }

        //Volvemos a transformar  a minúsulas
        if (!Auxiliar.isUpperCase(palabra)) {
            for(int x = 0; x < cesarDecodificado.length; x++) {
                if(!Auxiliar.isInThere(palabra.charAt(x))){
                    cesarDecodificado[x] = String.valueOf(palabra.charAt(x));
                }else{
                    cesarDecodificado[x] = cesarDecodificado[x].toUpperCase();
                }
            }
        }

        return cesarDecodificado;
    }

}
