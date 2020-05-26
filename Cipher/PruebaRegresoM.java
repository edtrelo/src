
package Cipher;

public class PruebaRegresoM {
    public String[] goTesla( String mensajeDcf) {//el metodo es privado, por el momento dejemoslo en publico
            
        String ABC = " abcdefghijklmnopqrstuvwxyz 0123456789.,?! () [] &:; = + -_ $ @ ";

        String codigoM[] = new String[60];
        
        codigoM[0] = " .- ";             // a
        codigoM[1] = " -... ";           // b
        codigoM[2] = " -.-. ";           // c
        codigoM[3] = " - .. ";           // d
        codigoM[4] = " . ";              // e
        codigoM[5] = " ..-. ";           // f
        codigoM[6] = " -. ";             // g
        codigoM[7] = " .... ";           // h
        codigoM[8] = " .. ";             // i
        codigoM[9] = " .--- ";           // j
        codigoM[10] = " -.- ";           // k
        codigoM[11] = " .- .. ";         // l
        codigoM[12] = " - ";             // m
        codigoM[13] = " -. ";            // n
        codigoM[14] = " --- ";           // o
        codigoM[15] = " .--. ";          // p
        codigoM[16] = " --.- ";          // q
        codigoM[17] = " .-. ";           // r
        codigoM[18] = " ... ";           // s
        codigoM[19] = " - ";             // t
        codigoM[20] = " ..- ";           // u
        codigoM[21] = " ...- ";          // v
        codigoM[22] = " .-- ";           // w
        codigoM[23] = " -..- ";          // x
        codigoM[24] = " -.-- ";          // y
        codigoM[25] = " - .. ";          // z
        codigoM[26] = " / ";             // espacio
        codigoM[27] = " ----- ";         // 0
        codigoM[28] = " .---- ";         // 1
        codigoM[29] = " ..--- ";         // 2
        codigoM[30] = " ...-- ";         // 3
        codigoM[31] = " ....- ";         // 4
        codigoM[32] = " ..... ";         // 5
        codigoM[33] = " -.... ";         // 6
        codigoM[34] = " --... ";         // 7
        codigoM[35] = " --- .. ";        // 8
        codigoM[36] = " ----. ";         // 9
        codigoM[37] = " .-.-.- ";        // .
        codigoM[38] = " --..-- ";        // ,
        codigoM[39] = " ..-- .. ";       // ?
        codigoM[40] = " .-.- .. ";       // !
        codigoM[41] = " -.--. ";         // (
        codigoM[42] = " -. - .- ";       // )
        codigoM[43] = " -.--. ";         // [
        codigoM[44] = " -. - .- ";       // ]
        codigoM[45] = " .-... ";         // &
        codigoM[46] = " ---... ";        // :
        codigoM[47] = " -.-.-. ";        // ;
        codigoM[48] = " -...- ";         // =
        codigoM[49] = " .-.-. ";         // +
        codigoM[50] = " -....- ";        // -
        codigoM[51] = " .. - .- ";       // _
        codigoM[52] = " ...-..- ";       // $
        codigoM[53] = " . - .-. ";       // @
        
        //convertimos todos los String en arreglos de String 
        String[] newMensajeDcf = mensajeDcf.split(" ");
        String[] mensajeFinal=new String[newMensajeDcf.length];

        //abc como arreglo de char
        char[] newABC=ABC.toCharArray();
        System.out.println("");
        
        for(int i=0;i<newMensajeDcf.length;i++){
            for(int j=0;j<60;j++){
             if(newMensajeDcf[i].equalsIgnoreCase(codigoM[j])){//este if no esta entrando.i.e no se cumple la logica
                 mensajeFinal[i]=String.valueOf(newABC[j]);
                 System.out.println(mensajeFinal[i]);
             }else{System.out.println("Algo salio mal");}   
            }
        }
        return mensajeFinal;
    }
}
