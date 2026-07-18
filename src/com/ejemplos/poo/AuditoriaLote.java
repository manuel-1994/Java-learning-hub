package com.ejemplos.poo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de proteger la colección de datos contra mutaciones externas
 * ilegales.
 * Vinculada con: teoria/03-poo/abstraccion-encapsulamiento.md
 */
public class AuditoriaLote {
    // Encapsulamiento rígido: Nadie fuera de esta clase puede acceder al ArrayList
    // real
    private final List<ComprobanteFiscal> lote = new ArrayList<>();

    public void registrarComprobante(ComprobanteFiscal comprobante) {
        if (comprobante != null) {
            lote.add(comprobante);
        }
    }

    /**
     * COPIA DEFENSIVA: En lugar de entregar la dirección de memoria de 'lote',
     * clona los elementos en una nueva lista independiente en el Heap.
     */
    public List<ComprobanteFiscal> getLote() {
        return new ArrayList<>(this.lote);
    }
}