package com.ejemplos.logica;

/**
 * Vinculado teóricamente con: teoria/01-logica/bucles-iteraciones.md
 */
public class Bucles {
    public static void main(String[] args) {
        System.out.println("=== 🔄 Práctica: Bucles e Iteraciones Controladas ===");

        System.out.println("\n1. Ciclo FOR Determinado:");
        for (int i = 1; i <= 3; i++) {
            System.out.println(" -> Iteración secuencial número: " + i);
        }

        System.out.println("\n2. Ciclo WHILE con ruptura controlada por break:");
        int contador = 0;
        while (true) {
            if (contador == 2) {
                System.out.println(" -> Condición de salida alcanzada de forma explícita.");
                break; // Rompe el bucle infinito
            }
            contador++;
        }
    }
}
