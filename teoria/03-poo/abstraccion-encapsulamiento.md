# 🛡️ Abstracción y Encapsulamiento de Estados Internos

El encapsulamiento y la abstracción aíslan el estado de un objeto para evitar la corrupción de sus datos, exponiendo únicamente operaciones seguras a través de una interfaz pública.

## 🔑 Conceptos Clave y Fundamentos
* **Modificadores de Acceso (Matriz de Visibilidad):**
  * `private`: Restricción absoluta. Solo visible en el interior de la misma clase.
  * `default` (Ausencia de palabra clave): Visible únicamente por clases del mismo paquete.
  * `protected`: Accesible por clases del mismo paquete y subclases en paquetes externos.
  * `public`: Visibilidad global irrestricta.
* **Ocultamiento de Información:** Consiste en decretar todos los atributos como `private` para obligar a que cualquier alteración de la memoria pase por un método validador.
* **Fuga de Referencias (Reference Exposure):** Ocurre si un `getter` devuelve la dirección de memoria directa de un objeto interno mutable (como una colección o array). El código externo podría mutarlo directamente sin pasar por las validaciones de la clase.

## 📝 Resumen Técnico de Diseño Seguro
Para erradicar la fuga de referencias, los métodos de acceso lectores (`getters`) deben aplicar la técnica de **Copia Defensiva**, retornando una nueva instancia con los mismos valores lógicos o devolviendo una envoltura inmutable.

---

## ↩️ Navegación del Ecosistema
* [📊 Volver al Índice del Módulo 03](./index.md)
* [📚 Volver al Índice General de Teoría](../index.md)
* [💻 Ver Código Práctico Asociado](../../src/com/ejercicios/poo/GestionMapeoPOO.java)
