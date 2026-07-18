package com.ejemplos.poo;

/**
 * Subclase especializada que extiende de la estructura base.
 * Vinculada con: teoria/03-poo/herencia-polimorfismo.md
 */
public class FacturaNacional extends ComprobanteFiscal {
    private final double tasaIva;

    public FacturaNacional(String serie, double montoBase, double tasaIva) {
        super(serie, montoBase); // Invoca jerárquicamente al constructor del padre
        this.tasaIva = tasaIva;
    }

    @Override
    public double calcularImpuesto() {
        // Enlace Dinámico: Implementación especializada de cálculo de impuestos
        return getMontoBase() * this.tasaIva;
    }
}