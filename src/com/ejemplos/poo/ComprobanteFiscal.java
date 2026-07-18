package com.ejemplos.poo;

/**
 * Superclase abstracta que actúa como el plano conceptual de negocio.
 * Vinculada con: teoria/03-poo/clases-objetos.md
 */
public abstract class ComprobanteFiscal {
    private final String serie; // Atributo inmutable tras asignación inicial
    private double montoBase; // Encapsulado hermético privado

    public ComprobanteFiscal(String serie, double montoBase) {
        this.serie = serie;
        setMontoBase(montoBase); // Inyección obligatoria por aduana de validación
    }

    // Método lector expone el dato sin vulnerar la memoria
    public String getSerie() {
        return this.serie;
    }

    public double getMontoBase() {
        return this.montoBase;
    }

    // Aduana de control (Cláusula de Guarda) para asegurar la invariante de estado
    public void setMontoBase(double montoBase) {
        if (montoBase > 0.0) {
            this.montoBase = montoBase;
        } else {
            throw new IllegalArgumentException("Violación: El monto base debe ser estrictamente positivo.");
        }
    }

    // Contrato polimórfico puro que las subclases deben implementar
    public abstract double calcularImpuesto();
}
