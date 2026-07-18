# 🔀 Arquitectura del Flujo de Control: Estructuras Condicionales en Java

Las estructuras condicionales rompen la naturaleza lineal del código. Permiten al hilo de ejecución de la Máquina Virtual de Java (JVM) saltar bloques enteros de código basándose en el análisis de expresiones condicionales.

---

## 1. Anatomía y Buenas Prácticas del `if-else if-else`

La estructura condicional evalúa expresiones que den como resultado un valor booleano estricto. A diferencia de lenguajes como C o Python, en Java los números enteros (como `0` o `1`) no representan valores lógicos; usar un entero dentro de un `if` generará un error de compilación inmediato.

### El peligro del "Código Espagueti" o Flecha
Anidar múltiples estructuras `if` dentro de otras de forma desmesurada destruye la mantenibilidad del software. Para solucionar esto, la industria promueve el uso de **Cláusulas de Guarda** (*Guard Clauses*), las cuales evalúan los escenarios de error o salida rápida al principio del método, reduciendo la necesidad de bloques `else`.

### Ejemplo de Refactorización Profesional:
❌ **Código Mal Estructurado (Anidamiento Complejo):**
```java
public void procesarPago(Usuario u, double monto) {
    if (u != null) {
        if (u.estaActivo()) {
            if (u.getSaldo() >= monto) {
                u.descontar(monto);
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Usuario inactivo");
        }
    }
}
```

✔️ **Código Refactorizado (Cláusulas de Guarda Limpias):**
```java
public void procesarPago(Usuario u, double monto) {
    if (u == null) return;
    if (!u.estaActivo()) { System.out.println("Usuario inactivo"); return; }
    if (u.getSaldo() < monto) { System.out.println("Saldo insuficiente"); return; }
    
    u.descontar(monto); // Flujo principal limpio y sin niveles de sangría
}
```

---

## 2. La Evolución de `switch`: De Clásico a Expresiones Modernas

La estructura `switch` evalúa una sola variable frente a múltiples casos constantes. Tradicionalmente sufría del peligroso comportamiento de "caída libre" (*fall-through*), obligando al desarrollador a colocar manualmente la sentencia `break` en cada línea.

### Comparativa: Switch Clásico vs Switch Expression (Java 14+)

A partir de las versiones modernas de Java, `switch` pasó de ser una simple estructura de control a una **expresión capaz de retornar un valor**, eliminando por completo el uso de `break` gracias a la sintaxis de flecha (`->`).


| Característica | Switch Clásico | Switch Expression (Moderno) |
| :--- | :--- | :--- |
| **Sintaxis** | Usa dos puntos (`case X:`) | Usa flecha (`case X ->`) |
| **Control de Flujo** | Requiere `break;` explícito | Autocontenido (Evita caídas libres de error) |
| **Retorno** | No puede retornar datos directamente | Puede asignar su resultado a una variable |
| **Soporte de Bloques** | Mezcla variables en un solo ámbito global | Soporta bloques aislados usando `yield` |

### Código Demostrativo:
```java
// Switch Moderno como Expresión Asignable
String tipoDia = switch (diaSemana) {
    case 1, 5 -> "Inicio/Fin de semana laboral";
    case 2, 3, 4 -> "Núcleo de la semana";
    case 6, 7 -> "Fin de semana libre";
    default -> throw new IllegalArgumentException("Día inválido: " + diaSemana);
};
```

---

## 3. El Operador Ternario como Expresión Condicional

El operador ternario (`? :`) es el único operador en Java que toma tres operandos. No es un sustituto para bloques condicionales complejos, sino una herramienta para realizar asignaciones rápidas basadas en una condición en una sola línea.

### Sintaxis Estricta:
`variable = (condicion_booleana) ? valor_si_verdadero : valor_si_falso;`

```java
// Buenas prácticas: mantenerlo simple y legible
double descuento = (montoCompra > 1000) ? montoCompra * 0.10 : 0.0;
```

---

## 💻 Enlaces del Ecosistema
* [📂 Ver Archivo de Código: Condicionales.java](../../src/com/ejercicios/logica/Condicionales.java)
* [🧠 Volver al Índice del Módulo 01](./index.md)
