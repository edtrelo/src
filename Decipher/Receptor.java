package Decipher;

import Auxiliar.Auxiliar;
import Cipher.Emisor;
import java.util.Scanner;

public class Receptor extends AllTuring{

    private String privateKeyR;

    //construtor
    public Receptor(String privateKey) {
        privateKey = this.privateKeyR;
    }

    //Metodos getters y setters
    public String getPrivateKey() {
        return privateKeyR;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKeyR = privateKey;
    }
    //Fin de metodos getter y setters 


    public void Decode(String clavePrivada, String mensaje) {

        if (clavePrivada.equals(this.privateKeyR)) {
            System.out.println("Las contraseñas son correctas, ahora puede decifrar. ");
            System.out.println("Introduzca una clave entera (mayor cero) para el decifrado: ");
            Scanner scan = new Scanner(System.in);
            int clave = scan.nextInt();

            while(clave < 0){
                System.out.println("La clave es menor que cero, por favor, introduzca una clave mayor a cero: ");
                clave = scan.nextInt();
            }

            String [] decodificada = super.Decode(clave, mensaje);

            String palabra = Auxiliar.gimmeWord(decodificada);

            System.out.println("La palabra ha sido decifrada: ");
            System.out.println("Su mensaje: "+ mensaje + " decodificado con el método seleccionado le regresa: ");
            System.out.println(palabra);

        } else {
            System.out.println("Las contraseñas privadas no son iguales. ");
        }
    }

    public void Decode(String clavePrivada, String [] mensaje) {

        String mensajeChido = Auxiliar.gimmeWord(mensaje);

        Decode(clavePrivada, mensajeChido);
    }

    public void Decode(String clavePrivada, char[] mensaje) {

        String[] mensajeChido = Auxiliar.fromCharToString(mensaje);

        Decode(clavePrivada, mensajeChido);
    }

}
