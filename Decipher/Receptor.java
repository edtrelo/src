package Decipher;

import Auxiliar.Auxiliar;
import java.util.Scanner;

public class Receptor extends AllTuring{

    private String privateKeyR;

    //construtor
    public Receptor(String privateKey) {
        this.privateKeyR = privateKey;
    }

    //Metodos getters y setters
    public String getPrivateKey() {
        return privateKeyR;
    }

    public void setPrivateKey(String privateKey) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor introduzca su clave privada: ");
        String clavePrivada = scan.nextLine();
        if(clavePrivada.equals(this.getPrivateKey())){
            this.privateKeyR = privateKey;
        }
        else{
            System.out.println("No introdujo la clave correcta.");
        }

    }
    //Fin de metodos getter y setters 


    public void Decode(String mensaje) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor introduzca su clave privada: ");
        String clavePrivada = scan.nextLine();

        if (clavePrivada.equals(getPrivateKey())) {
            System.out.println("Las contraseñas son correctas, ahora puede decifrar. ");

            System.out.println("Introduzca una clave entera (mayor cero) para el decifrado: ");
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
            System.out.println("Usted debe ser del enemigo. ");
        }
    }

    public void Decode(String [] mensaje) {

        String mensajeChido = Auxiliar.gimmeWord(mensaje);

        Decode(mensajeChido);
    }

    public void Decode(char[] mensaje) {

        String[] mensajeChido = Auxiliar.fromCharToString(mensaje);

        Decode(mensajeChido);
    }

}
