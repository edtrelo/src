package Comunication;

import Cipher.*;

public class Chat {
	
	public static void main (String[] args){

		SuperEnigma prueba1 = new SuperEnigma();

		char[] prueba2 = prueba1.transposition(3, "hola");

		for(int x = 0; x < prueba2.length; x++){
			System.out.print(prueba2[x] + "\t");
		}

		char[] prueba3 = prueba1.transposition(8, "hola");

		System.out.println("\n");

		for(int x = 0; x < prueba3.length; x++){
			System.out.print(prueba3[x] + "\t");
		}

		String palabrita = "world";

		palabrita = palabrita.replace('w','x');

		System.out.println(palabrita);

		String[] str = prueba1.cifradoDePolibioM(3,"world");

		System.out.println("\n");

		for(int x = 0; x < str.length; x++){
			System.out.print(str[x] + "\t");
		}

	}
}
