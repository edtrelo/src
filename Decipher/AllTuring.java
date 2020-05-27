package Decipher;

import Auxiliar.Auxiliar;
import Cipher.Clavijero;
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
                    int recorrido = (y-claveCesar)%27;
                    if (recorrido < 0){
                        recorrido = recorrido + 27;
                    }
                    cesarDecodificado[x] = letrasCesar[recorrido];
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
                    int recorrido = (y-claveCesar)%27;
                    if (recorrido < 0){
                        recorrido = recorrido + 27;
                    }
                    cesarDecodificado[x] = letrasCesar[recorrido];
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

    public String[] cesarEmojiFall(int clave, String palabra){

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
        String[] cesarDecodificado= new String[palabra.length()/2];

        String [] emojisDelCesar = new String[27];

        //Creamos el arreglo con los primeros 27 emojis
        for(int x = 0; x < emojisDelCesar.length; x++) {
            int indice = x + 128512; //Es el número equvalente al primer emoji
            String hex = Integer.toHexString(indice);
            emojisDelCesar[x] = String.valueOf(Character.toChars(Integer.parseInt(hex, 16)));
        }

        //Aquí almacenaremos los emojis que forman la palabra
        //la longuitud es sobre dos porque cada dos caracteres forman un emoji
        String [] emojis = new String[palabra.length()/2];

        for (int x = 0; x < emojis.length; x++) {
            emojis[x] = new StringBuilder().appendCodePoint(
                    palabra.codePointAt(palabra.offsetByCodePoints(0, x))).toString();
        }

        //Creamos un arreglo para llenarlo de los hash codes de los emojis. Estos son los que usaremos para comparar
        int [] hashCodesPalabra = new int[emojis.length];

        for (int x = 0; x < hashCodesPalabra.length; x++) {
            hashCodesPalabra[x] = emojis[x].hashCode();
        }

        //Hacemos lo mismo con los emojis del Cesar
        int [] hashCodesEmojis = new int[emojisDelCesar.length];

        for (int x = 0; x < hashCodesEmojis.length; x++) {
            hashCodesEmojis[x] = emojisDelCesar[x].hashCode();
        }

        /*Verificamos cuáles hash codes coinciden y al emoji del arreglo de 27 con el que coincida, le asignamos
        el valor del arreglo del alfabeto que este en ese índice
         */
        for(int x = 0; x < hashCodesPalabra.length; x++){
            for (int y = 0; y < emojisDelCesar.length; y++){
                if(hashCodesPalabra[x] == hashCodesEmojis[y]){
                    int recorrido = (y-claveCesar)%27;
                    if(recorrido<0){
                        recorrido = recorrido + 27;
                    }
                    cesarDecodificado[x] = letrasCesar[recorrido];
                }
            }
        }

        Auxiliar.printArray(cesarDecodificado);

        //Esto soluciona lo de los símbolos y espacios
        for (int x = 0; x < cesarDecodificado.length; x++) {
            if (cesarDecodificado[x] == null) {
                cesarDecodificado[x] = String.valueOf(palabra.charAt(x));
            }
        }

        return cesarDecodificado;
    }

    //Sobrecarga del método cesarEmojiFall
    public String[] cesarEmojiFall(int clave, String[] palabraComoArray){

        String palabra = Auxiliar.gimmeWord(palabraComoArray);

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
        String[] cesarDecodificado= new String[palabra.length()/2];

        String [] emojisDelCesar = new String[27];

        //Creamos el arreglo con los primeros 27 emojis
        for(int x = 0; x < emojisDelCesar.length; x++) {
            int indice = x + 128512; //Es el número equvalente al primer emoji
            String hex = Integer.toHexString(indice);
            emojisDelCesar[x] = String.valueOf(Character.toChars(Integer.parseInt(hex, 16)));
        }

        //Aquí almacenaremos los emojis que forman la palabra
        //la longuitud es sobre dos porque cada dos caracteres forman un emoji
        String [] emojis = new String[palabra.length()/2];

        for (int x = 0; x < emojis.length; x++) {
            emojis[x] = new StringBuilder().appendCodePoint(
                    palabra.codePointAt(palabra.offsetByCodePoints(0, x))).toString();
        }

        //Creamos un arreglo para llenarlo de los hash codes de los emojis. Estos son los que usaremos para comparar
        int [] hashCodesPalabra = new int[emojis.length];

        for (int x = 0; x < hashCodesPalabra.length; x++) {
            hashCodesPalabra[x] = emojis[x].hashCode();
        }

        //Hacemos lo mismo con los emojis del Cesar
        int [] hashCodesEmojis = new int[emojisDelCesar.length];

        for (int x = 0; x < hashCodesEmojis.length; x++) {
            hashCodesEmojis[x] = emojisDelCesar[x].hashCode();
        }

        /*Verificamos cuáles hash codes coinciden y al emoji del arreglo de 27 con el que coincida, le asignamos
        el valor del arreglo del alfabeto que este en ese índice
         */
        for(int x = 0; x < hashCodesPalabra.length; x++){
            for (int y = 0; y < emojisDelCesar.length; y++){
                if(hashCodesPalabra[x] == hashCodesEmojis[y]){
                    int recorrido = (y-claveCesar)%27;
                    if(recorrido<0){
                        recorrido = recorrido + 27;
                    }
                    cesarDecodificado[x] = letrasCesar[recorrido];
                }
            }
        }

        Auxiliar.printArray(cesarDecodificado);

        //Esto soluciona lo de los símbolos y espacios
        for (int x = 0; x < cesarDecodificado.length; x++) {
            if (cesarDecodificado[x] == null) {
                cesarDecodificado[x] = String.valueOf(palabra.charAt(x));
            }
        }

        return cesarDecodificado;
    }

    public String[] bombe(int clave, String palabra){

        palabra = palabra.toUpperCase();

        String [] rotor1 = {"Q", "E", "Z", "I", "P", "L", "O", "F", "S", "N", "B", "J", "V", "U", "A", "Y", "G",
                "T", "H", "D", "C", "W", "R", "M", "X", "K"};

        String [] rotor2 = {"O", "J", "X", "G", "T", "V", "S", "D", "Q", "L", "Y", "E", "I", "A", "B", "P", "H",
                "W", "M", "F", "K", "U", "N", "C", "R", "Z"};

        String [] rotor3 = {"A", "N", "O", "V", "R", "E", "C", "G", "P", "U", "F", "S", "B", "K", "J", "T", "Y",
                "H", "I", "Z", "L", "M", "D", "X", "Q", "W"};

        String [] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        /*Los rotores se recorrerán cada vez que una letra se codifique. No lo harán cuando haya símbolos, por eso
        solo consideramos a la palabra sin los símbolos. El rotor con el que iniciaremos es con la penúltima rotación,
        es decir, no consideraremos al rotor que queda después de codificar la última letra, pues ese no se usa. */

        String palabraSinSimbolos = "";

        for(int x = 0; x < palabra.length(); x++){
            if(Auxiliar.isInThere(palabra.charAt(x))){
                palabraSinSimbolos = palabraSinSimbolos + palabra.charAt(x);
            }
        }

        int numeroRotaciones = palabraSinSimbolos.length() - 1;

        for(int x = 0; x < numeroRotaciones; x++){
            Auxiliar.recorreArray(rotor1);
            Auxiliar.recorreArray(rotor2);
            Auxiliar.recorreArray(rotor3);
        }

        //Aquí iremos guardando lo que vayamos decodificando
        String [] palabraDecodificada = new String[palabra.length()];

        //DE LA PALABRA CIFRADA AL ROTOR 3

        /*Los ciclos van al reves en comparación del método enigma. Comenzamos decifrando la última letra, cada que
        decifremos una letra, debemos "des-recorrer" el rotor, para eso usaremos el método retrasaArray().
        */
        for(int x = palabra.length()-1; x >= 0 ; x--) {

            int indice;

            if (!Auxiliar.isInThere(palabra.charAt(x))) {
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            } else {
                //Ubicamos en qué posición se ubica la letra actual en el rotor 3
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), rotor3);
                //Le asignamos ese lugar a la letra del alfabeto que originalmente ocupa ese lugar
                palabraDecodificada[x] = alfabeto[indice];
                //rdes-recorremos el rotor 3
                Auxiliar.retrasaArray(rotor3);
            }
        }


        //DEL ROTOR 3 AL ROTOR 2
        //Nuestra palabra ahora es el arreglo que generamos
        palabra = Auxiliar.gimmeWord(palabraDecodificada);

        for(int x = palabra.length()-1; x >= 0 ; x--) {

            int indice;

            if (!Auxiliar.isInThere(palabra.charAt(x))) {
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            } else {
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), rotor2);
                palabraDecodificada[x] = alfabeto[indice];
                Auxiliar.retrasaArray(rotor2);
            }
        }

        palabra = Auxiliar.gimmeWord(palabraDecodificada);

        for(int x = palabra.length()-1; x >= 0 ; x--) {

            int indice;

            if(!Auxiliar.isInThere(palabra.charAt(x))){
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            }else {
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), rotor1);
                palabraDecodificada[x] = alfabeto[indice];
                Auxiliar.retrasaArray(rotor1);
            }
        }

        Clavijero clavijero = new Clavijero();
        clavijero.mix(clave);

        //Este es el clavijero que usaremos
        String [] clavijeroEnigma = clavijero.clavijero;

        palabra = Auxiliar.gimmeWord(palabraDecodificada);

        for(int x = palabra.length()-1; x >= 0; x--){

            int indice;

            if(!Auxiliar.isInThere(palabra.charAt(x))){
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            }else{
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), clavijeroEnigma);
                palabraDecodificada[x] = alfabeto[indice];
            }
        }

        return palabraDecodificada;
    }

    //Sobrecarga del método Bombe
    public String[] bombe(int clave, String[] palabraComoArray){

        String palabra = Auxiliar.gimmeWord(palabraComoArray);

        palabra = palabra.toUpperCase();

        String [] rotor1 = {"Q", "E", "Z", "I", "P", "L", "O", "F", "S", "N", "B", "J", "V", "U", "A", "Y", "G",
                "T", "H", "D", "C", "W", "R", "M", "X", "K"};

        String [] rotor2 = {"O", "J", "X", "G", "T", "V", "S", "D", "Q", "L", "Y", "E", "I", "A", "B", "P", "H",
                "W", "M", "F", "K", "U", "N", "C", "R", "Z"};

        String [] rotor3 = {"A", "N", "O", "V", "R", "E", "C", "G", "P", "U", "F", "S", "B", "K", "J", "T", "Y",
                "H", "I", "Z", "L", "M", "D", "X", "Q", "W"};

        String [] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        /*Los rotores se recorrerán cada vez que una letra se codifique. No lo harán cuando haya símbolos, por eso
        solo consideramos a la palabra sin los símbolos. El rotor con el que iniciaremos es con la penúltima rotación,
        es decir, no consideraremos al rotor que queda después de codificar la última letra, pues ese no se usa. */

        String palabraSinSimbolos = "";

        for(int x = 0; x < palabra.length(); x++){
            if(Auxiliar.isInThere(palabra.charAt(x))){
                palabraSinSimbolos = palabraSinSimbolos + palabra.charAt(x);
            }
        }

        int numeroRotaciones = palabraSinSimbolos.length() - 1;

        for(int x = 0; x < numeroRotaciones; x++){
            Auxiliar.recorreArray(rotor1);
            Auxiliar.recorreArray(rotor2);
            Auxiliar.recorreArray(rotor3);
        }

        //Aquí iremos guardando lo que vayamos decodificando
        String [] palabraDecodificada = new String[palabra.length()];

        //DE LA PALABRA CIFRADA AL ROTOR 3

        /*Los ciclos van al reves en comparación del método enigma. Comenzamos decifrando la última letra, cada que
        decifremos una letra, debemos "des-recorrer" el rotor, para eso usaremos el método retrasaArray().
        */
        for(int x = palabra.length()-1; x >= 0 ; x--) {

            int indice;

            if (!Auxiliar.isInThere(palabra.charAt(x))) {
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            } else {
                //Ubicamos en qué posición se ubica la letra actual en el rotor 3
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), rotor3);
                //Le asignamos ese lugar a la letra del alfabeto que originalmente ocupa ese lugar
                palabraDecodificada[x] = alfabeto[indice];
                //rdes-recorremos el rotor 3
                Auxiliar.retrasaArray(rotor3);
            }
        }


        //DEL ROTOR 3 AL ROTOR 2
        //Nuestra palabra ahora es el arreglo que generamos
        palabra = Auxiliar.gimmeWord(palabraDecodificada);

        for(int x = palabra.length()-1; x >= 0 ; x--) {

            int indice;

            if (!Auxiliar.isInThere(palabra.charAt(x))) {
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            } else {
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), rotor2);
                palabraDecodificada[x] = alfabeto[indice];
                Auxiliar.retrasaArray(rotor2);
            }
        }

        palabra = Auxiliar.gimmeWord(palabraDecodificada);

        for(int x = palabra.length()-1; x >= 0 ; x--) {

            int indice;

            if(!Auxiliar.isInThere(palabra.charAt(x))){
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            }else {
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), rotor1);
                palabraDecodificada[x] = alfabeto[indice];
                Auxiliar.retrasaArray(rotor1);
            }
        }

        Clavijero clavijero = new Clavijero();
        clavijero.mix(clave);

        //Este es el clavijero que usaremos
        String [] clavijeroEnigma = clavijero.clavijero;

        palabra = Auxiliar.gimmeWord(palabraDecodificada);

        for(int x = palabra.length()-1; x >= 0; x--){

            int indice;

            if(!Auxiliar.isInThere(palabra.charAt(x))){
                palabraDecodificada[x] = String.valueOf(palabra.charAt(x));
            }else{
                indice = Auxiliar.gimmeIndex(String.valueOf(palabra.charAt(x)), clavijeroEnigma);
                palabraDecodificada[x] = alfabeto[indice];
            }
        }

        return palabraDecodificada;
    }

    public String[] breakHASH(String[] palabra){

        int[] indices = new int[27];

        for(int x = 1; x < 28; x++){
            indices[x-1] = x;
        }

        String [] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String [] hash = new String[palabra.length];

        //tranformamos todos los strings a números
        for(int x = 0; x < palabra.length; x++){
            if(Auxiliar.isInThere(Integer.parseInt(palabra[x]), indices)){
                hash[x] = alfabeto[Integer.parseInt(palabra[x])-1];
            }else {
                hash[x] = palabra[x];
            }
        }

        return hash;
    }
        //metodo de descifrado de cMorse
    public String[] goTesla( String mensajeDcf) {//el metodo es privado, por el momento dejemoslo en publico
            
        String ABC = " abcdefghijklmnopqrstuvwxyz 0123456789.,?! () [] &:; = + -_ $ @ ";

        String codigoM[] = new String[60];
        
        codigoM[0] = ".-";             // a
        codigoM[1] = "-...";           // b
        codigoM[2] = "-.-.";           // c
        codigoM[3] = "-..";           // d
        codigoM[4] = ".";              // e
        codigoM[5] = "..-.";           // f
        codigoM[6] = "-.";             // g
        codigoM[7] = "....";           // h
        codigoM[8] = "..";             // i
        codigoM[9] = ".---";           // j
        codigoM[10] = "-.-";           // k
        codigoM[11] = ".-..";         // l
        codigoM[12] = "--";             // m
        codigoM[13] = "-.";            // n
        codigoM[14] = "---";           // o
        codigoM[15] = ".--.";          // p
        codigoM[16] = "--.-";          // q
        codigoM[17] = ".-.";           // r
        codigoM[18] = "...";           // s
        codigoM[19] = "-";             // t
        codigoM[20] = "..-";           // u
        codigoM[21] = "...-";          // v
        codigoM[22] = ".--";           // w
        codigoM[23] = "-..-";          // x
        codigoM[24] = "-.--";          // y
        codigoM[25] = "--..";          // z      
        codigoM[26] = "-----";         // 0
        codigoM[27] = ".----";         // 1
        codigoM[28] = "..---";         // 2
        codigoM[29] = "...--";         // 3
        codigoM[30] = "....-";         // 4
        codigoM[31] = ".....";         // 5
        codigoM[32] = "-....";         // 6
        codigoM[33] = "--...";         // 7
        codigoM[34] = "---..";        // 8
        codigoM[35] = "----.";         // 9
        codigoM[36] = ".-.-.-";        // .
        codigoM[37] = "--..--";        // ,
        codigoM[38] = "..--..";       // ?
        codigoM[39] = ".-.-..";       // !
        codigoM[40] = "-.--.";         // (
        codigoM[41] = "-.-.-";       // )
        codigoM[42] = "-.--.";         // [
        codigoM[43] = "-.-.-";       // ]
        codigoM[44] = ".-...";         // &
        codigoM[45] = "---...";        // :
        codigoM[46] = "-.-.-.";        // ;
        codigoM[47] = "-...-";         // =
        codigoM[48] = ".-.-.";         // +
        codigoM[49] = "-....-";        // -
        codigoM[50] = "..-.-";       // _
        codigoM[51] = "...-..-";       // $
        codigoM[52] = ".-.-.";       // @
        codigoM[53] = "/";             // espacio
        
        //convertimos todos los String en arreglos de String 
        String[] newMensajeDcf = mensajeDcf.split(" ");
        String[] mensajeFinal=new String[newMensajeDcf.length];

        //abc como arreglo de char
        char[] newABC=ABC.toCharArray();
        
        
        for(int i=0;i<newMensajeDcf.length;i++){
            for(int j=0;j<60;j++){
             if(newMensajeDcf[i].equalsIgnoreCase(codigoM[j])){//este if no esta entrando.i.e no se cumple la logica
                 mensajeFinal[i]=String.valueOf(newABC[j]);
//                 System.out.print(mensajeFinal[i]);//imrpime el mensaje descifrado con la clave incluida 
             }
            }
        }
        //Para resolver los nulls que pasa cuando no hay equivalencia en morse
        for (int x = 0; x < mensajeFinal.length; x++) {
            if (mensajeFinal[x] == null) {
                mensajeFinal[x] = String.valueOf(newABC[x]);
            }
        }
        return mensajeFinal;
    }

    //100
    //clave
}
