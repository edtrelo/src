package Cipher;

import Auxiliar.Auxiliar;

import java.util.*;

<<<<<<< HEAD
 public class SuperEnigma {  

 

    //Ahorita las clases las pongo en public para poder probarlas
    //Luego hay que cambiarlas
    public char[] transposition(int clave, String palabra) {
=======
 class SuperEnigma {

    protected char[] transposition(int clave, String palabra) {
>>>>>>> 818673c9dcbce857a8f1156f973320b995772ddc

        //Nos aseguramos que la clave sea mayor a cero.
        while(clave < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("La clave debe ser mayor a cero.");
            clave = scan.nextInt();
        }

        boolean isKeyEven; /*Vamos a hacer dos metodos dependiendo si la clave
		es par o impar*/

        if(clave%2 == 0){
            isKeyEven = true;
        }
        else {
            isKeyEven = false;
        }

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

        int claveCesar = clave % 27; //contamos a la ñ

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
}