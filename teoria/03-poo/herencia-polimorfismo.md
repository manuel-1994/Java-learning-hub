# 🧬 Herencia, Polimorfismo y Enlace Dinámico

La herencia y el polimorfismo proveen extensibilidad al código fuente mediante la reutilización estructural de clases y la ejecución dinámica de comportamientos especializados.

## 🔑 Conceptos Clave y Fundamentos
* **Herencia Simple (`extends`):** Java prohíbe la herencia múltiple de clases para evitar la ambigüedad en colisiones de firmas de métodos (el problema del diamante). Una clase solo deriva de una superclase.
* **Polimorfismo de Subtipos:** Capacidad de una variable declarada con el tipo de una superclase o interfaz abstracta para almacenar de forma transparente referencias de cualquier subclase derivada.
* **Enlace Dinámico (Dynamic Binding):** Mecanismo mediante el cual la JVM decide, en tiempo de ejecución, qué método ejecutar basándose en el tipo del objeto real en el Heap, ignorando el tipo estático de la variable en el Stack.

## 📊 Funcionamiento de la Tabla de Métodos Virtuales (VMT)
```mermaid
graph TD
    Var[Variable: Documento doc] -->|Apunta in Heap a| Obj[Objeto Real: Factura]
    Obj --> VMT[JVM inspecciona VMT de la clase Factura]
    VMT --> Exec[Ejecuta el método procesar() de Factura]
```

## 📝 Resumen Técnico
La anotación `@Override` le indica explícitamente al compilador que verifique que el método cumple exactamente con la firma de la superclase, evitando errores tipográficos que rompan el polimorfismo.

---

## ↩️ Navegación del Ecosistema
* [📊 Volver al Índice del Módulo 03](./index.md)
* [📚 Volver al Índice General de Teoría](../index.md)
* [💻 Ver Código Práctico Asociado](../../src/com/ejercicios/poo/GestionMapeoPOO.java)
