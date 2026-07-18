package com.ejemplos.logica;

/**
 * Vinculado teóricamente con: teoria/01-logica/variables-operadores.md
 */
public class Variables {
    public static void main(String[] args) {
        System.out.println("=== 🔢 Práctica: Variables y Tipado Estricto ===");

        // Asignación directa en memoria Stack
        int edadMinima = 18;
        double precioProducto = 29.99;
        boolean esMiembroActivo = true;
        final double TASA_IMPUESTO = 0.16; // Constante inmutable

        // Demostración de cortocircuito: El segundo bloque no se evalúa si el primero
        // es falso
        boolean accesoConcedido = esMiembroActivo && (edadMinima >= 18);

        System.out.println("Estado de acceso: " + accesoConcedido);
        System.out.println("Cálculo de precio final: " + (precioProducto + (precioProducto * TASA_IMPUESTO)));
    }
}
