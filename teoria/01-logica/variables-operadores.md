# 🔢 Guía Exhaustiva de Variables, Tipos de Datos y Operadores en Java

En Java, la memoria se gestiona de forma estricta mediante el sistema de tipos. Comprender cómo se almacenan los datos y cómo operan los circuitos lógicos del procesador sobre ellos es fundamental para escribir código eficiente y evitar desbordamientos de memoria.

---

## 1. El Sistema de Tipado Estricto y Memoria (Stack vs Heap)

Java es un lenguaje fuertemente tipado. Esto significa que cada variable debe tener un tipo declarado explícitamente en tiempo de compilación. A nivel de hardware, Java divide la memoria en dos regiones críticas:

1. **Memoria Stack (Pila):** Es ultrarrápida. Almacena las variables locales de ejecución y los valores de los **tipos de datos primitivos**. Su ciclo de vida es automático y está ligado al ámbito del método.
2. **Memoria Heap (Montículo):** Es una región más grande y dinámica. Almacena todos los **objetos** (incluidos los `String` y colecciones). Las variables en el Stack actúan como punteros o referencias que guardan la dirección de memoria física donde reside el objeto en el Heap.

### Tabla Comparativa de Tipos Primitivos en Java


| Tipo Primitivo | Tamaño en Memoria | Valor Mínimo | Valor Máximo | Caso de Uso Recomendado |
| :--- | :--- | :--- | :--- | :--- |
| `byte` | 8 bits (1 byte) | -128 | 127 | Flujos de archivos binarios, optimización extrema de buffers. |
| `short` | 16 bits (2 bytes) | -32,768 | 32,767 | Controladores de hardware antiguos, microcontroladores. |
| `int` | 32 bits (4 bytes) | -2³¹ | 2³¹ - 1 (~2,147 millones) | Tipo por defecto para contadores, índices y aritmética entera. |
| `long` | 64 bits (8 bytes) | -2⁶³ | 2⁶³ - 1 | Identificadores únicos de bases de datos (IDs), milisegundos Unix. |
| `float` | 32 bits (4 bytes) | ±1.4E-45 | ±3.4E38 | Gráficos 3D, videojuegos (bajo consumo de memoria decimal). |
| `double` | 64 bits (8 bytes) | ±4.9E-324 | ±1.7E308 | Tipo por defecto para cálculos matemáticos y científicos estándares. |
| `boolean` | 1 bit (virtual) | `false` | `true` | Evaluación de banderas, compuertas lógicas y control de flujo. |
| `char` | 16 bits (2 bytes) | '\u0000' (0) | '\uffff' (65,535) | Almacenamiento de un único carácter en formato Unicode UTF-16. |

> ⚠️ **Regla de Oro Financiera:** Nunca uses `float` o `double` para transacciones de dinero. Debido a cómo los procesadores representan los números de punto flotante en binario (estándar IEEE 754), se producen errores de redondeo imperceptibles (ej. `0.1 + 0.2` puede resultar en `0.30000000000000004`). Para dinero, usa siempre la clase **`java.math.BigDecimal`**.

---

## 2. Operadores de Cortocircuito y Aritmética Avanzada

Los operadores en Java no solo realizan cálculos; determinan la velocidad de ejecución de las condiciones complejas.

### Evaluación de Cortocircuito (`&&` y `||`)
* **`&&` (AND Operador):** Si la expresión de la izquierda evalúa como `false`, Java **no evalúa** la expresión de la derecha. Sabe que todo el conjunto será falso.
* **`||` (OR Operador):** Si la expresión de la izquierda evalúa como `true`, Java **no evalúa** la expresión de la derecha. Sabe que todo el conjunto será verdadero.

**Caso de Uso de Seguridad Crítico:**
```java
// Si 'usuario' es null, evaluar 'usuario.esActivo()' lanzaría NullPointerException.
// Gracias al cortocircuito, si es null, la ejecución se detiene de inmediato y el código es seguro.
if (usuario != null && usuario.esActivo()) {
    // Código seguro
}
```

### Operadores de Asignación Compuesta e Incremento
* `i++` (Post-incremento): Devuelve el valor original de `i` y **luego** lo incrementa.
* `++i` (Pre-incremento): Incrementa `i` primero y **luego** devuelve el valor modificado.

```java
int x = 5;
int y = x++; // y = 5, x = 6
int z = ++x; // z = 7, x = 7
```

---

## 3. Guía de Limpieza: Gestión del Buffer con `Scanner`

La clase `java.util.Scanner` es una herramienta excelente para capturar datos, pero genera fugas de memoria (*Resource Leaks*) si no se maneja correctamente. Abre un canal de lectura directa con el flujo de entrada del sistema (`System.in`).

### El error clásico del salto de línea (`nextLine()`)
Cuando lees un número con `nextInt()` y luego intentas leer texto con `nextLine()`, el programa parece "saltarse" la captura del texto. Esto ocurre porque `nextInt()` consume el número pero deja el carácter de salto de línea (`\n`) atrapado en el buffer. El siguiente `nextLine()` lee ese `\n` residual y asume que el usuario presionó ENTER sin escribir nada.

**Solución Técnica:** Limpiar el buffer manualmente insertando un `nextLine()` vacío intermediario.

```java
Scanner teclado = new Scanner(System.in);

System.out.print("Ingresa tu edad: ");
int edad = teclado.nextInt(); 
teclado.nextLine(); // 💡 SOLUCIÓN: Consume el '\n' residual que quedó flotando en el buffer

System.out.print("Ingresa tu nombre completo: ");
String nombre = teclado.nextLine(); // Ahora captura el texto correctamente

teclado.close(); // 💡 OBLIGATORIO: Cierra el flujo de memoria al finalizar el programa
```

---

## 💻 Enlaces del Ecosistema
* [📂 Ir al Código Fuente de Lógica](../../src/com/ejercicios/logica/)
* [🧠 Volver al Índice del Módulo 01](./index.md)
