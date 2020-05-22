/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cipher;

import java.util.Random;

/**
 *
 * @author carlosvasquezguerra
 */
public class Clavijero {

    private static final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public String[] clavijero;

    /**
     * Al crear un nuevo clavijero, se tendrá un clavijero con el alfabeto en el
     * orden tradicional.
     */
    public Clavijero() {
        String[] clavjInit = new String[LETTERS.length];
        for (int i = 0; i < clavjInit.length; i++) {
            clavjInit[i] = LETTERS[i];
        }
        this.clavijero = clavjInit;
    }

    /**
     * Función para modificar el clavijero
     *
     * @param num
     */
    public void mix(int num) {
        clavijero = randomPermutation(LETTERS, num);
    }

    private static String[] randomPermutation(String[] arr, long seed) {
        Random random = new Random();
        random.setSeed(seed);
        String[] permutation = new String[arr.length];
        for (int i = 0; i < permutation.length; i++) {
            int indexRandom = random.nextInt(arr.length);
            permutation[i] = arr[indexRandom];
            arr = deleteItem(arr, indexRandom);
        }
        return permutation;
    }

    /**
     * Función para obtener retirar un solo elemento del arreglo String[]
     *
     * @param arr
     * @param index : 0<=index<arr.length @re
     * turn
     */
    private static String[] deleteItem(String[] arr, int index) {
        String[] arrResult = new String[arr.length - 1];
        for (int i = 0; i < index; i++) {
            arrResult[i] = arr[i];
        }
        for (int i = index; i < arrResult.length; i++) {
            arrResult[i] = arr[i + 1];
        }
        return arrResult;
    }

}
