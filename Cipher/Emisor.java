package Cipher;

public class Emisor extends SuperEnigma{

    private String mensaje;
    private String contraseña;
    private boolean available = false;

    //Por hacer el constructor
    
    //Espero me salga bien lo que me pide de los getters y el constructor ajjajaja
    //Alexis hara el metodo CM, lo queesta en en esta clase y poner los de los signos.
    //Cambiar las vocales acentuadas

    //Sobreescritura del metodo de la superclase
    public char[] transposition(int clave) {
        return super.transposition(clave, this.mensaje);
    }

    public String [] cifradoDePolibioM(int clave){
        return super.cifradoDePolibioM(clave, this.mensaje);
    }

    //getters y setters

}

