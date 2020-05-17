package Cipher;

public class Emisor extends SuperEnigma{

    private String mensaje;
    private String privateKey;
    private boolean available = false;

    //Por hacer el constructor
    
    //Espero me salga bien lo que me pide de los getters y el constructor ajjajaja
    //Alexis hara el metodo CM, lo que esta en en esta clase y poner los de los signos.
    //Cambiar las vocales acentuadas
    
    //Constructores
    public Emisor(String privateKey){
        this.setPrivateKey(privateKey);
        
    }
    public Emisor(String privateKey, String mensaje){
        this.setPrivateKey(privateKey);
        this.setMensaje(mensaje);
    }

    //Sobreescritura del metodo de la superclase
    public char[] transposition(int clave) {
        return super.transposition(clave, this.mensaje);
    }

    public String [] cifradoDePolibioM(int clave){
        return super.cifradoDePolibioM(clave, this.mensaje);
    }

    //getters y setters

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) { //para que pueda usar el metodo, solo debe de cumplir que el usuario este disp.
        if (this.available=true){
            System.out.println("El usuario esta disponible");
           this.mensaje=mensaje; 
        }else{System.out.println("El usuario no esta disponible");}
         
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {//Paraque pueda usarse el metodo de la clave debe de recibir una 
                                                  // "clave privada" para que se pueda modificar y tambien se debe de 
                                                  // verificar que este disponible el usuario 
                                                  
        if(this.available=true){
            System.out.println("El usuario esta disponible");
        this.privateKey = privateKey;
        }else{System.out.println("El usuario debe de estar dispoible para poder interactuar");}
    }
    public boolean getAvailable(){
        return available;
    }
    public void setAvailable(boolean available) {
        //tengo duda en como modificar el estado de disponibilidad
        this.available = available;
    }
    
    
    
}

