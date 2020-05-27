package Cipher;

import Auxiliar.Auxiliar;

import java.util.*;

    //Ahorita las clases las pongo en public para poder probarlas
    //Luego hay que cambiarlas

 class SuperEnigma {

    protected char[] transposition(int clave, String palabra) {
        //Nos aseguramos que la clave sea mayor a cero.
        while(clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        boolean isKeyEven = Auxiliar.isEven(clave);
        /*Vamos a hacer dos metodos dependiendo si la clave
		es par o impar*/

        boolean isUpper = Auxiliar.isUpperCase(palabra);

        //Pasamos la palabra a minúsculas
        palabra = palabra.toLowerCase();

        //Creamos la palabra como arreglo de chars
        char [] palabraComoArreglo = palabra.toCharArray();

        int largoDeLaPalabra = palabra.length();

        char letrasdelABC [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


        char arregloCifrado [] = new char[2*largoDeLaPalabra];

        //Aqui dependiendo de la clave vamos a rellenar los espacios


        if(isKeyEven) {
            for(int x = 0; x < arregloCifrado.length; x++){
                Random random = new Random();
                if (x%2 == 0){
                    arregloCifrado[x] = palabraComoArreglo[x/2];
                }
                if (x%2 == 1){
                    arregloCifrado[x] = letrasdelABC[random.nextInt(letrasdelABC.length)];
                }
            }
        }
        else {
            for(int x = 0; x < arregloCifrado.length; x++){
                Random random = new Random();
                if (x%2 == 0){
                    arregloCifrado[x] = letrasdelABC[random.nextInt(letrasdelABC.length)];
                }
                if (x%2 == 1){
                    arregloCifrado[x] = palabraComoArreglo[(x-1)/2];
                }
            }
        }

        //Volvemos a transformar (si lo hicimos) la palabra (ahora cifrada) a mayusculas
        if(isUpper){
            for(int x = 0; x < arregloCifrado.length; x++){
                arregloCifrado[x] = Character.toUpperCase(arregloCifrado[x]);
            }
        }

        return arregloCifrado;
    }

    protected String [] cifradoDePolibioM(int clave, String palabra) {

        //NOTA: En vez de que la j sustituyera a la i, aquí sustituimos la w por la v.

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

        //Servira para darle las vueltas al abecedario

        String[] arregloClave = new String[5];

        //Relleno el arreglo que va a contener los indices de la tabla
        for(int x = 0; x < 5; x++){
            //El arreglo se va a recorrer según la clave
            arregloClave[x] = abecedario25[(x + clave-1)%25];
        }

        String codificado [] = new String[palabra.length()];


        //La z recorre la palabra
        for (int z = 0; z < palabra.length(); z++){
            //La x recorre las columnas
            if (String.valueOf(palabra.charAt(z)).equals("W")){
                palabra = palabra.replace('W', 'X');
            }
            for(int x = 0; x < matrizLetras.length; x++){
                //La y recoore las filas
                for(int y = 0; y < matrizLetras[x].length; y++){
                    if (String.valueOf(palabra.charAt(z)).equals(matrizLetras[x][y])){
                        codificado[z] = arregloClave[x] + arregloClave[y];
                    }
                }
            }
        }

        //Esto soluciona lo de los símbolos y espacios
        for (int x = 0; x < codificado.length; x++){
            if(codificado[x] == null){
                codificado[x] = String.valueOf(palabra.charAt(x));
            }
        }

        return codificado;

    }

    protected String [] cifradoCesar(int clave, String palabra) {

        //Nos aseguramos que la clave sea mayor a cero.
        while (clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        boolean isUpper = Auxiliar.isUpperCase(palabra);

        //Pasamos la palabra a arreglo char
        char[] palabraComoArreglo = palabra.toCharArray();

        int claveCesar = clave % 27;

        String letrasCesar[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String cesarCodificado[] = new String[palabra.length()];

        for (int x = 0; x < palabra.length(); x++) {
            for (int y = 0; y < letrasCesar.length; y++) {
                if (String.valueOf(palabraComoArreglo[x]).equalsIgnoreCase(letrasCesar[y])) {
                    cesarCodificado[x] = letrasCesar[(y + claveCesar) % 27];
                }
            }
        }


        //Esto soluciona lo de los símbolos y espacios
        for (int x = 0; x < cesarCodificado.length; x++) {
            if (cesarCodificado[x] == null) {
                cesarCodificado[x] = String.valueOf(palabra.charAt(x));
            }
        }

        //Volvemos a transformar (si lo hicimos) el char a minúsulas
        if (!isUpper) {
            for(int x = 0; x < cesarCodificado.length; x++) {
                cesarCodificado[x] = cesarCodificado[x].toLowerCase();
            }
        }

        return cesarCodificado;
    }

    protected String [] cifradoCesarEmoji(int clave, String palabra){

        //Nos aseguramos que la clave sea mayor a cero.
        while (clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        //Pasamos la palabra a arreglo char
        char[] palabraComoArreglo = palabra.toCharArray();

        int claveCesar = clave % 27;

        String letrasCesar[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String [] emojisDelCesar = new String[27];

        //Creamos el arreglo con los primeros 27 emojis
        for(int x = 0; x < emojisDelCesar.length; x++) {
            int indice = x + 128512; //Es el número equvalente al primer emoji
            String hex = Integer.toHexString(indice);
            emojisDelCesar[x] = String.valueOf(Character.toChars(Integer.parseInt(hex, 16)));
        }

        //Este es el arreglo que vamos a regresar
        String [] cesarCodificado = new String[palabra.length()];

        for (int x = 0; x < palabra.length(); x++) {
            for (int y = 0; y < letrasCesar.length; y++) {
                if (String.valueOf(palabraComoArreglo[x]).equalsIgnoreCase(letrasCesar[y])) {
                    cesarCodificado[x] = emojisDelCesar[(y + claveCesar) % 27];
                }
            }
        }

        //Esto soluciona lo de los símbolos y espacios
        for (int x = 0; x < cesarCodificado.length; x++) {
            if (cesarCodificado[x] == null) {
                cesarCodificado[x] = String.valueOf(palabra.charAt(x));
            }
        }

        return cesarCodificado;
    }

    protected String [] enigma(int clave, String palabra){

        //Este es el arreglo que vamos a regresar.
        String [] palabraEnigma = new String[palabra.length()];

        Clavijero clavijero = new Clavijero();
        clavijero.mix(clave);

        //Este es el clavijero que usaremos
        String [] clavijeroEnigma = clavijero.clavijero;
        int[] indices = Auxiliar.gimmeIndex(palabra);

        //DE PALABRA A CLAVIJERO
        for(int x = 0; x<palabra.length(); x++){
            if(indices[x]==-1){
                palabraEnigma[x] = String.valueOf(palabra.charAt(x));
            }else{
                palabraEnigma[x] = clavijeroEnigma[indices[x]];
            }
        }

        String [] rotor1 = {"Q", "E", "Z", "I", "P", "L", "O", "F", "S", "N", "B", "J", "V", "U", "A", "Y", "G",
                "T", "H", "D", "C", "W", "R", "M", "X", "K"};

        String [] rotor2 = {"O", "J", "X", "G", "T", "V", "S", "D", "Q", "L", "Y", "E", "I", "A", "B", "P", "H",
                "W", "M", "F", "K", "U", "N", "C", "R", "Z"};

        String [] rotor3 = {"A", "N", "O", "V", "R", "E", "C", "G", "P", "U", "F", "S", "B", "K", "J", "T", "Y",
                "H", "I", "Z", "L", "M", "D", "X", "Q", "W"};

        palabra = Auxiliar.gimmeWord(palabraEnigma);
        //Obtengo los índices de la palabra
        indices = Auxiliar.gimmeIndex(palabra);

        for(int x = 0; x < palabra.length(); x++){
            //DE CLAVIJERO A PRIMER ROTOR
            if(indices[x]==-1){
                palabraEnigma[x] = String.valueOf(palabra.charAt(x));
            }else {
                palabraEnigma[x] = rotor1[indices[x]];
                Auxiliar.recorreArray(rotor1);
            }


            //DE PRIMER ROTOR A SEGUNDO ROTOR
            //Volvemos a cambiar el arreglo a palabra
            palabra = Auxiliar.gimmeWord(palabraEnigma);
            //Obtenemos los índices de la palabra cifrada que arroja el rotor 1
            indices = Auxiliar.gimmeIndex(palabra);
            if(indices[x]==-1){
                palabraEnigma[x] = String.valueOf(palabra.charAt(x));
            }else {
                palabraEnigma[x] = rotor2[indices[x]];
                Auxiliar.recorreArray(rotor2);
            }

            //DE SEGUNDO ROTOR A TERCER ROTOR
            //Volvemos a cambiar el arreglo a palabra
            palabra = Auxiliar.gimmeWord(palabraEnigma);
            //Obtenemos los índices de la palabra cifrada que arroja el rotor 2
            indices = Auxiliar.gimmeIndex(palabra);
            if(indices[x]==-1){
                palabraEnigma[x] = String.valueOf(palabra.charAt(x));
            }else {
                palabraEnigma[x] = rotor3[indices[x]];
                Auxiliar.recorreArray(rotor3);
            }
        }

        return palabraEnigma;
    }

    protected String[] HASH(String palabra){

        int[] indices = new int[palabra.length()];

        indices = Auxiliar.gimmeIndex(palabra);

        String [] palabraHash = new String[palabra.length()];

        for(int x = 0; x < palabra.length(); x++){
            if(indices[x]>= 0){
                palabraHash[x] = String.valueOf(indices[x]+1);
            }else {
                palabraHash[x] = String.valueOf(palabra.charAt(x));
            }
        }

        return palabraHash;

    }

    protected String[] cMorse(int clave, String mensaje) {

        char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'á', 'é', 'í', 'ó', 'ú', '.', ',', '?', '!', '(', ')', '[', ']', '&', ':', ';', '=', '+', '-', '_', '$', '@',' '};

        String[] codigoM = new String[59];
        codigoM[0] = " .- ";        // a
        codigoM[1] = " -... ";        // b
        codigoM[2] = " -.-. ";        // c
        codigoM[3] = " -.. ";        // d
        codigoM[4] = " . ";        // e
        codigoM[5] = " ..-. ";        // f
        codigoM[6] = " -. ";        // g
        codigoM[7] = " .... ";        // h
        codigoM[8] = " .. ";        // i
        codigoM[9] = " .--- ";        // j
        codigoM[10] = " -.- ";        // k
        codigoM[11] = " .-.. ";        // l
        codigoM[12] = " -- ";        // m
        codigoM[13] = " -. ";        // n
        codigoM[14] = " --- ";        // o
        codigoM[15] = " .--. ";         // p
        codigoM[16] = " --.- ";         // q
        codigoM[17] = " .-. ";        // r
        codigoM[18] = " ... ";        // s
        codigoM[19] = " - ";        // t
        codigoM[20] = " ..- ";        // u
        codigoM[21] = " ...- ";         // v
        codigoM[22] = " .-- ";        // w
        codigoM[23] = " -..- ";         // x
        codigoM[24] = " -.-- ";         // y
        codigoM[25] = " --.. ";         // z
        codigoM[26] = " ----- ";        // 0
        codigoM[27] = " .---- ";        // 1
        codigoM[28] = " ..--- ";        // 2
        codigoM[29] = " ...-- ";        // 3
        codigoM[30] = " ....- ";        // 4
        codigoM[31] = " ..... ";        // 5
        codigoM[32] = " -.... ";        // 6
        codigoM[33] = " --... ";        // 7
        codigoM[34] = " ---.. ";    // 8
        codigoM[35] = " ----. ";        // 9
        codigoM[36] = " .- ";        // á
        codigoM[37] = " . ";        // é
        codigoM[38] = " .. ";        // í
        codigoM[39] = " --- ";        // ó
        codigoM[40] = " ..- ";        // ú
        codigoM[41] = " .-.-.- ";    // .
        codigoM[42] = " --..-- ";    // ,
        codigoM[43] = " ..--.. ";    // ?
        codigoM[44] = " .-.-.. ";    // !
        codigoM[45] = " -.--. ";        // (
        codigoM[46] = " -.-.- ";    // )
        codigoM[47] = " -.--. ";        // [
        codigoM[48] = " -.-.- ";    // ]
        codigoM[49] = " .-... ";    // &
        codigoM[50] = " ---... ";    // :
        codigoM[51] = " -.-.-. ";    // ;
        codigoM[52] = " -...- ";        // =
        codigoM[53] = " .-.-. ";        // +
        codigoM[54] = " -....- ";	// -
        codigoM[55] = " ..-.- ";	// _
        codigoM[56] = " ...-..- ";	// $
        codigoM[57] = " .-.-. ";	// @  
        codigoM[58]=" / ";             //espacio
        
        mensaje = mensaje.toLowerCase();
        char[] mensajeComoArreglo = mensaje.toCharArray();

        //la clave debe de ser mayor a cero y menorigual a la longitud del mensaje      
        while (clave < 0 || clave > mensaje.length()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero y menor o igual que la long del mensaje.");
            clave = scan.nextInt();
        }
        //Transformamos la clave a String
        String newClave = Integer.toString(clave);
        //Generamos un número aleatorio entre el 1 y la longuitud del arreglo - 2.
        Random random = new Random();
        int aleatorio = random.nextInt(mensaje.length()-2) + 1;
        //introducimos de manera pseudoañeatoria el numero a la palabra
        String newMensaje = mensaje.substring(0, aleatorio) + newClave
                + mensaje.substring(aleatorio, mensaje.length());


        // System.out.println(newMensaje); Imprime la palabra ya con la clave

        char[] newMensajeArr = newMensaje.toCharArray();
        
        //Transformamos todos los chars a Strings
        String[] abc2 = new String[abc.length];
        for (int x = 0; x < abc2.length; x++) {
            abc2[x] = String.valueOf(abc[x]);
        }

        String[] mensajeCifrado = new String[newMensaje.length()];

        for (int i = 0; i < newMensajeArr.length; i++) {
            for (int j = 0; j < abc2.length; j++) {
                if (abc2[j].equalsIgnoreCase(String.valueOf(newMensajeArr[i]))) {//Aqui se checa que la palabra se ecnuentre en el abc
                    mensajeCifrado[i] = codigoM[j];//Aqui ya se convierte cada palabra en Cmorse
                    //System.out.println(mensajeCifrado[i]); imprime la palabra ya codificada 
                }
            }
        }

        //Para resolver los nulls que pasa cuando no hay equivalencia en morse
        for (int x = 0; x < mensajeCifrado.length; x++) {
            if (mensajeCifrado[x] == null) {
                mensajeCifrado[x] = String.valueOf(newMensajeArr[x]);
            }
        }

        return mensajeCifrado;

    }

}