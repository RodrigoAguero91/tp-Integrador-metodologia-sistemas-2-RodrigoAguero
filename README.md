# 🚀 Trabajo Práctico Integrador - Metodología de Sistemas II

* **Alumno:** Rodrigo  Agüero
* **Comisión:** M25 C4-02

El proyecto aborda la refactorización integral de un sistema heredado ("God Class") aplicando principios SOLID, Clean Code, patrones de diseño y pruebas unitarias en Java.

---

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java (OpenJDK 27)
* **Gestor de Dependencias:** Maven
* **Testing:** JUnit 5
* **Control de Versiones:** Git y GitHub

---

## 📂 Arquitectura del Proyecto (Capas)
El sistema fue desacoplado migrando de una clase única a una arquitectura limpia basada en paquetes:
* `ar.edu.utn.tup.model`: Entidades del dominio y enumerados de control (`EstadoSolicitud`, `Prioridad`).
* `ar.edu.utn.tup.dto`: Objetos de transferencia de datos (*Introduce Parameter Object*).
* `ar.edu.utn.tup.exception`: Excepciones personalizadas de negocio (`SolicitudException`).
* `ar.edu.utn.tup.repository`: Abstracción de persistencia mediante interfaces y almacenamiento en memoria.
* `ar.edu.utn.tup.service`: Lógica de negocio desacoplada (`SolicitudService`, `ReporteService`).

---

## 🏷️ Hitos del Repositorio (Tags Git)
El desarrollo y la evolución del código se documentaron mediante etiquetas oficiales:
1. `estado-inicial`: Código base con acoplamiento y *code smells*.
2. `etapa-diagnostico`: Identificación de fallas y deuda técnica.
3. `etapa-refactoring`: Aplicación de principios SOLID y Clean Code.
4. `etapa-pruebas`: Configuración y ejecución exitosa de pruebas unitarias con JUnit 5.

---

## ⚙️ Instrucciones de Ejecución
1. Clonar el repositorio.
2. Abrir el proyecto en **IntelliJ IDEA** como proyecto **Maven**.
3. Ejecutar la clase principal `Main.java` (ubicada en `src/main/java/ar/edu/utn/tup/Main.java`) para verificar el flujo completo.
4. Ejecutar las pruebas unitarias desde la carpeta `src/test/java`.
