package Decipher;

import Cipher.Emisor;
import java.util.Scanner;

public class Receptor {

    private String privateKeyR;

    //Metodos getters y setters
    public String getPrivateKey() {
        return privateKeyR;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKeyR = privateKey;
    }
    //Fin de metodos getter y setters 

    //construtor 
    public Receptor(String privateKey) {
        privateKey = this.privateKeyR;
    }

    public void Decode(Emisor privatekeyE) {//si pide que no devuelva, entonces lo sig no se imprimiria 

        if (privatekeyE.equals(this.privateKeyR)) {//no entiendo en que momento estamos diciendo cual es la clave de cada 
            AllTuring t = new AllTuring();//entonces no sé en que momento debemos de dar el valor a cada clavePrivada
            System.out.println("Las contraseñas son correctas, procedamos. ");//pero fuera de eso si cumple que son iguales jala
            System.out.println("Introduzca una clave.");
            Scanner scan = new Scanner(System.in);
            int clave = scan.nextInt();
            System.out.println("Ahora introduzca un mensaje por decifrar.");
            Scanner scan_2 = new Scanner(System.in);
            String mensaje = scan_2.nextLine();
            t.Decode(clave, mensaje);
        } else {
            System.out.println("Las contraseñas no son iguales");
        }
    }

}
