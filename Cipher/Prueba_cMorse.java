
package Cipher;


import Auxiliar.Auxiliar;

public class Prueba_cMorse {


    public String[] cMorse( String mensaje) {

        char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'á', 'é', 'í', 'ó', 'ú', '.', ',', '?', '!', '(', ')', '[', ']', '&', ':', ';', '=', '+', '-', '_', '$', '@'};

        String[] codigoM = new String[58];
        codigoM[0] = " .- ";        // a
        codigoM[1] = " -... ";        // b
        codigoM[2] = " -.-. ";        // c
        codigoM[3] = " - .. ";        // d
        codigoM[4] = " . ";        // e
        codigoM[5] = " ..-. ";        // f
        codigoM[6] = " -. ";        // g
        codigoM[7] = " .... ";        // h
        codigoM[8] = " .. ";        // i
        codigoM[9] = " .--- ";        // j
        codigoM[10] = " -.- ";        // k
        codigoM[11] = " .-.. ";        // l
        codigoM[12] = " - ";        // m
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
        codigoM[25] = " - .. ";         // z
        codigoM[26] = " ----- ";        // 0
        codigoM[27] = " .---- ";        // 1
        codigoM[28] = " ..--- ";        // 2
        codigoM[29] = " ...-- ";        // 3
        codigoM[30] = " ....- ";        // 4
        codigoM[31] = " ..... ";        // 5
        codigoM[32] = " -.... ";        // 6
        codigoM[33] = " --... ";        // 7
        codigoM[34] = " --- .. ";    // 8
        codigoM[35] = " ----. ";        // 9
        codigoM[36] = " .- ";        // á
        codigoM[37] = " . ";        // é
        codigoM[38] = " .. ";        // í
        codigoM[39] = " --- ";        // ó
        codigoM[40] = " ..- ";        // ú
        codigoM[41] = " .-.-.- ";    // .
        codigoM[42] = " --..-- ";    // ,
        codigoM[43] = " ..-- .. ";    // ?
        codigoM[44] = " .-.- .. ";    // !
        codigoM[45] = " -.--. ";        // (
        codigoM[46] = " -. - .- ";    // )
        codigoM[47] = " -.--. ";        // [
        codigoM[48] = " -. - .- ";    // ]
        codigoM[49] = " .-... ";    // &
        codigoM[50] = " ---... ";    // :
        codigoM[51] = " -.-.-. ";    // ;
        codigoM[52] = " -...- ";        // =
        codigoM[53] = " .-.-. ";        // +
        codigoM[54] = " -....- ";	// -
        codigoM[55] = " .. - .- ";	// _
        codigoM[56] = " ...-..- ";	// $
        codigoM[57] = " . - .-. ";	// @   
        codigoM[54] = " -....- ";    // -
        codigoM[55] = " .. - .- ";    // _
        codigoM[56] = " ...-..- ";    // $
        codigoM[57] = " . - .-. ";    // @
        
        String mensajeHigh = mensaje.toUpperCase();
        String mensajeLow = mensaje.toLowerCase();
         
        //hacer la palabra en minuscula
        if (mensaje.equals(mensajeHigh)) {
            mensaje = mensajeLow;
        }else{mensaje=mensajeLow;}
        
        String mensajeMod=mensaje;
        System.out.println(mensajeMod);
        
        //el mensaje ya modifcado 
        char[] mensajeModComoArr=mensajeMod.toCharArray();
        
        String[] a = null;
  
  String mensajeCifrado;
    for(int i=0;i<mensajeModComoArr.length;i++){
        for(int j=0;j<abc.length;j++){
              if(mensajeModComoArr[i]==abc[j]){//Aqui se checa que la palabra se ecnuentre en el abc
               mensajeCifrado=codigoM[j];//Aqui ya se convierte cada palabra en Cmorse
                  System.out.print(mensajeCifrado);//Aqui imprime cada resultado
              }
        }System.out.println("");
    }
       // String[] cifradoComoArr=mensajeCifrado; //Aqui intento convertir el resultado en un arreglo
    // la cuestion es que el resultado lo devuelve en un string, lo que me estuvo tardando y tardando es que no
    // puedo convertirlo en arreglo
        return a;
        
    }
}