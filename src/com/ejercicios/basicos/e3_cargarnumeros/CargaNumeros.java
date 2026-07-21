package com.ejercicios.basicos.e3_cargarnumeros;

import java.util.Scanner;

public class CargaNumeros {
    public static void main(String[] args) {
        CargaNumeros myObject = new CargaNumeros();
        int[] vector = myObject.iniciarVector();
        myObject.cargarNumeros(vector);
    }

    public int[] iniciarVector() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers;
        System.out.println("Ingrese la cantidad de números a cargar");

        while (true) {
            if (scanner.hasNextInt()) {
                int cantidad = scanner.nextInt();
                if (cantidad > 0) {
                    numbers = new int[cantidad];
                    return numbers;
                } else {
                    System.out.println("Por favor, ingrese un número mayor a 0");
                    continue;
                }
            }
            System.out.println("Por favor, ingrese un número válido");
            scanner.next();
        }
    }

    public void cargarNumeros(int[] vector) {
        Scanner scanner = new Scanner(System.in);
        int contador = 0;

        for (int i = 0; i < vector.length; i++) {
            System.out.println("Ingrese el número " + (i + 1) + ":");
            while (true) {
                if (scanner.hasNextInt()) {
                    vector[i] = scanner.nextInt();
                    if (vector[i] == 3) {
                        contador++;
                    }
                    break;
                } else {
                    System.out.println("Por favor, ingrese un número valido");
                    scanner.next();
                }
            }
        }
        System.out.println("La cantidad de veces que se ingresó el número 3 es: " + contador);
    }
}
