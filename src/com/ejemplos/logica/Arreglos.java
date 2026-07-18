package com.ejemplos.logica;

public class Arreglos {
    // Algoritmo puro de Ordenamiento Burbuja O(n^2)
    public static void ordenarBurbuja(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Mecánica del Swap (Intercambio en memoria)
                    int temporal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporal;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 🧮 Práctica: Arreglos Fijos e Irregulares ===");

        // 1. Vector estático contiguo desordenado
        int[] secuencia = { 44, 12, 9, 33 };
        ordenarBurbuja(secuencia);

        System.out.print("Vector ordenado físicamente: ");
        for (int num : secuencia) {
            System.out.print("[" + num + "] ");
        }

        // 2. Creación de una matriz irregular (Jagged Array)
        System.out.println("\n\nMatriz Asimétrica en Memoria Heap:");
        int[][] matrizIrregular = new int[2][];
        matrizIrregular[0] = new int[2]; // Fila 0 tiene 2 columnas
        matrizIrregular[1] = new int[3]; // Fila 1 tiene 3 columnas

        matrizIrregular[0][1] = 95;
        matrizIrregular[1][2] = 88;

        for (int i = 0; i < matrizIrregular.length; i++) {
            for (int j = 0; j < matrizIrregular[i].length; j++) {
                System.out.print(matrizIrregular[i][j] + " ");
            }
            System.out.println();
        }
    }
}
