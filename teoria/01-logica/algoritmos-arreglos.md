# ⚡ Algoritmos Clásicos: Búsqueda, Ordenamiento y Manipulación Estática

Para procesar información dentro de estructuras estáticas sin depender de librerías externas de Java, es un requerimiento dominar la lógica algorítmica pura de ordenamiento y búsqueda lineal.

## 🔑 Conceptos Clave y Fundamentos
* **Búsqueda Lineal:** Consiste en escanear el arreglo celda por celda desde el índice 0 hasta el final. Se aplica en arreglos desordenados y su peor escenario requiere evaluar todos los elementos.
* **Ordenamiento de Burbuja (Bubble Sort):** Un algoritmo clásico de ordenamiento que compara repetidamente elementos adyacentes y los intercambia si están en el orden incorrecto. Los valores más grandes "flotan" hacia el final de la estructura en cada ciclo.
* **Intercambio de Variables (Swap):** Técnica obligatoria para mover datos entre celdas sin destruir la información intermedia, requiriendo el uso de una variable temporal de respaldo.

## 📝 Análisis de Complejidad Algorítmica (Big O)
* **Búsqueda Lineal:** Complejidad de tiempo lineal $O(n)$. Si el arreglo escala a un millón de datos, el algoritmo ejecutará un millón de operaciones en el peor de los casos.
* **Ordenamiento Burbuja:** Complejidad de tiempo cuadrática $O(n^2)$ debido a sus bucles anidados obligatorios. No es eficiente para volúmenes masivos de datos, pero es el pilar fundamental para aprender control de índices.

## 💻 Código Fuente de Nivel Avanzado
```java
package com.ejercicios.logica;

public class AlgoritmosArreglos {
    
    // Implementación técnica del algoritmo de Ordenamiento de Burbuja O(n^2)
    public static void ordenarBurbuja(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Mecánica de Intercambio (Swap)
                    int temporal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporal;
                }
            }
        }
    }

    // Implementación técnica de Búsqueda Lineal O(n)
    public static int buscarLineal(int[] array, int valorObjetivo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valorObjetivo) {
                return i; // Retorna el índice de coincidencia de forma inmediata
            }
        }
        return -1; // Bandera técnica estándar para indicar que el valor no existe
    }

    public static void main(String[] args) {
        int[] datosDesordenados = {54, 12, 89, 7, 34};

        System.out.println("--- Ordenando Arreglo Estático ---");
        ordenarBurbuja(datosDesordenados);
        for (int numero : datosDesordenados) {
            System.out.print(numero + " ");
        }

        System.out.println("\n\n--- Ejecutando Búsqueda Lineal ---");
        int objetivo = 34;
        int resultadoIndice = buscarLineal(datosDesordenados, objetivo);
        System.out.println("El número " + objetivo + " se encuentra en el índice: " + resultadoIndice);
    }
}
```

---

## 💻 Enlaces del Ecosistema
* [🧠 Volver al Índice del Módulo 01](./index.md)
