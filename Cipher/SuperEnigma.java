package Cipher;

import Comunication.*;

import java.util.*;

 class SuperEnigma {

    //Ahorita las clases las pongo en public para poder probarlas
    //Luego hay que cambiarlas
    public char[] transposition(int clave, String palabra) {

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

        //Creamos la palabra como arreglo de chars
        char [] palabraComoArreglo = palabra.toCharArray();

		/*Tendriamos que crear un metodo aparte para checar si una palabra es toda
		mayusculas y transformarla a minusculas*/

        int largoDeLaPalabra = palabra.length();

        boolean isWordUpper = true;

        //Verificamos si la palabra es mayuscula o minuscula
        for(int x = 0; x < largoDeLaPalabra; x++){
            if(!Character.isUpperCase(palabraComoArreglo[x])){
                isWordUpper = false;
            }
        }

        //Pasamos todas las palabras a minusculas
        if(isWordUpper){
            for(int x = 0; x < largoDeLaPalabra; x++){
                Character.toLowerCase(palabraComoArreglo[x]);
            }
        }


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

        //Volvemos a transformar (si lo hicimos) el char a mayusculas

        if(isWordUpper){
            for(int x = 0; x < arregloCifrado.length; x++){
                Character.toUpperCase(arregloCifrado[x]);
            }
        }

        return arregloCifrado;
    }

    public String [] cifradoDePolibioM(int clave, String palabra) {

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
        int indiceModuloClave = clave%26 - 1;

        String[] arregloClave = new String[5];

        //Relleno el arreglo que va a contener los indices de la tabla
        for(int x = 0; x < 5; x++){
            //El arreglo se va a recorrer según la clave
            arregloClave[x] = abecedario25[indiceModuloClave + x];
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

        return codificado;

    }

    // ya pude obtener el proyecto :D
}