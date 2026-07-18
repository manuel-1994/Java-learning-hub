package com.ejemplos.poo;

import java.util.List;

public class GestionMapeoPOO {
    public static void main(String[] args) {
        System.out.println("=== 📦 Laboratorio de Programación Orientada a Objetos ===");

        AuditoriaLote auditoria = new AuditoriaLote();

        // 1. Registro de instancias a través del contenedor seguro
        auditoria.registrarComprobante(new FacturaNacional("FAC-2026-01", 1000.0, 0.16));
        auditoria.registrarComprobante(new FacturaNacional("FAC-2026-02", 500.0, 0.08));

        // 2. Recuperación controlada mediante copia defensiva (Evita la fuga de
        // referencias)
        List<ComprobanteFiscal> copiaDeTrabajo = auditoria.getLote();

        System.out.println("\n[Procesamiento Polimórfico - Enlace Dinámico de la JVM]:");
        for (ComprobanteFiscal doc : copiaDeTrabajo) {
            // La JVM inspecciona el objeto real en el Heap y ejecuta el método de la
            // subclase
            System.out.println(" -> Comprobante " + doc.getSerie() +
                    " | Impuesto Liquidado: $" + doc.calcularImpuesto());
        }
    }
}