# Ejercicio 3: Sistema de Reportes de una Plataforma

Este ejercicio implementa un sistema de generación de reportes con soporte para múltiples formatos y extensiones.

Patrones utilizados:
- Builder: para construir reportes paso a paso con secciones.
- Decorator: para agregar extensiones como firma digital, marca de agua y compresión.

Formatos disponibles:
- PDF
- CSV
- JSON

Extensiones disponibles:
- Firma digital
- Marca de agua
- Compresión del contenido

La solución permite agregar nuevos formatos y decoradores sin cambiar el código existente del sistema principal.
