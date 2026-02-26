# Semana 2: SOLID y Patrones de Software

## Evidencia Técnica
- **Rama de trabajo:** `feature/semana2-patrones`
- **Temas vistos:** Patrones Creacionales (Factory Method), Estructurales (Adapter), de Comportamiento (Memento) y Principios SOLID.

## Ejercicios Resueltos

### 1. Patrón Factory Method (Notificaciones)
Implementación de un sistema de notificaciones donde el cliente no conoce las clases concretas (`Email`, `SMS`, `Push`), sino que delega la creación a una clase `Factory`.
- **Beneficio:** Facilita la extensión del sistema sin modificar el código cliente.

### 2. Patrón Adapter (Impresoras)
Se diseñó un adaptador para que una `ImpresoraDetallada` (clase externa/compleja) pudiera ser utilizada por el sistema que solo esperaba una `ImpresoraSimple`.
- **Beneficio:** Permite la interoperabilidad entre clases con interfaces incompatibles.

### 3. Patrón Memento (Editor de Texto)
Implementación de un sistema de "Deshacer" (Undo). El `Editor` crea estados (`Memento`) que son almacenados por un `Historial` (`Caretaker`).
- **Beneficio:** Permite restaurar estados previos sin violar el encapsulamiento del objeto principal.

### 4. Principios SOLID (Calculadora)
Rediseño de una calculadora básica aplicando:
- **SRP:** Cada clase de operación tiene una sola responsabilidad.
- **OCP:** Se pueden agregar nuevas operaciones (como Potencia o Raíz) creando nuevas clases sin modificar la clase `Calculadora`.
- **DIP:** La calculadora depende de la interfaz `Operacion`, no de implementaciones concretas.

## Autoevaluación Semanal

### ¿Qué entendía mal antes?
Antes pensaba que los patrones de diseño eran complicaciones innecesarias o que solo servían para proyectos gigantes. También solía meter mucha lógica en una sola clase (como una calculadora llena de `if/else`).

### ¿Qué entiendo ahora?
Ahora entiendo que los patrones como **Factory** o **Adapter** hacen que el código sea mucho más flexible y fácil de mantener. Entiendo que los principios **SOLID** son guías para evitar el "código espagueti" y permitir que el software crezca sin romperse.

### ¿Qué me falta reforzar?
Me falta practicar más la identificación de cuál patrón es el mejor para cada situación específica, ya que a veces dudo entre usar un **Adapter** o un **Decorator**. También quiero profundizar en la Inyección de Dependencias.