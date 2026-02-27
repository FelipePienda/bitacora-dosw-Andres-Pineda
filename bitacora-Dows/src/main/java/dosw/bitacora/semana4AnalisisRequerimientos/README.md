# Semana 4: Análisis de Requerimientos - Escuela de Ingeniería

Este documento contiene el análisis detallado del proceso de inscripción para el programa de **Ingeniería de Sistemas**.

---

## 1. Identificación del Requerimiento
* **Código:** RF-01
* **Nombre:** Formulario de Inscripción a Carrera
* **Descripción:** Permitir a los aspirantes registrar su información básica y académica para iniciar el proceso de admisión.
* **Actor Principal:** Aspirante.
* **Precondiciones:** El aspirante debe haber seleccionado el programa de "Ingeniería de Sistemas" en la oferta académica.

---

## 2. Detalle de Datos (Entrada y Salida)
Basado en los campos obligatorios del formulario web:

| Sentido | Nombre | Descripción | Tipo de Campo | Obligatorio |
| :--- | :--- | :--- | :--- | :--- |
| Entrada | Nivel de Estudio | Grado académico al que aspira | Lista Desplegable | Sí |
| Entrada | Programa | Carrera específica (Sistemas) | Lista Desplegable | Sí |
| Entrada | Documento | Número de identificación | Alfanumérico | Sí |
| Salida | Mensaje de Error | Alerta por campos vacíos | Texto (Pop-up) | N/A |
| Salida | Formulario Extendido | Siguiente fase del registro | Interfaz Web | N/A |

---

## 3. Flujo de Eventos

### Flujo Básico
1. El aspirante ingresa a la sección "Inscríbete".
2. El sistema despliega el formulario de admisión.
3. El aspirante selecciona el nivel de estudio y programa.
4. El aspirante ingresa su documento y presiona "Validar".
5. El sistema confirma los datos y permite continuar al registro detallado.

### Flujo Alterno (Error)
* **E-01:** Si el aspirante deja el campo "Tipo Admisión" vacío, el sistema bloquea el envío y muestra el mensaje: *"El campo Tipo Admisión es obligatorio, por favor diligéncielo"*.

---

## 4. Reglas de Negocio (RN)
* **RN-01:** Solo se procesan documentos de identidad válidos (C.C., T.I., C.E.).
* **RN-02:** El registro solo es válido si el programa tiene inscripciones abiertas para el ciclo actual.

---

## 5. Requerimientos No Funcionales (RNF)
* **Seguridad:** Los datos personales deben viajar bajo protocolo HTTPS.
* **Usabilidad:** El formulario debe ser compatible con dispositivos móviles (Responsive).

---

## 6. Autoevaluación
¿Qué entendía mal antes?

Creía que los imports en Java eran globales para todo el proyecto y no por cada archivo.

Veía los requerimientos como descripciones simples, sin entender la importancia de separar flujos básicos de los errores (flujos alternos).

¿Qué entiendo ahora?

Cada clase es independiente y requiere sus propios imports para reconocer elementos como List o clases externas.

Un análisis profesional exige detallar actores, precondiciones y reglas de negocio específicas (como la obligatoriedad de campos).

¿Qué me falta reforzar?

Mejorar la creación de diagramas de casos de uso visuales para complementar el texto.