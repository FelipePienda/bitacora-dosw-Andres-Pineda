# Ejercicio: Análisis de Requerimientos (Parte 1) - Plataforma de Entrenadores Pokémon

## 1. Contexto

Una empresa de videojuegos desea desarrollar una aplicación web para entrenadores Pokémon, con manejo de equipos, interacción entre jugadores y visualización de progreso en una liga competitiva. El cliente menciona además preocupaciones sobre la experiencia de combate, la capacidad para múltiples usuarios, la seguridad de cuentas y la claridad del historial de batallas. En el futuro se espera agregar torneos, recompensas y modos de juego adicionales.

---

## 2. Requisitos extraídos

| ID | Requisito | Tipo | Prioridad | Justificación | Dependencias |
|----|-----------|------|-----------|---------------|--------------|
| RF-01 | El sistema debe permitir que un usuario se registre como entrenador en la plataforma. | Funcional | Alta | Es la base para autenticar usuarios y gestionar sus equipos. | Ninguna |
| RF-02 | El sistema debe permitir que un entrenador inicie sesión con credenciales seguras. | Funcional | Alta | Necesario para controlar acceso y proteger cuentas. | RF-01 |
| RF-03 | El sistema debe permitir que el entrenador cree y administre su equipo de Pokémon. | Funcional | Alta | Funcionalidad central para participar en combates. | RF-01, RF-02 |
| RF-04 | El sistema debe permitir que los entrenadores inicien combates contra otros jugadores en línea. | Funcional | Alta | Núcleo del producto multijugador. | RF-02, RF-03 |
| RF-05 | El sistema debe mostrar el progreso de cada entrenador dentro de una liga competitiva. | Funcional | Media | Importante para motivar la competencia y retención. | RF-02 |
| RF-06 | El sistema debe mostrar el historial de batallas con resultados y detalles relevantes. | Funcional | Media | Refuerza la claridad del historial y la transparencia. | RF-02, RF-04 |
| RF-07 | El sistema debe permitir interacción entre jugadores, como invitaciones a combate o chat básico. | Funcional | Media | Mejora la experiencia social de la plataforma. | RF-02, RF-04 |
| RNF-01 | El sistema debe garantizar la seguridad de las cuentas mediante autenticación segura. | No funcional | Alta | El cliente se preocupa por la seguridad y es crítico para proteger datos. | RF-02 |
| RNF-02 | El sistema debe soportar múltiples usuarios conectados simultáneamente sin caída de servicio. | No funcional | Alta | Requisito de capacidad y escalabilidad para el juego en línea. | RF-04 |
| RNF-03 | El sistema debe ofrecer una experiencia de usuario fluida durante los combates. | No funcional | Alta | Necesario para jugar en línea sin frustración. | RF-04, RNF-02 |
| RNF-04 | El sistema debe ser capaz de registrar y consultar el historial de batallas de forma clara y accesible. | No funcional | Media | Refuerza claridad y trazabilidad de combates. | RF-06 |
| RNF-05 | El sistema debe ser extensible para agregar futuros modos de juego, torneos y recompensas sin reescribir el código principal. | No funcional | Media | Facilita evolución futura y evita refactorizaciones costosas. | Todas las funcionalidades básicas |
| RNF-06 | El sistema debe persistir datos de entrenadores, equipos, batallas y progreso. | No funcional | Alta | Asume almacenamiento necesario para la plataforma. | RF-01, RF-03, RF-05, RF-06 |

---

## 3. Clasificación y justificación

- **Funcional**: describe qué debe hacer el sistema.
  - RF-01 a RF-07 cubren registro, autenticación, gestión de equipos, combate, progreso, historial e interacción.
- **No funcional**: describe cómo debe comportarse el sistema.
  - RNF-01 a RNF-06 cubren seguridad, escalabilidad, experiencia de combate, claridad de datos, extensibilidad y persistencia.

Justificación rápida:
- Prioridad Alta se asigna a elementos de valor inmediato y bloqueantes para la plataforma básica.
- Prioridad Media se asigna a mejoras de experiencia, visibilidad y extensibilidad futura.

---

## 4. Dependencias y bloqueos

- RF-02 depende de RF-01 porque no se puede iniciar sesión sin registro previo.
- RF-03 depende de RF-01 y RF-02 porque la gestión de equipo requiere usuario autenticado.
- RF-04 depende de RF-02 y RF-03 porque el combate en línea requiere usuarios registrados con equipo.
- RF-06 depende de RF-04 porque el historial se genera a partir de combates realizados.
- RNF-02 y RNF-03 dependen de RF-04, ya que la experiencia de múltiples usuarios y combates fluido solo aplica en el juego en línea.
- RNF-05 depende de una arquitectura modular, por lo que es un riesgo si el diseño inicial no considera extensibilidad.
- RNF-06 depende de definir la tecnología de persistencia y los datos a almacenar.

Bloqueos potenciales:
- Falta de documentación formal del cliente puede bloquear decisiones de seguridad y experiencia de combate.
- La definición incompleta de futuros torneos y recompensas bloquea su diseño, pero no impide la arquitectura extensible.
- La capacidad en simultáneo puede requerir pruebas de carga específicas y selección de hosting/infraestructura.

---

## 5. Matriz de trazabilidad

| ID | Tipo | Módulo/Caso de uso asociado | Prueba o validación posible |
|----|------|-----------------------------|-----------------------------|
| RF-01 | Funcional | Registro de entrenador | Crear cuenta nueva y comprobar existencia en base de datos. |
| RF-02 | Funcional | Inicio de sesión | Autenticación exitosa con credenciales válidas; rechazo con inválidas. |
| RF-03 | Funcional | Gestión de equipo | Añadir/editar/eliminar Pokémon del equipo y validar cambios. |
| RF-04 | Funcional | Combate en línea | Iniciar combate entre dos jugadores y verificar finalización del duelo. |
| RF-05 | Funcional | Liga competitiva | Mostrar tabla de clasificación y progreso acumulado. |
| RF-06 | Funcional | Historial de batallas | Consultar lista de combates con resultado y datos. |
| RF-07 | Funcional | Interacción social | Enviar invitación de combate o mensaje básico entre jugadores. |
| RNF-01 | No funcional | Seguridad / Autenticación | Revisión de políticas de contraseña y pruebas de acceso no autorizado. |
| RNF-02 | No funcional | Escalabilidad | Pruebas de carga con múltiples usuarios simultáneos. |
| RNF-03 | No funcional | UX de combates | Evaluación de latencia y feedback de usuarios durante combate. |
| RNF-04 | No funcional | Historial de batallas | Verificar que el historial sea legible y filtrable. |
| RNF-05 | No funcional | Arquitectura | Revisión de diseño modular y facilidad para agregar nuevos modos. |
| RNF-06 | No funcional | Persistencia | Validar almacenamiento correcto de entrenadores, equipos y batallas. |

---

## 6. Análisis de ambigüedades e incompletitudes

1. **Experiencia del usuario durante los combates**: no está claro si se refiere a interfaz visual, rendimiento, animaciones o facilidad de uso. Necesita validar si es mayormente UX, jugabilidad o performance.
2. **Múltiples usuarios conectados simultáneamente**: no se define cuántos usuarios son esperados ni si se requiere soporte en tiempo real para miles de conexiones. Hay que aclarar el volumen esperado y el alcance de la concurrencia.
3. **Seguridad de las cuentas**: no se especifica el nivel requerido (autenticación multifactor, cifrado de datos, protección contra fraude, etc.). Es necesario validar políticas de seguridad concretas.
4. **Interacción entre jugadores**: no se detalla qué tipo de interacción se espera: solo desafíos, chat, intercambio de objetos o rankings compartidos.
5. **Progresión en la liga competitiva**: falta información sobre cómo se calcula el progreso, frecuencias de actualización y reglas de la liga.
6. **Futuras funcionalidades**: torneos, recompensas y modos no están definidos, lo que sugiere diseñar una arquitectura flexible, pero no permite especificar requisitos funcionales concretos todavía.

---

## 7. Supuestos razonables

- El sistema requiere autenticación y gestión de sesiones, aunque no se mencione explícitamente.
- Los datos deben persistirse en una base de datos o almacenamiento equivalente.
- Se espera una aplicación web, por lo tanto se requieren interfaces de usuario y APIs.
- El historial de batallas debe incluir al menos fecha, participantes, resultado y estadísticas básicas.
- La plataforma debe poder evolucionar hacia nuevas modalidades sin reescribir el núcleo.

---

## 8. Observaciones finales

Este análisis traduce las necesidades del cliente en requerimientos claros, medibles y priorizados, distinguiendo entre lo funcional y lo no funcional. También identifica dependencias clave y ambigüedades que deben resolverse con el cliente antes de avanzar al diseño o desarrollo.
