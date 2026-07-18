package com.ejemplos.estructuras;

import java.util.HashSet;
import java.util.Set;

// Record de Java Moderno que autogenera de forma perfecta el contrato equals() y hashCode()
record Socio(String membresiaId, String nombreCompleto) {
}

public class GestionConjuntos {
    public static void main(String[] args) {
        System.out.println("=== 🛡️ Laboratorio de Unicidad de Datos (HashSet) ===");

        Set<Socio> clubLectura = new HashSet<>();

        // Instanciación de objetos con los mismos datos lógicos pero diferentes
        // espacios en memoria Stack
        Socio socio1 = new Socio("L-998", "Roberto Gómez");
        Socio socio2 = new Socio("L-998", "Roberto Gómez"); // Registro duplicado idéntico
        Socio socio3 = new Socio("L-441", "Elena Rostova");

        // 1. Inserción controlada mediante hashing directo O(1)
        System.out.println("\n[Procesando registros en la Tabla Hash...]");
        System.out.println(" -> Registro Socio 1: " + clubLectura.add(socio1)); // Retorna true
        System.out.println(" -> Registro Socio 2 (Duplicado): " + clubLectura.add(socio2)); // Retorna false nativo por
                                                                                            // colisión hash lógicamente
                                                                                            // idéntica
        System.out.println(" -> Registro Socio 3: " + clubLectura.add(socio3)); // Retorna true

        // 2. Verificación de volumen de persistencia en memoria Heap
        System.out.println("\n[Resultado] Cantidad total de registros únicos (Debe ser 2): " + clubLectura.size());
        System.out.println(clubLectura);

        // 3. Búsqueda instantánea en tiempo constante O(1)
        Socio busqueda = new Socio("L-441", "Elena Rostova");
        if (clubLectura.contains(busqueda)) {
            System.out.println(
                    "\n[Búsqueda O(1)] El socio con membresía " + busqueda.membresiaId() + " se encuentra activo.");
        }
    }
}
