package com.ejemplos.logica;

import java.util.Scanner;

/**
 * Vinculado teóricamente con: teoria/01-logica/estructuras-control.md
 */
public class Condicionales {
    public static void main(String[] args) {
        System.out.println("=== 🔀 Práctica: Estructuras de Control Condicional ===");
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese código numérico de departamento (1-3): ");
        int departamento = teclado.nextInt();

        // 1. Estructura condicional múltiple tradicional con if/else
        if (departamento == 1) {
            System.out.println("Ruta: Despliegue en capa de Sistemas.");
        } else if (departamento == 2) {
            System.out.println("Ruta: Despliegue en capa de Ventanas Gráficas.");
        } else if (departamento == 3) {
            System.out.println("Ruta: Despliegue en capa de Proyectos Integrados.");
        } else {
            System.out.println("Código erróneo. Departamento desconocido.");
        }

        // 2. Estructura condicional múltiple optimizada con Switch
        switch (departamento) {
            case 1 -> System.out.println("Ruta: Despliegue en capa de Sistemas.");
            case 2 -> System.out.println("Ruta: Despliegue en capa de Ventanas Gráficas.");
            case 3 -> System.out.println("Ruta: Despliegue en capa de Proyectos Integrados.");
            default -> System.out.println("Código erróneo. Departamento desconocido.");
        }

        // 3. Uso del Operador Ternario compacto
        System.out.print("Ingrese saldo de cuenta: ");
        double saldo = teclado.nextDouble();
        String estadoCuenta = (saldo >= 0) ? "Estado Comercial: Solvente" : "Estado Comercial: En Mora";
        System.out.println(estadoCuenta);

        teclado.close(); // Liberación técnica de búfer
    }
}
