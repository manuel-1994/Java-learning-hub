# 🗺️ Mapas de Llave-Valor (`Map` y `HashMap`)

La interfaz `java.util.Map` no hereda de la interfaz raíz `Collection`. Modela una estructura de diccionario asociativo que vincula una clave única (*Key*) a un valor específico (*Value*).

## 🔑 Conceptos Clave y Fundamentos
* **Claves Únicas:** Las claves actúan bajo las mismas reglas estrictas de un `Set`. No se permiten duplicados. Si intentas insertar una clave existente con un valor diferente, la estructura sobrescribirá el valor anterior de forma silenciosa y retornará el valor viejo reemplazado.
* **Valores Mutables:** Los valores asociados no tienen restricciones; pueden repetirse indefinidamente o contener referencias directas a colecciones complejas.
* **Factor de Carga (Load Factor):** Un parámetro decimal (por defecto `0.75`) que determina cuándo reestructurar la tabla hash. Si la tabla alcanza el 75% de su ocupación, Java duplica su cantidad de casilleros internos y realiza un proceso masivo de **Re-hashing** de todas las claves existentes para redistribuir la memoria.

## 📝 Resumen Técnico y Operativo
* **Rendimiento de Búsqueda:** Complejidad constante $O(1)$ para recuperar valores por su clave mediante `.get(key)`.
* **Iteración Eficiente:** Para recorrer un mapa, la forma técnicamente óptima en Java es extraer su conjunto de entradas combinadas mediante el método `.entrySet()`. Esto evita tener que hacer búsquedas repetitivas con `.get()` dentro de un bucle de claves.

## 💻 Código Fuente Avanzado con Casos de Borde
```java
package com.ejercicios.estructuras;

import java.util.HashMap;
import java.util.Map;

public class EjemploMapas {
    public static void main(String[] args) {
        Map<String, Integer> inventario = new HashMap<>();

        inventario.put("PROD-001", 50);
        inventario.put("PROD-002", 120);
        
        // Mutación por sobrescritura controlada
        Integer stockAnterior = inventario.put("PROD-001", 75); // Retorna 50 y guarda 75

        System.out.println("Stock previo reemplazado: " + stockAnterior);

        // Método moderno para evitar validaciones condicionales repetitivas
        inventario.putIfAbsent("PROD-003", 200);
        int stockInexistente = inventario.getOrDefault("PROD-999", 0); // Evita un NullPointerException

        System.out.println("\n--- Recorrido Arquitectónico Óptimo usando EntrySet ---");
        for (Map.Entry<String, Integer> entrada : inventario.entrySet()) {
            System.out.println("Código: " + entrada.getKey() + " | Unidades: " + entrada.getValue());
        }
    }
}
```

---

## ↩️ Navegación del Ecosistema
* [📊 Volver al Índice del Módulo 02](./index.md)
* [📚 Volver al Índice General de Teoría](../index.md)
* [💻 Ver Código Práctico Asociado](../../src/com/ejercicios/estructuras/GestionColecciones.java)
