package com.ejemplos.estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionListas {
    public static void main(String[] args) {
        System.out.println("=== 📦 Laboratorio Avanzado de Listas Dinámicas (ArrayList) ===");

        // 1. Inicialización con capacidad predefinida para optimizar la asignación en
        // el Heap
        List<String> lenguajes = new ArrayList<>(15);
        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("C++");
        lenguajes.add("Java"); // Permite duplicados nativamente

        // 2. Inserción intermedia (Complejidad O(n) por desplazamiento de memoria)
        lenguajes.add(1, "TypeScript");

        System.out.println("\n[Estado Inicial] Elementos en la lista:");
        lenguajes.forEach(lang -> System.out.println(" -> " + lang));

        // 3. Ordenamiento in-place utilizando el algoritmo Timsort de Java Collections
        Collections.sort(lenguajes);
        System.out.println("\n[Estructura Ordenada] Lista alfabética:");
        System.out.println(lenguajes);

        // 4. Caso de borde: Validación preventiva de índices para evitar
        // ArrayIndexOutOfBoundsException
        int indiceObjetivo = 3;
        if (indiceObjetivo >= 0 && indiceObjetivo < lenguajes.size()) {
            System.out.println(
                    "\n[Acceso O(1)] Elemento en índice " + indiceObjetivo + ": " + lenguajes.get(indiceObjetivo));
        }

        // 5. Demostración del comportamiento de error Fail-Fast
        try {
            System.out.println("\n[Prueba Fail-Fast] Intentando modificar la lista durante un ciclo:");
            for (String lang : lenguajes) {
                if (lang.equals("C++")) {
                    lenguajes.remove(lang); // Esto disparará la excepción inmediatamente
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.err.println(
                    "❌ Excepción controlada: No puedes alterar la estructura física de una lista mientras la recorres.");
        }
    }
}
