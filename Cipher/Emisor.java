package Cipher;

import java.util.*;

public class Emisor extends SuperEnigma{

    private String mensaje;
    private String privateKey;
    private boolean available = false;

    //Por hacer el constructor

    //-------Inicio: Constructores------------------------------------------------------
    public Emisor(String privateKey){
        this.privateKey = privateKey;
        
    }

    public Emisor(String privateKey, String mensaje){
        this.setPrivateKey(privateKey);
        this.setMensaje(mensaje);
    }
    //-------Fin: Constructores----------------------------------------------------------


    //-------Inicio: Métodos-------------------------------------------------------------

    public char[] transposition(int clave) {
        return super.transposition(clave, this.mensaje);
    }

    public String[] cifradoDePolibioM(int clave){
        return super.cifradoDePolibioM(clave, this.mensaje);
    }

    public String[] cifradoCesar(int clave){return super.cifradoCesar(clave, this.mensaje);}

    public String[] cifradoCesarEmoji(int clave){return super.cifradoCesarEmoji(clave, this.mensaje);}

    public String[] enigma(int clave){
        return super.enigma(clave, this.mensaje);
    }

    public String[] HASH(){
        return super.HASH(this.mensaje);
    }

    public String[] cMorse(int clave){return super.cMorse(clave, this.mensaje);}


    //-------Fin: Métodos-----------------------------------------------------------------

    //-------Inicio: Getters y Setters----------------------------------------------------

    public String getMensaje() {
        if (available){
            return mensaje;
        }else {
            System.out.println("El usuario no está disponible. ");
            return "";
        }
    }

    public void setMensaje(String mensaje) { //para que pueda usar el metodo, solo debe de cumplir que el usuario este disp.
        if (available){
            this.mensaje = mensaje;
        }else{System.out.println("El usuario no está disponible.");}
         
    }

    public void setPrivateKey(String privateKey) {
        /*Para que pueda usarse el metodo de la clave debe de recibir una
        "clave privada" para que se pueda modificar y tambien se debe de
        verificar que este disponible el usuario */

        Scanner scan = new Scanner(System.in);
        if(this.available){ //Este es el caso para cuando se instancia por primera vez
            System.out.println("Por favor ingrese la clave actual: ");
            String claveIngresada = scan.nextLine();
            while(!claveIngresada.equals(this.privateKey)){
                System.out.println("La clave que ha ingresado no es correcta. ");
            }
            System.out.println("Ingrese la nueva clave: ");
            this.privateKey = scan.nextLine();
        }else {
            System.out.println("El usuario debe de estar dispoible para poder interactuar.");
        }

        //La idea aquí era que el usuario debe meter la clave vieja para cambiarla por una nueva.
    }

    public boolean getAvailable(){
       return available;
    }

    public void switchAvailable() {
        this.available = !available;

        /*este método set que no reciba atributos, o sea, si está disponible, entonces este método hace que no lo
        este y lo mismo si no lo está*/
    }

    //-------Fin Getters y Setters----------------------------------------------------

} // Fin de la Clase Emisor-----------------------------------------------------------

