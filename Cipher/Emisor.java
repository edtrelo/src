package Cipher;

public class Emisor extends SuperEnigma{

    private String mensaje;
    private String privateKey;
    private boolean available = false;

    //Sobreescritura del metodo de la superclase
    public char[] transposition() {
        int clave = Integer.parseInt(this.privateKey);
        return super.transposition(clave, this.mensaje);
    }

    public String [] cifradoDePolibioM(){
        int clave = Integer.parseInt(this.privateKey);
        return super.cifradoDePolibioM(clave, this.mensaje);
    }
}

