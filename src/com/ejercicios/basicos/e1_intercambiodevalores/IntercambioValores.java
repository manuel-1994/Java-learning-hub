package com.ejercicios.basicos.e1_intercambiodevalores;

public class IntercambioValores {
    public static void main(String[] args) {
        IntercambioValores miObjeto = new IntercambioValores();
        miObjeto.intercambiarValores(35, 20);
        System.exit(0);
    }

    public void intercambiarValores(int number, int number2) {
        System.out.println("El valor de number es: " + number);
        System.out.println("El valor de number 2 es: " + number2);

        int aux = number;
        number = number2;
        number2 = aux;

        System.out.println("El nuevo valor de number es: " + number);
        System.out.println("El nuevo valor de number 2 es: " + number2);
    }
}
