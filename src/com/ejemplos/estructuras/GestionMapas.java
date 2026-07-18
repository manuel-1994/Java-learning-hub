package com.ejemplos.estructuras;

import java.util.HashMap;
import java.util.Map;

public class GestionMapas {
    public static void main(String[] args) {
        System.out.println("=== 🗺️ Laboratorio de Estructuras Asociativas (HashMap) ===");

        // Inicialización de mapa para control de inventarios (Clave: SKU -> Valor:
        // Cantidad disponible)
        Map<String, Integer> bodega = new HashMap<>();

        // 1. Inserción de datos base
        bodega.put("REP-882", 14);
        bodega.put("REP-104", 45);

        // 2. Caso de Borde: Mutación por sobrescritura de clave existente
        // El método put guarda el nuevo valor y nos devuelve el objeto anterior que
        // estaba en esa celda
        Integer stockAnterior = bodega.put("REP-882", 20);
        System.out.println(
                "\n[Alerta de Reemplazo] El SKU 'REP-882' tenía " + stockAnterior + " unidades. Nuevo stock: 20");

        // 3. Técnicas modernas de inserción segura y rescate de datos preventivo
        bodega.putIfAbsent("REP-311", 100); // Solo se agrega si la clave no existe

        // getOrDefault evita un NullPointerException si la clave buscada no está en el
        // mapa
        int consultaInexistente = bodega.getOrDefault("REP-999", 0);
        System.out.println("Stock del repuesto inexistente 'REP-999': " + consultaInexistente);

        // 4. Recorrido optimizado de alto rendimiento utilizando EntrySet
        System.out.println("\n[Auditoría de Bodega] Desglose de Existencias:");
        for (Map.Entry<String, Integer> item : bodega.entrySet()) {
            System.out.println(" -> Código SKU: " + item.getKey() + " | Cantidad Física: " + item.getValue() + " uds.");
        }
    }
}
