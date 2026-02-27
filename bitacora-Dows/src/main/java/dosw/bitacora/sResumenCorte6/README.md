1. Java Streams y Programación Funcional
   Origen (Lista) → Operaciones Intermedias (perezosas) → Operación Terminal (ejecuta)

filter(objeto -> objeto.esValido()): Mantiene solo los elementos que cumplen la condición.

map(objeto -> objeto.getAtributo()): Transforma elementos de un tipo a otro (ej. de Objeto a String).

peek(objeto -> System.out...): Depuración. Ve el elemento actual sin alterar el flujo.

Terminal: collect(Collectors.toList()): Guarda el resultado final en una lista nueva.

Terminal: anyMatch(condición): Devuelve true si al menos uno cumple. (Útil para buscar).

Terminal: allMatch(condición): Devuelve true si todos cumplen. (Útil para validar).

💡 Truco de Examen: allMatch y anyMatch usan short-circuiting (parada temprana). Si anyMatch encuentra un acierto rápido, el peek no mostrará el resto de la lista original.

2. Principios SOLID
   No memorices el código, memoriza la intención:

S - Single Responsibility (Responsabilidad Única): Una clase hace una sola cosa. (No mezcles lógica de usuario con cálculos de pago).

O - Open/Closed (Abierto/Cerrado): El código debe estar abierto a extensiones (nuevas funciones) pero cerrado a modificaciones (no toques lo que ya funciona). Usa herencia o interfaces.

L - Liskov Substitution (Sustitución de Liskov): Las subclases deben poder usarse en lugar de sus clases padre sin romper el programa.

I - Interface Segregation (Segregación de Interfaces): Es mejor tener muchas interfaces pequeñas y específicas que una grande y genérica.

D - Dependency Inversion (Inversión de Dependencias): Depende de interfaces (abstracciones), no de clases concretas (implementaciones).

3. Patrones de Diseño (Los 3 Clave)
   Singleton: Garantiza que una clase tenga una única instancia global. (Ej: Conexión a Base de Datos).

Factory: Centraliza la creación de objetos complejos. En lugar de new ObjetoA() en todos lados, llamas a Fabrica.crearObjeto(tipoA).

Observer: Para notificaciones. Un objeto cambia de estado y avisa automáticamente a todos sus "suscriptores" o dependientes. (Ej: Actualización de precio en Uber).

LADO 2: Análisis e Ingeniería de Software (Semana 4 y 5)
4. Levantamiento de Requerimientos (Estructura fija)
   Si te piden analizar una funcionalidad (ej. un formulario), usa esta estructura de documento:

1. Identificación: Código (RF-01), Nombre, Descripción, Actor Principal (ej. Aspirante).

2. Precondiciones: Qué debe cumplir el sistema antes de empezar (ej. El aspirante debe haber seleccionado el programa).

3. Detalle de Datos:

Entrada (Actor entrega): Nombre del campo, descripción, tipo (lista, texto), ¿es obligatorio?.

Salida (Sistema responde): Mensaje de confirmación, ID de registro o mensaje de error.

4. Flujos:

Flujo Básico: Los pasos del "camino feliz" sin errores (ej. Diligenciar → Validar → Confirmar).

Flujo Alterno (Error/Excepción): Lo que pasa cuando ocurre un error (ej. Si el campo está vacío, mostrar pop-up y bloquear envío).

5. Reglas de Negocio (RN): Restricciones de la vida real (del dominio), no del software (ej. "Solo se aceptan mayores de 18 años" o "Solo documentos válidos en Colombia").

6. Requerimientos No Funcionales (RNF): Calidades del sistema (Seguridad HTTPS, Rapidez < 2s, Responsive).

5. Conceptos de Agilismo y Herramientas (Semana 5)
   Agilismo: Enfoque flexible de desarrollo que valora a las personas y al software funcionando sobre procesos y documentación.

SCRUM: Marco de trabajo ágil con roles fijos:

Product Owner (PO): Define el "qué" y prioriza la lista de tareas (Product Backlog).

Scrum Master (SM): Elimina impedimentos y facilita el proceso.

Development Team: Realiza el trabajo.

Artefactos Clave:

Sprint Backlog: Lista de tareas seleccionadas para el Sprint actual.

Incremento: La parte del producto funcionando y potencialmente entregable al final del Sprint.


Diferencia entre Requerimiento y Regla de Negocio:

Requerimiento Funcional (RF): Lo que el software hace. "El sistema debe permitir pagar".

Regla de Negocio (RN): La restricción de la realidad. "Solo se aceptan tarjetas Visa".

Prueba de Escritorio: Para Streams, dibuja la lista y ve tachando los elementos que el filter elimina. Así no te confundes.

# Conceptos importantes 
Inmutabilidad: En Streams y programación funcional, los datos originales no se cambian; se crea una nueva estructura con los resultados.

Funciones Lambda: Son funciones anónimas (sin nombre) que permiten pasar código como si fuera un objeto.

Efectos Secundarios (Side Effects): Una función pura no debe cambiar nada fuera de ella. El método .peek() se usa para observar, pero no debe modificar los atributos de los objetos del Stream.

2. Maven y Gestión de Proyectos (Semana 2 y 3)
   ¿Qué es Maven?: Es una herramienta de gestión de proyectos que maneja el ciclo de vida de construcción (build) y las dependencias (librerías externas).

Archivo pom.xml: Es el "corazón" de Maven. Ahí se definen la versión del proyecto, las dependencias y los plugins.

Ciclo de Vida (Lifecycle): Recuerda las fases: compile (compila), test (ejecuta pruebas), package (crea el JAR/WAR) e install (guarda el proyecto en tu repositorio local).

3. Diferencias Teóricas en Requerimientos (Semana 4)
   Criterios de Aceptación: Son las condiciones que el software debe cumplir para que el cliente lo acepte como "terminado". Se derivan del Flujo Básico.

Frontera del Sistema: Es el límite entre el software y el mundo exterior (actores o sistemas externos como Pasarelas de Pago).

Prototipado (UX/UI): Es una representación visual (mockup) del sistema que ayuda a validar los requerimientos con el usuario antes de programar.

Agilismo y SCRUM (Semana 5)
Manifiesto Ágil: Valora más a los individuos e interacciones que a los procesos y herramientas, y el software funcionando sobre la documentación extensiva.

Time-boxing: Es el tiempo fijo que dura un Sprint (normalmente 1 a 4 semanas). No se puede mover la fecha de fin del Sprint.

Historias de Usuario (User Stories): Es una forma ágil de escribir requerimientos desde la perspectiva del usuario: "Como [rol], quiero [acción], para [beneficio]".
diferencia entre un Requerimiento No Funcional y una Regla de Negocio?

R: El RNF es una característica del software (ej. "la página debe cargar en 1 segundo"). La Regla de Negocio es una restricción de la institución que existiría aunque no hubiera software (ej. "los estudiantes deben tener el seguro médico pagado para inscribirse").